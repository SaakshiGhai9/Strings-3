// Time Complexity: O(n) due to traversal
// Space complexity: O(n) sue to stack space

import java.util.Stack;

public class BasicCalculator2 {
    public int calculate(String s) {
            Stack<Integer> stack = new Stack<>();
            int currentNumber = 0;
            char lastOperator = '+';

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (Character.isDigit(c)) {
                    currentNumber = currentNumber * 10 + (c - '0');
                }

                if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                    if (lastOperator == '+') {
                        stack.push(currentNumber);
                    } else if (lastOperator == '-') {
                        stack.push(-currentNumber);
                    } else if (lastOperator == '*') {
                        stack.push(stack.pop() * currentNumber);
                    } else if (lastOperator == '/') {
                        stack.push(stack.pop() / currentNumber);
                    }

                    lastOperator = c;
                    currentNumber = 0;
                }
            }

            int result = 0;
            for (int num : stack) {
                result += num;
            }

            return result;
        }

        public static void main(String[] args) {
            BasicCalculator2 evaluator = new BasicCalculator2();

            // Example 1
            String expr1 = "3+2*2";
            System.out.println("Result of '3+2*2': " + evaluator.calculate(expr1)); // Output: 7

            // Example 2
            String expr2 = " 3/2 ";
            System.out.println("Result of '3/2': " + evaluator.calculate(expr2)); // Output: 1

            // Example 3
            String expr3 = " 3+5 / 2 ";
            System.out.println("Result of '3+5 / 2': " + evaluator.calculate(expr3)); // Output: 5
        }
    }


