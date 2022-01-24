create index IX_B2E1B087 on amf_ProfileDetail (companyId, userId);
create index IX_914AED2F on amf_ProfileDetail (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_4DBAF371 on amf_ProfileDetail (uuid_[$COLUMN_LENGTH:75$], groupId);