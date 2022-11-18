package _220519_CodeforcesRound792;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_Problem_C_ColumnSwapping {

	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		outer: while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[][] arr = new int[n][m];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			boolean isSorted = true;
			for (int i = 0; i < n; i++) {
				for (int j = 1; j < m; j++) {
					if (arr[i][j] < arr[i][j - 1]) {
						isSorted = false;
						break;
					}
				}
			}
			if (isSorted) {
				sb.append("1 1").append('\n');
				continue;
			}
			int index1 = -1;
			int index2 = -1;
			for (int i = 0; i < n; i++) {
				int i1 = -1;
				int i2 = -1;
				for (int j = 1; j < m; j++) {
					if (j - 1 == index1 || j == index2) {
						if (arr[i][j] > arr[i][j - 1]) {
							sb.append(-1).append('\n');
							continue outer;
						}
					}
					if (arr[i][j] < arr[i][j - 1]) {
						if (i1 == -1) {
							i1 = j - 1;
							if (index1 == -1) {
								index1 = i1;
							} else if (index1 != i1) {
								sb.append(-1).append('\n');
								continue outer;
							}
						} else if (i2 == -1) {
							i2 = j;
							if (index2 == -1) {
								index2 = i2;
							} else if (index2 != i2) {
								sb.append(-1).append('\n');
								continue outer;
							}
						} else {
							sb.append(-1).append('\n');
							continue outer;
						}
					}
				}
			}
			if (index2 == -1) {
				sb.append((index1 + 1) + " " + (index1 + 2)).append('\n');
				continue outer;
			}
			for (int i = 0; i < n; i++) {
				int temp = arr[i][index1];
				arr[i][index1] = arr[i][index2];
				arr[i][index2] = temp;
			}

			for (int i = 0; i < n; i++) {
				for (int j = 1; j < m; j++) {
					if (arr[i][j] < arr[i][j - 1]) {
						sb.append(-1).append('\n');
						continue outer;
					}
				}
			}

			sb.append((index1 + 1) + " " + (index2 + 1)).append('\n');
		}

		System.out.println(sb.toString());

	}

}
