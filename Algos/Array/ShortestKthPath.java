import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class ShortestPath {

	static class Node {
		int key;
		int data;

		Node(int key,int data) {
			this.key = key;
			this.data = data;
		}
	}

	public static ArrayList<ArrayList<Node>> graph;
	public static ArrayList<Integer> list = new ArrayList<Integer>();
	public static int count;
	public static int iteration;

	public static ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>(1000);
	public static ArrayList<Integer> totalCounts = new ArrayList<Integer>();

	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		
		graph = new ArrayList<ArrayList<Node>>(9);
		for(int i=0; i<9; i++){
			graph.add(new ArrayList<Node>());
		}

		addEdge(0, 7, 8); 
		addEdge(0, 1, 4); 
		addEdge(1, 7, 11); 
		addEdge(1, 2, 8); 
		addEdge(2, 3, 7); 
		addEdge(2, 5, 4); 
		addEdge(2, 8, 2); 
		addEdge(3, 4, 9); 
		addEdge(3, 5, 14); 
		addEdge(4, 5, 10); 
		addEdge(5, 6, 2); 
		addEdge(6, 7, 1); 
		addEdge(6, 8, 6); 
		addEdge(7, 8, 7);

		int T = sc.nextInt();
		while(T-- > 0){

			// clear global variables
			list.clear();
			iterations = 0;
			count = 0;
			totalCounts.clear();
			pathList.clear();

			int start = sc.nextInt();
			int end = sc.nextInt();
			int[] visited = new int[9];
			for(int i=0;i<9;i++){
				visited[i] = 0;
			}
			list.add(start);
			visited[start] = 1;

			dfs(start, end, visited);
			printMinPath();
		}
	}

	public static void addEdge(int u, int v, int w) {
		graph.get(u).add(new Node(v, w));
		graph.get(v).add(new Node(u, w));
	}

	public static void dfs(int vertex, int end, int[] visited) {
		if(vertex == end) {
			totalCounts.add(count);
			pathList.add(new ArrayList<Integer>(list));
			return;
		}

		for(int i = 0; i < graph.get(vertex).size(); i++) {
			iteration++;
			Node num = graph.get(vertex).get(i);
			if(visited[num.key] == 0) {

				visited[num.key] = 1;
				list.add(num.key);
				count += num.data;
				
				dfs(num.key, end, visited);

				visited[num.key] = 0;
				list.remove(list.size() - 1);
				count -= num.data;
			}
		}
	}

	public static void printMinPath() {
		try {
			int min = Collections.min(totalCounts);
			int index = totalCounts.indexOf(min);

			System.out.println("ShortestPath will be " + pathList.get(index) + " with distance as " + min + " and " + iteration + " iterations");
		} catch (Exception e) {
        	System.out.println("Exception caught : " + e);
      	}
	}
}