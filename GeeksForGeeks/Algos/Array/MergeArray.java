/**
* https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays/0/
* @author Prakhar Khandelwal
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while(T-- > 0) {
		    String[] vals = br.readLine().trim().split("\\s+");
			int X = Integer.parseInt(vals[0]);
			int Y = Integer.parseInt(vals[1]);
			
			int[] a1 = new int[X];
			int[] a2 = new int[Y];
			
			String[] sA1 = br.readLine().trim().split("\\s+");
			for(int i=0;i<X;i++){
			    a1[i] = Integer.parseInt(sA1[i]);
			}
			
			String[] sA2 = br.readLine().trim().split("\\s+");
			for(int i=0;i<Y;i++){
			    a2[i] = Integer.parseInt(sA2[i]);
			}
			
			mergeArrays(a1, a2);
		}
	 }
	 
	 public static void mergeArrays(int[] a1, int[] a2){
	     
	     int x = a1.length-1;
	     int y = 0;
	     
	     // segregate smallest and greatest elements
	     while(x >= 0 && y < a2.length) {
	         if(a1[x] > a2[y]) {
	             int temp = a1[x];
	             a1[x] = a2[y];
	             a2[y] = temp;
	         }
	         x--;
	         y++;
	     }
	     
	     Arrays.sort(a1);
	     Arrays.sort(a2);
	     
	     // print arrays
	     StringBuilder sb = new StringBuilder();
	     for(int i = 0; i < a1.length; i++) {
	         sb.append(a1[i] + " ");
	     }
	     
	     for(int i = 0; i < a2.length; i++) {
	         sb.append(a2[i] + " ");
	     }
	     
	     System.out.println(sb);
	 }
}
