package com.liferay.amf.profile.detail.service.search;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        property = "indexer.class.name=com.liferay.profile.detail.info.service.model.ProfileDetail",
        service = ModelSummaryContributor.class
)
public class ProfileDetailModelSummaryContributor
    implements ModelSummaryContributor {

  
    @Override
	public Summary getSummary(Document document, Locale locale, String snippet) {

		return _createSummary(document, "userName", "aboutMe");
	}

	private Summary _createSummary(Document document, String userName, String aboutMe) {

		String prefix = Field.SNIPPET + StringPool.UNDERLINE;

		Summary summary = new Summary(document.get(prefix + aboutMe, aboutMe),
				document.get(prefix + userName, userName));

		summary.setMaxContentLength(200);

		return summary;
	}

}
