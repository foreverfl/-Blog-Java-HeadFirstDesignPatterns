package _220519_CodeforcesRound792;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_A_DigitMinimization {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			String input = br.readLine();
			int result = minimize(input);
			sb.append(result).append('\n');
		}

		System.out.println(sb.toString());

	}

	private static int minimize(String str) {
		int res = Integer.MAX_VALUE;

		if (str.length() == 2) {
			res = str.charAt(1) - '0';
		} else {
			for (int i = 0; i < str.length(); i++) {
				res = Math.min(res, str.charAt(i) - '0');
			}
		}

		return res;

	}

}
