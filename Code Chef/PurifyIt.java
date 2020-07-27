/*
https://www.codechef.com/COOK113B/problems/PRFYIT
*/
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PurifyIt{

	public static String inputString;
	public static int count;
		
		
	public static void main(String arg[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int T = sc.nextInt();
			sc.nextLine();
			while(T>0){
				inputString = sc.nextLine();
				count=0;
				validator();
				System.out.println(count);
				T--;
			}
		}
	}

	public static void validator(){
		while(true){
			if(traverse()){
				break;
			}
		}
	}

	public static boolean traverse(){

		int[] max = new int[4];
		int[] start = new int[4];

		// initialize max array;
		for(int i=0;i<4;i++){
			max[i] = 0;
		}

		//initialize start array
		for(int i=0;i<4;i++){
			start[i] = 0;
		}

		String subSequence = "";
		char[] inputChar = inputString.toCharArray();
		
		int j=0;

		// iterating all over the string to fetch both the patterns
		for(int i=0;i<inputString.length();i++){
			if(j<4){
				if(i!=0){
					if(inputChar[i]!=inputChar[i-1]){
						if(j+1==4)break;
						start[++j] = i;
						max[j] = 1;
						subSequence+=String.valueOf(inputChar[i]);
					}else{
						if(start[j]==0 && max[j]==0){
							start[j] = i;
						}
						++max[j];
					}
				}else{
					++max[i];
					subSequence+=String.valueOf(inputChar[i]);
				}
			}else{
				// System.out.println("Exiting string check loop...");
				break;
			}
		}


		// if any sequence found
		if(subSequence.equals("0101") || subSequence.equals("1010")){
			
			String[] eliminator = findMinAndStarting(max,subSequence).split(" ");
			
			// eliminate the minimum occurance of the number
			int startLoop = start[Integer.parseInt(eliminator[0])];
			int endLoop = Integer.parseInt(eliminator[1]);

			List<String> inputAsList = new ArrayList<>();

			inputAsList.addAll(Arrays.asList(inputString.split("")));
			

			for(int i=startLoop;i<=(startLoop+endLoop-1);i++){
				inputAsList.remove(i);
				count++;
			}
			
			inputString = String.join("",inputAsList);
			return false;
		}
		return true;
	}

	public static String findMinAndStarting(int[] max,String subSequence){

		char skipValue = '0';
		
		if(oneCount()>zeroCount()){
			skipValue = '1';
		}

		char[] subSequenceChar = subSequence.toCharArray();

		int min = inputString.length();
		int index = 0;
		for(int i=0;i<4;i++){
			if(max[i]<min && subSequenceChar[i]!=skipValue){
				min = max[i];
				index = i;
			}
		}
		return index + " " + min;
	}

	public static int zeroCount(){
		return inputString.length() - inputString.replace("0","").length();
	}

	public static int oneCount(){
		return inputString.length() - inputString.replace("1","").length();
	}
}