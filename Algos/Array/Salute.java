import java.util.Scanner;
import java.util.Arrays;

public class Salute {
	
	/*
		PreRequisite : Talking about --->-><-><-->-
		for each crossing it will take 10 secs (5 + 5)
		in a parade you cannot overlap each other, if the front person is stopped you too have to..

		we can calculate maximum salutes from anywhere you want...
		Time Complexity would be O(n)		
	*/

	private static String parade;
	public static void main(String[] arg){

		Scanner sc = new Scanner(System.in);
		parade = sc.nextLine();

		// remove all "-";
		parade = parade.replace("-","");

		// taking > as the decision making starting
		System.out.println("Time: " + startWith('>')*5 + " secs");
	}

	public static int startWith (char direction) {
		int start = -1, count = -1;
		int[] a = new int[parade.length()];

		char[] c = parade.toCharArray();
		for(int i = 0; i < parade.length(); i++) {
			if(c[i]==direction){ // if > found, increase the count of array by 1
				start = 0;
				a[++count] = 0;
			} else {
				if(start == -1) continue; // if the starting element is < i.e. no crossing can occur using this... just skip this..
				a = updateArray(a, count); // add salute count to each element of array
			}
		}

		int total = 0;
		for(int i = 0; i <= count; i++) {
			total += a[i];
		}
		return total;
	}

	public static int[] updateArray(int[] a, int n) {
		for(int i=0; i <= n; i++){
			a[i] += 2; // factor of 2 is the reason that for each crossing there would be a 2 salutes
		}
		return a;
	}
	// --->-><-><-->-->--<
	// --->-><-><-->-
}