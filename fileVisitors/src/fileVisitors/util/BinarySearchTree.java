package fileVisitors.driver;

/*
	BST Implementation taken from:
	http://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
	Search methods taken from:
	http://www.algolist.net/Data_structures/Binary_search_tree/Lookup
	Delete methods taken from:
	http://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
	
	All methods were adapted to the needs of this assignment
*/

class BinarySearchTree {

	class Node {
		String word;
		Node left, right;

		public Node(String wordKey) {
		    word = wordKey;
		    left = right = null;
		}
		
	}

	/*	BST Data Members	*/
	Node root;
	MyLogger log;
	

	BinarySearchTree() { }
	
	// Constructor
	BinarySearchTree(MyLogger l) { 
		root = null; 
		
		log = l;
		log.writeMessage("BST Constructor", MyLogger.DebugLevel.CONSTRUCTOR);

	}

	/*
		This method calls insertRec which is the recursive
		implementation for inserting into a BST
	*/
	void insert(String wordKey) {
		root = insertRec(root, wordKey);
	}

	/* 
		A recursive function to insert a new key in BST 
	*/
	Node insertRec(Node root, String wordKey) {

		/* If the tree is empty, return a new node */
		if (root == null) {
		    root = new Node(wordKey);
		    return root;
		}

		/* Otherwise, recur down the tree */
		if( wordKey.compareTo(root.word) < 0 )
			root.left = insertRec(root.left, wordKey);
		else if( wordKey.compareTo(root.word) > 0 )
			root.right = insertRec(root.right, wordKey);
		
		return root;
	}

	/*	
		The following methods are for printing out the tree inorder	
	*/
	void inorder()  {
		inorderRec(root);
	}
	
	void inorderRec(Node root) {
		if (root != null) {
		    inorderRec(root.left);
			System.out.println(root.word);
		    inorderRec(root.right);
		}
	}
	
	public Node getRoot() {
		return root;
	}
}
