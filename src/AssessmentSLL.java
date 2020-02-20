//Hugh Winchester
// 2494047w
//do not include package statement 
//do not import any classes
//just complete the methods indicated,
//namely:
//insertTail
//deleteAlternate and
//merge

public class AssessmentSLL<E extends Comparable<E>> {

	// Each SLL object is the header of
	// a singly-linked-list

	private Node<E> first;

	/**
	 * constructor
	 */
	public AssessmentSLL() {
		// Construct an empty SLL.
		first = null;
	}

	// //////// Inner class //////////
	private static class Node<E> {
		// Each Node object is a node of a
		// singly-linked-list.
		protected E element;
		protected Node<E> next;

		public Node(E elem, Node<E> n) {
			element = elem;
			next = n;
		}

	}

	// ////////////////////////////////

	/**
	 * print all elements starting from first node
	 */
	public void printFirstToLast() {
		// Print all elements in this SLL, in first-to-last order.
		Node<E> curr = first;
		while (curr != null) {
			System.out.println(curr.element);
			curr = curr.next;
		}
	}

	/**
	 * insert new node containing elem at front of list
	 * 
	 */
	public void insert(E elem) {
		Node<E> newNode = new Node<E>(elem, first);
		first = newNode;
	}

	/**
	 * add new node to end of list
	 */
	public void insertTail(E elem) {

		Node<E> newNode = new Node<E>(elem, null);

		if (first != null) {
			Node<E> curr = first;
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = newNode;
		} else
			first = newNode;
	}

	/**
	 * delete every alternate element imagine the elements are indexed 0, 1, 2, ...
	 * , n-1 delete all the odd indexed elements so if list had values ant, badger,
	 * cat, dog the method would delete nodes containing badger and dog
	 */
	public void deleteAlternate() {

		if (first == null) return;

		Node currentNode = first;
		Node nextNode = currentNode.next;

		while (currentNode != null && nextNode != null){
			currentNode.next = nextNode.next; // temporarily sets the current node to point at the node after the next node.
			nextNode = null; // effectively removes the node
			currentNode = currentNode.next; // current node is set to point at the node after the current node

			if (currentNode != null){
				nextNode = currentNode.next; // sets nextNode to the next node (if one exists).
			}
		}
	}

	/**
	 * method to merge two ordered lists with this one whilst removing duplicates
	 * order should be preserved you need to replace the type list1, list2 and list3
	 * and the return type with the new name of this class
	 */
	public AssessmentSLL<E> merge(AssessmentSLL<E> list1, AssessmentSLL<E> list2) {
		AssessmentSLL<E> mergedList = new AssessmentSLL<E>();

		// you to fill in the rest

		return mergedList;

	}

}