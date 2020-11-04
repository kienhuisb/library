package org.fross.library;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.concurrent.TimeUnit;

import org.fusesource.jansi.Ansi;

public class Spinner extends Thread {
	protected final int SPINNER_DELAY = 120;

	String[] spinnerSymbols = { "|", "/", "-", "\\" };
	int currentSpinner = 0;

	/**
	 * run(): Overrides Thread run() method interface and is the main thread execution loop
	 */
	public void run() {
		// Keep calling the update spinner until the thread is interrupted
		while (Thread.currentThread().isInterrupted() == false) {
			// Spin the spinner
			spinSpinner();

			// Delay before next thread symbol is displayed
			try {
				TimeUnit.MILLISECONDS.sleep(SPINNER_DELAY);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}

		// Erase the last spinner symbol character
		System.out.println(" ");
	}

	/**
	 * spinSpinner(): Show the spinner symbol and advance to the next index
	 * 
	 */
	public void spinSpinner() {
		// Display the Spinner
		Output.printColor(Ansi.Color.YELLOW, spinnerSymbols[currentSpinner]);

		// Move cursor back one spot
		System.out.print(ansi().cursorLeft(1));

		// Advance the spinner to the next symbol
		currentSpinner++;

		// Loop it back around when we hit the end
		if (currentSpinner >= spinnerSymbols.length) {
			currentSpinner = 0;
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
		Spinner spinner = new Spinner();
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