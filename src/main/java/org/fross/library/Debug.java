/******************************************************************************
 * Output.java
 * 
 * A class to control output of a console program.  Contains methods
 * for colorization, debug and errors output.
 * 
 *  Written by Michael Fross.  Copyright 2019-2020  All rights reserved.
 *  
 *  License: MIT License / https://opensource.org/licenses/MIT
 *  Please see included LICENSE.txt file for additional details
 *           
 ******************************************************************************/
package org.fross.library;


/**
 * Debug contains static methods to maintain the debug state and display
 * messages when enabled.
 * 
 * @author michael.d.fross
 *
 */
public class Debug {
	// Class Variables
	private static boolean clDebug = false;

	/**
	 * Query(): Query current state of this object's debug setting
	 * 
	 * @return
	 */
	public static boolean query() {
		return clDebug;
	}

	/**
	 * Enable(): Turn debugging on for this object
	 */
	public static void enable() {
		clDebug = true;
	}

	/**
	 * Disable(): Disable debugging for this object
	 */
	public static void disable() {
		clDebug = false;
	}

}