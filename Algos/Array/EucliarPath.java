/**
* https://practice.geeksforgeeks.org/problems/eulerian-path-in-an-undirected-graph
* @author Prakhar Khandelwal
* 
* For Undirected Graphs we have a formula : 
* Either every vertex has even degree or exactly two vertices have odd degree then its an undirected graph.
* for more info follow the below link
* https://www.youtube.com/watch?v=xR4sGgwtR2I
*/

import java.util.*;
import java.io.*;

class EucliarPath {
	public static void main (String[] args) throws IOException
	 {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            
            int oddCount = 0;
            for(int i=0;i<N;i++) {
                String[] subs = br.readLine().trim().split("\\s+");
                int degree = 0;
                for(int j=0;j<N;j++){
                    if(Integer.parseInt(subs[j])==1) degree++; 
                }
                if(degree % 2 != 0) oddCount++;
            }
            
            if(oddCount == 2 || oddCount == 0){
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
	 }
}