package main.se.kth.iv1350.Salesystem.startup;

import main.se.kth.iv1350.Salesystem.controller.Controller;
import main.se.kth.iv1350.Salesystem.view.View;

/**
 * Starts the entire application.
 */
public class Main {

	/**
	 * The main method used to start the application.
	 * 
	 * @param args This application does not take any command line parameters.
	 */
	public static void main(String[] args) {
		Controller contr = new Controller();
		View view = new View(contr);
		
		view.programRun();
	}
}
