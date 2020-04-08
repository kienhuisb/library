/******************************************************************************
 * Cal Project
 * 
 *  Written by Michael Fross.  Copyright 2019-2020  All rights reserved.
 *  
 *  License: MIT License / https://opensource.org/licenses/MIT
 *  Please see included LICENSE.txt file for additional details
 *           
 ******************************************************************************/
package org.fross.library;

import java.text.DecimalFormat;
import org.fusesource.jansi.Ansi;
import org.fross.library.Output;

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
	 * HumanReadable(): Take a number in Bytes and return a more human readable format
	 * 
	 * Reference:
	 * https://stackoverflow.com/questions/3758606/how-to-convert-byte-size-into-human-readable-format-in-java
	 * 
	 * @param bytes
	 * @return
	 */
	public static String humanReadable(long bytes) {
		String[] descriptor = { "K", "M", "G", "T", "P", "E" };
		int unit = 1000; // As opposed to 1024

		if (bytes < unit) {
			return bytes + "  B";
		}

		int exp = (int) (Math.log(bytes) / Math.log(unit));
		String pre = descriptor[exp - 1];
		return String.format("%.3f %sB", bytes / Math.pow(unit, exp), pre);
	}

}
