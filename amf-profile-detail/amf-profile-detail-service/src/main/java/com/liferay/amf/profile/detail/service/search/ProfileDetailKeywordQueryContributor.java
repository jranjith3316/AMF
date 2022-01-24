package com.liferay.amf.profile.detail.service.search;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.liferay.amf.profile.detail.model.ProfileDetail",
        service = KeywordQueryContributor.class
)
public class ProfileDetailKeywordQueryContributor
    implements KeywordQueryContributor {

    @Override
    public void contribute(
        String keywords, BooleanQuery booleanQuery,
        KeywordQueryContributorHelper keywordQueryContributorHelper) {

        SearchContext searchContext =
    keywordQueryContributorHelper.getSearchContext();

		queryHelper.addSearchTerm(booleanQuery, searchContext, Field.USER_NAME, false);
		queryHelper.addSearchTerm(booleanQuery, searchContext, Field.USER_ID, false);
		queryHelper.addSearchTerm(booleanQuery, searchContext, "aboutMe", false);
		queryHelper.addSearchTerm(booleanQuery, searchContext, "favoriteQuotes", false);
		queryHelper.addSearchTerm(booleanQuery, searchContext, "favoriteMovie", false);
		queryHelper.addSearchTerm(booleanQuery, searchContext, "leastFavMovie", false);
		queryHelper.addSearchTerm(booleanQuery, searchContext, "favoriteActor", false);
		queryHelper.addSearchTerm(booleanQuery, searchContext, "favoriteGenre", false);
		queryHelper.addSearchTerm(booleanQuery, searchContext, "privacy", false);

    }

    @Reference
    protected QueryHelper queryHelper;

}

