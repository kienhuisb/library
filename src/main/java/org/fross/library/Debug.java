/**************************************************************************************************************
 * Library Project
 * 
 *  Library holds methods and classes frequently used by my programs.
 * 
 *  Copyright (c) 2019-2021 Michael Fross
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

/**
 * Debug contains static methods to maintain the debug state and display messages when enabled.
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

	/**
	 * displaySysInfo(): Display some system level information used in Debug Mode
	 */
	public static void displaySysInfo() {
		Output.debugPrint("------------------------------------------------------------");
		Output.debugPrint("System Information:");
		Output.debugPrint("  - class.path:     " + System.getProperty("java.class.path"));
		Output.debugPrint("  - java.home:      " + System.getProperty("java.home"));
		Output.debugPrint("  - java.vendor:    " + System.getProperty("java.vendor"));
		Output.debugPrint("  - java.version:   " + System.getProperty("java.version"));
		Output.debugPrint("  - os.name:        " + System.getProperty("os.name"));
		Output.debugPrint("  - os.version:     " + System.getProperty("os.version"));
		Output.debugPrint("  - os.arch:        " + System.getProperty("os.arch"));
		Output.debugPrint("  - user.name:      " + System.getProperty("user.name"));
		Output.debugPrint("  - user.home:      " + System.getProperty("user.home"));
		Output.debugPrint("  - user.dir:       " + System.getProperty("user.dir"));
		Output.debugPrint("  - file.separator: " + System.getProperty("file.separator"));
		Output.debugPrint("  - library.path:   " + System.getProperty("java.library.path"));
		Output.debugPrint("------------------------------------------------------------");
	}

}