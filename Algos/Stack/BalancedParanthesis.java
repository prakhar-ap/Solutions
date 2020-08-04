/**
* https://practice.geeksforgeeks.org/problems/parenthesis-checker
* @author Prakhar Khandelwal
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class BalancedParanthesis {
	public static void main (String[] args) throws IOException{
	    Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
	    while(T-- > 0) {
	        String exp = sc.next();
		    if(isBalanced(exp)) {
	        	System.out.println("balanced");
	        } else {
	        	System.out.println("not balanced");
	        }
	    }
	}

	public static boolean isBalanced(String exp) {
		Stack<Character> st = new Stack<>();
	        
        for(int i=0;i<exp.length();i++) {

        	if(exp.charAt(i) == '[' ||  exp.charAt(i) == '(' || exp.charAt(i) == '{'){
        		st.push(exp.charAt(i));
        	} else if(exp.charAt(i) == ']' ||  exp.charAt(i) == ')' || exp.charAt(i) == '}'){
            	if(st.isEmpty()){
            		return false;
            	}

            	char ch = st.pop();
                if(exp.charAt(i) == ']' && ch == '['){
                   continue; 
                } else if(exp.charAt(i) == '}' && ch == '{'){
                   continue; 
                } else if(exp.charAt(i) == ')' && ch == '('){
                   continue; 
                } else {
                	return false;
                }               
            }
        }
	   	
	   	if(st.isEmpty()) {
	   		return true;
	   	} else {
	   		return false;
	   	}
	}
} 