package _220312_SK;

import java.io.IOException;

public class Test_02 {

	public static void main(String[] args) throws IOException {
		int[][] arr = solution(7, true);

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static int[][] solution(int n, boolean clockwise) {

		int[][] answer = new int[n][n];
		int i = 0, j = 0;

		// true

		// first
		int print = n;
		int k = 1;
		int right = -1;
		int bottom = 0;
		int top = 1;

		loop: for (i = n; i > 0; i--) {

			for (j = 0; j < print - 1; j++) {
				right += top;
				answer[bottom][right] = k;
				k++;

				if (bottom == n / 2 && right == n / 2)
					break loop;
			}

			print--;

			for (j = 0; j < print - 1; j++) {
				bottom += top;
				answer[bottom][right] = k;
				k++;

				if (bottom == n / 2 && right == n / 2)
					break loop;
			}

			print--;

			top = top * (-1);
		}

		// second
		print = n;
		k = 1;
		right = n - 1;
		bottom = -1;
		top = 1;

		loop: for (i = n; i > 0; i--) {

			for (j = print; j > 0; j--) {
				bottom += top;
				answer[bottom][right] = k;
				k++;

				if (bottom == n / 2 && right == n / 2)
					break loop;
			}

			print--;
			top = top * (-1);

			for (j = 0; j < print - 1; j++) {
				right += top;
				answer[bottom][right] = k;
				k++;

				if (bottom == n / 2 && right == n / 2)
					break loop;
			}

			print--;
		}

//		// third
//		print = n;
//		k = 1;
//		right = n;
//		bottom = n - 1;
//		top = -1;
//
//		loop: for (i = n; i > 0; i--) {
//
//			for (j = 0; j < print - 1; j++) {
//				right += top;
//				answer[bottom][right] = k;
//				k++;
//
//				if (bottom == n / 2 && right == n / 2)
//					break loop;
//			}
//
//			print--;
//
//			for (j = print; j > 2; j--) {
//				bottom += top;
//				answer[bottom][right] = k;
//				k++;
//
//				if (bottom == n / 2 && right == n / 2)
//					break loop;
//			}
//
//			top = top * (-1);
//			print--;
//
//		}
//
//		// fourth
//		print = n;
//		k = 1;
//		right = 0;
//		bottom = n;
//		top = -1;
//
//		loop: for (i = n; i > 0; i--) {
//
//			for (j = print; j > 1; j--) {
//				bottom += top;
//				answer[bottom][right] = k;
//				k++;
//
//				if (bottom == n / 2 && right == n / 2)
//					break loop;
//			}
//
//			print--;
//			top = top * (-1);
//
//			for (j = 0; j < print - 2; j++) {
//				right += top;
//				answer[bottom][right] = k;
//				k++;
//
//				if (bottom == n / 2 && right == n / 2)
//					break loop;
//			}
//
//			print--;
//		}

		return answer;
	}

}
