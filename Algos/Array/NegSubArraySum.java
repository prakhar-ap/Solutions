import java.util.*;
import java.io.*;
import java.lang.*;

class NegSubArraySum {
	
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		int N  = sc.nextInt();
		int SUM = sc.nextInt();

		int[] a = new int[N];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<N;i++) {
			a[i] = sc.nextInt();
		}

		String range = "-1";
		int curr_sum=0;
		for(int i=0;i<N;i++){

			curr_sum += a[i];

			if(curr_sum == SUM) {
				range = "0 "+ i;
				break;
			}

			if(map.get(curr_sum - SUM) != null) {
				range = (map.get(curr_sum - SUM)+1) + " " + i;
				break;
			}

			map.put(curr_sum, i);
		}

		System.out.println(range);
	}
}