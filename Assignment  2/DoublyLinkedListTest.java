import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 * Test class for Doubly Linked List
 *
 * @author Yifan Zhu
 * @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest {
	// ~ Constructor ........................................................
	@Test
	public void testConstructor() {
		new DoublyLinkedList<Integer>();
	}

	// ~ Public Methods ........................................................

	// ----------------------------------------------------------
	/**
	 * Check if the insertBefore works
	 */
	@Test
	public void testInsertBefore() {
		// test non-empty list
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0, 1);
		testDLL.insertBefore(1, 2);
		testDLL.insertBefore(2, 3);

		testDLL.insertBefore(0, 4);
		assertEquals("Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3",
				testDLL.toString());
		testDLL.insertBefore(1, 5);
		assertEquals("Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3",
				testDLL.toString());
		testDLL.insertBefore(2, 6);
		assertEquals("Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3",
				testDLL.toString());
		testDLL.insertBefore(-1, 7);
		assertEquals(
				"Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list",
				"7,4,5,6,1,2,3", testDLL.toString());
		testDLL.insertBefore(7, 8);
		assertEquals(
				"Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list",
				"7,4,5,6,1,2,3,8", testDLL.toString());
		testDLL.insertBefore(700, 9);
		assertEquals(
				"Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list",
				"7,4,5,6,1,2,3,8,9", testDLL.toString());

		// test empty list
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0, 1);
		assertEquals(
				"Checking insertBefore to an empty list at position 0 - expected the element at the head of the list",
				"1", testDLL.toString());
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(10, 1);
		assertEquals(
				"Checking insertBefore to an empty list at position 10 - expected the element at the head of the list",
				"1", testDLL.toString());
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(-10, 1);
		assertEquals(
				"Checking insertBefore to an empty list at position -10 - expected the element at the head of the list",
				"1", testDLL.toString());
	}

	/**
	 * Check if the get works
	 */
	@Test
	public void testGet() {
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		assertEquals("Checking get to a list containing 0 elements at position 0 - expected null", null,
				testDLL.get(0));
		testDLL.insertBefore(0, 1);
		testDLL.insertBefore(1, 2);
		testDLL.insertBefore(2, 3);
		assertEquals("Checking get to a list containing 3 elements at position -1 - expected null", null,
				testDLL.get(-1));
		assertEquals("Checking get to a list containing 3 elements at position 0 - expected 1", Integer.valueOf(1),
				testDLL.get(0));
		assertEquals("Checking get to a list containing 3 elements at position 2 - expected 3", Integer.valueOf(3),
				testDLL.get(2));
		assertEquals("Checking get to a list containing 3 elements at position 4 - expected null", null,
				testDLL.get(4));
	}

	/**
	 * Check if the deleteAt works
	 */
	@Test
	public void testDeleteAt() {
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		assertEquals("Checking deleteAt to a list containing 0 elements at position 0 - expected false", false,
				testDLL.deleteAt(0));
		testDLL.insertBefore(0, 1);
		assertEquals("Checking deleteAt to a list containing 1 elements at position 0 - expected true", true,
				testDLL.deleteAt(0));
		testDLL.insertBefore(0, 1);
		testDLL.insertBefore(1, 2);
		assertEquals("Checking deleteAt to a list containing 2 elements at position 0 - expected true", true,
				testDLL.deleteAt(0));
		assertEquals("Checking deleteAt to a list containing 1 elements at position 0 - expected true", true,
				testDLL.deleteAt(0));
		testDLL.insertBefore(0, 1);
		testDLL.insertBefore(1, 2);
		testDLL.insertBefore(2, 3);
		testDLL.insertBefore(3, 4);
		assertEquals("Checking deleteAt to a list containing 4 elements at position -1 - expected false", false,
				testDLL.deleteAt(-1));
		assertEquals("Checking deleteAt to a list containing 4 elements at position 1 - expected true", true,
				testDLL.deleteAt(1));
		assertEquals("Checking deleteAt to a list containing 3 elements at position 2 - expected true", true,
				testDLL.deleteAt(2));
		assertEquals("Checking deleteAt to a list containing 2 elements at position 5 - expected false", false,
				testDLL.deleteAt(5));
		assertEquals("Checking deleteAt to a list containing 1 elements - expected 1", "1,3", testDLL.toString());
	}

	/**
	 * Check if the reverse works
	 */
	@Test
	public void testReverse() {
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0, 1);
		testDLL.insertBefore(1, 2);
		testDLL.reverse();
		assertEquals("Checking reverse to a list containing 2 elements - expected 2,1", "2,1", testDLL.toString());
	}

	/**
	 * Check if the makeUnique works
	 */
	@Test
	public void testMakeUnique() {
		DoublyLinkedList<Character> testDLL = new DoublyLinkedList<Character>();
		testDLL.makeUnique();
		assertEquals("Checking makeUnique to a list containing 0 elements - expected ", "", testDLL.toString());
		testDLL.insertBefore(0, 'A');
		testDLL.insertBefore(1, 'B');
		testDLL.insertBefore(2, 'C');
		testDLL.insertBefore(3, 'B');
		testDLL.insertBefore(4, 'D');
		testDLL.insertBefore(5, 'A');
		testDLL.makeUnique();
		assertEquals("Checking makeUnique to a list containing 6 elements - expected A,B,C,D", "A,B,C,D",
				testDLL.toString());
	}

	/**
	 * Check if the makeUnique works
	 */
	@Test
	public void testMakeUnique1() {
		DoublyLinkedList<String> testDLL = new DoublyLinkedList<String>();
		testDLL.insertBefore(0, "test");
		testDLL.insertBefore(1, "test");
		testDLL.makeUnique();
		assertEquals("Checking makeUnique to a list containing 2 elements - expected test", "test", testDLL.toString());
	}

	/**
	 * Check if the push works
	 */
	@Test
	public void testPush() {
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.push(1);
		testDLL.push(2);
		testDLL.push(3);
		assertEquals("Checking push to a list containing 3 elements - expected 1,2,3", "1,2,3", testDLL.toString());
	}

	/**
	 * Check if the pop works
	 */
	@Test
	public void testPop() {
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		assertEquals("Checking pop to a list containing 0 elements - expected null", null, testDLL.pop());
		testDLL.push(1);
		testDLL.push(2);
		testDLL.push(3);
		assertEquals("Checking pop to a list containing 3 elements - expected 3", Integer.valueOf(3), testDLL.pop());
		assertEquals("Checking pop to a list containing 3 elements - expected 1,2", "1,2", testDLL.toString());
	}

	/**
	 * Check if the pop works
	 */
	@Test
	public void testPop1() {
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.push(1);
		assertEquals("Checking pop to a list containing 1 elements - expected 1", Integer.valueOf(1), testDLL.pop());
		assertEquals("Checking pop to a list containing 1 elements - expected ", "", testDLL.toString());
	}

	/**
	 * Check if the enqueue works
	 */
	@Test
	public void testEnqueue() {
		DoublyLinkedList<Character> testDLL = new DoublyLinkedList<Character>();
		testDLL.enqueue('A');
		testDLL.enqueue('B');
		testDLL.enqueue('C');
		assertEquals("Checking enqueue to a list containing 3 elements - expected 'A', 'B', 'C'", "A,B,C",
				testDLL.toString());
	}

	/**
	 * Check if the dequeue works
	 */
	@Test
	public void testDequeue() {
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		assertEquals("Checking dequeue to a list containing 0 elements - expected null", null, testDLL.dequeue());
		testDLL.enqueue(1);
		testDLL.enqueue(2);
		testDLL.enqueue(3);
		assertEquals("Checking dequeue to a list containing 3 elements - expected 1", Integer.valueOf(1),
				testDLL.dequeue());
		assertEquals("Checking dequeue to a list containing 3 elements - expected 2,3", "2,3", testDLL.toString());
	}

	/**
	 * Check if the dequeue works
	 */
	@Test
	public void testDequeue1() {
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.enqueue(1);
		assertEquals("Checking dequeue to a list containing 1 elements - expected 1", Integer.valueOf(1),
				testDLL.dequeue());
		assertEquals("Checking dequeue to a list containing 1 elements - expected ", "", testDLL.toString());
	}

}
