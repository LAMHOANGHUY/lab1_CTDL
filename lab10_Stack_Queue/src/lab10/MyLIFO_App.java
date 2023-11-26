package lab10;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyLIFO_App {
	// This method reserves the given array
	public static <E> void reserve(E[] array) {
		// Tạo một Stack để lưu trữ các phần tử của mảng
		Stack<E> stack = new Stack<>();
		// Đẩy các phần tử của mảng vào Stack
		for (E element : array) {
			stack.push(element);
		}
		// Pop các phần tử từ Stack để đảo ngược thứ tự trong mảng
		for (int i = 0; i < array.length; i++) {
			array[i] = stack.pop();
		}
	}

	// This method checks the correctness of the given input
	// i.e. ()(())[]{(())} ==> true, ){[]}() ==>false
	public static boolean isCorrect(String input) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else {
				if (stack.isEmpty())
					return false;
				char openPeek = stack.peek();
				if ((c == ')' && openPeek == '(') || (c == ']' && openPeek == '[') || (c == '}' && openPeek == '{')) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	// This method evaluates the value of an expression
	// i.e. 51 + (54 *(3+2)) = 321
	public static int evaluateExpression(String expression) {
		expression = insertBlanks(expression);
		Stack<Integer> operandStack = new Stack<>();
		Stack<Character> operatorStack = new Stack<>();
		String[] tokens = expression.split(" ");
		for (String token : tokens) {
			if (token.length() == 0) {
				continue;
			} else if (Character.isDigit(token.charAt(0))) {
				operandStack.push(Integer.parseInt(token));
			} else if (token.charAt(0) == '(') {
				operatorStack.push('(');
			} else if (token.charAt(0) == ')') {
				while (operatorStack.peek() != '(') {
					processAnOperator(operandStack, operatorStack);
				}
				operatorStack.pop();
			} else if (token.charAt(0) == '+' || token.charAt(0) == '-' || token.charAt(0) == '*'
					|| token.charAt(0) == '/') {
				while (!operatorStack.isEmpty() && (precedence(token.charAt(0)) <= precedence(operatorStack.peek()))) {
					processAnOperator(operandStack, operatorStack);
				}
				operatorStack.push(token.charAt(0));
			}
		}
		while (!operatorStack.isEmpty()) {
			processAnOperator(operandStack, operatorStack);
		}
		return operandStack.pop();
	}

	public static String insertBlanks(String input) {
		String result = "";
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/'
					|| input.charAt(i) == '(' || input.charAt(i) == ')') {
				result = result + " " + input.charAt(i) + " ";
			} else {
				result = result + input.charAt(i);
			}
		}
		return result;
	}

	// This method returns the precedence of an operator
	public static int precedence(char operator) {
		if (operator == '+' || operator == '-') {
			return 1;
		} else if (operator == '*' || operator == '/') {
			return 2;
		} else {
			return 0;
		}
	}

	// This method pops and processes an operator and its operands from the stacks
	public static void processAnOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
		char operator = operatorStack.pop();
		int operand2 = operandStack.pop();
		int operand1 = operandStack.pop();
		int result = 0;
		switch (operator) {
		case '+':
			result = operand1 + operand2;
			break;
		case '-':
			result = operand1 - operand2;
			break;
		case '*':
			result = operand1 * operand2;
			break;
		case '/':
			result = operand1 / operand2;
			break;
		}
		operandStack.push(result);
	}

	// method stutter that accepts a queue of integers as a parameter and replaces
	// every element of the queue with two copies of that element
	// front [1, 2, 3] back
	// becomes
	// front [1, 1, 2, 2, 3, 3] back
	public static <E> void stutter(Queue<E> input) {
		int originalSize = input.size();
		Queue<E> temp = new LinkedList<>();
		for (int i = 0; i < originalSize; i++) {
			E element = input.poll();
			temp.add(element);
			temp.add(element);
		}
		// Thêm các phần tử từ hàng đợi tạm thời vào cuối hàng đợi gốc
		input.addAll(temp);
	}

	// Method mirror that accepts a queue of strings as a parameter and appends the
	// queue's contents to itself in reverse order
	// front [a, b, c] back
	// becomes
	// front [a, b, c, c, b, a] back
	public static <E> void mirror(Queue<E> input) {
		Stack<E> stack = new Stack<>();
		for (int i = 0; i < input.size(); i++) {
			E element = input.remove();
			stack.push(element);
			input.add(element);
		}
		while (!stack.isEmpty()) {
			E element = stack.pop();
			input.add(element);
		}
	}

	public static void main(String[] args) {
		Integer[] intArray = { 1, 2, 4 };
		System.out.println("Original Integer Array: " + Arrays.toString(intArray));
		reserve(intArray);
		System.out.println("Reversed Integer Array: " + Arrays.toString(intArray));

		System.out.println("_____________");
		// Test cases
		String test1 = "()()[]";
		System.out.println("Test 1: " + isCorrect(test1)); // is true
		String test2 = "){[]}()";
		System.out.println("Test 2: " + isCorrect(test2)); // is false

		System.out.println("_____________");
		Queue<Integer> queue1 = new LinkedList<>();
		queue1.add(1);
		queue1.add(2);
		queue1.add(3);
		System.out.println("Before stutter : " + queue1);
		stutter(queue1);
		System.out.println("After stutter : " + queue1);

		System.out.println("________________");
		Queue<String> queue2 = new LinkedList<>();
		queue2.add("a");
		queue2.add("b");
		queue2.add("c");
		System.out.println("Before mirroring :" + queue2);
		mirror(queue2);
		System.out.println("After mirroring  :" + queue2);

		System.out.println("________________");

		String expression1 = "5 + (4 * 3)";
		String expression2 = "51 + (54 * (3 + 2))";

		int result1 = evaluateExpression(expression1);
		int result2 = evaluateExpression(expression2);

		System.out.println(expression1 + " = " + result1);
		System.out.println(expression2 + " = " + result2);
	}
}
