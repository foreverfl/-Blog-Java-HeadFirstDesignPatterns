package _220312_SK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class tmp {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] snail = new int[N][N];

		int print = N;
		int k = 1;
		int right = -1;
		int bottom = 0;
		int top = 1;

		for (int i = N; i > 0; i--) {

			for (int j = 0; j < print; j++) { // 가로
				right += top;
				snail[bottom][right] = k;
				k++;
			}

			print--;

			for (int j = 0; j < print; j++) { // 세로
				bottom += top;
				snail[bottom][right] = k;
				k++;
			}

			top = top * (-1);
		}

		// 출력
		for (int i = 0; i < snail.length; i++) {
			for (int j = 0; j < snail[i].length; j++) {
				System.out.printf("%2d ", snail[i][j]);
			}
			System.out.println();
		}
	}
}