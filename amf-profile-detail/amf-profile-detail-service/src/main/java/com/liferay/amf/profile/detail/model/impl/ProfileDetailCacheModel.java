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

package com.liferay.amf.profile.detail.model.impl;

import com.liferay.amf.profile.detail.model.ProfileDetail;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProfileDetail in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProfileDetailCacheModel
	implements CacheModel<ProfileDetail>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProfileDetailCacheModel)) {
			return false;
		}

		ProfileDetailCacheModel profileDetailCacheModel =
			(ProfileDetailCacheModel)object;

		if (profileDetailId == profileDetailCacheModel.profileDetailId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, profileDetailId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", profileDetailId=");
		sb.append(profileDetailId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", aboutMe=");
		sb.append(aboutMe);
		sb.append(", favoriteQuotes=");
		sb.append(favoriteQuotes);
		sb.append(", favoriteMovie=");
		sb.append(favoriteMovie);
		sb.append(", leastFavMovie=");
		sb.append(leastFavMovie);
		sb.append(", favoriteActor=");
		sb.append(favoriteActor);
		sb.append(", favoriteGenre=");
		sb.append(favoriteGenre);
		sb.append(", privacy=");
		sb.append(privacy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProfileDetail toEntityModel() {
		ProfileDetailImpl profileDetailImpl = new ProfileDetailImpl();

		if (uuid == null) {
			profileDetailImpl.setUuid("");
		}
		else {
			profileDetailImpl.setUuid(uuid);
		}

		profileDetailImpl.setProfileDetailId(profileDetailId);
		profileDetailImpl.setGroupId(groupId);
		profileDetailImpl.setCompanyId(companyId);
		profileDetailImpl.setUserId(userId);

		if (userName == null) {
			profileDetailImpl.setUserName("");
		}
		else {
			profileDetailImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			profileDetailImpl.setCreateDate(null);
		}
		else {
			profileDetailImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			profileDetailImpl.setModifiedDate(null);
		}
		else {
			profileDetailImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (aboutMe == null) {
			profileDetailImpl.setAboutMe("");
		}
		else {
			profileDetailImpl.setAboutMe(aboutMe);
		}

		if (favoriteQuotes == null) {
			profileDetailImpl.setFavoriteQuotes("");
		}
		else {
			profileDetailImpl.setFavoriteQuotes(favoriteQuotes);
		}

		if (favoriteMovie == null) {
			profileDetailImpl.setFavoriteMovie("");
		}
		else {
			profileDetailImpl.setFavoriteMovie(favoriteMovie);
		}

		if (leastFavMovie == null) {
			profileDetailImpl.setLeastFavMovie("");
		}
		else {
			profileDetailImpl.setLeastFavMovie(leastFavMovie);
		}

		if (favoriteActor == null) {
			profileDetailImpl.setFavoriteActor("");
		}
		else {
			profileDetailImpl.setFavoriteActor(favoriteActor);
		}

		if (favoriteGenre == null) {
			profileDetailImpl.setFavoriteGenre("");
		}
		else {
			profileDetailImpl.setFavoriteGenre(favoriteGenre);
		}

		profileDetailImpl.setPrivacy(privacy);

		profileDetailImpl.resetOriginalValues();

		return profileDetailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		profileDetailId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		aboutMe = objectInput.readUTF();
		favoriteQuotes = objectInput.readUTF();
		favoriteMovie = objectInput.readUTF();
		leastFavMovie = objectInput.readUTF();
		favoriteActor = objectInput.readUTF();
		favoriteGenre = objectInput.readUTF();

		privacy = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(profileDetailId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (aboutMe == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(aboutMe);
		}

		if (favoriteQuotes == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(favoriteQuotes);
		}

		if (favoriteMovie == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(favoriteMovie);
		}

		if (leastFavMovie == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(leastFavMovie);
		}

		if (favoriteActor == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(favoriteActor);
		}

		if (favoriteGenre == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(favoriteGenre);
		}

		objectOutput.writeInt(privacy);
	}

	public String uuid;
	public long profileDetailId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String aboutMe;
	public String favoriteQuotes;
	public String favoriteMovie;
	public String leastFavMovie;
	public String favoriteActor;
	public String favoriteGenre;
	public int privacy;

}