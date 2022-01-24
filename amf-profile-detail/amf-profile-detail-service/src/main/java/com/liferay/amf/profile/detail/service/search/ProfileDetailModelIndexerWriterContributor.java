package com.liferay.amf.profile.detail.service.search;

import com.liferay.amf.profile.detail.model.ProfileDetail;
import com.liferay.amf.profile.detail.service.ProfileDetailLocalService;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.IndexerWriterMode;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.liferay.amf.profile.detail.model.ProfileDetail",
        service = ModelIndexerWriterContributor.class
)
public class ProfileDetailModelIndexerWriterContributor implements ModelIndexerWriterContributor<ProfileDetail> {

	@Override
	public void customize(BatchIndexingActionable batchIndexingActionable,
			ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
        batchIndexingActionable.setPerformActionMethod((ProfileDetail profileDetail) -> {
            Document document = modelIndexerWriterDocumentHelper.getDocument(
    profileDetail);

            batchIndexingActionable.addDocuments(document);
        });
		
	}

	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
        return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
        		profileDetailLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(ProfileDetail profileDetail) {
        return profileDetail.getCompanyId();
     }

	@Override
	public IndexerWriterMode getIndexerWriterMode(ProfileDetail profileDetail) {	
			return IndexerWriterMode.UPDATE;
	}

	
	@Reference
    protected DynamicQueryBatchIndexingActionableFactory
    dynamicQueryBatchIndexingActionableFactory;


    @Reference
    protected ProfileDetailLocalService profileDetailLocalService;

}
