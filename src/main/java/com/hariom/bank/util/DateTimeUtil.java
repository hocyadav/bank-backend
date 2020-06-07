package com.hariom.bank.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Get current date and time 
 * @author Hariom Yadav | 06-Jun-2020
 *
 */
public class DateTimeUtil {
	
	/**
	 * order date = Current date and time
	 * @return Date and time
	 */
	public static String dateTime() {
		LocalDateTime myDateObj = LocalDateTime.now();  
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");  
	    String formattedDate = myDateObj.format(myFormatObj); 
	    
	    return formattedDate;
	}
	
}
