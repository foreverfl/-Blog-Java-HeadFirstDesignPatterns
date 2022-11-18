package _220515_Programmers_GrebChallenging;

import java.util.Arrays;

public class Problem_2 {

	public static void main(String[] args) {
		int[] arr_1 = { 1, 2, 5, 3, 1, 0, 2, 3 };
		int result_1 = solution(arr_1, 6, 3);
		System.out.println(result_1);

		int[] arr_2 = { 0, 1, 2, 3, 4 };
		int result_2 = solution(arr_2, 5, 2);
		System.out.println(result_2);

		int[] arr_3 = { 0, 1, 2, 3, 4, 3 };
		int result_3 = solution(arr_3, 5, 2);
		System.out.println(result_3);

	}

	public static int solution(int[] bricks, int n, int k) {
		int len = bricks.length;
		boolean[] check = new boolean[len];
		Arrays.fill(check, true);

		int answer = 0;
		while (true) {
			int max = Integer.MIN_VALUE;
			int puddle = 1;
			for (int i = 1; i < len - 1; i++) {
				if (check[i - 1] == true && check[i] == false) {
					puddle++;
				}
			}

			if (puddle == k)
				break;

			for (int i = 1; i < len - 1; i++) {
				if (check[i] == false)
					continue;
				if (check[i + 1] == false || check[i - 1] == false)
					continue;

				max = Math.max(max, bricks[i]);
			}

			for (int i = 1; i < len - 1; i++) {
				if (check[i] == false)
					continue;
				if (check[i + 1] == false || check[i - 1] == false)
					continue;
				
				if (bricks[i] == max && check[i] == true) {
					answer += n - bricks[i];
					bricks[i] = n;
					check[i] = false;
					break;
				}
			}

		}

		return answer;
	}

}
