package fileVisitors.driver;

import java.util.ArrayList;

public class Driver {
	
	public static void main(String[] args) {
		int i, j;
		String line;
		
		try {
			
			if(args.length != 3) { /* THIS IS NOT CHECKING ARGUMENTS PROPERLY IDK WHY FIX IT */
				System.err.println("Please enter 3 arguments.\n");
				System.exit(0);
			}
			
			/*
			int DEBUG_LEVEL = Integer.parseInt(args[2]);
			if( DEBUG_LEVEL < 0 || DEBUG_LEVEL > 4 ) {
				System.out.println("Debug value needs to be between 0 and 4 (inclusive)");
				System.exit(0);
			}
			*/
			MyLogger logger = new MyLogger();
			//logger.setDebugValue(DEBUG_LEVEL);
			
			FileProcessor fileProc = new FileProcessor(args[0], logger);
			//FileDisplay fileDisplay = new FileDisplay(args[1], logger);
			Results results = new Results(logger);
			
			VisitorI popVisit = new PopulateVisitor(fileProc, logger);
			popVisit.fillTree();
			
			VisitorI palinVisit = new PalindromeHighlight(logger);
			palinVisit.accept(popVisit);
			
			
			
			//results.writeSchedulesToFile(fileDisplay, tree);
			
			/*	Debug	
			results.writeToScreen(tree);
			*/
			
			
			//fileDisplay.closeOutput();
			fileProc.closeInput();
			
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Warning: " 
			+ "ArrayIndexOutOfBoundsException.");	
			System.exit(0);	
		} catch(NumberFormatException e) {
			System.out.println("Warning: " 
			+ "NumberFormatException. Some input given wasn't an integer.");
			System.exit(0);
		} finally {
			
		}
	
	}

}
