/**
* https://practice.geeksforgeeks.org/problems/count-the-triplets
* @author Prakhar Khandelwal
*/

import java.util.*;
import java.io.*;

class Triplets {
	public static void main(String[] arg) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());
    		int[] a = new int[N];
            
            String[] line = br.readLine().trim().split("\\s+"); 
    		for(int i=0;i<N;i++) {
    			a[i] = Integer.parseInt(line[i]);
    		}
    
    		int c=0;
    		Arrays.sort(a);
    		
    		for(int i=N-1;i>=0;i--){
    			int j = 0;
    			int k = i-1;
    
    			while (j < k){
    				if(a[i] == a[j] + a[k]) {
    					j++; k--; c++;
    				} else if( a[i] > a[j] + a[k] ) j++;
    				else k--;
    			}
    		}
    		System.out.println(c == 0 ? -1 : c);
        }
    }
}