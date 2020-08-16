/**
* https://practice.geeksforgeeks.org/problems/check-if-string-is-rotated-by-two-places/0
* @author Prakhar Khandelwal
*
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class RotatedString
 {
    static String first;
    static String second;
	public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t-- > 0) {
	        first = sc.next();
	        second = sc.next();
	        
	        // operate on these
	        // there could be two possiblities
	        // left / right rotation of 2nd string
	        
	        if (second.length() == 1
	            || rotate(2)
	            || rotate(second.length() - 2) ) {
	            System.out.println(1);
	        } else {
	            System.out.println(0);
	        }
	    }
	 }
	 
	 public static boolean rotate(int division) {
	     String f = second.substring(0, division);
	     String s = second.substring(division, second.length());
	     
	     return (s+f).equals(first);
	 }
}