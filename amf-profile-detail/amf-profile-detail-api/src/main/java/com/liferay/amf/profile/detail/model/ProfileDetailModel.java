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

package com.liferay.amf.profile.detail.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the ProfileDetail service. Represents a row in the &quot;amf_ProfileDetail&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.amf.profile.detail.model.impl.ProfileDetailModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.amf.profile.detail.model.impl.ProfileDetailImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProfileDetail
 * @generated
 */
@ProviderType
public interface ProfileDetailModel
	extends BaseModel<ProfileDetail>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a profile detail model instance should use the {@link ProfileDetail} interface instead.
	 */

	/**
	 * Returns the primary key of this profile detail.
	 *
	 * @return the primary key of this profile detail
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this profile detail.
	 *
	 * @param primaryKey the primary key of this profile detail
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this profile detail.
	 *
	 * @return the uuid of this profile detail
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this profile detail.
	 *
	 * @param uuid the uuid of this profile detail
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the profile detail ID of this profile detail.
	 *
	 * @return the profile detail ID of this profile detail
	 */
	public long getProfileDetailId();

	/**
	 * Sets the profile detail ID of this profile detail.
	 *
	 * @param profileDetailId the profile detail ID of this profile detail
	 */
	public void setProfileDetailId(long profileDetailId);

	/**
	 * Returns the group ID of this profile detail.
	 *
	 * @return the group ID of this profile detail
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this profile detail.
	 *
	 * @param groupId the group ID of this profile detail
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this profile detail.
	 *
	 * @return the company ID of this profile detail
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this profile detail.
	 *
	 * @param companyId the company ID of this profile detail
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this profile detail.
	 *
	 * @return the user ID of this profile detail
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this profile detail.
	 *
	 * @param userId the user ID of this profile detail
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this profile detail.
	 *
	 * @return the user uuid of this profile detail
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this profile detail.
	 *
	 * @param userUuid the user uuid of this profile detail
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this profile detail.
	 *
	 * @return the user name of this profile detail
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this profile detail.
	 *
	 * @param userName the user name of this profile detail
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this profile detail.
	 *
	 * @return the create date of this profile detail
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this profile detail.
	 *
	 * @param createDate the create date of this profile detail
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this profile detail.
	 *
	 * @return the modified date of this profile detail
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this profile detail.
	 *
	 * @param modifiedDate the modified date of this profile detail
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the about me of this profile detail.
	 *
	 * @return the about me of this profile detail
	 */
	@AutoEscape
	public String getAboutMe();

	/**
	 * Sets the about me of this profile detail.
	 *
	 * @param aboutMe the about me of this profile detail
	 */
	public void setAboutMe(String aboutMe);

	/**
	 * Returns the favorite quotes of this profile detail.
	 *
	 * @return the favorite quotes of this profile detail
	 */
	@AutoEscape
	public String getFavoriteQuotes();

	/**
	 * Sets the favorite quotes of this profile detail.
	 *
	 * @param favoriteQuotes the favorite quotes of this profile detail
	 */
	public void setFavoriteQuotes(String favoriteQuotes);

	/**
	 * Returns the favorite movie of this profile detail.
	 *
	 * @return the favorite movie of this profile detail
	 */
	@AutoEscape
	public String getFavoriteMovie();

	/**
	 * Sets the favorite movie of this profile detail.
	 *
	 * @param favoriteMovie the favorite movie of this profile detail
	 */
	public void setFavoriteMovie(String favoriteMovie);

	/**
	 * Returns the least fav movie of this profile detail.
	 *
	 * @return the least fav movie of this profile detail
	 */
	@AutoEscape
	public String getLeastFavMovie();

	/**
	 * Sets the least fav movie of this profile detail.
	 *
	 * @param leastFavMovie the least fav movie of this profile detail
	 */
	public void setLeastFavMovie(String leastFavMovie);

	/**
	 * Returns the favorite actor of this profile detail.
	 *
	 * @return the favorite actor of this profile detail
	 */
	@AutoEscape
	public String getFavoriteActor();

	/**
	 * Sets the favorite actor of this profile detail.
	 *
	 * @param favoriteActor the favorite actor of this profile detail
	 */
	public void setFavoriteActor(String favoriteActor);

	/**
	 * Returns the favorite genre of this profile detail.
	 *
	 * @return the favorite genre of this profile detail
	 */
	@AutoEscape
	public String getFavoriteGenre();

	/**
	 * Sets the favorite genre of this profile detail.
	 *
	 * @param favoriteGenre the favorite genre of this profile detail
	 */
	public void setFavoriteGenre(String favoriteGenre);

	/**
	 * Returns the privacy of this profile detail.
	 *
	 * @return the privacy of this profile detail
	 */
	public int getPrivacy();

	/**
	 * Sets the privacy of this profile detail.
	 *
	 * @param privacy the privacy of this profile detail
	 */
	public void setPrivacy(int privacy);

	@Override
	public ProfileDetail cloneWithOriginalValues();

}