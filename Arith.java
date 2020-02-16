// -------------------------------------------------------------------------
/**
 *  Utility class containing validation/evaluation/conversion operations
 *  for prefix and postfix arithmetic expressions.
 *
 *  @author Neil Kilbane 18322169 
 *          Discussed with Hieu Nguyen and Swapnil Raj
 *  @version 1/12/15 13:03:48
 */

 import java.util.*;

public class Arith 
{


  //~ Validation methods ..........................................................


  /**
   * Validation method for prefix notation.
   * 
   * Running Time: O(n) worst-case
   *   The block of code within the for-loop is executed n times.
   *   Each instruction in this block has O(1) worst-case running time.
   *   Each instruction outside of the for-loop has O(1) worst-case running time.
   *   Therefore the worst-case running time is (O(n) * O(1)) + O(1) = O(n).
   *
   * Optimality:
   *   I think my code is optimal with respect to time. In order to validate the prefix array,
   *   I need to parse every String in the array, so I can't make it faster than O(n).
   *   I think my code is optimal with respect to memory usage. I only use one counter, and I
   *   declare the literal variable outside of the for-loop so that the same memory address is used
   *   for each literal. I also use only one counter.
   *
   * @param prefixLiterals : an array containing the string literals hopefully in prefix order.
   * The method assumes that each of these literals can be one of:
   * - "+", "-", "*", or "/"
   * - or a valid string representation of an integer.
   *
   * @return true if the parameter is indeed in prefix notation, and false otherwise.
   **/
  public static boolean validatePrefixOrder(String prefixLiterals[])
  {
    //TODO
    int counter = 1;
    String literal;
    for(int i = 0; i < prefixLiterals.length; i++)
    {
      literal = prefixLiterals[i];
      switch(literal) {
	case ("+"):
	case ("-"):
	case ("*"):
	case ("/"):
	  counter++;
	  break;
	default:
	  counter--;
      }

      if(counter == 0 && i != prefixLiterals.length - 1) return false;
    }
    return(counter == 0);
  }


  /**
   * Validation method for postfix notation.
   *
   * Running Time: O(n) worst-case
   *   The block of code within the for-loop is executed n times.
   *   Each instruction in this block has O(1) worst-case running time.
   *   Each instruction outside of the for-loop has O(1) worst-case running time.
   *   Therefore the worst-case running time is (O(n) * O(1)) + O(1) = O(n).
   *   
   * Optimality:
   *   I think my code is optimal with respect to time. In order to validate the postfix array,
   *   I need to parse every String in the array, so I can't make it faster than O(n).
   *   I think my code is optimal with respect to memory usage. I only use one counter, and I
   *   declare the literal variable outside of the for-loop so that the same memory address is used
   *   for each literal. I also use only one counter.
   *
   * @param postfixLiterals : an array containing the string literals hopefully in postfix order.
   * The method assumes that each of these literals can be one of:
   * - "+", "-", "*", or "/"
   * - or a valid string representation of an integer.
   *
   * @return true if the parameter is indeed in postfix notation, and false otherwise.
   **/
  public static boolean validatePostfixOrder(String postfixLiterals[])
  {
    //TODO
    int counter = 0;
    String literal;
    for(int i = 0; i < postfixLiterals.length; i++)
    {
      literal = postfixLiterals[i];
      switch(literal) {
	case ("+"):
	case ("-"):
	case ("*"):
	case ("/"):
	  counter--;
	  break;
	default:
	  counter++;
      }

      if(counter <= 0) return false;
    }
    return(counter == 1);
  }


  //~ Evaluation  methods ..........................................................


