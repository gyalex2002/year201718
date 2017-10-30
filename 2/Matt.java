import java.util.Scanner;

public class Matt {
	private static int[][] edges;
	private static boolean[] explV;
	private static int r = 0;
	private static int x;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k = sc.nextInt();
		edges = new int[k][2];
		for (int i = 0; i < k; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
		}
		x = sc.nextInt();
		sc.close();
		explV = new boolean[n];
		if (x == 0 && n > 1) dfs(1);
		else dfs(0);
		if (r >= n-1) System.out.println("Connected");
		else System.out.println("Not Connected");
	}
	private static void dfs(int v) {
		if (explV[v]) return;
		explV[v] = true;
		if (v == x) return;
		r++;
		for (int i = 0; i < edges.length; i++) {
			if (edges[i][0] == v || edges[i][1] == v) {
				int w;
				if (edges[i][0] == v) w = edges[i][1];
				else w = edges[i][0];
				if (!explV[w])
					dfs(w);
			}
		}
	}
}
