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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.amf.profile.detail.service.http.ProfileDetailServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ProfileDetailSoap implements Serializable {

	public static ProfileDetailSoap toSoapModel(ProfileDetail model) {
		ProfileDetailSoap soapModel = new ProfileDetailSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setProfileDetailId(model.getProfileDetailId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAboutMe(model.getAboutMe());
		soapModel.setFavoriteQuotes(model.getFavoriteQuotes());
		soapModel.setFavoriteMovie(model.getFavoriteMovie());
		soapModel.setLeastFavMovie(model.getLeastFavMovie());
		soapModel.setFavoriteActor(model.getFavoriteActor());
		soapModel.setFavoriteGenre(model.getFavoriteGenre());
		soapModel.setPrivacy(model.getPrivacy());

		return soapModel;
	}

	public static ProfileDetailSoap[] toSoapModels(ProfileDetail[] models) {
		ProfileDetailSoap[] soapModels = new ProfileDetailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProfileDetailSoap[][] toSoapModels(ProfileDetail[][] models) {
		ProfileDetailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProfileDetailSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProfileDetailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProfileDetailSoap[] toSoapModels(List<ProfileDetail> models) {
		List<ProfileDetailSoap> soapModels = new ArrayList<ProfileDetailSoap>(
			models.size());

		for (ProfileDetail model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProfileDetailSoap[soapModels.size()]);
	}

	public ProfileDetailSoap() {
	}

	public long getPrimaryKey() {
		return _profileDetailId;
	}

	public void setPrimaryKey(long pk) {
		setProfileDetailId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getProfileDetailId() {
		return _profileDetailId;
	}

	public void setProfileDetailId(long profileDetailId) {
		_profileDetailId = profileDetailId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getAboutMe() {
		return _aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		_aboutMe = aboutMe;
	}

	public String getFavoriteQuotes() {
		return _favoriteQuotes;
	}

	public void setFavoriteQuotes(String favoriteQuotes) {
		_favoriteQuotes = favoriteQuotes;
	}

	public String getFavoriteMovie() {
		return _favoriteMovie;
	}

	public void setFavoriteMovie(String favoriteMovie) {
		_favoriteMovie = favoriteMovie;
	}

	public String getLeastFavMovie() {
		return _leastFavMovie;
	}

	public void setLeastFavMovie(String leastFavMovie) {
		_leastFavMovie = leastFavMovie;
	}

	public String getFavoriteActor() {
		return _favoriteActor;
	}

	public void setFavoriteActor(String favoriteActor) {
		_favoriteActor = favoriteActor;
	}

	public String getFavoriteGenre() {
		return _favoriteGenre;
	}

	public void setFavoriteGenre(String favoriteGenre) {
		_favoriteGenre = favoriteGenre;
	}

	public int getPrivacy() {
		return _privacy;
	}

	public void setPrivacy(int privacy) {
		_privacy = privacy;
	}

	private String _uuid;
	private long _profileDetailId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _aboutMe;
	private String _favoriteQuotes;
	private String _favoriteMovie;
	private String _leastFavMovie;
	private String _favoriteActor;
	private String _favoriteGenre;
	private int _privacy;

}