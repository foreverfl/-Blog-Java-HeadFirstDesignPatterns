package _220402_ProgrammersDevMachting_1;

import java.util.ArrayList;
import java.util.List;

public class Problem_2 {

	public static void main(String[] args) {
		String[] grid_1 = { "??b", "abc", "cc?" };
		String[] grid_2 = { "abcabcab", "????????" };
		String[] grid_3 = { "aa?" };

		int result_1 = solution(grid_1);
		int result_2 = solution(grid_2);
		int result_3 = solution(grid_3);

		System.out.println(result_1);
		System.out.println(result_2);
		System.out.println(result_3);

	}

	static char[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static boolean[][] visited;
	static int N, M;
	static int ans;

	public static int solution(String[] grid) {
		N = grid.length;
		M = grid[0].length();
		map = new char[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = grid[i].charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != '?') {
					dfs(i, j);
				}
			}
		}

		int answer = -1;
		return answer;
	}

	public static void dfs(int x, int y) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
				if (!visited[nx][ny] && map[nx][ny] == '?') {
					dfs(nx, ny);
				}
			}
		}
	}

	public static void dfs_check(int x, int y, char check) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
				if (!visited[nx][ny] && map[nx][ny] == '?') {
					dfs(nx, ny);
				}
			}
		}
	}
}
