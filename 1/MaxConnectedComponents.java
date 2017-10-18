import java.util.*;

public class MaxConnectedComponents {
	private static int[][] edges;
	private static boolean[] explV;
	private static boolean[] explE;
	private static int j;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt(), r = -1;
		edges = new int[m][2];
		explV = new boolean[n];
		explE = new boolean[m];
		for (int i = 0; i < m; i++) {
			edges[i][0] = sc.nextInt()-1;
			edges[i][1] = sc.nextInt()-1;
		}
		sc.close();
		for (int i = 0; i < n; i++) {
			j = 0;
			dfs(i);
			r = r > j ? r : j;
		}
		System.out.println(r);
	}
	private static void dfs(int v) {
		if (explV[v]) return;
		explV[v] = true;
		for (int i = 0; i < edges.length; i++) {
			if (edges[i][0] == v || edges[i][1] == v) {
				int w;
				if (edges[i][0] == v) w = edges[i][1];
				else w = edges[i][0];
				if (!explE[i]) j++;
				explE[i] = true;
				if (!explV[w])
					dfs(w);
			}
		}
	}
}
//https://www.hackerearth.com/practice/algorithms/graphs/depth-first-search/practice-problems/algorithm/monk-and-graph-problem/