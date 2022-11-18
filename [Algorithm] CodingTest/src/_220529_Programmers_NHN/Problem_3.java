package _220529_Programmers_NHN;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_3 {

	public static void main(String[] args) {
		String[] maze_0 = { "AAA", "ABB", "ABA" };
		String[] queries_0 = { "1 1 3 3 AB" };

		int[] result_0 = solution(maze_0, queries_0);
		for (int i = 0; i < result_0.length; i++) {
			System.out.print(result_0[i] + " ");
		}

		System.out.println();

		String[] maze_1 = { "AAAAA", "AABBB", "CAEFG", "AAEFF" };
		String[] queries_1 = { "1 1 1 5 AF", "1 1 4 5 AF", "2 1 4 5 FAE", "1 5 4 5 ABF", "1 1 4 1 A" };

		int[] result_1 = solution(maze_1, queries_1);
		for (int i = 0; i < result_1.length; i++) {
			System.out.print(result_1[i] + " ");
		}

		System.out.println();

		String[] maze_2 = { "AAA", "ABB", "ABA" };
		String[] queries_2 = { "1 1 1 3 A", "1 3 3 1 A", "1 1 3 3 A", "1 1 3 3 AB" };

		int[] result_2 = solution(maze_2, queries_2);
		for (int i = 0; i < result_2.length; i++) {
			System.out.print(result_2[i] + " ");
		}
	}

	static char[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int N, M;
	static int[] start = new int[2];
	static int[] end = new int[2];
	static List<Character> route = new ArrayList<>();;
	static int ans_tmp = Integer.MAX_VALUE;

	public static int[] solution(String[] maze, String[] queries) {

		int[] answer = new int[queries.length];

		N = maze.length;
		M = maze[0].length();

		map = new char[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = maze[i].charAt(j);
			}
		}

		for (int i = 0; i < queries.length; i++) {
			StringTokenizer st = new StringTokenizer(queries[i]);
			start[0] = Integer.parseInt(st.nextToken()) - 1;
			start[1] = Integer.parseInt(st.nextToken()) - 1;
			end[0] = Integer.parseInt(st.nextToken()) - 1;
			end[1] = Integer.parseInt(st.nextToken()) - 1;

			String route_tmp = st.nextToken();
			for (int j = 0; j < route_tmp.length(); j++) {
				route.add(route_tmp.charAt(j));
			}

			dfs(start[0], start[1], 1);

			answer[i] = ans_tmp;

			if (ans_tmp == Integer.MAX_VALUE)
				answer[i] = -1;
			else
				answer[i] = ans_tmp;

			ans_tmp = Integer.MAX_VALUE;
			visited = new boolean[N][M];
			route.clear();

		}

		return answer;
	}

	public static void dfs(int x, int y, int cnt) {

		if (x == end[0] && y == end[1]) {
			ans_tmp = Math.min(ans_tmp, cnt);
			return;
		}

		if (!route.contains(map[x][y]))
			return;

		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;

			if (!visited[nx][ny]) {
				dfs(nx, ny, cnt + 1);
			}

		}
	}

}
