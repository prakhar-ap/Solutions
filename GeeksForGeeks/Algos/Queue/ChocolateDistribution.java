/**
* https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem/0
* @author Prakhar Khandelwal
*
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class ChocolateDistribution
 {
	public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t-- > 0) {
	        int n = sc.nextInt();
	        
	        int[] a = new int[n];
	        for(int i=0;i<n;i++){
	            a[i] = sc.nextInt();
	        }
	        int m = sc.nextInt();
	        
	        if(n == 1) {
	            System.out.println(a[0]);
	            continue;
	        }
	        
	        Arrays.sort(a);
	        
	        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	        
	        for(int i=0;i<n-m+1;i++) {
	           minHeap.add(a[m+i-1] - a[i]);
	        }
	        
	        System.out.println(minHeap.remove());
	    }
	 }
}