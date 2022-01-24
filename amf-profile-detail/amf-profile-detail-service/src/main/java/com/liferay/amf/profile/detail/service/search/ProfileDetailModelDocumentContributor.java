package com.liferay.amf.profile.detail.service.search;

import com.liferay.amf.profile.detail.model.ProfileDetail;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = "indexer.class.name=com.liferay.amf.profile.detail.model.ProfileDetail", service = ModelDocumentContributor.class)
public class ProfileDetailModelDocumentContributor implements ModelDocumentContributor<ProfileDetail> {

	@Override
	public void contribute(Document document, ProfileDetail profileDetail) {
		
		 document.addText(Field.USER_NAME, profileDetail.getUserName());
		document.addText("aboutMe", profileDetail.getAboutMe());
		document.addText("favoriteQuotes", profileDetail.getFavoriteQuotes());
		document.addText("favoriteMovie", profileDetail.getFavoriteMovie());
		document.addText("leastFavMovie", profileDetail.getLeastFavMovie());
		document.addText("favoriteActor", profileDetail.getFavoriteActor());
		document.addText("favoriteGenre", profileDetail.getFavoriteGenre());
		document.addKeyword("privacy", profileDetail.getPrivacy());
		document.addKeyword("userId", profileDetail.getUserId());		
	}

	private Log log = LogFactoryUtil.getLog(this.getClass().getName());



}
