package _220605_SkillCheckTest_Level_3;

public class Problem_2 {

	public static void main(String[] args) {
		int[] info_1 = { 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1 };
		int[][] edges_1 = { { 0, 1 }, { 1, 2 }, { 1, 4 }, { 0, 8 }, { 8, 7 }, { 9, 10 }, { 9, 11 }, { 4, 3 }, { 6, 5 },
				{ 4, 6 }, { 8, 9 } };

		System.out.println(solution(info_1, edges_1));

		int[] info_2 = { 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0 };
		int[][] edges_2 = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 1, 4 }, { 2, 5 }, { 2, 6 }, { 3, 7 }, { 4, 8 }, { 6, 9 },
				{ 9, 10 } };

		System.out.println(solution(info_2, edges_2));

	}

	static class Node {
		int value;
		Node left;
		Node right;

		Node(int value) {
			this.value = value;
			left = null;
			right = null;
		}
	}

	public static int solution(int[] info, int[][] edges) {
		for (int i = 0; i < edges.length; i++) {
		
		}

		int answer = 0;
		return answer;
	}
}
