//Hugh Winchester
// 2494047w
//do not include package statement
//do not import any classes
//just complete the methods indicated,
//namely:
//insertTail
//deleteAlternate and
//merge

import java.util.HashSet;

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
	 */
	public void insert(E elem) {
		Node<E> newNode = new Node<E>(elem, first);
		first = newNode;
	}

	/**
	 * add new node to end of list
	 */
	public void insertTail(E elem) {

		Node<E> newNode = new Node<E>(elem, null); // Create a new node containing the element passed in the argument.

		if (first != null) { // If the head of the existing list is not equal to null
			Node<E> curr = first; // set node curr to equal the head of the list
			while (curr.next != null) { // while the curr node's next doesn't point to null
				curr = curr.next; // set the curr pointer to point at the next node in the list
			}
			curr.next = newNode; // once loop breaks, set curr's next to point to newNode
		} else
			first = newNode; // list is empty, head of the list is newNode.
	}

	/**
	 * delete every alternate element imagine the elements are indexed 0, 1, 2, ...
	 * , n-1 delete all the odd indexed elements so if list had values ant, badger,
	 * cat, dog the method would delete nodes containing badger and dog
	 */
	public void deleteAlternate() {

		if (first == null) return; // returns if the list is null

		Node currentNode = first; // head of the list
		Node nextNode = currentNode.next; // next node in the list after the head

		while (currentNode != null && nextNode != null) {
			currentNode.next = nextNode.next; // temporarily sets the current node to point at the node after the next node.
			nextNode = null; // effectively removes the node
			currentNode = currentNode.next; // current node is set to point at the node after the current node

			if (currentNode != null) {
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

		HashSet<E> hashSet = new HashSet<>(); // HashSet to contain already added numbers. To be used for comparisons.

		/* If either list is null return */

		if (list1 == null) return list2;
		if (list2 == null) return list1;

		Node<E> nodeHeadList1 = list1.first; // set nodeHeadList1 to point to the head of list1
		Node<E> nodeHeadList2 = list2.first; // set nodeHeadList2 to point to the head of list2


		if (nodeHeadList1.element.compareTo(nodeHeadList2.element) < 0) { // if nodeHeadList1 is less than nodeHeadList2

			mergedList.first = nodeHeadList1; // set the head of the mergedList to be nodeHead1
			nodeHeadList1 = nodeHeadList1.next; // moves the pointer to the next node

		} else { // do the opposite of above

			mergedList.first = nodeHeadList2;
			nodeHeadList2 = nodeHeadList2.next;

		}

		Node<E> current = mergedList.first;

		hashSet.add(mergedList.first.element); // add the node to the HashSet to detect duplicates

		while (nodeHeadList1 != null && nodeHeadList2 != null) {


			if (nodeHeadList1.element.compareTo(nodeHeadList2.element) > 0) {
				Node<E> tempNode = new Node<>(nodeHeadList2.element, nodeHeadList2.next); // new Temp node to contain current head of list
				if (!hashSet.contains(nodeHeadList2.element)) { // if the HashSet doesn't currently contain the value then...
					nodeHeadList2.next = null;  // set the node's next to null
					hashSet.add(nodeHeadList2.element); // add the element to the HashSet
					current.next = nodeHeadList2; // add the node to the end of merged list
					current = current.next; // move the merged list pointer to the end of the list
				}
				nodeHeadList2 = tempNode.next; // move the pointer of nodeHeadList to the next node
			}
			else {
				Node<E> tempNode = new Node<>(nodeHeadList1.element, nodeHeadList1.next);
				if (!hashSet.contains(nodeHeadList1.element)) {
					hashSet.add(nodeHeadList1.element);
					nodeHeadList1.next = null;
					current.next = nodeHeadList1;
					current = current.next;
				}

				nodeHeadList1 = tempNode.next;

			}


		}


			while (nodeHeadList2 != null) {
				Node<E> tempNode = new Node<>(nodeHeadList2.element, nodeHeadList2.next);
				if(hashSet.contains(nodeHeadList2.element)){
					nodeHeadList2 = null;
				}
				current.next = nodeHeadList2;
				nodeHeadList2 = tempNode.next;
			}


			while (nodeHeadList1 != null) {
				Node<E> tempNode = new Node<>(nodeHeadList1.element, nodeHeadList1.next);
				if(hashSet.contains(nodeHeadList1.element)){
					nodeHeadList1 = null;
				}
				current.next = nodeHeadList1;
				nodeHeadList1 = tempNode.next;
			}


		return mergedList;
	}


}
