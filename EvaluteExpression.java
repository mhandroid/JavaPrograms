package com.mub.main;

import java.util.Stack;
/**
 * Class to Evalute airthematic Expression
 * Created by @author Mubarak Hussain.
 */
public class EvaluteExpression {
	 public static int evaluate(String expression) 
	    { 
	        char[] tokens = expression.toCharArray(); 
	  
	         // Stack for numbers: 'values' 
	        Stack<Integer> values = new Stack<Integer>(); 
	  
	        // Stack for Operators: 'ops' 
	        Stack<Character> ops = new Stack<Character>(); 
	  
	        for (int i = 0; i < tokens.length; i++) 
	        { 
	             //if Current token is a whitespace, continue
	            if (tokens[i] == ' ') 
	                continue; 
	  
	            // if Current token is a number, push it
	            if (tokens[i] >= '0' && tokens[i] <= '9') 
	            { 
	                StringBuffer sbuf = new StringBuffer(); 
	                // There may be more than one digits in number 
	                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') 
	                    sbuf.append(tokens[i++]); 
	                values.push(Integer.parseInt(sbuf.toString())); 
	            } 

	            else if (tokens[i] == '(') 
	                ops.push(tokens[i]); 

	            else if (tokens[i] == ')') 
	            { 
	                while (ops.peek() != '(') 
	                  values.push(applyOp(ops.pop(), values.pop(), values.pop())); 
	                ops.pop(); 
	            } 
	  
	            else if (tokens[i] == '+' || tokens[i] == '-' || 
	                     tokens[i] == '*' || tokens[i] == '/') 
	            { 
	          
	                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())) 
	                  values.push(applyOp(ops.pop(), values.pop(), values.pop())); 
	
	                ops.push(tokens[i]); 
	            } 
	        } 

	        while (!ops.empty()) 
	            values.push(applyOp(ops.pop(), values.pop(), values.pop())); 

	        return values.pop(); 
	    } 

	    public static boolean hasPrecedence(char op1, char op2) 
	    { 
	        if (op2 == '(' || op2 == ')') 
	            return false; 
	        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) 
	            return false; 
	        else
	            return true; 
	    } 
	  
	    public static int applyOp(char op, int b, int a) 
	    { 
	        switch (op) 
	        { 
	        case '+': 
	            return a + b; 
	        case '-': 
	            return a - b; 
	        case '*': 
	            return a * b; 
	        case '/': 
	            if (b == 0) 
	                throw new
	                UnsupportedOperationException("Cannot divide by zero"); 
	            return a / b; 
	        } 
	        return 0; 
	    } 
	  
	    // Driver method to test above methods 
	    public static void main(String[] args) 
	    { 
	        System.out.println(EvaluteExpression.evaluate("10 + 2 * 6")); 
	        System.out.println(EvaluteExpression.evaluate("100 * 2 + 12")); 
	        System.out.println(EvaluteExpression.evaluate("100 * ( 2 + 12 )")); 
	        System.out.println(EvaluteExpression.evaluate("100 * ( 2 + 12 ) / 14")); 
	    } 
}
