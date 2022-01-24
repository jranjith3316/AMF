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

package com.liferay.amf.profile.detail.service;

import com.liferay.amf.profile.detail.model.ProfileDetail;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ProfileDetail. This utility wraps
 * <code>com.liferay.amf.profile.detail.service.impl.ProfileDetailLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProfileDetailLocalService
 * @generated
 */
public class ProfileDetailLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.amf.profile.detail.service.impl.ProfileDetailLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the profile detail to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProfileDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param profileDetail the profile detail
	 * @return the profile detail that was added
	 */
	public static ProfileDetail addProfileDetail(ProfileDetail profileDetail) {
		return getService().addProfileDetail(profileDetail);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new profile detail with the primary key. Does not add the profile detail to the database.
	 *
	 * @param profileDetailId the primary key for the new profile detail
	 * @return the new profile detail
	 */
	public static ProfileDetail createProfileDetail(long profileDetailId) {
		return getService().createProfileDetail(profileDetailId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the profile detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProfileDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param profileDetailId the primary key of the profile detail
	 * @return the profile detail that was removed
	 * @throws PortalException if a profile detail with the primary key could not be found
	 */
	public static ProfileDetail deleteProfileDetail(long profileDetailId)
		throws PortalException {

		return getService().deleteProfileDetail(profileDetailId);
	}

	/**
	 * Deletes the profile detail from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProfileDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param profileDetail the profile detail
	 * @return the profile detail that was removed
	 */
	public static ProfileDetail deleteProfileDetail(
		ProfileDetail profileDetail) {

		return getService().deleteProfileDetail(profileDetail);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.amf.profile.detail.model.impl.ProfileDetailModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.amf.profile.detail.model.impl.ProfileDetailModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ProfileDetail fetchProfileDetail(long profileDetailId) {
		return getService().fetchProfileDetail(profileDetailId);
	}

	/**
	 * Returns the profile detail matching the UUID and group.
	 *
	 * @param uuid the profile detail's UUID
	 * @param groupId the primary key of the group
	 * @return the matching profile detail, or <code>null</code> if a matching profile detail could not be found
	 */
	public static ProfileDetail fetchProfileDetailByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchProfileDetailByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static List<ProfileDetail> getProfileDetail(
			com.liferay.portal.kernel.search.Hits hits)
		throws PortalException {

		return getService().getProfileDetail(hits);
	}

	/**
	 * Returns the profile detail with the primary key.
	 *
	 * @param profileDetailId the primary key of the profile detail
	 * @return the profile detail
	 * @throws PortalException if a profile detail with the primary key could not be found
	 */
	public static ProfileDetail getProfileDetail(long profileDetailId)
		throws PortalException {

		return getService().getProfileDetail(profileDetailId);
	}

	public static ProfileDetail getProfileDetailByUserId(
		long companyId, long userId) {

		return getService().getProfileDetailByUserId(companyId, userId);
	}

	/**
	 * Returns the profile detail matching the UUID and group.
	 *
	 * @param uuid the profile detail's UUID
	 * @param groupId the primary key of the group
	 * @return the matching profile detail
	 * @throws PortalException if a matching profile detail could not be found
	 */
	public static ProfileDetail getProfileDetailByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getProfileDetailByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the profile details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.amf.profile.detail.model.impl.ProfileDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile details
	 * @param end the upper bound of the range of profile details (not inclusive)
	 * @return the range of profile details
	 */
	public static List<ProfileDetail> getProfileDetails(int start, int end) {
		return getService().getProfileDetails(start, end);
	}

	/**
	 * Returns all the profile details matching the UUID and company.
	 *
	 * @param uuid the UUID of the profile details
	 * @param companyId the primary key of the company
	 * @return the matching profile details, or an empty list if no matches were found
	 */
	public static List<ProfileDetail> getProfileDetailsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getProfileDetailsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of profile details matching the UUID and company.
	 *
	 * @param uuid the UUID of the profile details
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of profile details
	 * @param end the upper bound of the range of profile details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching profile details, or an empty list if no matches were found
	 */
	public static List<ProfileDetail> getProfileDetailsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProfileDetail> orderByComparator) {

		return getService().getProfileDetailsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of profile details.
	 *
	 * @return the number of profile details
	 */
	public static int getProfileDetailsCount() {
		return getService().getProfileDetailsCount();
	}

	public static List<Object[]> getProfileDetailSearchResult(
		String[] values, String keyword, String subQuery, String toBirthDate,
		String fromBirthDate, String criteria, int offset, int limit) {

		return getService().getProfileDetailSearchResult(
			values, keyword, subQuery, toBirthDate, fromBirthDate, criteria,
			offset, limit);
	}

	public static List<ProfileDetail> search(
		long companyId, String keywords, int privacy,
		java.util.LinkedHashMap<String, Object> params, int start, int end,
		OrderByComparator<ProfileDetail> orderByComparator) {

		return getService().search(
			companyId, keywords, privacy, params, start, end,
			orderByComparator);
	}

	public static com.liferay.portal.kernel.search.Hits search(
		long companyId, String keywords, int privacy,
		java.util.LinkedHashMap<String, Object> params, int start, int end,
		com.liferay.portal.kernel.search.Sort[] sorts) {

		return getService().search(
			companyId, keywords, privacy, params, start, end, sorts);
	}

	/**
	 * Updates the profile detail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProfileDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param profileDetail the profile detail
	 * @return the profile detail that was updated
	 */
	public static ProfileDetail updateProfileDetail(
		ProfileDetail profileDetail) {

		return getService().updateProfileDetail(profileDetail);
	}

	public static ProfileDetailLocalService getService() {
		return _service;
	}

	private static volatile ProfileDetailLocalService _service;

}