  /**
   * Evaluation method for prefix notation.
   *
   * Running Time: O(n) worst-case
   *   The block of code within the for-loop is executed n times.
   *   The running time of Integer.parseInt(literal) is O(literal.length).
   *   Since literal.length does not depend on the length of the input array, I will treat the running time as O(1).
   *   Each instruction in this block has O(1) worst-case running time.
   *   Each instruction outside of the for-loop has O(1) worst-case running time.
   *   Therefore the worst-case running time is (O(n) * O(1)) + O(1) = O(n).
   *
   * Optimality: 
   *   I think my code is optimal with respect to time. I can't make it any faster than O(n), because I
   *   need to iterate through the entire String array to evaluate the expression.
   *   I think my code is optimal with respect to memory usage. I use the same
   *   three variables, a, b and result, for every binary operation. I also declare the literal variable
   *   outside the for-loop so that the same memory address is used for each literal in the array.
   *   
   * @param prefixLiterals : an array containing the string literals in prefix order.
   * The method assumes that each of these literals can be one of:
   * - "+", "-", "*", or "/"
   * - or a valid string representation of an integer.
   *
   * @return the integer result of evaluating the expression
   **/
  public static int evaluatePrefixOrder(String prefixLiterals[])
  {
    //TODO
    if (validatePrefixOrder(prefixLiterals))
    {
      Stack<Integer> stack = new Stack<Integer>();
      int a, b, result;
      String literal;
      for(int i = prefixLiterals.length -1;i >= 0;i--)
      {
     	literal = prefixLiterals[i];
      	switch(literal) {
      	case("+"):
      	  a = stack.pop();
      	  b = stack.pop();
	  result = a + b;
	  stack.push(result);
	  break;
      	case("-"):
      	  a = stack.pop();
      	  b = stack.pop();
	  result = a - b;
	  stack.push(result);
	  break;
      	case("*"):
      	  a = stack.pop();
      	  b = stack.pop();
	  result = a * b;
	  stack.push(result);
	  break;
      	case("/"):
      	  a = stack.pop();
      	  b = stack.pop();
	  result = a / b;
	  stack.push(result);
	  break;
      	default:
      	  stack.push(Integer.parseInt(literal));
      	}
      }
      result = stack.pop();
      return result;
    }
    return 0;
  }


  /**
   * Evaluation method for postfix notation.
   *
   * Running Time: O(n) worst-case
   *   The block of code within the for-loop is executed n times.
   *   The running time of Integer.parseInt(literal) is O(literal.length).
   *   Since literal.length does not depend on the length of the input array, I will treat the running time as O(1).
   *   Each instruction in this block has O(1) worst-case running time.
   *   Each instruction outside of the for-loop has O(1) worst-case running time.
   *   Therefore the worst-case running time is (O(n) * O(1)) + O(1) = O(n).
   *   
   * Optimality: 
   *   I think my code is optimal with respect to time. I can't make it any faster than O(n), because I
   *   need to iterate through the entire String array to evaluate the expression.
   *   I think my code is optimal with respect to memory usage. I use the same
   *   three variables, a, b and result, for every binary operation. I also declare the literal variable
   *   outside the for-loop so that the same memory address is used for each literal in the array.
   *   
   * @param postfixLiterals : an array containing the string literals in postfix order.
   * The method assumes that each of these literals can be one of:
   * - "+", "-", "*", or "/"
   * - or a valid string representation of an integer.
   *
   * @return the integer result of evaluating the expression
   **/
  public static int evaluatePostfixOrder(String postfixLiterals[])
  {
    //TODO
    if (validatePostfixOrder(postfixLiterals))
    {
      Stack<Integer> stack = new Stack<Integer>();
      String literal;
      int a, b, result;
      for(int i = 0;i < postfixLiterals.length;i++)
      {
     	literal = postfixLiterals[i];
      	switch(literal) {
      	case("+"):
      	  b = stack.pop();
      	  a = stack.pop();
	  result = a + b;
	  stack.push(result);
	  break;
      	case("-"):
      	  b = stack.pop();
      	  a = stack.pop();
	  result = a - b;
	  stack.push(result);
	  break;
      	case("*"):
      	  b = stack.pop();
      	  a = stack.pop();
	  result = a * b;
	  stack.push(result);
	  break;
      	case("/"):
      	  b = stack.pop();
      	  a = stack.pop();
	  result = a / b;
	  stack.push(result);
	  break;
      	default:
      	  stack.push(Integer.parseInt(literal));
      	}
      }
      result = stack.pop();
      return result;
    }
    return 0;
  }


  //~ Conversion  methods ..........................................................


