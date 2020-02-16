import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

//-------------------------------------------------------------------------
/**
 *  Test class for Arith.java
 *
 *  @author Neil Kilbane 
 *  @version 17/01/20 10:19:53
 */
@RunWith(JUnit4.class)
public class ArithTest
{
	//~ Constructor ........................................................
	@Test
	public void testConstructor()
	{
		new Arith();
	}
	
	//~ Public Methods ........................................................
	/**
	 * Check that every method works for empty arrays
	 */
	@Test
	public void testEmpty()
	{
		String[] emptyArray = new String[0];
		int expectedResult = 0;

		assertFalse("validatePrefixOrder(emptyArray)", Arith.validatePrefixOrder(emptyArray));
		assertFalse("validatePostfixOrder(emptyArray)", Arith.validatePostfixOrder(emptyArray));

		assertEquals("evaluatePrefixOrder(emptyArray)", expectedResult, Arith.evaluatePrefixOrder(emptyArray));
		assertEquals("evaluatePostfixOrder(emptyArray)", expectedResult, Arith.evaluatePostfixOrder(emptyArray));

		assertArrayEquals("convertPrefixToPostfix(emptyArray)", emptyArray, Arith.convertPrefixToPostfix(emptyArray));
		assertArrayEquals("convertPostfixToPrefix(emptyArray)", emptyArray, Arith.convertPostfixToPrefix(emptyArray));
		assertArrayEquals("convertPrefixToInfix(emptyArray)", emptyArray, Arith.convertPrefixToInfix(emptyArray));
		assertArrayEquals("convertPostfixToInfix(emptyArray)", emptyArray, Arith.convertPostfixToInfix(emptyArray));
	}
	 
	/**
	 * Check that every method works for non-empty arrays
	 */
	@Test
	public void testNonEmpty()
	{
		//(((1 - 2) * 3) + (10 - (3 + (6 / 3))))
		String[] prefixArray = {"+","*","-","1","2","3","-","10","+","3","/","6","3"};
		String[] postfixArray = {"1","2","-","3","*","10","3","6","3","/","+","-","+"};
		String[] infixArray = {"(","(","(","1","-","2",")","*","3",")","+","(","10","-","(","3","+","(","6","/","3",")",")",")",")"};
		int expectedResult = 2;

		assertTrue("validatePrefixOrder(prefixArray)", Arith.validatePrefixOrder(prefixArray));
		assertTrue("validatePostfixOrder(postfixArray)", Arith.validatePostfixOrder(postfixArray));

		assertEquals("evaluatePrefixOrder(prefixArray)", expectedResult, Arith.evaluatePrefixOrder(prefixArray));
		assertEquals("evaluatePostfixOrder(postfixArray)", expectedResult, Arith.evaluatePostfixOrder(postfixArray));

		assertArrayEquals("convertPrefixToPostfix(prefixArray)", postfixArray, Arith.convertPrefixToPostfix(prefixArray));
		assertArrayEquals("convertPostfixToPrefix(postfixArray)", prefixArray, Arith.convertPostfixToPrefix(postfixArray));
		assertArrayEquals("convertPrefixToInfix(prefixArray)", infixArray, Arith.convertPrefixToInfix(prefixArray));
		assertArrayEquals("convertPostfixToInfix(postfixArray)", infixArray, Arith.convertPostfixToInfix(postfixArray));

	}

	/**
	 * Check that every method works for empty arrays
	 */
	/**
	 * Check that every method works for empty arrays
	 */
}
