package com.liferay.amf.profile.detail.service.persistence.impl;

import com.liferay.amf.profile.detail.service.persistence.ProfileDetailFinder;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = ProfileDetailFinder.class)
public class ProfileDetailFinderImpl extends ProfileDetailFinderBaseImpl implements ProfileDetailFinder
{
	private static final Log LOG = LogFactoryUtil.getLog(ProfileDetailFinderImpl.class);
	private static final String WHERE_CLAUSE = "[$WHERE_CLAUSE$]";
	private static final String LIMIT = "[$LIMIT$]";
	private static final String LIMIT_LITERAL = "limit ";


	public List<Object[]> getProfileDetailSearchResult(String[] values, String keyword, String subQuery, String toBirthDate, String fromBirthDate, String criteria, int offset, int limit) {
		Session session = null;

		try {

			String sql = customSQL.get(getClass(),"com.liferay.amf.profile.detail.service.persistence.impl.ProfileDetailFinderImpl.getProfileDetailSearchResult");
			session = openSession();
			if(-1 != limit && -1 != offset) {
				sql = sql.replace(LIMIT, LIMIT_LITERAL + offset + " ," + limit);
			}else {
				sql = sql.replace(LIMIT, StringPool.BLANK);
			}


			if(Validator.isNotNull(fromBirthDate)|| Validator.isNotNull(toBirthDate)) {
				if(!subQuery.isEmpty()) {
					if(!"where".equalsIgnoreCase(subQuery)) {
						subQuery+=criteria.equalsIgnoreCase("any")?"OR ":"AND ";
					}
				}
				subQuery+=" (";
				if(Validator.isNotNull(fromBirthDate)) {
					subQuery= subQuery+"UNIX_TIMESTAMP(str_to_date(ct.birthday ,'%Y-%m-%d')) > UNIX_TIMESTAMP(str_to_date('"+fromBirthDate+"' ,'%m/%d/%Y'))";
				}

				if(Validator.isNotNull(toBirthDate)) {
					subQuery= subQuery+"and UNIX_TIMESTAMP(str_to_date(ct.birthday ,'%Y-%m-%d')) < UNIX_TIMESTAMP(str_to_date('"+toBirthDate+"' ,'%m/%d/%Y'))";
				}else {
					subQuery= subQuery+"and UNIX_TIMESTAMP(str_to_date(ct.birthday ,'%Y-%m-%d')) < UNIX_TIMESTAMP(NOW())";
				}
				subQuery+=") ";
			}

			if ( Validator.isNotNull(subQuery)) {
				sql = sql.replace(WHERE_CLAUSE, subQuery);
			}else {
				sql = sql.replace(WHERE_CLAUSE, StringPool.BLANK);
			}

			SQLQuery sqlQuery = session.createSQLQuery(sql);
			QueryPos qPos = QueryPos.getInstance(sqlQuery);
			if(values.length!=0) {
				for (String string : values) {
					qPos.add("%" + keyword + "%");
				}
			}
			return sqlQuery.list();
		} catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		finally {
			closeSession(session);
		}
		return new ArrayList<>();
	}


	@Reference
	private CustomSQL customSQL;

}