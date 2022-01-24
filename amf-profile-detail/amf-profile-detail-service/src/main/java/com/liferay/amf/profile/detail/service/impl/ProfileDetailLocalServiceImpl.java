/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.amf.profile.detail.service.impl;

import com.liferay.amf.profile.detail.model.ProfileDetail;
import com.liferay.amf.profile.detail.service.ProfileDetailLocalServiceUtil;
import com.liferay.amf.profile.detail.service.base.ProfileDetailLocalServiceBaseImpl;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the profile detail local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.amf.profile.detail.service.ProfileDetailLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProfileDetailLocalServiceBaseImpl
 */
@Component(
		property = "model.class.name=com.liferay.amf.profile.detail.model.ProfileDetail",
		service = AopService.class
)
public class ProfileDetailLocalServiceImpl
		extends ProfileDetailLocalServiceBaseImpl {

	public ProfileDetail getProfileDetailByUserId(long companyId, long userId) {
		ProfileDetail profileDetail = null;
		try {
			profileDetail = profileDetailPersistence.findByUserIdAndComapanyId(companyId, userId);
		}catch (Exception e) {
			log.error("Exception occure while getting Profile Detail By userId and groupId:::"+e);
		}
		return profileDetail;
	}

	/*
	 * @Indexable(type = IndexableType.REINDEX) public ProfileDetail
	 * addProfileDetail(ProfileDetail profileDetail) { return
	 * profileDetailLocalService.updateProfileDetail(profileDetail);
	 *
	 * }
	 */


	public ProfileDetail updateProfileDetail(ProfileDetail profileDetail) {
		log.info("Inside updateProfileDetail:::::::::::::::");
		profileDetail = profileDetailPersistence.update(profileDetail);
		reindexProfile(profileDetail);
		return profileDetail;
	}


	private void reindexProfile(ProfileDetail profileDetail) {
		try {
			Indexer<ProfileDetail> indexer =
					IndexerRegistryUtil.getIndexer(ProfileDetail.class);
			indexer.reindex(profileDetail);
		} catch (Exception e) {
			log.error("Error occure while reindexing Profile:::",e);
		}

	}

	@Indexable(type = IndexableType.REINDEX)
	public ProfileDetail deleteProfileDetail(ProfileDetail profileDetail) {
		return profileDetailLocalService.deleteProfileDetail(profileDetail);
	}

	@Override
	public List<ProfileDetail> search(
			long companyId, String keywords, int privacy,
			LinkedHashMap<String, Object> params, int start, int end,
			OrderByComparator<ProfileDetail> orderByComparator) {

		try {
			return profileDetailLocalService.getProfileDetail(
					search(
							companyId, keywords, privacy, params, start, end,
							getSorts(orderByComparator)));
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}




	public List<ProfileDetail> getProfileDetail(Hits hits) throws PortalException {
		List<Document> documents = hits.toList();

		List<ProfileDetail> profileDetails = new ArrayList<>(documents.size());

		for (Document document : documents) {
			long profileDetailId = GetterUtil.getLong(document.get("profileDetailId"));

			ProfileDetail profileDetail = ProfileDetailLocalServiceUtil.fetchProfileDetail(profileDetailId);

			if (profileDetail == null) {
				profileDetail = null;

				Indexer<ProfileDetail> indexer = IndexerRegistryUtil.getIndexer(
						ProfileDetail.class);

				long companyId = GetterUtil.getLong(
						document.get(Field.COMPANY_ID));

				indexer.delete(companyId, document.getUID());
			}
			else if (profileDetails != null) {
				profileDetails.add(profileDetail);
			}
		}

		return profileDetails;
	}

	protected Sort[] getSorts(OrderByComparator<ProfileDetail> orderByComparator) {
		if (orderByComparator == null) {
			return new Sort[0];
		}

		String[] orderByClauses = StringUtil.split(
				orderByComparator.getOrderBy());

		String[] orderByFields = orderByComparator.getOrderByFields();

		Sort[] sorts = new Sort[orderByFields.length];

		for (int i = 0; i < orderByFields.length; i++) {
			boolean reverse = orderByClauses[i].contains("DESC");

			sorts[i] = new Sort(orderByFields[i], reverse);
		}

		return sorts;
	}


	public Hits search(
			long companyId, String keywords, int privacy,
			LinkedHashMap<String, Object> params, int start, int end,
			Sort[] sorts) {

		String userName = null;
		String aboutMe = null;
		String favoriteQuotes = null;
		String favoriteMovie = null;
		String leastFavMovie = null;
		String favoriteActor = null;
		String favoriteGenre = null;
		boolean andOperator = false;

		if (Validator.isNotNull(keywords)) {
			userName = keywords;
			aboutMe = keywords;
			favoriteQuotes = keywords;
			favoriteMovie = keywords;
			leastFavMovie = keywords;
			favoriteActor = keywords;
			favoriteGenre = keywords;
		}
		else {
			andOperator = true;
		}

		/*
		 * if (params != null) { params.put("keywords", keywords); }
		 */
		try {
			Indexer<ProfileDetail> indexer = IndexerRegistryUtil.nullSafeGetIndexer(
					ProfileDetail.class);

			SearchContext searchContext = buildSearchContext(companyId, userName, aboutMe, favoriteQuotes, favoriteMovie, leastFavMovie, favoriteActor, favoriteGenre, privacy, params, andOperator, start, end, sorts);

			return indexer.search(searchContext);
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}


	protected SearchContext buildSearchContext(
			long companyId, String userName, String aboutMe, String favoriteQuotes,
			String favoriteMovie, String leastFavMovie, String favoriteActor, String favoriteGenre,
			int privacy, LinkedHashMap<String, Object> params, boolean andSearch, int start,
			int end, Sort[] sorts) {

		SearchContext searchContext = new SearchContext();

		searchContext.setAndSearch(andSearch);

		Map<String, Serializable> attributes = new HashMap<>();

		/*
		 * if (params != null) { //Long groupId = (Long)params.get(Field.GROUP_ID);
		 *
		 * if (groupId == null) { groupId = 0L; }
		 *
		 * attributes.put(Field.GROUP_ID, groupId); }
		 */
		attributes.put(Field.USER_NAME, userName);

		attributes.put("aboutMe", aboutMe);
		attributes.put("favoriteQuotes", favoriteQuotes);
		attributes.put("favoriteMovie", favoriteMovie);
		attributes.put("leastFavMovie", leastFavMovie);
		attributes.put("favoriteActor", favoriteActor);
		attributes.put("favoriteGenre", favoriteGenre);
		attributes.put("params", params);
		attributes.put("privacy", privacy);
		searchContext.setAttributes(attributes);

		searchContext.setCompanyId(companyId);
		searchContext.setEnd(end);

		if (params != null) {
			String keywords = (String)params.remove("keywords");
			if (Validator.isNotNull(keywords)) {
				searchContext.setKeywords(keywords);
			}

			for (Map.Entry<String, Object> entry : params.entrySet()) {
				try {
					attributes.putIfAbsent(
							entry.getKey(), (Serializable)entry.getValue());
				}
				catch (Exception exception) {
					if (log.isWarnEnabled()) {
						log.warn(exception, exception);
					}
				}
			}
		}

		if (sorts != null) {
			searchContext.setSorts(sorts);
		}

		searchContext.setStart(start);

		/*
		 * QueryConfig queryConfig = searchContext.getQueryConfig();
		 *
		 * queryConfig.setHighlightEnabled(false); queryConfig.setScoreEnabled(false);
		 *
		 */
		/*
		 * PermissionChecker permissionChecker =
		 * PermissionThreadLocal.getPermissionChecker();
		 *
		 * if (permissionChecker != null) {
		 * searchContext.setUserId(permissionChecker.getUserId()); }
		 */
		return searchContext;
	}



	private Log log = LogFactoryUtil.getLog(this.getClass().getName());



	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Object[]> getProfileDetailSearchResult(String[] values, String keyword, String subQuery,
													   String toBirthDate, String fromBirthDate, String criteria, int offset, int limit) {
		List<Object[]> objects = new ArrayList<>();
		try {
			objects = profileDetailFinder.getProfileDetailSearchResult(values, keyword, subQuery, toBirthDate,
					fromBirthDate, criteria, offset, limit);

		} catch (Exception e) {
			log.error("Exception occure while getting Profile Detail By userId and groupId:::" + e);
		}
		return objects;
	}


}