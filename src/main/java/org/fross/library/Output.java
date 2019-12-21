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

import static org.fusesource.jansi.Ansi.*;
import org.fusesource.jansi.Ansi;
import org.fross.library.Debug;

public class Output {
	/**
	 * printColorln(): Print to the console with the provided foreground color
	 * 
	 * Allowable colors are: - Ansi.Color.BLACK - Ansi.Color.RED - Ansi.Color.GREEN
	 * - Ansi.Color.YELLOW - Ansi.Color.BLUE - Ansi.Color.MAGENTA - Ansi.Color.CYAN
	 * - Ansi.Color.WHITE - Ansi.Color.DEFAULT
	 * 
	 * @param Color
	 * @param msg
	 */
	public static void printColorln(Ansi.Color clr, String msg) {
		System.out.println(ansi().a(Attribute.INTENSITY_BOLD).fg(clr).a(msg).reset());
	}

	/**
	 * printColor(): Print to the console with the provided foreground color
	 * 
	 * Allowable colors are: - Ansi.Color.BLACK - Ansi.Color.RED - Ansi.Color.GREEN
	 * - Ansi.Color.YELLOW - Ansi.Color.BLUE - Ansi.Color.MAGENTA - Ansi.Color.CYAN
	 * - Ansi.Color.WHITE - Ansi.Color.DEFAULT
	 * 
	 * @param Color
	 * @param msg
	 */
	public static void printColor(Ansi.Color clr, String msg) {
		System.out.print(ansi().a(Attribute.INTENSITY_BOLD).fg(clr).a(msg).reset());
	}

	/**
	 * println(): Basic System.out.println call. It's here so all text output can go
	 * through this function.
	 * 
	 * @param msg
	 */
	public static void println(String msg) {
		System.out.println(msg);
	}

	/**
	 * print(): Basic System.out.print call. It's here so out text output can go
	 * through this function.
	 * 
	 * @param msg
	 */
	public static void print(String msg) {
		System.out.print(msg);
	}

	/**
	 * fatalError(): Print the provided string in RED and exit the program with the
	 * error code given
	 * 
	 * @param msg
	 * @param errorcode
	 */
	public static void fatalError(String msg, int errorcode) {
		Output.printColorln(Ansi.Color.RED, "\nFATAL ERROR: " + msg);
		System.exit(errorcode);
	}

	/**
	 * debugPrint(): Print the provided text in RED with the preface of DEBUG:
	 * 
	 * @param msg
	 */
	public static void debugPrint(String msg) {
		if (Debug.query() == true) {
			Output.printColorln(Ansi.Color.RED, "DEBUG:  " + msg);
		}
	}

}