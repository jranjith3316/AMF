package com.liferay.amf.profile.detail.web.constants;

import java.util.ArrayList;
import java.util.List;


public class AmfProfileDetailWebPortletKeys {

	public static final String AMFPROFILEDETAILWEB =
		"com_liferay_amf_profile_detail_web_AmfProfileDetailWebPortlet";

	public static final int PUBLIC_PERMISSION = 0;
	public static final int PRIVATE_PERMISSION = 1;
	public static final int PROTECTED_PERMISSION = 2;

	
    public static final List<String> FAVORITE_GENRE_LIST = new ArrayList<String>() {{
        add("Action");
        add("Comedies");
        add("Documentaries");
        add("Dramas");
        add("Foreign");
        add("Horror");
        add("Independent");
        add("Romance");
        add("Spirituality");
        add("Sci-Fi");
        add("Sports");
        add("Thriller");        
    }};



}