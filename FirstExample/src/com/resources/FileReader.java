/**
 * 
 */
package com.resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

/**
 * @author student
 *
 */
public class FileReader {


	    public static String loadFileIntoString(String filePath, String fileEncoding) throws FileNotFoundException, IOException {
	    	
	        String res = "";
	        try {
	        	res = IOUtils.toString( FileReader.class.getClass().getClassLoader().getResourceAsStream(filePath), fileEncoding);
	        }catch(Exception ex){
	        	ex.printStackTrace();
	        }
	        return res;
	    }
	
}
