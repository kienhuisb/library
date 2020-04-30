/******************************************************************************
 * Library Project
 * 
 *  Written by Michael Fross.  Copyright 2019-2020  All rights reserved.
 *  
 *  License: MIT License / https://opensource.org/licenses/MIT
 *  Please see included LICENSE.txt file for additional details
 *           
 ******************************************************************************/
package org.fross.library;

public class Date {

	/**
	 * getCurrentMonth(): Return an integer value of the current month
	 * 
	 * @return
	 */
	public static int getCurrentMonth() {
		java.util.Calendar jc = java.util.Calendar.getInstance();
		int month = jc.get(java.util.Calendar.MONTH) + 1;
		return month;
	}

	/**
	 * getCurrentDay(): Return an integer value of the current day
	 * 
	 * @return
	 */
	public static int getCurrentDay() {
		java.util.Calendar jc = java.util.Calendar.getInstance();
		int year = jc.get(java.util.Calendar.DAY_OF_MONTH);
		return year;
	}

	/**
	 * getCurrentYear(): Return an integer value of the current year
	 * 
	 * @return
	 */
	public static int getCurrentYear() {
		java.util.Calendar jc = java.util.Calendar.getInstance();
		int year = jc.get(java.util.Calendar.YEAR);
		return year;
	}

}
