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

import static org.fusesource.jansi.Ansi.ansi;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.Ansi.Attribute;
import org.fusesource.jansi.Ansi.Erase;

public class Output {
	static boolean colorEnabled = true;

	/**
	 * setColor():  Enable or disable colorized output
	 * 
	 * @param value
	 */
	public static void setColor(boolean value) {
		colorEnabled = value;
	}

	/**
	 * printColorln(): Print to the console with the provided foreground color
	 * 
	 * Allowable colors are: - Ansi.Color.BLACK - Ansi.Color.RED - Ansi.Color.GREEN - Ansi.Color.YELLOW
	 * - Ansi.Color.BLUE - Ansi.Color.MAGENTA - Ansi.Color.CYAN - Ansi.Color.WHITE - Ansi.Color.DEFAULT
	 * 
	 * @param Color
	 * @param msg
	 */
	public static void printColorln(Ansi.Color clr, String msg) {
		if (colorEnabled == true) {
			System.out.println(ansi().a(Attribute.INTENSITY_BOLD).fg(clr).a(msg).reset());
		} else {
			println(msg);
		}
	}

	/**
	 * colorEnabled(): Print to the console with the provided foreground color
	 * 
	 * Allowable colors are: - Ansi.Color.BLACK - Ansi.Color.RED - Ansi.Color.GREEN - Ansi.Color.YELLOW
	 * - Ansi.Color.BLUE - Ansi.Color.MAGENTA - Ansi.Color.CYAN - Ansi.Color.WHITE - Ansi.Color.DEFAULT
	 * 
	 * @param fclr
	 * @param msg
	 */
	public static void printColor(Ansi.Color fclr, String msg) {
		if (colorEnabled == true) {
			System.out.print(ansi().a(Attribute.INTENSITY_BOLD).fg(fclr).a(msg).reset());
		} else {
			print(msg);
		}
	}

	/**
	 * colorEnabled(): Overloaded. Added background parameter
	 * 
	 * @param fclr
	 * @param bclr
	 * @param msg
	 */
	public static void printColor(Ansi.Color fclr, Ansi.Color bclr, String msg) {
		if (colorEnabled == true) {
			System.out.print(ansi().a(Attribute.INTENSITY_BOLD).fg(fclr).bg(bclr).a(msg).reset());
			Ansi.ansi().reset();
		} else {
			print(msg);
		}
	}

	/**
	 * println(): Basic System.out.println call. It's here so all text output can go through this
	 * function.
	 * 
	 * @param msg
	 */
	public static void println(String msg) {
		System.out.println(msg);
	}

	/**
	 * print(): Basic System.out.print call. It's here so out text output can go through this function.
	 * 
	 * @param msg
	 */
	public static void print(String msg) {
		System.out.print(msg);
	}

	/**
	 * fatalError(): Print the provided string in RED and exit the program with the error code given
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

	/**
	 * clearScreen(): Uses the JAnsi library to clear the screen
	 */
	public static void clearScreen() {
		// Clear the screen
		System.out.println(ansi().eraseScreen(Erase.ALL).reset());

		// Position cursor at the top
		System.out.println(ansi().cursor(0, 0));
	}

}