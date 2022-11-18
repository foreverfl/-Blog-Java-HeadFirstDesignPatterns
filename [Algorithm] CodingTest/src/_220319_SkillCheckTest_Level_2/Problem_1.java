package _220319_SkillCheckTest_Level_2;

public class Problem_1 {

	public static void main(String[] args) {
		System.out.println(solution(15));
	}

	public static int solution(int n) {

		int cnt = 0;
		loop: for (int i = 1; i <= n; i++) {
			int tmp = 0;
			for (int j = i; j <= n; j++) {
				tmp += j;
				if(tmp > n)
					continue loop;
				
				if (tmp == n) {
					cnt++;
					break;
				}
			}
		}
		return cnt;
	}
}
