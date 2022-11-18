package _220319_SkillCheckTest_Level_2;

public class Problem_2 {

	public static void main(String[] args) {
		String str = "1111111";
		int[] result = solution(str);

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

	static int cnt_change;
	static int cnt_removedZero;

	public static int[] solution(String s) {
		// answer[0] -> 이진 변환의 횟수
		// answer[1] -> 변환 과정에서 제거된 모든 0의 개수

		int[] answer = new int[2];

		while (!s.equals("1")) {
			s = change(s);
			cnt_change++;
		}
		
		answer[0] = cnt_change;
		answer[1] = cnt_removedZero;

		return answer;
	}

	public static String change(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '0')
				cnt_removedZero++;
		}

		String tmp = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1')
				tmp += "1";
		}

		int len = tmp.length();

		String result = Integer.toBinaryString(len);
		
		return result;
	}

}
