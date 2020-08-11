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
		int start = -1, count = 0;
		int total = 0;

		char[] c = parade.toCharArray();
		for(int i = 0; i < parade.length(); i++) {
			if(c[i]==direction){ // if > found, increase the count of array by 1
				start = 0;
				++count;
			} else {
				if(start == -1) continue; // if the starting element is < i.e. no crossing can occur using this... just skip this..
				total+= 2*count; // add salute count to each element of array
			}
		}
		return total;
	}
	// --->-><-><-->-->--<
	// --->-><-><-->-
}