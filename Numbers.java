/**
 * 
 *  @author Ryan Kelley
 *  @version 3/16/17
 */

import java.util.Stack;

public class Numbers {
	private Stack<Integer> firstStack = new Stack<Integer>();
	private Stack<Integer> secondStack = new Stack<Integer>();
	private Stack<Integer> resultStack;
	private String num1;
	private String num2;
	
	/**
	 * Takes in a character from a string of numbers and converts it into an Integer.
	 * 
	 * @param num A character of a number from the string of numbers.
	 * @return    the character in integer form.
	 */
	
	public int convertToNum(char num)
	{
		String letter = Character.toString(num);
		int x = Integer.parseInt(letter);
		//System.out.println(x);
		
		return x;
	}
	
	/**
	 * Takes in an integer and converts it into a string to be printed out.
	 * 
	 * @param num	the integer that needs to be converted into a string.
	 * @return		the integer in string form.
	 */
	
	public String convertToString(int num)
	{
		String result = "";
		
		result = Integer.toString(num);
		
		return result;
	}
	
	/**
	 * Takes in the resultStack and pop off each integer in order to create the whole
	 * number into a string.
	 * 
	 * @param stack		The Stack of integers that needs to be converted into a string.
	 * @return			The integer in String form.
	 */
	
	public String getNums(Stack<Integer> stack)
	{
		String result = " ";
		int length = stack.size();
		int x = 0;
		
		for(int i = 0; i < length; i++)
		{
			x = stack.pop();
			result += convertToString(x);
		}
		
		//System.out.println(result);
		return result;
	}
	
	/**
	 * Takes in a string of a number and sets num1 equal to that string so it can be
	 * referenced from this class.
	 * 
	 * @param num	The number that is being set to Num1.
	 */
	
	public void setNum1(String num)
	{
		this.num1 = num;
	}
	
	/**
	 * Takes in a string of a number and sets num2 equal to that string so it can be
	 * referenced from this class.
	 * 
	 * @param num	The number that is being set to Num2.
	 */
	
	public void setNum2(String num)
	{
		this.num2 = num;
	}
	
	/**
	 * Calls num1 and returns that value in order to be used.
	 * 
	 * @return		the value of num1.
	 */
	
	public String getNum1()
	{
		return this.num1;
	}
	
	/**
	 * Calls num2 and returns that value in order to be used.
	 * 
	 * @return		the value of num2.
	 */
	
	public String getNum2()
	{
		return this.num2;
	}
	
	/**
	 * Calls firstStack and returns the whole stack of integers to be used.
	 * 
	 * @return		the firstStack of integers.
	 */
	
	public Stack<Integer> getFirstStack()
	{
		Stack<Integer> firstStackHolder = this.firstStack;
		return firstStackHolder;
	}
	
	/**
	 * Takes in an integer and pushes it onto the firstStack in order to create a stack
	 * of integers.
	 * 
	 * @param num	the integer to be added to the stack.
	 */
	
	public void addFirstStack(int num)
	{
		this.firstStack.push(num);
	}
	
	/**
	 * Calls secondStack and returns the whole stack of integers to be used.
	 * 
	 * @return		the secondStack of integers.
	 */
	
	public Stack<Integer> getSecStack()
	{
		Stack<Integer> secondStackHolder = this.secondStack;
		return secondStackHolder;
	}
	
	/**
	 * Takes in an integer and pushes it onto the secondStack in order to create a stack
	 * of integers.
	 * 
	 * @param num	the integer to be added to the stack.
	 */
	
	public void addSecStack(int num)
	{
		this.secondStack.push(num);
	}
	
	/**
	 * Takes in a String of numbers and converts each character into a integer using the
	 * convertToNum method. It converts the characters to integers so that they can be
	 * pushed on to a stack of integers.
	 * 
	 * @param num	the string of numbers to be added to the stack.
	 * @return		the string of numbers in stack form.
	 */
	
	private Stack<Integer> createStack(String num)
	{
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < num.length(); i++)
		{
			int x = convertToNum(num.charAt(i));
			stack.push(x);
		}
				
		return stack;
	}
	
	/**
	 * Takes in two different stacks of integers and pops off the first integer from
	 * each stack. Each integer is then added together and checked for a remainder. The
	 * remainder is added to the resultStack and a 1 is carried over to add to the next
	 * integer if the result of the two integers was more than 10.
	 * <p>
	 * The method then calls the getNum method to convert the resultStack into a String so
	 * it can be returned to the GUI.
	 * 
	 * @return		the resultStack in String form.
	 */
	
	public String addition()
	{
		//boolean done = false;
		resultStack = new Stack<Integer>();
		firstStack = createStack(getNum1());
		secondStack = createStack(getNum2());
		
		int carry = 0;
		
		while(!firstStack.isEmpty() && !secondStack.isEmpty())
		{
			int digit1 = firstStack.pop();
			int digit2 = secondStack.pop();
			int result = digit1 + digit2 + carry;
			int resultDigit = result % 10;
			carry = result/10;
			resultStack.push(resultDigit);
		}
		
		if(carry > 0)
			resultStack.push(carry);
		
		String nums = getNums(resultStack);
		return nums;
	}
	
	/**
	 * Takes in two different stacks of integers and pops off the first integer from
	 * each stack. The second integer is then subtracted from the first integer
	 * and checked for a remainder. The remainder is added to the resultStack and a 1
	 * is carried over to subtract from the next integer if the result of the two integers
	 * was less than 0.
	 * <p>
	 * The method then calls the getNum method to convert the resultStack into a String so
	 * it can be returned to the GUI.
	 * 
	 * @return		the resultStack in String form.
	 */
	
	public String subtraction()
	{
		resultStack = new Stack<Integer>();
		firstStack = createStack(getNum1());
		secondStack = createStack(getNum2());
		//secondStack = getSecStack();
		boolean done = false;
		
		int carry = 0;
		while(!done)
		{
			int digit1 = 0;
			int digit2 = 0;
			if(firstStack.isEmpty() && secondStack.isEmpty())
				done = true;
			else if(firstStack.isEmpty() && !secondStack.isEmpty())
				digit1 = 0;
			else if (!firstStack.isEmpty() && secondStack.isEmpty())
				digit2 = 0;
			else
			{
				digit1 = firstStack.pop();
				digit2 = secondStack.pop();
			}
			int result = digit1 - digit2 - carry;
			int resultDigit = result;
			
			if(result < 0)
			{
				carry = 1;
				resultDigit = 10 + result;
			}
			else
			{
				resultDigit = result;
				carry = 0;
			}
			
			resultStack.push(resultDigit);
		}
		
		if(carry > 0)
			resultStack.push(carry);
		
		String nums = getNums(resultStack);
		return nums;
	}
	
}