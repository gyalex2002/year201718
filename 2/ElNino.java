import java.util.*;

public class ElNino {
	private static int[][] edges;
	private static int[] a;
	private static int r = 0;
	private static int currV;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		a = new int[m];
		for (int i = 0; i < m; i++)
			a[i] = sc.nextInt();
		Arrays.sort(a);
		edges = new int[n-1][2];
		for (int i = 0; i < n-1; i++) {
			edges[i][0] = sc.nextInt()-1;
			edges[i][1] = i+1;
		}
		sc.close();
		for (currV = 0; currV < n; currV++)
			dfs(currV, 0);
		System.out.println(r);
	}
	private static void dfs(int v, int dist) {
		if(Arrays.binarySearch(a, dist) >= 0)
			r++;
		for (int i = 0; i < edges.length; i++) {
			if (edges[i][0] == v) {
				int w = edges[i][1];
				dfs(w, dist+1);
			}
		}
	}
}
