package _220402_ProgrammersDevMachting_1;

import java.util.ArrayList;
import java.util.List;

public class Problem_1 {
	public static void main(String[] args) {
		int[][] dist_1 = { { 0, 5, 2, 4, 1 }, { 5, 0, 3, 9, 6 }, { 2, 3, 0, 6, 3 }, { 4, 9, 6, 0, 3 },
				{ 1, 6, 3, 3, 0 } };
		int[][] dist_2 = { { 0, 2, 3, 1 }, { 2, 0, 1, 1 }, { 3, 1, 0, 2 }, { 1, 1, 2, 0 } };

		int[][] result_1 = solution(dist_1);
		int[][] result_2 = solution(dist_2);

		for (int i = 0; i < result_1.length; i++) {
			for (int j = 0; j < result_1[0].length; j++) {
				System.out.println(result_1[i][j] + " ");
			}
			System.out.println();
		}

		for (int i = 0; i < result_2.length; i++) {
			for (int j = 0; j < result_2[0].length; j++) {
				System.out.println(result_2[i][j] + " ");
			}
			System.out.println();
		}

		// [[1,2,0,4,3],[3,4,0,2,1]]
		// [[0,3,1,2],[2,1,3,0]]

	}

	static int[][] map;
	static boolean[][] visited;
	static int N;
	static List<Integer> list = new ArrayList<>();

	public static int[][] solution(int[][] dist) {
		N = dist.length;

		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = dist[i][j];
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, map[i][j]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == max) {
					dfs(i, 0);
				}
			}
		}
		
		Integer[] array = list.toArray(new Integer[list.size()]);

		int[][] answer = {};
		return answer;
	}

	public static void dfs(int x, int y) {
		visited[x][y] = true;
		visited[y][x] = true;

		list.add(x);

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			min = Math.min(min, map[x][i]);
		}

		for (int i = 0; i < N; i++) {
			if (!visited[x][i] && map[x][i] == min) {
				dfs(x, i);
			}
		}
	}
}
