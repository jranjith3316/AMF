package com.liferay.amf.profile.detail.service.search;

import com.liferay.amf.profile.detail.model.ProfileDetail;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = {})
public class ProfileDetailSearchRegister {

	@Activate
	protected void activate(BundleContext bundleContext) {

		_serviceRegistration = modelSearchRegistrarHelper.register(ProfileDetail.class, bundleContext,
				modelSearchDefinition -> {

					modelSearchDefinition.setDefaultSelectedFieldNames(Field.COMPANY_ID, Field.ENTRY_CLASS_NAME,
							Field.ENTRY_CLASS_PK, Field.GROUP_ID, Field.CREATE_DATE, Field.UID,
							Field.USER_ID, "userName", "aboutMe", "favoriteQuotes", "favoriteMovie", "leastFavMovie",
							"favoriteActor", "favoriteGenre", "privacy");
					 modelSearchDefinition.setModelIndexWriteContributor(modelIndexWriterContributor);
					 //modelSearchDefinition.setModelSummaryContributor(modelSummaryContributor);
				});
	}

	@Deactivate
	protected void deactivate() {

		_serviceRegistration.unregister();
	}

	@Reference(target = "(indexer.class.name=com.liferay.amf.profile.detail.model.ProfileDetail)")
	protected ModelIndexerWriterContributor<ProfileDetail> modelIndexWriterContributor;

	@Reference
	protected ModelSearchRegistrarHelper modelSearchRegistrarHelper;

	/*
	 * @Reference(target =
	 * "(indexer.class.name=com.liferay.amf.profile.detail.model.ProfileDetail)")
	 * protected ModelSummaryContributor modelSummaryContributor;
	 */
	private ServiceRegistration<?> _serviceRegistration;

}
