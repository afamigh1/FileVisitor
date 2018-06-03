package fileVisitors.driver;

import java.util.StringTokenizer;

public class PopulateVisitor implements VisitorI {
	
	MyLogger log;
	FileProcessor fileProc;
	BinarySearchTree tree;

	public PopulateVisitor(FileProcessor fp, MyLogger l) {
		log = l;
		fileProc = fp;
		
		tree = new BinarySearchTree(log);
	}
	
	public void fillTree() {
		String line;
		
		while( ( line = fileProc.readLine() ) != null) {
			StringTokenizer multiTokenizer = new StringTokenizer(line, " ");
			
			while(multiTokenizer.hasMoreTokens()) {
				String split = multiTokenizer.nextToken();
				tree.insert(split);
			}
		}
	}
	
	public BinarySearchTree getTree() {
		return tree;
	}
	
	@Override
	public void accept(VisitorI v) {
		
	}
	
	@Override
	public void visit(BinarySearchTree t) {
		
	}
	
}
