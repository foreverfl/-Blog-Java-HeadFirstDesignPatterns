package _220315_SkillCheckTest_Level_1;

public class Problem_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static boolean solution(String s) {
		boolean answer = true;
		int cnt_p = 0, cnt_y = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'P' || s.charAt(i) == 'p')
				cnt_p++;
			if (s.charAt(i) == 'Y' || s.charAt(i) == 'y')
				cnt_y++;
		}

		if (cnt_p == cnt_y)
			return true;
		else
			return false;
	}
}
