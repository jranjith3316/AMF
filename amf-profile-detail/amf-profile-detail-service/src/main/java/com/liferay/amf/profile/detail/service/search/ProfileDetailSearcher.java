package com.liferay.amf.profile.detail.service.search;

import com.liferay.amf.profile.detail.model.ProfileDetail;
import com.liferay.portal.kernel.search.BaseSearcher;
import com.liferay.portal.kernel.search.Field;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = "model.class.name=com.liferay.amf.profile.detail.model.ProfileDetail", service = BaseSearcher.class)
	public class ProfileDetailSearcher extends BaseSearcher {

		public static final String CLASS_NAME = ProfileDetail.class.getName();

		public ProfileDetailSearcher() {
			setDefaultSelectedFieldNames( Field.COMPANY_ID,
					Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK, Field.GROUP_ID, Field.CREATE_DATE,
					Field.UID, Field.USER_ID, "userName",
                    "aboutMe", "favoriteQuotes",
                    "favoriteMovie", "leastFavMovie", "favoriteActor",
                    "favoriteGenre", "privacy");
			setPermissionAware(true);
			setStagingAware(false);
			setFilterSearch(true);
		}

		@Override
		public String getClassName() {
			return CLASS_NAME;
		}

	}

