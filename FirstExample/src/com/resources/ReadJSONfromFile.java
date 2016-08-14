package com.resources;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author 1590085
 */
public class ReadJSONfromFile {
    

    public static void main(String args[]) throws Exception{

		//creating JSON object from JSON file
        //JSONObject search = Methods.extractJson();
        
    	getResult(4.0);
         
    }

	/**
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String getResult(double cGPA) throws FileNotFoundException, IOException {
		String json = jsonParser.FileReader.loadFileIntoString("json/StudentResult.json", "utf-8");
    	
    	JSONArray status = JSONArray.fromObject(json);
        
        for(int i = 0; i < status.size(); i++)
        {
            JSONObject student = status.getJSONObject(i);
            
            if(student.getDouble("GPA") > cGPA)
            {
                //counter +=1;
                System.out.println(" First Name " + student.getString("FirstName") + "Last Name :" +student.getString("LastName") + "GPA =" + student.getDouble("GPA"));
            }
        }
		return json;
	}
}
    