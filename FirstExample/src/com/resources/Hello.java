package com.resources;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Path("/Zied")
public class Hello extends ReadJSONfromFile{
	
//	@GET
//	@Path("getResult&{GPA}")
//	@Produces("text/json")
//	public String getResult(@PathParam("GPA") double GPA) throws FileNotFoundException, IOException {
//	
//		
//		String json = jsonParser.FileReader.loadFileIntoString("json/StudentResult.json", "utf-8");
//    	
//    	JSONArray status = JSONArray.fromObject(json);
//        String resultOutput = " ";
//        for(int i = 0; i < status.size(); i++)
//        {
//            JSONObject student = status.getJSONObject(i);
//            double eGPA = student.getDouble("GPA");
//            if(eGPA > GPA)
//            {
//                //counter +=1;
//                System.out.println(" First Name :" + student.getString("FirstName") + "Last Name :" +student.getString("LastName") + "GPA =" + student.getDouble("GPA"));
//            resultOutput = student.getString("FirstName") + student.getString("LastName") + student.getDouble("GPA");
//            }
//        }
//        
//		return resultOutput;
//		
//	}

	@GET
	@Path("/get")
	@Produces("application/json")
	public String getProductInJSON() {

		
		return "[]";

	}
	///////
	@SuppressWarnings("static-access")
	@GET
	@Path("/getResult/{GPA}")
	@Produces("application/json")
	public String getResultfinal(@PathParam("GPA") double GPA) throws FileNotFoundException, IOException {
	
		
		ReadJSONfromFile rs = new ReadJSONfromFile();
		return rs.getResult(GPA);
		
	}
	///
	
	@GET
	@Path("getMonth&{firstName}&{lastName}&{year}&{month}&{day}")
	@Produces("text/json")
	public String getMonth(@PathParam("firstName")String firstName, @PathParam("lastName") String lastName, @PathParam("year") int year, @PathParam("month") int month, @PathParam("day") int day) {
		
		Calendar cal = Calendar.getInstance();
		int currentYear = cal.get(Calendar.YEAR);
		
		//int currentMonth = cal.get(Calendar.MONTH);
		
		int finalmonth = ((currentYear - year) * 12) - month;
		
		toJSONdays(firstName, lastName, finalmonth, "AgeInMonths");
		
		String finalJSONObject  = toJSONdays(firstName, lastName, finalmonth, "ageInMonths").toString();
		
		return finalJSONObject;
		//return "FirstName : " + firstName + '\n' + "LastName : "  + lastName + '\n' + "AgeInMonths :" + finalmonth ;
		
	}
	
	@GET
	@Path("getDay&{firstName}&{lastName}&{year}&{month}&{day}")
	@Produces("text/json")
	public String getDay(@PathParam("firstName")String firstName, @PathParam("lastName") String lastName, @PathParam("year") int year, @PathParam("month") int month, @PathParam("day") int day) {
		
		Calendar cal = Calendar.getInstance();
		int currentYear = cal.get(Calendar.YEAR);
		
		
		int finalDay = ((currentYear - year)* 365) - (month * 30) + (30 - day);
		
		toJSONdays(firstName, lastName, finalDay, "AgeInDays");
		
		String finalJSONObject  = toJSONdays(firstName, lastName, finalDay, "ageInDays").toString();
		
		return finalJSONObject;
		//return "FirstName : " + firstName + '\n' + "LastName : "  + lastName + '\n' + "AgeInDays :" + finalDay ;
	}
	
	public JSONObject toJSONdays(String firstName, String lastName, int ageInDays, String ageIn)
	{
		JSONObject accumulateAge = new JSONObject();
	    accumulateAge.accumulate("FirstName", firstName);
	    accumulateAge.accumulate("LastName", lastName);
	    accumulateAge.accumulate(ageIn, ageInDays);
	   System.out.println(accumulateAge);
	    return accumulateAge;
	}
	
	
	
	
}
