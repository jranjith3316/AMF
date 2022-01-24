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

import com.liferay.amf.profile.detail.exception.NoSuchProfileDetailException;
import com.liferay.amf.profile.detail.model.ProfileDetail;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the profile detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProfileDetailUtil
 * @generated
 */
@ProviderType
public interface ProfileDetailPersistence
	extends BasePersistence<ProfileDetail> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProfileDetailUtil} to access the profile detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the profile details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching profile details
	 */
	public java.util.List<ProfileDetail> findByUuid(String uuid);

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
	public java.util.List<ProfileDetail> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ProfileDetail> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProfileDetail>
			orderByComparator);

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
	public java.util.List<ProfileDetail> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProfileDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first profile detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile detail
	 * @throws NoSuchProfileDetailException if a matching profile detail could not be found
	 */
	public ProfileDetail findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProfileDetail>
				orderByComparator)
		throws NoSuchProfileDetailException;

	/**
	 * Returns the first profile detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile detail, or <code>null</code> if a matching profile detail could not be found
	 */
	public ProfileDetail fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProfileDetail>
			orderByComparator);

	/**
	 * Returns the last profile detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile detail
	 * @throws NoSuchProfileDetailException if a matching profile detail could not be found
	 */
	public ProfileDetail findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProfileDetail>
				orderByComparator)
		throws NoSuchProfileDetailException;

	/**
	 * Returns the last profile detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile detail, or <code>null</code> if a matching profile detail could not be found
	 */
	public ProfileDetail fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProfileDetail>
			orderByComparator);

	/**
	 * Returns the profile details before and after the current profile detail in the ordered set where uuid = &#63;.
	 *
	 * @param profileDetailId the primary key of the current profile detail
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next profile detail
	 * @throws NoSuchProfileDetailException if a profile detail with the primary key could not be found
	 */
	public ProfileDetail[] findByUuid_PrevAndNext(
			long profileDetailId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProfileDetail>
				orderByComparator)
		throws NoSuchProfileDetailException;

	/**
	 * Removes all the profile details where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of profile details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching profile details
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the profile detail where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProfileDetailException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching profile detail
	 * @throws NoSuchProfileDetailException if a matching profile detail could not be found
	 */
	public ProfileDetail findByUUID_G(String uuid, long groupId)
		throws NoSuchProfileDetailException;

	/**
	 * Returns the profile detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching profile detail, or <code>null</code> if a matching profile detail could not be found
	 */
	public ProfileDetail fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the profile detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching profile detail, or <code>null</code> if a matching profile detail could not be found
	 */
	public ProfileDetail fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the profile detail where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the profile detail that was removed
	 */
	public ProfileDetail removeByUUID_G(String uuid, long groupId)
		throws NoSuchProfileDetailException;

	/**
	 * Returns the number of profile details where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching profile details
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the profile details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching profile details
	 */
	public java.util.List<ProfileDetail> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<ProfileDetail> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<ProfileDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProfileDetail>
			orderByComparator);

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
	public java.util.List<ProfileDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProfileDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first profile detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile detail
	 * @throws NoSuchProfileDetailException if a matching profile detail could not be found
	 */
	public ProfileDetail findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProfileDetail>
				orderByComparator)
		throws NoSuchProfileDetailException;

	/**
	 * Returns the first profile detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile detail, or <code>null</code> if a matching profile detail could not be found
	 */
	public ProfileDetail fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProfileDetail>
			orderByComparator);

	/**
	 * Returns the last profile detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile detail
	 * @throws NoSuchProfileDetailException if a matching profile detail could not be found
	 */
	public ProfileDetail findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProfileDetail>
				orderByComparator)
		throws NoSuchProfileDetailException;

	/**
	 * Returns the last profile detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile detail, or <code>null</code> if a matching profile detail could not be found
	 */
	public ProfileDetail fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProfileDetail>
			orderByComparator);

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
	public ProfileDetail[] findByUuid_C_PrevAndNext(
			long profileDetailId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProfileDetail>
				orderByComparator)
		throws NoSuchProfileDetailException;

	/**
	 * Removes all the profile details where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of profile details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching profile details
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the profile detail where companyId = &#63; and userId = &#63; or throws a <code>NoSuchProfileDetailException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the matching profile detail
	 * @throws NoSuchProfileDetailException if a matching profile detail could not be found
	 */
	public ProfileDetail findByUserIdAndComapanyId(long companyId, long userId)
		throws NoSuchProfileDetailException;

	/**
	 * Returns the profile detail where companyId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the matching profile detail, or <code>null</code> if a matching profile detail could not be found
	 */
	public ProfileDetail fetchByUserIdAndComapanyId(
		long companyId, long userId);

	/**
	 * Returns the profile detail where companyId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching profile detail, or <code>null</code> if a matching profile detail could not be found
	 */
	public ProfileDetail fetchByUserIdAndComapanyId(
		long companyId, long userId, boolean useFinderCache);

	/**
	 * Removes the profile detail where companyId = &#63; and userId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the profile detail that was removed
	 */
	public ProfileDetail removeByUserIdAndComapanyId(
			long companyId, long userId)
		throws NoSuchProfileDetailException;

	/**
	 * Returns the number of profile details where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the number of matching profile details
	 */
	public int countByUserIdAndComapanyId(long companyId, long userId);

	/**
	 * Caches the profile detail in the entity cache if it is enabled.
	 *
	 * @param profileDetail the profile detail
	 */
	public void cacheResult(ProfileDetail profileDetail);

	/**
	 * Caches the profile details in the entity cache if it is enabled.
	 *
	 * @param profileDetails the profile details
	 */
	public void cacheResult(java.util.List<ProfileDetail> profileDetails);

	/**
	 * Creates a new profile detail with the primary key. Does not add the profile detail to the database.
	 *
	 * @param profileDetailId the primary key for the new profile detail
	 * @return the new profile detail
	 */
	public ProfileDetail create(long profileDetailId);

	/**
	 * Removes the profile detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileDetailId the primary key of the profile detail
	 * @return the profile detail that was removed
	 * @throws NoSuchProfileDetailException if a profile detail with the primary key could not be found
	 */
	public ProfileDetail remove(long profileDetailId)
		throws NoSuchProfileDetailException;

	public ProfileDetail updateImpl(ProfileDetail profileDetail);

	/**
	 * Returns the profile detail with the primary key or throws a <code>NoSuchProfileDetailException</code> if it could not be found.
	 *
	 * @param profileDetailId the primary key of the profile detail
	 * @return the profile detail
	 * @throws NoSuchProfileDetailException if a profile detail with the primary key could not be found
	 */
	public ProfileDetail findByPrimaryKey(long profileDetailId)
		throws NoSuchProfileDetailException;

	/**
	 * Returns the profile detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param profileDetailId the primary key of the profile detail
	 * @return the profile detail, or <code>null</code> if a profile detail with the primary key could not be found
	 */
	public ProfileDetail fetchByPrimaryKey(long profileDetailId);

	/**
	 * Returns all the profile details.
	 *
	 * @return the profile details
	 */
	public java.util.List<ProfileDetail> findAll();

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
	public java.util.List<ProfileDetail> findAll(int start, int end);

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
	public java.util.List<ProfileDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProfileDetail>
			orderByComparator);

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
	public java.util.List<ProfileDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProfileDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the profile details from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of profile details.
	 *
	 * @return the number of profile details
	 */
	public int countAll();

}