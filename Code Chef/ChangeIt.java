/*
 * https://www.codechef.com/COOK113B/problems/CHNGIT
 * @author Prakhar Khandelwal
*/
import java.util.*;
import java.io.*;

public class ChangeIt{
	public static int N;
	public static Scanner sc;
	public static void main(String args[]){
        sc = new Scanner(System.in);
        if(sc.hasNextInt()){
    		int T = sc.nextInt();
    		while(T>0){
    			N = sc.nextInt();
    			/*Method 1*/
    			method1();
    			/*Method 2*/
    			method2();
          		T--;
    		}
        }
	}

	public static void method1(){

		List<Integer> list = new ArrayList<>(N);
		for(int i=0;i<N;i++){
			list.add(sc.nextInt());
		}
	
		Set<Integer> distinct = new HashSet<>(list);
		Set<Integer> count = new HashSet<>();

		for(Integer id : distinct){
			System.out.println(id + " : "+Collections.frequency(list,id));
			count.add(Collections.frequency(list,id));
		}
		list.clear();
  		list.addAll(count);
  		Collections.sort(list);
  		System.out.print("Output list : " + list);
  		System.out.print("Output from method including List and Sets  : ");
  		System.out.println(N-list.get(list.size()-1));
	}

	public static void method2(){
		
		int array[] =  new int[N];
          	for(int i=0;i<N;i++){
          		array[i] = sc.nextInt();
          	}
		System.out.print("Output from method including arrays  : ");
      	System.out.println(N-maxCount(array));
	}

	public static int maxCount(int[] array){
		int a[] = new int[101];
		
		//initialize array
		for(int i=0;i<101;i++){
			a[i]=0;
		}

		for(int i=0;i<array.length;i++){
			a[array[i]]++;
		}

		int max = 0;

		for(int i=0;i<101;i++){
			if(a[i]>=max)
				max = a[i];
		}

		return max;
	}
}



class FastReader{
	BufferedReader br;
	StringTokenizer st;

	public FastReader(){
		br=new BufferedReader(new InputStreamReader(System.in));
	}// constructor ends

	String next(){
		while(st == null || !st.hasMoreElements()){
		    try{
				st=new StringTokenizer(br.readLine());
		    }
		    catch(Exception e){
				e.printStackTrace();
		    }
		}
		return st.nextToken();
	}// next ends..\

	int nextInt(){
		return Integer.parseInt(next());
	}
	long nextLong(){
		return Long.parseLong(next());
	}

	double nextDouble(){
		return Double.parseDouble(next()); 
	}

	String nextLine(){
		String str="";
			try{
				str=br.readLine();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return str;
	}
}// class ends..