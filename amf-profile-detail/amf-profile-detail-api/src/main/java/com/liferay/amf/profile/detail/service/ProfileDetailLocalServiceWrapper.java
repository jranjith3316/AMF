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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProfileDetailLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProfileDetailLocalService
 * @generated
 */
public class ProfileDetailLocalServiceWrapper
	implements ProfileDetailLocalService,
			   ServiceWrapper<ProfileDetailLocalService> {

	public ProfileDetailLocalServiceWrapper(
		ProfileDetailLocalService profileDetailLocalService) {

		_profileDetailLocalService = profileDetailLocalService;
	}

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
	@Override
	public com.liferay.amf.profile.detail.model.ProfileDetail addProfileDetail(
		com.liferay.amf.profile.detail.model.ProfileDetail profileDetail) {

		return _profileDetailLocalService.addProfileDetail(profileDetail);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileDetailLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new profile detail with the primary key. Does not add the profile detail to the database.
	 *
	 * @param profileDetailId the primary key for the new profile detail
	 * @return the new profile detail
	 */
	@Override
	public com.liferay.amf.profile.detail.model.ProfileDetail
		createProfileDetail(long profileDetailId) {

		return _profileDetailLocalService.createProfileDetail(profileDetailId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileDetailLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public com.liferay.amf.profile.detail.model.ProfileDetail
			deleteProfileDetail(long profileDetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileDetailLocalService.deleteProfileDetail(profileDetailId);
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
	@Override
	public com.liferay.amf.profile.detail.model.ProfileDetail
		deleteProfileDetail(
			com.liferay.amf.profile.detail.model.ProfileDetail profileDetail) {

		return _profileDetailLocalService.deleteProfileDetail(profileDetail);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _profileDetailLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _profileDetailLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _profileDetailLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _profileDetailLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _profileDetailLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _profileDetailLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _profileDetailLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _profileDetailLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.amf.profile.detail.model.ProfileDetail
		fetchProfileDetail(long profileDetailId) {

		return _profileDetailLocalService.fetchProfileDetail(profileDetailId);
	}

	/**
	 * Returns the profile detail matching the UUID and group.
	 *
	 * @param uuid the profile detail's UUID
	 * @param groupId the primary key of the group
	 * @return the matching profile detail, or <code>null</code> if a matching profile detail could not be found
	 */
	@Override
	public com.liferay.amf.profile.detail.model.ProfileDetail
		fetchProfileDetailByUuidAndGroupId(String uuid, long groupId) {

		return _profileDetailLocalService.fetchProfileDetailByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _profileDetailLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _profileDetailLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _profileDetailLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _profileDetailLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileDetailLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.liferay.amf.profile.detail.model.ProfileDetail>
			getProfileDetail(com.liferay.portal.kernel.search.Hits hits)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileDetailLocalService.getProfileDetail(hits);
	}

	/**
	 * Returns the profile detail with the primary key.
	 *
	 * @param profileDetailId the primary key of the profile detail
	 * @return the profile detail
	 * @throws PortalException if a profile detail with the primary key could not be found
	 */
	@Override
	public com.liferay.amf.profile.detail.model.ProfileDetail getProfileDetail(
			long profileDetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileDetailLocalService.getProfileDetail(profileDetailId);
	}

	@Override
	public com.liferay.amf.profile.detail.model.ProfileDetail
		getProfileDetailByUserId(long companyId, long userId) {

		return _profileDetailLocalService.getProfileDetailByUserId(
			companyId, userId);
	}

	/**
	 * Returns the profile detail matching the UUID and group.
	 *
	 * @param uuid the profile detail's UUID
	 * @param groupId the primary key of the group
	 * @return the matching profile detail
	 * @throws PortalException if a matching profile detail could not be found
	 */
	@Override
	public com.liferay.amf.profile.detail.model.ProfileDetail
			getProfileDetailByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileDetailLocalService.getProfileDetailByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<com.liferay.amf.profile.detail.model.ProfileDetail>
		getProfileDetails(int start, int end) {

		return _profileDetailLocalService.getProfileDetails(start, end);
	}

	/**
	 * Returns all the profile details matching the UUID and company.
	 *
	 * @param uuid the UUID of the profile details
	 * @param companyId the primary key of the company
	 * @return the matching profile details, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.liferay.amf.profile.detail.model.ProfileDetail>
		getProfileDetailsByUuidAndCompanyId(String uuid, long companyId) {

		return _profileDetailLocalService.getProfileDetailsByUuidAndCompanyId(
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
	@Override
	public java.util.List<com.liferay.amf.profile.detail.model.ProfileDetail>
		getProfileDetailsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.amf.profile.detail.model.ProfileDetail>
					orderByComparator) {

		return _profileDetailLocalService.getProfileDetailsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of profile details.
	 *
	 * @return the number of profile details
	 */
	@Override
	public int getProfileDetailsCount() {
		return _profileDetailLocalService.getProfileDetailsCount();
	}

	@Override
	public java.util.List<Object[]> getProfileDetailSearchResult(
		String[] values, String keyword, String subQuery, String toBirthDate,
		String fromBirthDate, String criteria, int offset, int limit) {

		return _profileDetailLocalService.getProfileDetailSearchResult(
			values, keyword, subQuery, toBirthDate, fromBirthDate, criteria,
			offset, limit);
	}

	@Override
	public java.util.List<com.liferay.amf.profile.detail.model.ProfileDetail>
		search(
			long companyId, String keywords, int privacy,
			java.util.LinkedHashMap<String, Object> params, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.amf.profile.detail.model.ProfileDetail>
					orderByComparator) {

		return _profileDetailLocalService.search(
			companyId, keywords, privacy, params, start, end,
			orderByComparator);
	}

	@Override
	public com.liferay.portal.kernel.search.Hits search(
		long companyId, String keywords, int privacy,
		java.util.LinkedHashMap<String, Object> params, int start, int end,
		com.liferay.portal.kernel.search.Sort[] sorts) {

		return _profileDetailLocalService.search(
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
	@Override
	public com.liferay.amf.profile.detail.model.ProfileDetail
		updateProfileDetail(
			com.liferay.amf.profile.detail.model.ProfileDetail profileDetail) {

		return _profileDetailLocalService.updateProfileDetail(profileDetail);
	}

	@Override
	public ProfileDetailLocalService getWrappedService() {
		return _profileDetailLocalService;
	}

	@Override
	public void setWrappedService(
		ProfileDetailLocalService profileDetailLocalService) {

		_profileDetailLocalService = profileDetailLocalService;
	}

	private ProfileDetailLocalService _profileDetailLocalService;

}