package fileVisitors.driver;

import java.util.ArrayList;

public class Results implements StdoutDisplayInterface, FileDisplayInterface {

	ArrayList<String> resultsArray;
	MyLogger logger;

	public Results(MyLogger loggerIn) {
		resultsArray = new ArrayList<String>(5);
		logger = loggerIn;
		logger.writeMessage("Results Constructor", MyLogger.DebugLevel.CONSTRUCTOR);
	}
	
	/*
		store new results into the results array
		@param String result
		@ret none
	*/
	public void storeNewResult(String result) {
		logger.writeMessage("Writing to results object", MyLogger.DebugLevel.IN_RESULTS);
		resultsArray.add(result);
	}
	
	public void writeToScreen(BinarySearchTree t) {
		t.inorder();
	}
	
	/*
		toString for debugging objects with print statements
		@param none
		@return String description of the class
	*/
	public String toString() {
		return "Results class";
	}

}
