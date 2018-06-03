package fileVisitors.driver;

public interface VisitorI {
	
	public void fillTree();
	
	public void accept(VisitorI v);
	public void visit(BinarySearchTree t);

	public BinarySearchTree getTree();
	
}
