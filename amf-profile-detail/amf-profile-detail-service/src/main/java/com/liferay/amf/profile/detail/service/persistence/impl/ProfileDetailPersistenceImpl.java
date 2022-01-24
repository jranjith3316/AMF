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

package com.liferay.amf.profile.detail.service.persistence.impl;

import com.liferay.amf.profile.detail.exception.NoSuchProfileDetailException;
import com.liferay.amf.profile.detail.model.ProfileDetail;
import com.liferay.amf.profile.detail.model.ProfileDetailTable;
import com.liferay.amf.profile.detail.model.impl.ProfileDetailImpl;
import com.liferay.amf.profile.detail.model.impl.ProfileDetailModelImpl;
import com.liferay.amf.profile.detail.service.persistence.ProfileDetailPersistence;
import com.liferay.amf.profile.detail.service.persistence.ProfileDetailUtil;
import com.liferay.amf.profile.detail.service.persistence.impl.constants.amfPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the profile detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {ProfileDetailPersistence.class, BasePersistence.class})
public class ProfileDetailPersistenceImpl
	extends BasePersistenceImpl<ProfileDetail>
	implements ProfileDetailPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProfileDetailUtil</code> to access the profile detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProfileDetailImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the profile details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching profile details
	 */
	@Override
	public List<ProfileDetail> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ProfileDetail> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<ProfileDetail> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProfileDetail> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<ProfileDetail> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProfileDetail> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<ProfileDetail> list = null;

		if (useFinderCache) {
			list = (List<ProfileDetail>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ProfileDetail profileDetail : list) {
					if (!uuid.equals(profileDetail.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_PROFILEDETAIL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProfileDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<ProfileDetail>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first profile detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile detail
	 * @throws NoSuchProfileDetailException if a matching profile detail could not be found
	 */
	@Override
	public ProfileDetail findByUuid_First(
			String uuid, OrderByComparator<ProfileDetail> orderByComparator)
		throws NoSuchProfileDetailException {

		ProfileDetail profileDetail = fetchByUuid_First(
			uuid, orderByComparator);

		if (profileDetail != null) {
			return profileDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProfileDetailException(sb.toString());
	}

	/**
	 * Returns the first profile detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile detail, or <code>null</code> if a matching profile detail could not be found
	 */
	@Override
	public ProfileDetail fetchByUuid_First(
		String uuid, OrderByComparator<ProfileDetail> orderByComparator) {

		List<ProfileDetail> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last profile detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile detail
	 * @throws NoSuchProfileDetailException if a matching profile detail could not be found
	 */
	@Override
	public ProfileDetail findByUuid_Last(
			String uuid, OrderByComparator<ProfileDetail> orderByComparator)
		throws NoSuchProfileDetailException {

		ProfileDetail profileDetail = fetchByUuid_Last(uuid, orderByComparator);

		if (profileDetail != null) {
			return profileDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProfileDetailException(sb.toString());
	}

	/**
	 * Returns the last profile detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile detail, or <code>null</code> if a matching profile detail could not be found
	 */
	@Override
	public ProfileDetail fetchByUuid_Last(
		String uuid, OrderByComparator<ProfileDetail> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProfileDetail> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ProfileDetail[] findByUuid_PrevAndNext(
			long profileDetailId, String uuid,
			OrderByComparator<ProfileDetail> orderByComparator)
		throws NoSuchProfileDetailException {

		uuid = Objects.toString(uuid, "");

		ProfileDetail profileDetail = findByPrimaryKey(profileDetailId);

		Session session = null;

		try {
			session = openSession();

			ProfileDetail[] array = new ProfileDetailImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, profileDetail, uuid, orderByComparator, true);

			array[1] = profileDetail;

			array[2] = getByUuid_PrevAndNext(
				session, profileDetail, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProfileDetail getByUuid_PrevAndNext(
		Session session, ProfileDetail profileDetail, String uuid,
		OrderByComparator<ProfileDetail> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROFILEDETAIL_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ProfileDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						profileDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProfileDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the profile details where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProfileDetail profileDetail :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(profileDetail);
		}
	}

	/**
	 * Returns the number of profile details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching profile details
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROFILEDETAIL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"profileDetail.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(profileDetail.uuid IS NULL OR profileDetail.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the profile detail where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProfileDetailException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching profile detail
	 * @throws NoSuchProfileDetailException if a matching profile detail could not be found
	 */
	@Override
	public ProfileDetail findByUUID_G(String uuid, long groupId)
		throws NoSuchProfileDetailException {

		ProfileDetail profileDetail = fetchByUUID_G(uuid, groupId);

		if (profileDetail == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProfileDetailException(sb.toString());
		}

		return profileDetail;
	}

	/**
	 * Returns the profile detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching profile detail, or <code>null</code> if a matching profile detail could not be found
	 */
	@Override
	public ProfileDetail fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the profile detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching profile detail, or <code>null</code> if a matching profile detail could not be found
	 */
	@Override
	public ProfileDetail fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs);
		}

		if (result instanceof ProfileDetail) {
			ProfileDetail profileDetail = (ProfileDetail)result;

			if (!Objects.equals(uuid, profileDetail.getUuid()) ||
				(groupId != profileDetail.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROFILEDETAIL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<ProfileDetail> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ProfileDetail profileDetail = list.get(0);

					result = profileDetail;

					cacheResult(profileDetail);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ProfileDetail)result;
		}
	}

	/**
	 * Removes the profile detail where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the profile detail that was removed
	 */
	@Override
	public ProfileDetail removeByUUID_G(String uuid, long groupId)
		throws NoSuchProfileDetailException {

		ProfileDetail profileDetail = findByUUID_G(uuid, groupId);

		return remove(profileDetail);
	}

	/**
	 * Returns the number of profile details where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching profile details
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROFILEDETAIL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"profileDetail.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(profileDetail.uuid IS NULL OR profileDetail.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"profileDetail.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the profile details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching profile details
	 */
	@Override
	public List<ProfileDetail> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ProfileDetail> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<ProfileDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProfileDetail> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<ProfileDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProfileDetail> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<ProfileDetail> list = null;

		if (useFinderCache) {
			list = (List<ProfileDetail>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ProfileDetail profileDetail : list) {
					if (!uuid.equals(profileDetail.getUuid()) ||
						(companyId != profileDetail.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_PROFILEDETAIL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProfileDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<ProfileDetail>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public ProfileDetail findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProfileDetail> orderByComparator)
		throws NoSuchProfileDetailException {

		ProfileDetail profileDetail = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (profileDetail != null) {
			return profileDetail;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProfileDetailException(sb.toString());
	}

	/**
	 * Returns the first profile detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile detail, or <code>null</code> if a matching profile detail could not be found
	 */
	@Override
	public ProfileDetail fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProfileDetail> orderByComparator) {

		List<ProfileDetail> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ProfileDetail findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProfileDetail> orderByComparator)
		throws NoSuchProfileDetailException {

		ProfileDetail profileDetail = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (profileDetail != null) {
			return profileDetail;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProfileDetailException(sb.toString());
	}

	/**
	 * Returns the last profile detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile detail, or <code>null</code> if a matching profile detail could not be found
	 */
	@Override
	public ProfileDetail fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProfileDetail> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProfileDetail> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ProfileDetail[] findByUuid_C_PrevAndNext(
			long profileDetailId, String uuid, long companyId,
			OrderByComparator<ProfileDetail> orderByComparator)
		throws NoSuchProfileDetailException {

		uuid = Objects.toString(uuid, "");

		ProfileDetail profileDetail = findByPrimaryKey(profileDetailId);

		Session session = null;

		try {
			session = openSession();

			ProfileDetail[] array = new ProfileDetailImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, profileDetail, uuid, companyId, orderByComparator,
				true);

			array[1] = profileDetail;

			array[2] = getByUuid_C_PrevAndNext(
				session, profileDetail, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProfileDetail getByUuid_C_PrevAndNext(
		Session session, ProfileDetail profileDetail, String uuid,
		long companyId, OrderByComparator<ProfileDetail> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PROFILEDETAIL_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ProfileDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						profileDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProfileDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the profile details where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProfileDetail profileDetail :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(profileDetail);
		}
	}

	/**
	 * Returns the number of profile details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching profile details
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROFILEDETAIL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"profileDetail.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(profileDetail.uuid IS NULL OR profileDetail.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"profileDetail.companyId = ?";

	private FinderPath _finderPathFetchByUserIdAndComapanyId;
	private FinderPath _finderPathCountByUserIdAndComapanyId;

	/**
	 * Returns the profile detail where companyId = &#63; and userId = &#63; or throws a <code>NoSuchProfileDetailException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the matching profile detail
	 * @throws NoSuchProfileDetailException if a matching profile detail could not be found
	 */
	@Override
	public ProfileDetail findByUserIdAndComapanyId(long companyId, long userId)
		throws NoSuchProfileDetailException {

		ProfileDetail profileDetail = fetchByUserIdAndComapanyId(
			companyId, userId);

		if (profileDetail == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("companyId=");
			sb.append(companyId);

			sb.append(", userId=");
			sb.append(userId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProfileDetailException(sb.toString());
		}

		return profileDetail;
	}

	/**
	 * Returns the profile detail where companyId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the matching profile detail, or <code>null</code> if a matching profile detail could not be found
	 */
	@Override
	public ProfileDetail fetchByUserIdAndComapanyId(
		long companyId, long userId) {

		return fetchByUserIdAndComapanyId(companyId, userId, true);
	}

	/**
	 * Returns the profile detail where companyId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching profile detail, or <code>null</code> if a matching profile detail could not be found
	 */
	@Override
	public ProfileDetail fetchByUserIdAndComapanyId(
		long companyId, long userId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {companyId, userId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUserIdAndComapanyId, finderArgs);
		}

		if (result instanceof ProfileDetail) {
			ProfileDetail profileDetail = (ProfileDetail)result;

			if ((companyId != profileDetail.getCompanyId()) ||
				(userId != profileDetail.getUserId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROFILEDETAIL_WHERE);

			sb.append(_FINDER_COLUMN_USERIDANDCOMAPANYID_COMPANYID_2);

			sb.append(_FINDER_COLUMN_USERIDANDCOMAPANYID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(userId);

				List<ProfileDetail> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUserIdAndComapanyId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {companyId, userId};
							}

							_log.warn(
								"ProfileDetailPersistenceImpl.fetchByUserIdAndComapanyId(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProfileDetail profileDetail = list.get(0);

					result = profileDetail;

					cacheResult(profileDetail);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ProfileDetail)result;
		}
	}

	/**
	 * Removes the profile detail where companyId = &#63; and userId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the profile detail that was removed
	 */
	@Override
	public ProfileDetail removeByUserIdAndComapanyId(
			long companyId, long userId)
		throws NoSuchProfileDetailException {

		ProfileDetail profileDetail = findByUserIdAndComapanyId(
			companyId, userId);

		return remove(profileDetail);
	}

	/**
	 * Returns the number of profile details where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the number of matching profile details
	 */
	@Override
	public int countByUserIdAndComapanyId(long companyId, long userId) {
		FinderPath finderPath = _finderPathCountByUserIdAndComapanyId;

		Object[] finderArgs = new Object[] {companyId, userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROFILEDETAIL_WHERE);

			sb.append(_FINDER_COLUMN_USERIDANDCOMAPANYID_COMPANYID_2);

			sb.append(_FINDER_COLUMN_USERIDANDCOMAPANYID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(userId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERIDANDCOMAPANYID_COMPANYID_2 =
		"profileDetail.companyId = ? AND ";

	private static final String _FINDER_COLUMN_USERIDANDCOMAPANYID_USERID_2 =
		"profileDetail.userId = ?";

	public ProfileDetailPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProfileDetail.class);

		setModelImplClass(ProfileDetailImpl.class);
		setModelPKClass(long.class);

		setTable(ProfileDetailTable.INSTANCE);
	}

	/**
	 * Caches the profile detail in the entity cache if it is enabled.
	 *
	 * @param profileDetail the profile detail
	 */
	@Override
	public void cacheResult(ProfileDetail profileDetail) {
		entityCache.putResult(
			ProfileDetailImpl.class, profileDetail.getPrimaryKey(),
			profileDetail);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {profileDetail.getUuid(), profileDetail.getGroupId()},
			profileDetail);

		finderCache.putResult(
			_finderPathFetchByUserIdAndComapanyId,
			new Object[] {
				profileDetail.getCompanyId(), profileDetail.getUserId()
			},
			profileDetail);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the profile details in the entity cache if it is enabled.
	 *
	 * @param profileDetails the profile details
	 */
	@Override
	public void cacheResult(List<ProfileDetail> profileDetails) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (profileDetails.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProfileDetail profileDetail : profileDetails) {
			if (entityCache.getResult(
					ProfileDetailImpl.class, profileDetail.getPrimaryKey()) ==
						null) {

				cacheResult(profileDetail);
			}
		}
	}

	/**
	 * Clears the cache for all profile details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProfileDetailImpl.class);

		finderCache.clearCache(ProfileDetailImpl.class);
	}

	/**
	 * Clears the cache for the profile detail.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProfileDetail profileDetail) {
		entityCache.removeResult(ProfileDetailImpl.class, profileDetail);
	}

	@Override
	public void clearCache(List<ProfileDetail> profileDetails) {
		for (ProfileDetail profileDetail : profileDetails) {
			entityCache.removeResult(ProfileDetailImpl.class, profileDetail);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProfileDetailImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ProfileDetailImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProfileDetailModelImpl profileDetailModelImpl) {

		Object[] args = new Object[] {
			profileDetailModelImpl.getUuid(),
			profileDetailModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, profileDetailModelImpl);

		args = new Object[] {
			profileDetailModelImpl.getCompanyId(),
			profileDetailModelImpl.getUserId()
		};

		finderCache.putResult(
			_finderPathCountByUserIdAndComapanyId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUserIdAndComapanyId, args,
			profileDetailModelImpl);
	}

	/**
	 * Creates a new profile detail with the primary key. Does not add the profile detail to the database.
	 *
	 * @param profileDetailId the primary key for the new profile detail
	 * @return the new profile detail
	 */
	@Override
	public ProfileDetail create(long profileDetailId) {
		ProfileDetail profileDetail = new ProfileDetailImpl();

		profileDetail.setNew(true);
		profileDetail.setPrimaryKey(profileDetailId);

		String uuid = PortalUUIDUtil.generate();

		profileDetail.setUuid(uuid);

		profileDetail.setCompanyId(CompanyThreadLocal.getCompanyId());

		return profileDetail;
	}

	/**
	 * Removes the profile detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileDetailId the primary key of the profile detail
	 * @return the profile detail that was removed
	 * @throws NoSuchProfileDetailException if a profile detail with the primary key could not be found
	 */
	@Override
	public ProfileDetail remove(long profileDetailId)
		throws NoSuchProfileDetailException {

		return remove((Serializable)profileDetailId);
	}

	/**
	 * Removes the profile detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the profile detail
	 * @return the profile detail that was removed
	 * @throws NoSuchProfileDetailException if a profile detail with the primary key could not be found
	 */
	@Override
	public ProfileDetail remove(Serializable primaryKey)
		throws NoSuchProfileDetailException {

		Session session = null;

		try {
			session = openSession();

			ProfileDetail profileDetail = (ProfileDetail)session.get(
				ProfileDetailImpl.class, primaryKey);

			if (profileDetail == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProfileDetailException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(profileDetail);
		}
		catch (NoSuchProfileDetailException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ProfileDetail removeImpl(ProfileDetail profileDetail) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(profileDetail)) {
				profileDetail = (ProfileDetail)session.get(
					ProfileDetailImpl.class, profileDetail.getPrimaryKeyObj());
			}

			if (profileDetail != null) {
				session.delete(profileDetail);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (profileDetail != null) {
			clearCache(profileDetail);
		}

		return profileDetail;
	}

	@Override
	public ProfileDetail updateImpl(ProfileDetail profileDetail) {
		boolean isNew = profileDetail.isNew();

		if (!(profileDetail instanceof ProfileDetailModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(profileDetail.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					profileDetail);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in profileDetail proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProfileDetail implementation " +
					profileDetail.getClass());
		}

		ProfileDetailModelImpl profileDetailModelImpl =
			(ProfileDetailModelImpl)profileDetail;

		if (Validator.isNull(profileDetail.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			profileDetail.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (profileDetail.getCreateDate() == null)) {
			if (serviceContext == null) {
				profileDetail.setCreateDate(date);
			}
			else {
				profileDetail.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!profileDetailModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				profileDetail.setModifiedDate(date);
			}
			else {
				profileDetail.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(profileDetail);
			}
			else {
				profileDetail = (ProfileDetail)session.merge(profileDetail);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProfileDetailImpl.class, profileDetailModelImpl, false, true);

		cacheUniqueFindersCache(profileDetailModelImpl);

		if (isNew) {
			profileDetail.setNew(false);
		}

		profileDetail.resetOriginalValues();

		return profileDetail;
	}

	/**
	 * Returns the profile detail with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the profile detail
	 * @return the profile detail
	 * @throws NoSuchProfileDetailException if a profile detail with the primary key could not be found
	 */
	@Override
	public ProfileDetail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProfileDetailException {

		ProfileDetail profileDetail = fetchByPrimaryKey(primaryKey);

		if (profileDetail == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProfileDetailException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return profileDetail;
	}

	/**
	 * Returns the profile detail with the primary key or throws a <code>NoSuchProfileDetailException</code> if it could not be found.
	 *
	 * @param profileDetailId the primary key of the profile detail
	 * @return the profile detail
	 * @throws NoSuchProfileDetailException if a profile detail with the primary key could not be found
	 */
	@Override
	public ProfileDetail findByPrimaryKey(long profileDetailId)
		throws NoSuchProfileDetailException {

		return findByPrimaryKey((Serializable)profileDetailId);
	}

	/**
	 * Returns the profile detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param profileDetailId the primary key of the profile detail
	 * @return the profile detail, or <code>null</code> if a profile detail with the primary key could not be found
	 */
	@Override
	public ProfileDetail fetchByPrimaryKey(long profileDetailId) {
		return fetchByPrimaryKey((Serializable)profileDetailId);
	}

	/**
	 * Returns all the profile details.
	 *
	 * @return the profile details
	 */
	@Override
	public List<ProfileDetail> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ProfileDetail> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<ProfileDetail> findAll(
		int start, int end,
		OrderByComparator<ProfileDetail> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<ProfileDetail> findAll(
		int start, int end, OrderByComparator<ProfileDetail> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<ProfileDetail> list = null;

		if (useFinderCache) {
			list = (List<ProfileDetail>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROFILEDETAIL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROFILEDETAIL;

				sql = sql.concat(ProfileDetailModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProfileDetail>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the profile details from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProfileDetail profileDetail : findAll()) {
			remove(profileDetail);
		}
	}

	/**
	 * Returns the number of profile details.
	 *
	 * @return the number of profile details
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PROFILEDETAIL);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "profileDetailId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROFILEDETAIL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProfileDetailModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the profile detail persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathFetchByUserIdAndComapanyId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUserIdAndComapanyId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"companyId", "userId"}, true);

		_finderPathCountByUserIdAndComapanyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdAndComapanyId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"companyId", "userId"}, false);

		_setProfileDetailUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProfileDetailUtilPersistence(null);

		entityCache.removeCache(ProfileDetailImpl.class.getName());
	}

	private void _setProfileDetailUtilPersistence(
		ProfileDetailPersistence profileDetailPersistence) {

		try {
			Field field = ProfileDetailUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, profileDetailPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = amfPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = amfPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = amfPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PROFILEDETAIL =
		"SELECT profileDetail FROM ProfileDetail profileDetail";

	private static final String _SQL_SELECT_PROFILEDETAIL_WHERE =
		"SELECT profileDetail FROM ProfileDetail profileDetail WHERE ";

	private static final String _SQL_COUNT_PROFILEDETAIL =
		"SELECT COUNT(profileDetail) FROM ProfileDetail profileDetail";

	private static final String _SQL_COUNT_PROFILEDETAIL_WHERE =
		"SELECT COUNT(profileDetail) FROM ProfileDetail profileDetail WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "profileDetail.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProfileDetail exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProfileDetail exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProfileDetailPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private ProfileDetailModelArgumentsResolver
		_profileDetailModelArgumentsResolver;

}