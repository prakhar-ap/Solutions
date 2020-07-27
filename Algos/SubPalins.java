import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

class SubPalins {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String palins = sc.nextLine();
		subPalins(palins);
	}

	public static void subPalins(String palins) {
		// for ease of comparing
		palins = "_" + palins + "-";

		// create array to store the positions
		String[] R = new String[palins.length()*palins.length()];
		int count = 0;

		// v = 0 for 121 and v = 1 for 1221
		for (int v = 0; v <= 1; v++) {
			int r = 0;

			for (int i=1; i < palins.length() - 1;) {
				if(palins.charAt(i-r-1+v) == palins.charAt(i+r+1)) {
					r++; continue;
				}
				if ( (v == 0 && r > 0) || (v == 1 && r > 1) ) {
					// add in the array
					R[count++] = (i-r+v) + "," + (i+r);
				}
				i++; r=0;
			}
		}

		Set<String> pals = new HashSet<>();
		for (int i=0;i<count;i++) {
			String[] vals = R[i].split(",");

			pals.add(palins.substring(Integer.valueOf(vals[0]),Integer.valueOf(vals[1]) + 1));
		}
		System.out.println("Size: " + pals.size() + "\n" + pals);
	}
}
