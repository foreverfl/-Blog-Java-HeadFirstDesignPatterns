package _220612_SK;

public class Problem_1 {

	public static void main(String[] args) {
		int[] p = { 2, 5, 3, 1, 4 };
		int[] result = solution(p);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

	public static int[] solution(int[] p) {
		int[] ans = new int[p.length];

		for (int i = 0; i < p.length; i++) {

			int min = Integer.MAX_VALUE;
			for (int j = i + 1; j < p.length; j++) {
				if (p[j] <= min)
					min = p[j];
			}

			for (int j = i + 1; j < p.length; j++) {
				if (p[j] == min && p[j] <= p[i]) {
					int tmp = p[i];
					p[i] = p[j];
					p[j] = tmp;
					ans[i]++;
					ans[j]++;
				}
			}
		}

		return ans;
	}

}
