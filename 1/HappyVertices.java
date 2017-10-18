import java.util.*;

public class HappyVertices {
	private static int[][] edges;
	private static int[] numOfKids;
	private static int[] parent;
	private static boolean[] explV;
	private static boolean[] explE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt(), r = 0;
		parent = new int[n];
		numOfKids = new int[n];
		edges = new int[m][2];
		explV = new boolean[n];
		explE = new boolean[m];
		for (int i = 0; i < m; i++) {
			edges[i][0] = sc.nextInt()-1;
			edges[i][1] = sc.nextInt()-1;
		}
		sc.close();
		for (int i = 0; i < n; i++) {
			if (!explV[i]) parent[i] = -1;
			dfs(i);
			if (parent[i] != -1 && numOfKids[parent[i]] < numOfKids[i]) {
				r++;
			}
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
				if (!explE[i]) {
					parent[w] = v;
					numOfKids[v]++;
				}
				explE[i] = true;
				if (!explV[w])
					dfs(w);
			}
		}
	}
}
//https://www.hackerearth.com/practice/algorithms/graphs/depth-first-search/practice-problems/algorithm/happy-vertices/