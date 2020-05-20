/**************************************************************************************************************
 * Library Project
 * Copyright 2019-2020 Michael Fross, all rights reserved
 * 
 * Library holds methods and classes frequently used by my programs.
 * 
 * License:  
 *  MIT License / https://opensource.org/licenses/MIT
 *  Please see included LICENSE.txt file for additional details
 *   
 ***************************************************************************************************************/
package org.fross.library;

import java.text.DecimalFormat;
import org.fusesource.jansi.Ansi;

public class Format {
	
	/**
	 * Comma Return a string with comma separators at the correct intervals.
	 * Supports decimal places and a negative sign.
	 * 
	 * @param num - Number to comma-ize
	 * @return
	 */
	public static String Comma(Double num) {
		DecimalFormat df = null;

		try {
			df = new DecimalFormat("#,###.00#######");
		} catch (Exception Ex) {
			Output.printColorln(Ansi.Color.RED, "ERROR Adding Commas to numbers:\n" + Ex.getMessage());
		}

		return (String.valueOf(df.format(num)));
	}
	
	
	/**
	 * HumanReadableBytes(): Take a long number in bytes and return a more human readable format
	 * Reference:
	 * https://stackoverflow.com/questions/3758606/how-to-convert-byte-size-into-human-readable-format-in-java
	 * https://www.geeksforgeeks.org/how-to-calculate-log-base-2-of-an-integer-in-java/?ref=leftbar-rightbar
	 * 
	 * @param numInBytes
	 * @return String
	 */
	public static String humanReadableBytes(long numInBytes) {
		String[] descriptor = { "K", "M", "G", "T", "P", "E" };
		int unit = 1000; // As opposed to 1024

		// If the size is < than 1k, just return as bytes
		if (numInBytes < unit) {
			return numInBytes + "  B";
		}

		// Math.log uses base 10.  You have to divide to get the base we want..in this case unit
		// exp is the number of times you have to multiply a base to get the inputed number
		int exp = (int) (Math.log(numInBytes) / Math.log(unit));
	
		// Determine the descriptor to use based on the log 
		String prefix = descriptor[exp - 1];
		
		// Create the string and return it
		return String.format("%.3f %sB", numInBytes / Math.pow(unit, exp), prefix);
	}

} // END OF CLASS
