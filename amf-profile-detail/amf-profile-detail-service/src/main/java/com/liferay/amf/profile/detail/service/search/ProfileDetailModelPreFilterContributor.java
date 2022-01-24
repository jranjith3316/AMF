/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.amf.profile.detail.service.search;

import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.TermsFilter;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.search.spi.model.query.contributor.ModelPreFilterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchSettings;

import java.util.LinkedHashMap;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * @author Prashant Ballal
 */
@Component(immediate = true, property = "indexer.class.name=com.cimb.client.model.CimbClient", service = ModelPreFilterContributor.class)
public class ProfileDetailModelPreFilterContributor implements ModelPreFilterContributor {

	@Override
	@SuppressWarnings("unchecked")
	public void contribute(BooleanFilter contextBooleanFilter, ModelSearchSettings modelSearchSettings,
			SearchContext searchContext) {

		// Searching by assignee
		long assigneeUserId = GetterUtil.getLong(searchContext.getAttribute("assigneeUserId"));

		if (assigneeUserId != 0) {
			contextBooleanFilter.addRequiredTerm("assigneeUserId", assigneeUserId);
		}

		// Searching by status
		int status = GetterUtil.getInteger(searchContext.getAttribute(Field.STATUS), WorkflowConstants.STATUS_ANY);

		if (status != WorkflowConstants.STATUS_ANY) {
			contextBooleanFilter.addRequiredTerm(Field.STATUS, status);
		}

		LinkedHashMap<String, Object> params = (LinkedHashMap<String, Object>) searchContext.getAttribute("params");

		if (params == null) {
			return;
		}

		for (Map.Entry<String, Object> entry : params.entrySet()) {
			Object value = entry.getValue();

			if (value == null) {
				continue;
			}

			Class<?> clazz = value.getClass();

			if (clazz.isArray() && (value instanceof Object[])) {
				Object[] values = (Object[]) value;

				if (values.length == 0) {
					continue;
				}
			}
			addContextQueryParams(contextBooleanFilter, searchContext, entry.getKey(), value);
		}
	}

	protected void addContextQueryParams(BooleanFilter contextFilter, SearchContext searchContext, String key,
			Object value) {

		if (key.equals("usersGroups")) {
			if (value instanceof Long[]) {
				Long[] values = (Long[]) value;

				if (ArrayUtil.isEmpty(values)) {
					return;
				}

				TermsFilter userGroupsTermsFilter = new TermsFilter("groupIds");

				userGroupsTermsFilter.addValues(ArrayUtil.toStringArray(values));

				contextFilter.add(userGroupsTermsFilter, BooleanClauseOccur.MUST);
			} else {
				contextFilter.addRequiredTerm("groupIds", String.valueOf(value));
			}
		} else if (key.equals("usersOrgs")) {
			if (value instanceof Long[]) {
				Long[] values = (Long[]) value;

				if (ArrayUtil.isEmpty(values)) {
					return;
				}

				String[] organizationIdsStrings = ArrayUtil.toStringArray(values);

				BooleanFilter userOrgsBooleanFilter = new BooleanFilter();

				userOrgsBooleanFilter.add(_createTermsFilter("ancestorOrganizationIds", organizationIdsStrings));
				userOrgsBooleanFilter.add(_createTermsFilter("organizationIds", organizationIdsStrings));

				contextFilter.add(userOrgsBooleanFilter, BooleanClauseOccur.MUST);
			} else {
				contextFilter.addRequiredTerm("organizationIds", String.valueOf(value));
			}
		} else if (key.equals("usersOrgsCount")) {
			contextFilter.addRequiredTerm("organizationCount", String.valueOf(value));
		} else if (key.equals("usersRoles")) {
			if (value instanceof Long[]) {
				Long[] values = (Long[]) value;

				if (ArrayUtil.isEmpty(values)) {
					return;
				}

				contextFilter.add(_createTermsFilter("roleIds", ArrayUtil.toStringArray(values)),
						BooleanClauseOccur.MUST);
			} else {
				contextFilter.addRequiredTerm("roleIds", String.valueOf(value));
			}
		} else if (key.equals("usersTeams")) {
			contextFilter.addRequiredTerm("teamIds", String.valueOf(value));
		} else if (key.equals("usersUserGroups")) {
			contextFilter.addRequiredTerm("userGroupIds", String.valueOf(value));
		}

	}

	private TermsFilter _createTermsFilter(String filterName, String[] values) {
		TermsFilter termsFilter = new TermsFilter(filterName);

		termsFilter.addValues(values);

		return termsFilter;
	}

}