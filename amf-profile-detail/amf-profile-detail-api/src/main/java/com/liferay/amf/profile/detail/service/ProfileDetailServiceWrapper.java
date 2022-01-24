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

package com.liferay.amf.profile.detail.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProfileDetailService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProfileDetailService
 * @generated
 */
public class ProfileDetailServiceWrapper
	implements ProfileDetailService, ServiceWrapper<ProfileDetailService> {

	public ProfileDetailServiceWrapper(
		ProfileDetailService profileDetailService) {

		_profileDetailService = profileDetailService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _profileDetailService.getOSGiServiceIdentifier();
	}

	@Override
	public ProfileDetailService getWrappedService() {
		return _profileDetailService;
	}

	@Override
	public void setWrappedService(ProfileDetailService profileDetailService) {
		_profileDetailService = profileDetailService;
	}

	private ProfileDetailService _profileDetailService;

}