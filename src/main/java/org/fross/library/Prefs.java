/**************************************************************************************************************
 * Library Project
 * 
 *  Library holds methods and classes frequently used by my programs.
 * 
 *  Copyright (c) 2019 Michael Fross
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
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