/******************************************************************************
 * Format.java
 * 
 * A class that contains various formatting functions.
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

}
