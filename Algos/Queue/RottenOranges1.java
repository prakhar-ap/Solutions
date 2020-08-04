/**
* https://practice.geeksforgeeks.org/problems/rotten-oranges
* @author Prakhar Khandelwal
*/

import java.util.*;
import java.io.*;

class RottenOranges1 {
	
	public static void main(String[] arg) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(br.readLine()); //sc.nextInt();

		while(T-- > 0) {

			String[] rc = br.readLine().trim().split("\\s+");
			int r = Integer.parseInt(rc[0]);//sc.nextInt();
			int c = Integer.parseInt(rc[1]);//sc.nextInt();

			int[][] matrix = new int[r][c];
			int twoCount = 0;
			List<String> doer = new ArrayList<>();

			String input[] = br.readLine().trim().split("\\s+");
			int inc = 0;

			for(int i = 0; i < r; i++){
				for(int j = 0; j < c; j++) {
					matrix[i][j] = Integer.parseInt(input[inc++]);//sc.nextInt();
					if(matrix[i][j] == 1) doer.add(i+" "+j);
					if(matrix[i][j] == 2) twoCount++; 
				}
			}
			inc = 0;
			int dec = 0;

			// if already no fresh oranges are found
			if(doer.size() == 0) {
				System.out.println(-1);
				continue;
			}

			int time = 0;
			int previous = 0;
			while(doer.size() != 0) {
				// termination condition
				if(previous == twoCount) { // this states that nothing changed in the doer's count
					time = -1;
					break;
				}
				previous = twoCount;
				List<String> temp = new ArrayList<>();
				
				//System.out.println("Doer: " + doer);
				for(String s : doer) {
					inc++;
					// doer's position
					int i = Integer.parseInt(s.split("\\s+")[0]);
					int j = Integer.parseInt(s.split("\\s+")[1]);

					// validate nearby elements
					if( (i - 1 >= 0 && matrix[i-1][j] == 2) || 
						(i + 1 <  r && matrix[i+1][j] == 2) ||
						(j - 1 >= 0 && matrix[i][j-1] == 2) ||
						(j + 1 <  c && matrix[i][j+1] == 2) ) {
						//System.out.println(s + ", " + doer.size());
						temp.add(i+" "+j);
					}
				}
				//System.out.println(temp);
				if(temp.size() != 0) {
					for(String t: temp) {
						dec++;
						int i = Integer.parseInt(t.split("\\s+")[0]);
						int j = Integer.parseInt(t.split("\\s+")[1]);

						matrix[i][j] = 2;
						twoCount++; // decrease 2's count

						// delete values from the doer's list
						doer.remove(t);
					}
				}
				time++;
			}

			if(doer.size() != 0){
				time = -1;
			}
			System.out.println("inc: "+ inc + ", dec: "+dec);
			System.out.println(time);
		}
	}
}