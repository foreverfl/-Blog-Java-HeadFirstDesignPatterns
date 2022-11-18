package _220515_Programmers_GrebChallenging;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_3 {

	public static void main(String[] args) {
//		String[] arr_0 = { "FCBBBFCBBECBB" };
//		int[] res_0 = solution(arr_0, 3, 2);
//		for (int i = 0; i < res_0.length; i++) {
//			System.out.print(res_0[i] + " ");
//		}
//		System.out.println();

		String[] arr_1 = { "AFFDEFDEFDEEC", "ABABABABBCCEF", "FFFFFFFFFFFFF", "FCBBBFCBBECBB" };
		int[] res_1 = solution(arr_1, 3, 2);
		for (int i = 0; i < res_1.length; i++) {
			System.out.print(res_1[i] + " ");
		}
		System.out.println();

		String[] arr_2 = { "AFFDEFDEFDEEC", "ABABABABBCCEF", "FFFFFFFFFFFFF", "FCBBBFCBBECBB" };
		int[] res_2 = solution(arr_2, 3, 2);
		for (int i = 0; i < res_2.length; i++) {
			System.out.print(res_2[i] + " ");
		}
		System.out.println();

		String[] arr_3 = { "AFFDEFDEFDEEC", "ABABABABBCCEF", "FFFFFFFFFFFFF", "FCBBBFCBBECBB" };
		int[] res_3 = solution(arr_3, 3, 2);
		for (int i = 0; i < res_3.length; i++) {
			System.out.print(res_3[i] + " ");
		}

	}

	public static int[] solution(String[] replies, int n, int k) {
		int[] answer = new int[replies.length];
		Arrays.fill(answer, 1);

		for (int i = 0; i < replies.length; i++) {
			List<String> patterns = findPattern(replies[i], n);

			for (int j = 0; j < patterns.size(); j++) {
				String check = replies[i];
				String pattern = patterns.get(j);

				String tmp_1 = "";
				String tmp_2 = "";
				int cnt = 0;
				for (int a = 0; a < check.length(); a++) {
					String tmp_3 = "";
					if (check.charAt(a) == pattern.charAt(a)) {
						continue;

					} else {
						if (check.charAt(a + 1) == pattern.charAt(a + 1)) {

						} else {
							if (check.charAt(a + 2) == pattern.charAt(a + 2)) {

							} else {

								tmp_3 += check.charAt(a);
								check = check.replaceFirst(tmp_3, "");
								a = -1;
								cnt = 0;
								continue;
							}

						}

					}

					tmp_1 += check.charAt(a);
					tmp_2 += pattern.charAt(a);

					if (tmp_1.equals(tmp_2) && tmp_2.length() == pattern.length()) {
						check = check.replaceFirst(tmp_1, "");
						tmp_1 = "";
						tmp_2 = "";
						a = -1;
						cnt++;

						if (cnt >= k) {
							answer[i] = 0;
							break;
						}
					}

				}

			}

		}

		return answer;
	}

	public static List<String> findPattern(String str, int len) {

		List<String> patterns = new ArrayList<>();
		int idx = len;
		while (true) {
			if (idx == str.length())
				break;

			for (int i = 0; i < str.length() - idx + 1; i++) {
				String tmp = "";
				for (int j = i; j < i + idx; j++) {
					tmp += str.charAt(j);
				}
				patterns.add(tmp);
			}

			idx++;

		}

		return patterns;
	}
}
