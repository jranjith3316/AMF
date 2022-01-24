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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;amf_ProfileDetail&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ProfileDetail
 * @generated
 */
public class ProfileDetailTable extends BaseTable<ProfileDetailTable> {

	public static final ProfileDetailTable INSTANCE = new ProfileDetailTable();

	public final Column<ProfileDetailTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProfileDetailTable, Long> profileDetailId =
		createColumn(
			"profileDetailId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProfileDetailTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProfileDetailTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProfileDetailTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProfileDetailTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProfileDetailTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProfileDetailTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProfileDetailTable, String> aboutMe = createColumn(
		"aboutMe", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProfileDetailTable, String> favoriteQuotes =
		createColumn(
			"favoriteQuotes", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProfileDetailTable, String> favoriteMovie =
		createColumn(
			"favoriteMovie", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProfileDetailTable, String> leastFavMovie =
		createColumn(
			"leastFavMovie", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProfileDetailTable, String> favoriteActor =
		createColumn(
			"favoriteActor", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProfileDetailTable, String> favoriteGenre =
		createColumn(
			"favoriteGenre", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProfileDetailTable, Integer> privacy = createColumn(
		"privacy", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private ProfileDetailTable() {
		super("amf_ProfileDetail", ProfileDetailTable::new);
	}

}