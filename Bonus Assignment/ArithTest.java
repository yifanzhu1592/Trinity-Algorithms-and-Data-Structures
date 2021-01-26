import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 * Test class for Arith
 *
 * @author Yifan Zhu
 * @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class ArithTest {
	// ~ Constructor ........................................................
	@Test
	public void testConstructor() {
		new Arith();
	}

	// ~ Public Methods ........................................................

	// ----------------------------------------------------------
	/**
	 * Check if the validateInfixOrder works
	 */
	@Test
	public void testValidateInfixOrder() {
		Arith arith = new Arith();

		// test valid infix
		String[] infixLiterals = { "1", "*", "2", "+", "3", "-", "1", "/", "1" };
		assertEquals("Checking if 1 * 2 + 3 - 1 / 1 is a valid infix", true, arith.validateInfixOrder(infixLiterals));

		// test invalid infix
		String[] infixLiterals1 = { "1", "*", "2", "+" };
		assertEquals("Checking if 1 * 2 + is a valid infix", false, arith.validateInfixOrder(infixLiterals1));

		// test invalid infix
		String[] infixLiterals2 = { "1", "*", "2", "3", "0" };
		assertEquals("Checking if 1 * 2 3 0 is a valid infix", false, arith.validateInfixOrder(infixLiterals1));
		// test invalid infix

		String[] infixLiterals3 = { "1", "*", "2", "+", "+" };
		assertEquals("Checking if 1 * 2 + + is a valid infix", false, arith.validateInfixOrder(infixLiterals1));
	}

	/**
	 * Check if the evaluateInfixOrder works
	 */
	@Test
	public void testEvaluateInfixOrder() {
		Arith arith = new Arith();

		// test valid infix
		String[] infixLiterals = { "1", "*", "2", "+", "3", "-", "1", "/", "1" };
		assertEquals("Getting the value of 1 * 2 + 3 - 1 / 1", 4, arith.evaluateInfixOrder(infixLiterals));
	}

	/**
	 * Check if the convertInfixToPostfix works
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testConvertInfixToPostfix() {
		Arith arith = new Arith();

		// test valid infix
		String[] infixLiterals = { "1", "*", "2", "+", "3", "/", "1", "-", "1", "-", "1", "+", "1", "+", "1" };
		assertEquals("Converting infix to postfix",
				new String[] { "1", "2", "*", "3", "1", "/", "+", "1", "-", "1", "-", "1", "+", "1", "+" },
				arith.convertInfixToPostfix(infixLiterals));
	}

	/**
	 * Check if the convertPostfixToInfix works
	 */
	@Test
	public void testConvertPostfixToInfix() {
		Arith arith = new Arith();

		// test valid infix
		String[] postfixLiterals = { "1", "2", "*", "3", "+", "1", "1", "/", "-" };
		assertEquals("Converting postfix to infix", new String[] { "1", "*", "2", "+", "3", "-", "1", "/", "1" },
				arith.convertPostfixToInfix(postfixLiterals));
	}

}
