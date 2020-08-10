/**
* @author Prakhar Khandelwal 
*
*/
import java.util.*;
import java.io.*;

class RottenOrangesQueue{
	
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		while(T-- > 0) {

			int r = sc.nextInt();
			int c = sc.nextInt();

			int[][] matrix = new int[r][c];
			int victimCount = 0;
			Queue<String> q = new LinkedList<>();

			for(int i = 0; i < r; i++){
				for(int j = 0; j < c; j++) {
					matrix[i][j] = sc.nextInt();
					if(matrix[i][j] == 1) victimCount++;
					if(matrix[i][j] == 2) q.add(i+" "+j); 
				}
			}

			if(victimCount == 0) {
				System.out.println(-1);
				continue;
			}

			int time = 0;
			
			while(q.peek() != null) {
				int loopCount = q.size();
				boolean flag = false;
				while(loopCount -- > 0){
					int i = Integer.parseInt(q.peek().split("\\s+")[0]);
					int j = Integer.parseInt(q.peek().split("\\s+")[1]);
					q.pop();
					
					if(i - 1 >= 0 && matrix[i-1][j] == 1) { // TOP
						--victimCount;
						matrix[i-1][j] = 2; // rot the orange
						flag = true; // decrease victim's count
						q.add((i-1)+" "+j); // add doer's position
					} 
					if(i + 1 < r && matrix[i+1][j] == 1) { // DOWN
						--victimCount;
						matrix[i+1][j] = 2; // rot the orange
						flag = true; // decrease victim's count
						q.add((i+1)+" "+j); // add doer's position
					}
					if(j - 1 >= 0 && matrix[i][j-1] == 1) { // LEFT
						--victimCount;
						matrix[i][j-1] = 2; // rot the orange
						flag = true; // decrease victim's count
						q.add(i+" "+(j-1)); // add doer's position
					}
					if(j + 1 < c && matrix[i][j+1] == 1) { // RIGHT
						--victimCount;
						matrix[i][j+1] = 2; // rot the orange
						flag = true; // decrease victim's count
						q.add(i+" "+(j+1)); // add doer's position
					}					
				}
				if(flag)
	       			time++;
			}

			if(victimCount != 0){
				System.out.println(-1);
			} else {
				System.out.println(time);
			}
		}
	}
}