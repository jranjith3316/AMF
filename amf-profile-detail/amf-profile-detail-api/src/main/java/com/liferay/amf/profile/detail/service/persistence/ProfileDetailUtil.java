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

package com.liferay.amf.profile.detail.service.persistence;

import com.liferay.amf.profile.detail.model.ProfileDetail;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the profile detail service. This utility wraps <code>com.liferay.amf.profile.detail.service.persistence.impl.ProfileDetailPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProfileDetailPersistence
 * @generated
 */
public class ProfileDetailUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ProfileDetail profileDetail) {
		getPersistence().clearCache(profileDetail);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, ProfileDetail> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProfileDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProfileDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProfileDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProfileDetail> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProfileDetail update(ProfileDetail profileDetail) {
		return getPersistence().update(profileDetail);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProfileDetail update(
		ProfileDetail profileDetail, ServiceContext serviceContext) {

		return getPersistence().update(profileDetail, serviceContext);
	}

	/**
	 * Returns all the profile details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching profile details
	 */
	public static List<ProfileDetail> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the profile details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfileDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile details
	 * @param end the upper bound of the range of profile details (not inclusive)
	 * @return the range of matching profile details
	 */
	public static List<ProfileDetail> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the profile details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfileDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile details
	 * @param end the upper bound of the range of profile details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching profile details
	 */
	public static List<ProfileDetail> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProfileDetail> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the profile details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfileDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile details
	 * @param end the upper bound of the range of profile details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching profile details
	 */
	public static List<ProfileDetail> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProfileDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first profile detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile detail
	 * @throws NoSuchProfileDetailException if a matching profile detail could not be found
	 */
	public static ProfileDetail findByUuid_First(
			String uuid, OrderByComparator<ProfileDetail> orderByComparator)
		throws com.liferay.amf.profile.detail.exception.
			NoSuchProfileDetailException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first profile detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile detail, or <code>null</code> if a matching profile detail could not be found
	 */
	public static ProfileDetail fetchByUuid_First(
		String uuid, OrderByComparator<ProfileDetail> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last profile detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile detail
	 * @throws NoSuchProfileDetailException if a matching profile detail could not be found
	 */
	public static ProfileDetail findByUuid_Last(
			String uuid, OrderByComparator<ProfileDetail> orderByComparator)
		throws com.liferay.amf.profile.detail.exception.
			NoSuchProfileDetailException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last profile detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile detail, or <code>null</code> if a matching profile detail could not be found
	 */
	public static ProfileDetail fetchByUuid_Last(
		String uuid, OrderByComparator<ProfileDetail> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the profile details before and after the current profile detail in the ordered set where uuid = &#63;.
	 *
	 * @param profileDetailId the primary key of the current profile detail
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next profile detail
	 * @throws NoSuchProfileDetailException if a profile detail with the primary key could not be found
	 */
	public static ProfileDetail[] findByUuid_PrevAndNext(
			long profileDetailId, String uuid,
			OrderByComparator<ProfileDetail> orderByComparator)
		throws com.liferay.amf.profile.detail.exception.
			NoSuchProfileDetailException {

		return getPersistence().findByUuid_PrevAndNext(
			profileDetailId, uuid, orderByComparator);
	}

	/**
	 * Removes all the profile details where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of profile details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching profile details
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the profile detail where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProfileDetailException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching profile detail
	 * @throws NoSuchProfileDetailException if a matching profile detail could not be found
	 */
	public static ProfileDetail findByUUID_G(String uuid, long groupId)
		throws com.liferay.amf.profile.detail.exception.
			NoSuchProfileDetailException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the profile detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching profile detail, or <code>null</code> if a matching profile detail could not be found
	 */
	public static ProfileDetail fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the profile detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching profile detail, or <code>null</code> if a matching profile detail could not be found
	 */
	public static ProfileDetail fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the profile detail where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the profile detail that was removed
	 */
	public static ProfileDetail removeByUUID_G(String uuid, long groupId)
		throws com.liferay.amf.profile.detail.exception.
			NoSuchProfileDetailException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of profile details where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching profile details
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the profile details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching profile details
	 */
	public static List<ProfileDetail> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the profile details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfileDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of profile details
	 * @param end the upper bound of the range of profile details (not inclusive)
	 * @return the range of matching profile details
	 */
	public static List<ProfileDetail> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the profile details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfileDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of profile details
	 * @param end the upper bound of the range of profile details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching profile details
	 */
	public static List<ProfileDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProfileDetail> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the profile details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfileDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of profile details
	 * @param end the upper bound of the range of profile details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching profile details
	 */
	public static List<ProfileDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProfileDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first profile detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile detail
	 * @throws NoSuchProfileDetailException if a matching profile detail could not be found
	 */
	public static ProfileDetail findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProfileDetail> orderByComparator)
		throws com.liferay.amf.profile.detail.exception.
			NoSuchProfileDetailException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first profile detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile detail, or <code>null</code> if a matching profile detail could not be found
	 */
	public static ProfileDetail fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProfileDetail> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last profile detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile detail
	 * @throws NoSuchProfileDetailException if a matching profile detail could not be found
	 */
	public static ProfileDetail findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProfileDetail> orderByComparator)
		throws com.liferay.amf.profile.detail.exception.
			NoSuchProfileDetailException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last profile detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile detail, or <code>null</code> if a matching profile detail could not be found
	 */
	public static ProfileDetail fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProfileDetail> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the profile details before and after the current profile detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param profileDetailId the primary key of the current profile detail
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next profile detail
	 * @throws NoSuchProfileDetailException if a profile detail with the primary key could not be found
	 */
	public static ProfileDetail[] findByUuid_C_PrevAndNext(
			long profileDetailId, String uuid, long companyId,
			OrderByComparator<ProfileDetail> orderByComparator)
		throws com.liferay.amf.profile.detail.exception.
			NoSuchProfileDetailException {

		return getPersistence().findByUuid_C_PrevAndNext(
			profileDetailId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the profile details where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of profile details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching profile details
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the profile detail where companyId = &#63; and userId = &#63; or throws a <code>NoSuchProfileDetailException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the matching profile detail
	 * @throws NoSuchProfileDetailException if a matching profile detail could not be found
	 */
	public static ProfileDetail findByUserIdAndComapanyId(
			long companyId, long userId)
		throws com.liferay.amf.profile.detail.exception.
			NoSuchProfileDetailException {

		return getPersistence().findByUserIdAndComapanyId(companyId, userId);
	}

	/**
	 * Returns the profile detail where companyId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the matching profile detail, or <code>null</code> if a matching profile detail could not be found
	 */
	public static ProfileDetail fetchByUserIdAndComapanyId(
		long companyId, long userId) {

		return getPersistence().fetchByUserIdAndComapanyId(companyId, userId);
	}

	/**
	 * Returns the profile detail where companyId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching profile detail, or <code>null</code> if a matching profile detail could not be found
	 */
	public static ProfileDetail fetchByUserIdAndComapanyId(
		long companyId, long userId, boolean useFinderCache) {

		return getPersistence().fetchByUserIdAndComapanyId(
			companyId, userId, useFinderCache);
	}

	/**
	 * Removes the profile detail where companyId = &#63; and userId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the profile detail that was removed
	 */
	public static ProfileDetail removeByUserIdAndComapanyId(
			long companyId, long userId)
		throws com.liferay.amf.profile.detail.exception.
			NoSuchProfileDetailException {

		return getPersistence().removeByUserIdAndComapanyId(companyId, userId);
	}

	/**
	 * Returns the number of profile details where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the number of matching profile details
	 */
	public static int countByUserIdAndComapanyId(long companyId, long userId) {
		return getPersistence().countByUserIdAndComapanyId(companyId, userId);
	}

	/**
	 * Caches the profile detail in the entity cache if it is enabled.
	 *
	 * @param profileDetail the profile detail
	 */
	public static void cacheResult(ProfileDetail profileDetail) {
		getPersistence().cacheResult(profileDetail);
	}

	/**
	 * Caches the profile details in the entity cache if it is enabled.
	 *
	 * @param profileDetails the profile details
	 */
	public static void cacheResult(List<ProfileDetail> profileDetails) {
		getPersistence().cacheResult(profileDetails);
	}

	/**
	 * Creates a new profile detail with the primary key. Does not add the profile detail to the database.
	 *
	 * @param profileDetailId the primary key for the new profile detail
	 * @return the new profile detail
	 */
	public static ProfileDetail create(long profileDetailId) {
		return getPersistence().create(profileDetailId);
	}

	/**
	 * Removes the profile detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileDetailId the primary key of the profile detail
	 * @return the profile detail that was removed
	 * @throws NoSuchProfileDetailException if a profile detail with the primary key could not be found
	 */
	public static ProfileDetail remove(long profileDetailId)
		throws com.liferay.amf.profile.detail.exception.
			NoSuchProfileDetailException {

		return getPersistence().remove(profileDetailId);
	}

	public static ProfileDetail updateImpl(ProfileDetail profileDetail) {
		return getPersistence().updateImpl(profileDetail);
	}

	/**
	 * Returns the profile detail with the primary key or throws a <code>NoSuchProfileDetailException</code> if it could not be found.
	 *
	 * @param profileDetailId the primary key of the profile detail
	 * @return the profile detail
	 * @throws NoSuchProfileDetailException if a profile detail with the primary key could not be found
	 */
	public static ProfileDetail findByPrimaryKey(long profileDetailId)
		throws com.liferay.amf.profile.detail.exception.
			NoSuchProfileDetailException {

		return getPersistence().findByPrimaryKey(profileDetailId);
	}

	/**
	 * Returns the profile detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param profileDetailId the primary key of the profile detail
	 * @return the profile detail, or <code>null</code> if a profile detail with the primary key could not be found
	 */
	public static ProfileDetail fetchByPrimaryKey(long profileDetailId) {
		return getPersistence().fetchByPrimaryKey(profileDetailId);
	}

	/**
	 * Returns all the profile details.
	 *
	 * @return the profile details
	 */
	public static List<ProfileDetail> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the profile details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfileDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile details
	 * @param end the upper bound of the range of profile details (not inclusive)
	 * @return the range of profile details
	 */
	public static List<ProfileDetail> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the profile details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfileDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile details
	 * @param end the upper bound of the range of profile details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of profile details
	 */
	public static List<ProfileDetail> findAll(
		int start, int end,
		OrderByComparator<ProfileDetail> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the profile details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfileDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile details
	 * @param end the upper bound of the range of profile details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of profile details
	 */
	public static List<ProfileDetail> findAll(
		int start, int end, OrderByComparator<ProfileDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the profile details from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of profile details.
	 *
	 * @return the number of profile details
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProfileDetailPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProfileDetailPersistence _persistence;

}