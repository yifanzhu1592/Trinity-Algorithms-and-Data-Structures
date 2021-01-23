// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author  Yifan Zhu
 *  @version 09/10/18 11:13:22
 */

/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * 
 * @param <T> This is a type parameter. T is used as a class name in the
 *            definition of this class.
 *
 *            When creating a new DoublyLinkedList, T should be instantiated
 *            with an actual class name that extends the class Comparable. Such
 *            classes include String and Integer.
 *
 *            For example to create a new DoublyLinkedList class containing
 *            String data: DoublyLinkedList<String> myStringList = new
 *            DoublyLinkedList<String>();
 *
 *            The class offers a toString() method which returns a
 *            comma-separated sting of all elements in the data structure.
 * 
 *            This is a bare minimum class you would need to completely
 *            implement. You can add additional methods to support your code.
 *            Each method will need to be tested by your jUnit tests -- for
 *            simplicity in jUnit testing introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>> {

	/**
	 * private class DLLNode: implements a *generic* Doubly Linked List node.
	 */
	private class DLLNode {
		public final T data; // this field should never be updated. It gets its
								// value once from the constructor DLLNode.
		public DLLNode next;
		public DLLNode prev;

		/**
		 * Constructor
		 * 
		 * @param theData  : data of type T, to be stored in the node
		 * @param prevNode : the previous Node in the Doubly Linked List
		 * @param nextNode : the next Node in the Doubly Linked List
		 * @return DLLNode
		 */
		public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) {
			data = theData;
			prev = prevNode;
			next = nextNode;
		}
	}

	// Fields head and tail point to the first and last nodes of the list.
	private DLLNode head, tail;

	/**
	 * Constructor of an empty DLL
	 * 
	 * @return DoublyLinkedList
	 */
	public DoublyLinkedList() {
		head = null;
		tail = null;
	}

	/**
	 * Tests if the doubly linked list is empty
	 * 
	 * @return true if list is empty, and false otherwise
	 *
	 *         Worst-case asymptotic running time cost: O(1)
	 *
	 *         Justification: We only need to check the head object.
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Inserts an element in the doubly linked list
	 * 
	 * @param pos  : The integer location at which the new data should be inserted
	 *             in the list. We assume that the first position in the list is 0
	 *             (zero). If pos is less than 0 then add to the head of the list.
	 *             If pos is greater or equal to the size of the list then add the
	 *             element at the end of the list.
	 * @param data : The new data of class T that needs to be added to the list
	 * @return none
	 *
	 *         Worst-case asymptotic running time cost: O(N)
	 *
	 *         Justification: In the worst case, we scan through the whole list
	 *         once, and it is a linear scan.
	 */
	public void insertBefore(int pos, T data) {
		DLLNode node = new DLLNode(data, null, null);
		if (isEmpty()) {
			head = node;
			tail = node;
		} else {
			if (pos < 0) {
				node.next = head;
				head.prev = node;
				head = node;
			} else {
				int i = 0;
				DLLNode current = head;
				while (i < pos && current.next != null) {
					current = current.next;
					i++;
				}
				if (i == pos) {
					if (pos == 0) {
						node.next = head;
						head.prev = node;
						head = node;
					} else {
						node.next = current;
						node.prev = current.prev;
						current.prev.next = node;
						current.prev = node;
					}
				} else {
					tail.next = node;
					node.prev = tail;
					tail = node;
				}
			}
		}
		return;
	}

	/**
	 * Returns the data stored at a particular position
	 * 
	 * @param pos : the position
	 * @return the data at pos, if pos is within the bounds of the list, and null
	 *         otherwise.
	 *
	 *         Worst-case asymptotic running time cost: O(N)
	 *
	 *         Justification: In the worst case, we scan through the whole list
	 *         once, and it is a linear scan.
	 */
	public T get(int pos) {
		if (pos < 0) {
			return null;
		} else {
			if (isEmpty()) {
				return null;
			} else {
				int i = 0;
				DLLNode current = head;
				while (i < pos && current.next != null) {
					current = current.next;
					i++;
				}
				if (i == pos) {
					return current.data;
				} else {
					return null;
				}
			}
		}
	}

	/**
	 * Deletes the element of the list at position pos. First element in the list
	 * has position 0. If pos points outside the elements of the list then no
	 * modification happens to the list.
	 * 
	 * @param pos : the position to delete in the list.
	 * @return true : on successful deletion, false : list has not been modified.
	 *
	 *         Worst-case asymptotic running time cost: O(N)
	 *
	 *         Justification: In the worst case, we scan through the whole list
	 *         once, and it is a linear scan.
	 */
	public boolean deleteAt(int pos) {
		if (isEmpty()) {
			return false;
		} else {
			if (pos < 0) {
				return false;
			} else {
				int i = 0;
				DLLNode current = head;
				while (i < pos && current.next != null) {
					current = current.next;
					i++;
				}
				if (i == pos) {
					if (head.next == null) {
						head = null;
						tail = null;
					} else if (current == head) {
						head.next.prev = null;
						head = head.next;
					} else if (current == tail) {
						tail.prev.next = null;
						tail = tail.prev;
					} else {
						current.next.prev = current.prev;
						current.prev.next = current.next;
					}
					return true;
				} else {
					return false;
				}
			}
		}
	}

	/**
	 * Reverses the list. If the list contains "A", "B", "C", "D" before the method
	 * is called Then it should contain "D", "C", "B", "A" after it returns.
	 *
	 * Worst-case asymptotic running time cost: O(N)
	 *
	 * Justification: Reversing the list in a linear scan.
	 */
	public void reverse() {
		DLLNode prev = null;
		DLLNode current = head;
		DLLNode node = tail;
		tail = head;
		head = node;
		while (current != null) {
			DLLNode nextNode = current.next;
			current.next = prev;
			current.prev = nextNode;
			prev = current;
			current = nextNode;
		}
	}

	/**
	 * Removes all duplicate elements from the list. The method should remove the
	 * _least_number_ of elements to make all elements unique. If the list contains
	 * "A", "B", "C", "B", "D", "A" before the method is called Then it should
	 * contain "A", "B", "C", "D" after it returns. The relative order of elements
	 * in the resulting list should be the same as the starting list.
	 *
	 * Worst-case asymptotic running time cost: O(N^2)
	 *
	 * Justification: For each element in the list, we iterate through all the
	 * elements that are after this element.
	 */
	public void makeUnique() {
		if (isEmpty()) {
		} else {
			DLLNode currentFirst = head;
			while (currentFirst != null && currentFirst.next != null) {
				DLLNode currentSecond = currentFirst.next;
				while (currentSecond != null) {
					if (currentSecond.data.equals(currentFirst.data)) {
						if (currentSecond.next == null) {
							currentSecond.prev.next = null;
							tail = currentSecond.prev;
							currentSecond = currentSecond.next;
						} else {
							DLLNode node = currentSecond;
							currentSecond = currentSecond.next;
							node.next.prev = node.prev;
							node.prev.next = node.next;
						}
					} else {
						currentSecond = currentSecond.next;
					}
				}
				currentFirst = currentFirst.next;
			}
		}
	}

	/*----------------------- STACK API 
	 * If only the push and pop methods are called the data structure should behave like a stack.
	 */

	/**
	 * This method adds an element to the data structure. How exactly this will be
	 * represented in the Doubly Linked List is up to the programmer.
	 * 
	 * @param item : the item to push on the stack
	 *
	 *             Worst-case asymptotic running time cost: O(1)
	 *
	 *             Justification: Adding the element to the end of the list.
	 */
	public void push(T item) {
		DLLNode node = new DLLNode(item, null, null);
		if (isEmpty()) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			node.prev = tail;
			tail = node;
		}
	}

	/**
	 * This method returns and removes the element that was most recently added by
	 * the push method.
	 * 
	 * @return the last item inserted with a push; or null when the list is empty.
	 *
	 *         Worst-case asymptotic running time cost: O(1)
	 *
	 *         Justification: Deleting the last element.
	 */
	public T pop() {
		if (tail != null && tail.prev == null) {
			DLLNode node = tail;
			head = null;
			tail = null;
			return node.data;
		} else if (tail != null) {
			DLLNode node = tail;
			tail = tail.prev;
			tail.next = null;
			return node.data;
		} else {
			return null;
		}
	}

	/*----------------------- QUEUE API
	 * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
	 */

	/**
	 * This method adds an element to the data structure. How exactly this will be
	 * represented in the Doubly Linked List is up to the programmer.
	 * 
	 * @param item : the item to be enqueued to the stack
	 *
	 *             Worst-case asymptotic running time cost: O(1)
	 *
	 *             Justification: Adding the element to the end of the list.
	 */
	public void enqueue(T item) {
		DLLNode node = new DLLNode(item, null, null);
		if (isEmpty()) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			node.prev = tail;
			tail = node;
		}
	}

	/**
	 * This method returns and removes the element that was least recently added by
	 * the enqueue method.
	 * 
	 * @return the earliest item inserted with an enqueue; or null when the list is
	 *         empty.
	 *
	 *         Worst-case asymptotic running time cost: O(1)
	 *
	 *         Justification: Deleting the first element.
	 */
	public T dequeue() {
		if (head != null && head.next == null) {
			DLLNode node = head;
			head = null;
			tail = null;
			return node.data;
		} else if (head != null) {
			DLLNode node = head;
			head = head.next;
			head.prev = null;
			return node.data;
		} else {
			return null;
		}
	}

	/**
	 * @return a string with the elements of the list as a comma-separated list,
	 *         from beginning to end
	 *
	 *         Worst-case asymptotic running time cost: Theta(n)
	 *
	 *         Justification: We know from the Java documentation that
	 *         StringBuilder's append() method runs in Theta(1) asymptotic time. We
	 *         assume all other method calls here (e.g., the iterator methods above,
	 *         and the toString method) will execute in Theta(1) time. Thus, every
	 *         one iteration of the for-loop will have cost Theta(1). Suppose the
	 *         doubly-linked list has 'n' elements. The for-loop will always iterate
	 *         over all n elements of the list, and therefore the total cost of this
	 *         method will be n*Theta(1) = Theta(n).
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		boolean isFirst = true;

		// iterate over the list, starting from the head
		for (DLLNode iter = head; iter != null; iter = iter.next) {
			if (!isFirst) {
				s.append(",");
			} else {
				isFirst = false;
			}
			s.append(iter.data.toString());
		}

		return s.toString();
	}

}