  /**
   * Converts prefix to postfix.
   * 
   * Running Time: O(n) amortized
   *   The block of code within the for-loop is executed n times.
   *   The running time of Integer.parseInt(literal) is O(literal.length).
   *   Since literal.length does not depend on the length of the input array, I will treat the running time as O(1).
   *   The amortized running time for StringBuilder.append() is O(1).
   *   Each instruction in this block has O(1) worst-case running time.
   *   Each instruction outside of the for-loop has O(1) worst-case running time.
   *   Therefore the amortized running time is (O(n) * O(1)) + O(1) = O(n).
   *
   *
   * @param prefixLiterals : an array containing the string literals in prefix order.
   * The method assumes that each of these literals can be one of:
   * - "+", "-", "*", or "/"
   * - or a valid string representation of an integer.
   *
   * @return the expression in postfix order.
   **/
  public static String[] convertPrefixToPostfix(String prefixLiterals[])
  {
    //TODO
    if(validatePrefixOrder(prefixLiterals))
    {
      Stack<StringBuilder> stack = new Stack<StringBuilder>();
      StringBuilder a = new StringBuilder();
      StringBuilder b = new StringBuilder();
      String literal;
      for(int i = prefixLiterals.length - 1; i >= 0; i--)
      {
        literal = prefixLiterals[i];
        switch(literal) {
        case("+"):
        case("-"):
        case("*"):
        case("/"):
          a = stack.pop(); 
          b = stack.pop(); 
	  a.append(" ");
	  a.append(b);
	  a.append(" ");
	  a.append(literal);
	  stack.push(a);
	  break;
        default:
          stack.push(new StringBuilder(literal));
        }
      }
      a = stack.pop();
      String result = a.toString();
      String[] postfixLiterals = result.split(" ");
      return postfixLiterals;
    }
    return new String[0];
  }


  /**
   * Converts postfix to prefix.
   * 
   * Running Time: O(n) amortized
   *   The block of code within the for-loop is executed n times.
   *   The running time of Integer.parseInt(literal) is O(literal.length).
   *   Since literal.length does not depend on the length of the input array, I will treat the running time as O(1).
   *   The amortized running time for StringBuilder.append() is O(1).
   *   Each instruction in this block has O(1) worst-case running time.
   *   Each instruction outside of the for-loop has O(1) worst-case running time.
   *   Therefore the amortized running time is (O(n) * O(1)) + O(1) = O(n).
   *
   * @param prefixLiterals : an array containing the string literals in postfix order.
   * The method assumes that each of these literals can be one of:
   * - "+", "-", "*", or "/"
   * - or a valid string representation of an integer.
   *
   * @return the expression in prefix order.
   **/
  public static String[] convertPostfixToPrefix(String postfixLiterals[])
  {
    //TODO
    if(validatePostfixOrder(postfixLiterals))
    {
      Stack<StringBuilder> stack = new Stack<StringBuilder>();
      StringBuilder a = new StringBuilder();
      StringBuilder b = new StringBuilder();
      StringBuilder subExpression;
      String literal;
      for(int i = 0; i < postfixLiterals.length; i++)
      {
        literal = postfixLiterals[i];
        switch(literal) {
        case("+"):
        case("-"):
        case("*"):
        case("/"):
          b = stack.pop(); 
          a = stack.pop(); 
	  subExpression = new StringBuilder(literal);
	  subExpression.append(" ");
	  subExpression.append(a);
	  subExpression.append(" ");
	  subExpression.append(b);
	  stack.push(subExpression);
	  break;
        default:
	  stack.push(new StringBuilder(literal));
        }
      }
      a = stack.pop();
      String result = a.toString();
      String[] prefixLiterals = result.split(" ");
      return prefixLiterals;
    }
    return new String[0];
  }

