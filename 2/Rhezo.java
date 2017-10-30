import java.util.Scanner;

public class Rhezo {
	private static int[][] edges;
	private static boolean[] explV;
	private static boolean[] explE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt(), p = sc.nextInt(), r = 0;
		edges = new int[m][2];
		for (int i = 0; i < m; i++) {
			edges[i][0] = sc.nextInt()-1;
			edges[i][1] = sc.nextInt()-1;
		}
		sc.close();
		for (int i = 0; i < m; i++) {
			explV = new boolean[n];
			explE = new boolean[m];
			int t1 = dfs(edges[i][0], 0, edges[i][1], i), t2 = dfs(edges[i][1], 0, edges[i][0], i);
			if (t1 != -1 && t2 != -1 && Math.max(t1, t2) < p)
				r++;
		}
		System.out.println(r);
	}
	private static int dfs(int v, int depth, int other, int avoid) {
		if (explV[v]) return depth;
		explV[v] = true;
		int r = depth + 1;
		for (int i = 0; i < edges.length; i++) {
			if (i == avoid) continue;
			if (edges[i][0] == v || edges[i][1] == v) {
				int w;
				if (edges[i][0] == v) w = edges[i][1];
				else w = edges[i][0];
				explE[i] = true;
				if (!explV[w]) {
					if (w == other) return -1;
					r = dfs(w, depth == -1 ? -1 : depth+1, other, avoid);
				}
			}
		}
		return r;
	}
}
