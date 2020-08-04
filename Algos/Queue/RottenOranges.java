/**
* https://practice.geeksforgeeks.org/problems/rotten-oranges
* for this problem statement doer is 2 and victim is 1
* @author Prakhar Khandelwal
*/

import java.util.*;

class RottenOranges {
	private static int VICTIM = 1;
	private static int DOER = 2;

	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		while(T-- > 0) {

			int r = sc.nextInt();
			int c = sc.nextInt();

			int[][] matrix = new int[r][c];
			int victimCount = 0;
			List<String> doer = new ArrayList<>(); // doer -> digitPosition

			for(int i = 0; i < r; i++){
				for(int j = 0; j < c; j++) {
					matrix[i][j] = sc.nextInt();
					if(matrix[i][j] == VICTIM) victimCount++;
					if(matrix[i][j] == DOER) doer.add(i+" "+j); 
				}
			}

			int inc = 0, dec=0;

			// if already no fresh oranges are found
			if(victimCount == 0) {
				System.out.println(-1);
				continue;
			}

			int time = 0;
			int previous = 0;
			while(victimCount != 0) {
				// termination condition
				if(previous == doer.size()) { // this states that nothing changed in the doer's count
					time = -1;
					break;
				}
				previous = doer.size();
				List<String> temp = new ArrayList<>();
				
				for(String s : doer) {
					inc++;
					// doer's position
					int i = Integer.parseInt(s.split("\\s+")[0]);
					int j = Integer.parseInt(s.split("\\s+")[1]);

					// validate nearby elements
					if(i - 1 >= 0 && matrix[i-1][j] == VICTIM) {
						temp.add((i-1)+" "+j); // add doer's position
						matrix[i-1][j] = DOER; // rot the orange
						victimCount--; // decrease victim's count
					} 
					if(i + 1 < r && matrix[i+1][j] == VICTIM) {
						temp.add((i+1)+" "+j); // add doer's position
						matrix[i+1][j] = DOER; // rot the orange
						victimCount--; // decrease victim's count
					}
					if(j - 1 >= 0 && matrix[i][j-1] == VICTIM) {
						temp.add(i+" "+(j-1)); // add doer's position
						matrix[i][j-1] = DOER; // rot the orange
						victimCount--; // decrease victim's count
					}
					if(j + 1 < c && matrix[i][j+1] == VICTIM) {
						temp.add(i+" "+(j+1)); // add doer's position
						matrix[i][j+1] = DOER; // rot the orange
						victimCount--; // decrease victim's count
					}
				}
				if(temp.size() != 0) {
					doer.addAll(temp);
				}
				time++;
			}

			if(victimCount != 0){
				time = -1;
			}
			System.out.println("inc: "+ inc);
			System.out.println(time);
		}
	}
}