  /**
   * Converts prefix to infix.
   * 
   * Running Time: O(n) amortized
   *   The block of code within the for-loop is executed n times.
   *   The running time of Integer.parseInt(literal) is O(literal.length).
   *   Since literal.length does not depend on the length of the input array, I will treat the running time as O(1).
   *   The amortized running time for StringBuilder.append() is O(1).
   *   Each instruction in this block has O(1) worst-case running time.
   *   Each instruction outside of the for-loop has O(1) worst-case running time.
   *   Therefore the amortized running time is (O(n) * O(1)) + O(1) = O(n).
   *
   * @param infixLiterals : an array containing the string literals in prefix order.
   * The method assumes that each of these literals can be one of:
   * - "+", "-", "*", or "/"
   * - or a valid string representation of an integer.
   *
   * @return the expression in infix order.
   **/
  public static String[] convertPrefixToInfix(String prefixLiterals[])
  {
    //TODO
    if(validatePrefixOrder(prefixLiterals))
    {
      Stack<StringBuilder> stack = new Stack<StringBuilder>();
      StringBuilder a = new StringBuilder();
      StringBuilder b = new StringBuilder();
      StringBuilder subExpression;
      String literal;
      for(int i = prefixLiterals.length - 1; i >= 0; i--)
      {
        literal = prefixLiterals[i];
        switch(literal) {
        case("+"):
        case("-"):
        case("*"):
        case("/"):
	   subExpression = new StringBuilder("( ");
          a = stack.pop(); 
          b = stack.pop(); 
	  subExpression.append(a);
	  subExpression.append(" ");
	  subExpression.append(literal);
	  subExpression.append(" ");
	  subExpression.append(b);
	  subExpression.append(" )");
	  stack.push(subExpression);
	  break;
        default:
	  stack.push(new StringBuilder(literal));
        }
      }
      a = stack.pop();
      String result = a.toString();
      String[] infixLiterals = result.split(" ");
      return infixLiterals;
    }
    return new String[0];
  }

  /**
   * Converts postfix to infix.
   * 
   * Running Time: O(n) amortized
   *   The block of code within the for-loop is executed n times.
   *   The running time of Integer.parseInt(literal) is O(literal.length).
   *   Since literal.length does not depend on the length of the input array, I will treat the running time as O(1).
   *   The amortized running time for StringBuilder.append() is O(1).
   *   Each instruction in this block has O(1) worst-case running time.
   *   Each instruction outside of the for-loop has O(1) worst-case running time.
   *   Therefore the amortized running time is (O(n) * O(1)) + O(1) = O(n).
   *
   * @param infixLiterals : an array containing the string literals in postfix order.
   * The method assumes that each of these literals can be one of:
   * - "+", "-", "*", or "/"
   * - or a valid string representation of an integer.
   *
   * @return the expression in infix order.
   **/
  public static String[] convertPostfixToInfix(String postfixLiterals[])
  {
    //TODO
    if(validatePostfixOrder(postfixLiterals))
    {
      Stack<StringBuilder> stack = new Stack<StringBuilder>();
      StringBuilder a = new StringBuilder();
      StringBuilder b = new StringBuilder();
      String literal;
      for(int i = 0; i < postfixLiterals.length; i++)
      {
        literal = postfixLiterals[i];
        switch(literal) {
        case("+"):
        case("-"):
        case("*"):
        case("/"):
	  StringBuilder subExpression = new StringBuilder("( ");
          b = stack.pop(); 
          a = stack.pop(); 
	  subExpression.append(a);
	  subExpression.append(" ");
	  subExpression.append(literal);
	  subExpression.append(" ");
	  subExpression.append(b);
	  subExpression.append(" )");
	  stack.push(subExpression);
	  break;
        default:
	  stack.push(new StringBuilder(literal));
        }
      }
      a = stack.pop();
      String result = a.toString();
      String[] infixLiterals = result.split(" ");
      return infixLiterals;
    }
    return new String[0];
  }
}

/**
 * Q5 - Data Structures used in my code:
     java.util.Stack
     Methods used:
       push(Object) - O(1) amortized running time
       pop() - O(1) amortized running time
     java.lang.String
       Methods used:
         split(String) - O(n) worst-case running time
     java.lang.StringBuilder
       Methods used:
         append(Object) - O(1) amortized running time
	 toString() - O(n) worst-case running tome
     java.lang.Integer
       Methods used:
         parseInt(String) - O(n) worst-case running time

**/
