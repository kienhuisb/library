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

import static org.fusesource.jansi.Ansi.ansi;

import java.util.concurrent.TimeUnit;

import org.fusesource.jansi.Ansi;

/**
 * Spinner is a simple class that displays a text based graphic that 
 * can be shown while other work is being done.
 * 
 * The spinner process starts a new thread and when the work in the main
 * program is complete, it's stopped.
 * 
 * Usage:
 * 	Start Spinner:
 * 		SpinnerBouncyBall spinner = new SpinnerBouncyBall();
 * 		spinner.start();
 * 
 *  Stop Spinner:
 *  	spinner.interrupt();
 *  
 * @author Michael
 *
 */
public class SpinnerBouncyBall extends Thread {
	protected final int SPINNER_DELAY = 70;
	protected final int NUM_BALL_SLOTS = 6;
	protected final String LEFT_WALL = "[";
	protected final String RIGHT_WALL = "]";
	protected final String BALL = "o";

	// Position of the ball in it's journey
	int ballPosition = 0;

	// Direction the ball is heading. Positive is to the right
	int ballDirection = 1;

	/**
	 * run(): Overrides Thread run() method interface and is the main thread execution loop
	 */
	public void run() {
		// Keep calling the update spinner until the thread is interrupted
		while (Thread.currentThread().isInterrupted() == false) {
			// Bounce the ball
			bounceBall();

			// Delay before next thread symbol is displayed
			try {
				TimeUnit.MILLISECONDS.sleep(SPINNER_DELAY);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
	}

	/**
	 * bounceBall(): Show the spinner symbol and advance to the next index
	 * 
	 */
	public void bounceBall() {
		// Display the bouncy ball and walls
		Output.printColor(Ansi.Color.WHITE, LEFT_WALL);
		System.out.print(" ".repeat(ballPosition));
		Output.printColor(Ansi.Color.YELLOW, BALL);
		System.out.print(" ".repeat(NUM_BALL_SLOTS - ballPosition));
		Output.printColor(Ansi.Color.WHITE, RIGHT_WALL);

		// Move cursor back
		System.out.print(ansi().cursorLeft(NUM_BALL_SLOTS + 3));

		// Determine next ball location
		if (ballDirection > 0) {
			// Ball moving to the right (positive direction)
			ballPosition++;
			if (ballPosition >= NUM_BALL_SLOTS)
				ballDirection *= -1;
		} else {
			// Ball moving to the left
			ballPosition--;
			if (ballPosition <= 0)
				ballDirection *= -1;
		}
	}

	/**
	 * main(): Simply here to test the spinner
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Running Spinner for 10 seconds:");

		// Define and start the spinner
		SpinnerBouncyBall spinner = new SpinnerBouncyBall();
		spinner.start();

		// Sleep for 10 seconds
		try {
			TimeUnit.MILLISECONDS.sleep(10000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}

		// Stop the spinner
		spinner.interrupt();

		System.out.println("\nSpinner Complete\n\n");
	}

} // END CLASS
