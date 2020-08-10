
/**
* https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1/ 
* @author Prakhar Khandelwal 
*
* For every visited vertex ‘v’, if there is an adjacent ‘u’ such that u is already visited and u is not parent of v, then there is a cycle in graph.
* If we don’t find such an adjacent for any vertex, we say that there is no cycle.
*/
import java.util.*;
import java.io.*;
import java.lang.*;


class DetectCycle {
	static int iteration = 0;
	public static void main(String[] arg){
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		while(T-- > 0) {
			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			int nov = sc.nextInt();
			int edg = sc.nextInt();

			for(int i=0;i< nov + 1;i++) 
				list.add(new ArrayList<Integer>());

			for(int i=1; i <= edg; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				list.get(u).add(v);
				list.get(v).add(u);
			}

			if(isCyclic(list, nov)){
				System.out.println(1);
			} else {
				System.out.println(0);
			}
			System.out.println("iteration: " + iteration);
		}
	}

	public static boolean isCyclic(ArrayList<ArrayList<Integer>> g, int V) {
       boolean[] visited = new boolean[V];
       for(int i = 0; i < V; i++) {
           visited[i] = false;
       }
       
       for(int i = 0 ; i < g.size() - 1; i++) {
       		if(!visited[i] && dfs(i, -1, g, visited)) {
       			return true;
       		}
       }
       return false;
    }

    public static boolean dfs(int start, int parent, ArrayList<ArrayList<Integer>> g, boolean[] visited) {
        visited[start] = true;
        for(int i = 0; i < g.get(start).size(); i++) {
            int curr = g.get(start).get(i);
            if(!visited[curr]){
                if(dfs(curr, start, g, visited)){
                    return true;
                }
            } else{
            	if(curr != parent) {
                    return true;
                }
            }
        }
        return false;
    }
}