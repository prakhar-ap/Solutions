import java.util.*;
import java.lang.*;

class KthLargestSmallest {
	
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		int k = sc.nextInt();

		System.out.println("KthLargest: " + findKthLargest(a, k));
		System.out.println("KthSmallest: " + findKthSmallest(a, k));
	}

	public static int findKthLargest(int num[], int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for(int i: num) {
			minHeap.add(i);
			System.out.println("Added: " + minHeap);
			if(minHeap.size() > k) {
				minHeap.remove();
				System.out.println("After Removal: " + minHeap);
			}
		}

		return minHeap.remove();
	}

	public static int findKthSmallest(int num[], int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i: num) {
			maxHeap.add(i);
			if(maxHeap.size() > k) {
				maxHeap.remove();
			}
		}

		return maxHeap.remove();
	}
}