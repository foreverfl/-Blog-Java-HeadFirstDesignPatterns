package _220612_SK;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem_4 {

	public static void main(String[] args) {
//		String[] grid_1 = { "..FF", "###F", "###." };
//		int k_1 = 4;
//		int res_1 = solution(grid_1, k_1);
//		System.out.println(res_1);

		String[] grid_2 = { ".F.FFFFF.F", ".########.", ".########F", "...######F", "##.######F", "...######F",
				".########F", ".########.", ".#...####F", "...#......" };
		int k_2 = 6;
		int res_2 = solution(grid_2, k_2);
		System.out.println(res_2);
	}

	static class Node {
		int x;
		int y;
		int move;
		int rest;

		Node(int x, int y, int move, int rest) {
			this.x = x;
			this.y = y;
			this.move = move;
			this.rest = rest;
		}
	}

	static char[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int N, M;
	static List<Integer> list = new ArrayList<>();

	public static int solution(String[] grid, int k) {
		N = grid.length;
		M = grid[0].length();

		map = new char[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < grid.length; i++) {
			String str = grid[i];
			for (int j = 0; j < str.length(); j++) {
				map[i][j] = str.charAt(j);
			}
		}

		bfs(0, 0, k);

		Collections.sort(list);

		int answer = list.get(0);
		
		map = new char[N][M];
		visited = new boolean[N][M];
		list.clear();
		
		return answer;
	}

	public static void bfs(int x, int y, int k) {
		Queue<Node> queue = new LinkedList<>();

		Node first = new Node(x, y, 0, 0);
		queue.offer(first);
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			Node now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;

				if (visited[nx][ny])
					continue;

				if (nx == N - 1 && ny == M - 1) {
					list.add(now.rest);
				}

				if (map[nx][ny] == '.' && now.move <= k) {
					visited[nx][ny] = true;
					queue.offer(new Node(nx, ny, 0, now.rest + 1));

				} else if (map[nx][ny] == '.' || map[nx][ny] == 'F') {
					visited[nx][ny] = true;
					queue.offer(new Node(nx, ny, now.move + 1, now.rest));

				}
			}
		}
	}
}
