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

import java.util.prefs.Preferences;

/**
 * Prefs: Simplify calling the Java preferences system 
 * 
 * @author michael.d.fross
 *
 */
public class Prefs {
	// Class Constants
	private static final String PREFS_PATH_DEFAULT = "/org/fross";

	// Class Variables
	private static Preferences prefs;

	/**
	 * Prefs Constructor: Set the path of the preferences to the default
	 */
	public Prefs() {
		prefs = Preferences.userRoot().node(PREFS_PATH_DEFAULT);
	}

	/**
	 * Prefs Constructor: Set the path of the preferences to be stored by string given
	 * 
	 * @param p
	 */
	public Prefs(String p) {
		prefs = Preferences.userRoot().node(p);
	}

	/**
	 * QueryBoolean(): Returns a boolean preference item
	 * 
	 * @param key
	 * @return
	 */
	public static boolean QueryBoolean(String key) {
		return prefs.getBoolean(key, false);
	}

	/**
	 * QueryInt(): Returns an integer preference item
	 * 
	 * @param key
	 * @return
	 */
	public static int QueryInt(String key) {
		return prefs.getInt(key, 0);
	}
	
	/**
	 * QueryDouble(): Returns a Double preference item
	 * 
	 * @param key
	 * @return
	 */
	public static Double QueryDouble(String key) {
		return prefs.getDouble(key, 0);
	}

	/**
	 * QueryString(): Returns a String preference item
	 * 
	 * @param key
	 * @return
	 */
	public static String QueryString(String key) {
		return prefs.get(key, "Error");
	}

	/**
	 * Set Sets a boolean preference
	 * 
	 * @param key
	 * @param value
	 */
	public static void Set(String key, boolean value) {
		prefs.putBoolean(key, value);
	}

	/**
	 * Set(): Sets a integer preference
	 * 
	 * @param key
	 * @param value
	 */
	public static void Set(String key, int value) {
		prefs.putInt(key, value);
	}

	/**
	 * Set(): Sets a double preference
	 * 
	 * @param key
	 * @param value
	 */
	public static void Set(String key, double value) {
		prefs.putDouble(key, value);
	}

	/**
	 * Set(): Sets a string preference
	 * 
	 * @param key
	 * @param value
	 */
	public static void Set(String key, String value) {
		prefs.put(key, value);
	}
}