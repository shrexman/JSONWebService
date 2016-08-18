package com.resources;

import java.io.FileNotFoundException;
import java.io.IOException;

import net.sf.json.JSONObject;

public class Methods {

	
	
	public static JSONObject extractJson() throws FileNotFoundException,
			IOException {
		String json = FileReader.loadFileIntoString("json/StudentResult.json", "utf-8");
	    JSONObject search = JSONObject.fromObject(json);
		return search;
	}
	
        }      



