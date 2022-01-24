create table amf_ProfileDetail (
	uuid_ VARCHAR(75) null,
	profileDetailId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	aboutMe VARCHAR(1000) null,
	favoriteQuotes VARCHAR(75) null,
	favoriteMovie VARCHAR(75) null,
	leastFavMovie VARCHAR(75) null,
	favoriteActor VARCHAR(75) null,
	favoriteGenre VARCHAR(75) null,
	privacy INTEGER
);