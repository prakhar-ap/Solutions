/**
* https://practice.geeksforgeeks.org/problems/missing-number-in-array
* @author Prakhar Khandelwal
*
* Accepted Solution : https://ide.geeksforgeeks.org/FdSy14NOAh
*/
import java.util.*;

class Missing {
	public static void main (String[] args)
	 {
    	 Scanner sc = new Scanner(System.in);
    	 int T =  sc.nextInt();
    	 while(T-- > 0) {
    	     int N = sc.nextInt();
    	     if(N > 1){
				int a[] = new int[N - 1];
				int min = 10000000;
				for(int i=0;i < N - 1;i++){
					a[i] = sc.nextInt();
				}

				// if not sorted already
				Arrays.sort(a);

				int flag = 0;
				for(int i=0;i<N-1;i++){
					if((i+1)!=a[i]){
						flag++;
						System.out.println((i+1));
						break;	
					}
				}
				if(flag==0)
					System.out.println(N);
    	     }
    	 }
	 }
}