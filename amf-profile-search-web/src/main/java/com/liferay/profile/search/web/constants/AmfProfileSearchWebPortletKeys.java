package com.liferay.profile.search.web.constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmfProfileSearchWebPortletKeys {

	public static final String AMFPROFILESEARCHWEB =
		"com_liferay_profile_search_web_AmfProfileSearchWebPortlet";

    public static Map<String, Boolean> advanceSearchCheckBoxesMap;
    
    static
    {
    	advanceSearchCheckBoxesMap = new HashMap<>();
    	advanceSearchCheckBoxesMap.put("userName", Boolean.FALSE);
    	advanceSearchCheckBoxesMap.put("aboutMe", Boolean.FALSE);
    	advanceSearchCheckBoxesMap.put("favoriteQuotes", Boolean.FALSE);
    	advanceSearchCheckBoxesMap.put("favoriteMovie", Boolean.FALSE);
    	advanceSearchCheckBoxesMap.put("leastFavMovie", Boolean.FALSE);
    	advanceSearchCheckBoxesMap.put("favoriteActor", Boolean.FALSE); 	
    }
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