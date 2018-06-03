package fileVisitors.driver;

import java.lang.StringBuilder;
import java.util.Stack;

/*
	Stack Traversal of tree taken from:
	http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
*/

public class PalindromeHighlight implements VisitorI {
	
	MyLogger log;
	BinarySearchTree tree;

	public PalindromeHighlight(MyLogger l) {
		log = l;
	}
	
	@Override
	public void accept(VisitorI v) {
		tree = v.getTree();
		
		visit(tree);
	}
	
	@Override
	public void visit(BinarySearchTree t) {

		//keep the nodes in the path that are waiting to be visited
		Stack<BinarySearchTree.Node> stack = new Stack<BinarySearchTree.Node>();
		BinarySearchTree.Node node = t.getRoot();
		 
		//first node to be visited will be the left one
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
		 
		// traverse the tree
		while (stack.size() > 0) {
			// visit the top node
			node = stack.pop();
			
			if(node.word.length() > 3 && isPalindrome(node.word)) {
				node.word = node.word.toUpperCase();
			}
			
			if (node.right != null) {
				node = node.right;
				 
				// the next node to be visited is the leftmost
				while (node != null) {
					stack.push(node);
					node = node.left;
				}
			}
		}
    }
	
	public boolean isPalindrome(String str) {
		return str.equalsIgnoreCase(new StringBuilder(str).reverse().toString());
	}
	
	public BinarySearchTree getTree() {
		return tree;
	}
	
	public void fillTree() { }

} 