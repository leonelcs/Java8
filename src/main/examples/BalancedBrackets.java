package main.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BalancedBrackets {
	
    public static boolean isBalanced(String expression) {
    	char[] charArray = expression.toCharArray();
    	List<Character> charList = new ArrayList<>();
    	for (int i=0; i < charArray.length; i++) {
    		if (charArray[i]=='(' || charArray[i]=='{' || charArray[i]=='[') {
    			charList.add(charArray[i]);
    		}
    		if (charArray[i]==')' || charArray[i]=='}' || charArray[i]==']') {
    			if (!charList.isEmpty()) {
    				Character aux = charList.get(charList.size()-1);

	    			switch (charArray[i]) {
	    				case ')':
	    					if (aux != '(') {
	    						return false;
	    					} else {
	    						charList.remove(charList.size()-1);
	    					}
	    					break;
	    				case ']':
	    					if (aux != '[') {
	    						return false;
	    					} else {
	    						charList.remove(charList.size()-1);
	    					}
	    					break;
	    				case '}':
	    					if (aux != '{') {
	    						return false;
	    					} else {
	    						charList.remove(charList.size()-1);
	    					}
	    					break;
	   				
	    			}
    			} else {
    				return false;
    			}
    				
    		}
    	}
    	if (!charList.isEmpty()) {
    		return false;
    	}
    	
    	
        return true;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }

}
