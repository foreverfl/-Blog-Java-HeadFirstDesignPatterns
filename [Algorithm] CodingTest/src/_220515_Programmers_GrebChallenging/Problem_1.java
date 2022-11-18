package _220515_Programmers_GrebChallenging;

public class Problem_1 {
	public static void main(String[] args) {
		String res = solution(6, "hi bye", 0);
		System.out.println(res);
		res = solution(6, "hi bye", 1);
		System.out.println(res);
		res = solution(6, "hi bye", 2);
		System.out.println(res);
		res = solution(6, "hi bye", 3);
		System.out.println(res);
		res = solution(6, "hi bye", 4);
		System.out.println(res);
		res = solution(6, "hi bye", 5);
		System.out.println(res);
		res = solution(6, "hi bye", 6);
		System.out.println(res);
		res = solution(6, "hi bye", 7);
		System.out.println(res);
		res = solution(6, "hi bye", 8);
		System.out.println(res);
		res = solution(6, "hi bye", 9);
		System.out.println(res);
		res = solution(6, "hi bye", 10);
		System.out.println(res);
		res = solution(6, "hi bye", 11);
		System.out.println(res);
		res = solution(6, "hi bye", 12);
		System.out.println(res);
		res = solution(6, "hi bye", 13);
		System.out.println(res);
	}

	public static String solution(int n, String text, int second) {
		String answer = "";

		int len = text.length();

		if ((second / n) % 2 == 0) {

			int str = second % len;
			int blank = n - str;

			while (blank-- > 0) {
				answer += "_";
			}

			for (int i = 0; i < str; i++) {
				answer += text.charAt(i);
			}

		} else {

			int str = n - second % len;
			int blank = n - str;

			for (int i = 0; i < str; i++) {
				answer += text.charAt(i);
			}

			while (blank-- > 0) {
				answer += "_";
			}

		}

		answer = answer.replaceAll(" ", "_");

		return answer;
	}
}
