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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ProfileDetail}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProfileDetail
 * @generated
 */
public class ProfileDetailWrapper
	extends BaseModelWrapper<ProfileDetail>
	implements ModelWrapper<ProfileDetail>, ProfileDetail {

	public ProfileDetailWrapper(ProfileDetail profileDetail) {
		super(profileDetail);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("profileDetailId", getProfileDetailId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("aboutMe", getAboutMe());
		attributes.put("favoriteQuotes", getFavoriteQuotes());
		attributes.put("favoriteMovie", getFavoriteMovie());
		attributes.put("leastFavMovie", getLeastFavMovie());
		attributes.put("favoriteActor", getFavoriteActor());
		attributes.put("favoriteGenre", getFavoriteGenre());
		attributes.put("privacy", getPrivacy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long profileDetailId = (Long)attributes.get("profileDetailId");

		if (profileDetailId != null) {
			setProfileDetailId(profileDetailId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String aboutMe = (String)attributes.get("aboutMe");

		if (aboutMe != null) {
			setAboutMe(aboutMe);
		}

		String favoriteQuotes = (String)attributes.get("favoriteQuotes");

		if (favoriteQuotes != null) {
			setFavoriteQuotes(favoriteQuotes);
		}

		String favoriteMovie = (String)attributes.get("favoriteMovie");

		if (favoriteMovie != null) {
			setFavoriteMovie(favoriteMovie);
		}

		String leastFavMovie = (String)attributes.get("leastFavMovie");

		if (leastFavMovie != null) {
			setLeastFavMovie(leastFavMovie);
		}

		String favoriteActor = (String)attributes.get("favoriteActor");

		if (favoriteActor != null) {
			setFavoriteActor(favoriteActor);
		}

		String favoriteGenre = (String)attributes.get("favoriteGenre");

		if (favoriteGenre != null) {
			setFavoriteGenre(favoriteGenre);
		}

		Integer privacy = (Integer)attributes.get("privacy");

		if (privacy != null) {
			setPrivacy(privacy);
		}
	}

	@Override
	public ProfileDetail cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the about me of this profile detail.
	 *
	 * @return the about me of this profile detail
	 */
	@Override
	public String getAboutMe() {
		return model.getAboutMe();
	}

	/**
	 * Returns the company ID of this profile detail.
	 *
	 * @return the company ID of this profile detail
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this profile detail.
	 *
	 * @return the create date of this profile detail
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the favorite actor of this profile detail.
	 *
	 * @return the favorite actor of this profile detail
	 */
	@Override
	public String getFavoriteActor() {
		return model.getFavoriteActor();
	}

	/**
	 * Returns the favorite genre of this profile detail.
	 *
	 * @return the favorite genre of this profile detail
	 */
	@Override
	public String getFavoriteGenre() {
		return model.getFavoriteGenre();
	}

	/**
	 * Returns the favorite movie of this profile detail.
	 *
	 * @return the favorite movie of this profile detail
	 */
	@Override
	public String getFavoriteMovie() {
		return model.getFavoriteMovie();
	}

	/**
	 * Returns the favorite quotes of this profile detail.
	 *
	 * @return the favorite quotes of this profile detail
	 */
	@Override
	public String getFavoriteQuotes() {
		return model.getFavoriteQuotes();
	}

	/**
	 * Returns the group ID of this profile detail.
	 *
	 * @return the group ID of this profile detail
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the least fav movie of this profile detail.
	 *
	 * @return the least fav movie of this profile detail
	 */
	@Override
	public String getLeastFavMovie() {
		return model.getLeastFavMovie();
	}

	/**
	 * Returns the modified date of this profile detail.
	 *
	 * @return the modified date of this profile detail
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this profile detail.
	 *
	 * @return the primary key of this profile detail
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the privacy of this profile detail.
	 *
	 * @return the privacy of this profile detail
	 */
	@Override
	public int getPrivacy() {
		return model.getPrivacy();
	}

	/**
	 * Returns the profile detail ID of this profile detail.
	 *
	 * @return the profile detail ID of this profile detail
	 */
	@Override
	public long getProfileDetailId() {
		return model.getProfileDetailId();
	}

	/**
	 * Returns the user ID of this profile detail.
	 *
	 * @return the user ID of this profile detail
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this profile detail.
	 *
	 * @return the user name of this profile detail
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this profile detail.
	 *
	 * @return the user uuid of this profile detail
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this profile detail.
	 *
	 * @return the uuid of this profile detail
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the about me of this profile detail.
	 *
	 * @param aboutMe the about me of this profile detail
	 */
	@Override
	public void setAboutMe(String aboutMe) {
		model.setAboutMe(aboutMe);
	}

	/**
	 * Sets the company ID of this profile detail.
	 *
	 * @param companyId the company ID of this profile detail
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this profile detail.
	 *
	 * @param createDate the create date of this profile detail
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the favorite actor of this profile detail.
	 *
	 * @param favoriteActor the favorite actor of this profile detail
	 */
	@Override
	public void setFavoriteActor(String favoriteActor) {
		model.setFavoriteActor(favoriteActor);
	}

	/**
	 * Sets the favorite genre of this profile detail.
	 *
	 * @param favoriteGenre the favorite genre of this profile detail
	 */
	@Override
	public void setFavoriteGenre(String favoriteGenre) {
		model.setFavoriteGenre(favoriteGenre);
	}

	/**
	 * Sets the favorite movie of this profile detail.
	 *
	 * @param favoriteMovie the favorite movie of this profile detail
	 */
	@Override
	public void setFavoriteMovie(String favoriteMovie) {
		model.setFavoriteMovie(favoriteMovie);
	}

	/**
	 * Sets the favorite quotes of this profile detail.
	 *
	 * @param favoriteQuotes the favorite quotes of this profile detail
	 */
	@Override
	public void setFavoriteQuotes(String favoriteQuotes) {
		model.setFavoriteQuotes(favoriteQuotes);
	}

	/**
	 * Sets the group ID of this profile detail.
	 *
	 * @param groupId the group ID of this profile detail
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the least fav movie of this profile detail.
	 *
	 * @param leastFavMovie the least fav movie of this profile detail
	 */
	@Override
	public void setLeastFavMovie(String leastFavMovie) {
		model.setLeastFavMovie(leastFavMovie);
	}

	/**
	 * Sets the modified date of this profile detail.
	 *
	 * @param modifiedDate the modified date of this profile detail
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this profile detail.
	 *
	 * @param primaryKey the primary key of this profile detail
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the privacy of this profile detail.
	 *
	 * @param privacy the privacy of this profile detail
	 */
	@Override
	public void setPrivacy(int privacy) {
		model.setPrivacy(privacy);
	}

	/**
	 * Sets the profile detail ID of this profile detail.
	 *
	 * @param profileDetailId the profile detail ID of this profile detail
	 */
	@Override
	public void setProfileDetailId(long profileDetailId) {
		model.setProfileDetailId(profileDetailId);
	}

	/**
	 * Sets the user ID of this profile detail.
	 *
	 * @param userId the user ID of this profile detail
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this profile detail.
	 *
	 * @param userName the user name of this profile detail
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this profile detail.
	 *
	 * @param userUuid the user uuid of this profile detail
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this profile detail.
	 *
	 * @param uuid the uuid of this profile detail
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected ProfileDetailWrapper wrap(ProfileDetail profileDetail) {
		return new ProfileDetailWrapper(profileDetail);
	}

}