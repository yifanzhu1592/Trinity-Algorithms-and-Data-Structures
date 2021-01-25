import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 * Test class for Doubly Linked List
 *
 * @version 3.1 09/11/15 11:32:15
 *
 * @author TODO
 */

@RunWith(JUnit4.class)
public class BSTTest {

	// TODO write more tests here.

	/**
	 * <p>
	 * Test {@link BST#prettyPrintKeys()}.
	 * </p>
	 */

	@Test
	public void testPrettyPrint() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals("Checking pretty printing of empty tree", "-null\n", bst.prettyPrintKeys());

		// -7
		// |-3
		// | |-1
		// | | |-null
		bst.put(7, 7); // | | -2
		bst.put(8, 8); // | | |-null
		bst.put(3, 3); // | | -null
		bst.put(1, 1); // | -6
		bst.put(2, 2); // | |-4
		bst.put(6, 6); // | | |-null
		bst.put(4, 4); // | | -5
		bst.put(5, 5); // | | |-null
						// | | -null
						// | -null
						// -8
						// |-null
						// -null

		String result = "-7\n" + " |-3\n" + " | |-1\n" + " | | |-null\n" + " | |  -2\n" + " | |   |-null\n"
				+ " | |    -null\n" + " |  -6\n" + " |   |-4\n" + " |   | |-null\n" + " |   |  -5\n"
				+ " |   |   |-null\n" + " |   |    -null\n" + " |    -null\n" + "  -8\n" + "   |-null\n"
				+ "    -null\n";
		assertEquals("Checking pretty printing of non-empty tree", result, bst.prettyPrintKeys());
	}

	/**
	 * <p>
	 * Test {@link BST#delete(Comparable)}.
	 * </p>
	 */
	@Test
	public void testDelete() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		bst.delete(1);
		assertEquals("Deleting from empty tree", "()", bst.printKeysInOrder());

		bst.put(1, 1);
		bst.put(2, 2);
		bst.delete(1);
		assertEquals("Deleting node with only right child", "(()2())", bst.printKeysInOrder());
		bst.delete(2);

		bst.put(7, 7); // _7_
		bst.put(8, 8); // / \
		bst.put(3, 3); // _3_ 8
		bst.put(1, 1); // / \
		bst.put(2, 2); // 1 6
		bst.put(6, 6); // \ /
		bst.put(4, 4); // 2 4
		bst.put(5, 5); // \
						// 5

		assertEquals("Checking order of constructed tree", "(((()1(()2()))3((()4(()5()))6()))7(()8()))",
				bst.printKeysInOrder());

		bst.delete(9);
		assertEquals("Deleting non-existent key", "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());

		bst.delete(8);
		assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", bst.printKeysInOrder());

		bst.delete(6);
		assertEquals("Deleting node with single child", "(((()1(()2()))3(()4(()5())))7())", bst.printKeysInOrder());

		bst.delete(3);
		assertEquals("Deleting node with two children", "(((()1())2(()4(()5())))7())", bst.printKeysInOrder());
	}

	/**
	 * <p>
	 * Test {@link BST#median()}.
	 * </p>
	 */
	@Test
	public void testMedian() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals("Checking median of constructed tree", null, bst.median());

		bst.put(7, 7); // _7_

		assertEquals("Checking median of constructed tree", "7", bst.median().toString());
	}

	/**
	 * <p>
	 * Test {@link BST#contains(Comparable)}.
	 * </p>
	 */
	@Test
	public void testContains() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();

		bst.put(7, 7); // _7_

		assertEquals("Checking if constructed tree contains 7", true, bst.contains(7));
		assertEquals("Checking if constructed tree contains 7", false, bst.contains(6));
	}

	/**
	 * <p>
	 * Test {@link BST#get(Comparable)}.
	 * </p>
	 */
	@Test
	public void testGet() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();

		bst.put(7, 7); // _7_
		bst.put(8, 8); // / \
		bst.put(3, 3); // _3_ 8
		bst.put(1, 1); // / \
		bst.put(2, 2); // 1 6
		bst.put(6, 6); // \ /
		bst.put(4, 4); // 2 4
		bst.put(5, 5); // \
						// 5

		assertEquals("Getting the value of node with key 7", "7", bst.get(7).toString());
		assertEquals("Getting the value of node with key 5", "5", bst.get(5).toString());
		assertEquals("Getting the value of node with key 3", "3", bst.get(3).toString());
		assertEquals("Getting the value of node with key 9", null, bst.get(9));
	}

	/**
	 * <p>
	 * Test {@link BST#put(Comparable)}.
	 * </p>
	 */
	@Test
	public void testPut() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();

		bst.put(1, 1);
		bst.put(2, 2);
		bst.put(2, 3);
		bst.delete(1);
		bst.delete(2);
		bst.delete(3);

		bst.put(7, 7); // _7_
		bst.put(8, 8); // / \
		bst.put(3, 3); // _3_ 8
		bst.put(1, 1); // / \
		bst.put(2, 2); // 1 6
		bst.put(6, 6); // \ /
		bst.put(4, 4); // 2 4
		bst.put(5, 5); // \
						// 5
		bst.put(9, null);

		assertEquals("Getting the value of node with key 7", "7", bst.get(7).toString());
		assertEquals("Getting the value of node with key 5", "5", bst.get(5).toString());
		assertEquals("Getting the value of node with key 3", "3", bst.get(3).toString());
		assertEquals("Getting the value of node with key 9", null, bst.get(9));
	}

	/**
	 * <p>
	 * Test {@link BST#height()}.
	 * </p>
	 */
	@Test
	public void testHeight() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals("Getting the height of the tree", -1, bst.height());

		bst.put(7, 7); // _7_
		bst.put(8, 8); // / \
		bst.put(3, 3); // _3_ 8
		bst.put(1, 1); // / \
		bst.put(2, 2); // 1 6
		bst.put(6, 6); // \ /
		bst.put(4, 4); // 2 4
		bst.put(5, 5); // \
						// 5

		assertEquals("Getting the height of the tree", 4, bst.height());
	}

	/**
	 * <p>
	 * Test {@link BST#height()}.
	 * </p>
	 */
	@Test
	public void testSelect() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals("Getting the 0th node of the epmty tree", null, bst.select(0));

		bst.put(7, 7); // _7_
		bst.put(8, 8); // / \
		bst.put(3, 3); // _3_ 8
		bst.put(1, 1); // / \
		bst.put(2, 2); // 1 6
		bst.put(6, 6); // \ /
		bst.put(4, 4); // 2 4
		bst.put(5, 5); // \
						// 5

		assertEquals("Getting the -1th node of the tree", null, bst.select(-1));
		assertEquals("Getting the 3rd node of the tree", "4", bst.select(3).toString());
	}
}
