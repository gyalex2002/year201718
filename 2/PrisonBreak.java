public class PrisonBreak {
	private static boolean[][] graph = {
			{false, true, true, false},
			{false, false, true, true},
			{false, false, false, false},
			{false, true, false, false}
	};
	private static int n = 4, r = 0;
	public static void main(String[] args) { 
		dfs(0, 0, new boolean[n][n]);
		System.out.println(r);
	}
	private static void dfs(int x, int y, boolean[][] expl) {
		if (expl[x][y] || graph[x][y]) return;
		expl[x][y] = true;
		boolean[][] expl2 = new boolean[n][n];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				expl2[i][j] = expl[i][j];
		if (x == n-1 && y == n-1)
			r++;
		else if (x == n-1 && y == 0) {
			dfs(x-1, y, expl2);
			dfs(x, y+1, expl2);
		}
		else if (x == n-1) {
			dfs(x-1, y, expl2);
			dfs(x, y+1, expl2);
			dfs(x, y-1, expl2);
		}
		else if (x == 0 && y == n-1) {
			dfs(x+1, y, expl2);
			dfs(x, y-1, expl2);
		}
		else if (x == 0 && y == 0) {
			dfs(x+1, y, expl2);
			dfs(x, y+1, expl2);
		}
		else if (x == 0) {
			dfs(x+1, y, expl2);
			dfs(x, y+1, expl2);
			dfs(x, y-1, expl2);
		}
		else if (y == 0) {
			dfs(x+1, y, expl2);
			dfs(x-1, y, expl2);
			dfs(x, y+1, expl2);
		}
		else if (y == n-1) {
			dfs(x+1, y, expl2);
			dfs(x-1, y, expl2);
			dfs(x, y-1, expl2);
		}
		else {
			dfs(x+1, y, expl2);
			dfs(x-1, y, expl2);
			dfs(x, y+1, expl2);
			dfs(x, y-1, expl2);
		}
	}
}
