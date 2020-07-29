/**
* https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0
* @author Prakhar Khandelwal
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class SubArraySum {

	private static int SUM;
	
	public static void main(String[] arg) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while(T-- > 0) {
			String[] input = br.readLine().split("\\s+");
			int N = Integer.parseInt(input[0]);
			SUM = Integer.parseInt(input[1]);

			String[] vals = br.readLine().split("\\s+");

			int[] array = new int[N]; // create a prefix array
			
			for(int i=0;i<N;i++){
				array[i] += Integer.parseInt(vals[i]);
			}

			calculateRange(array);
		}
	}

	public static void calculateRange(int[] a){
		String range = "-1";

		// x to keep track of leftmost element
		int cur_sum = a[0], x = 0;

		for(int i = 1; i <= a.length; i++) {

			while( cur_sum > SUM && x < i - 1) {
				cur_sum -= a[x++]; // if the sum exceeds.. then just remove the leftmost
			}

			if(cur_sum == SUM) {
				range = (x+1) + " " + i;
				break;  
			}

			if(i < a.length) {
				cur_sum += a[i];
			}
		}

		System.out.println(range);
	}
}