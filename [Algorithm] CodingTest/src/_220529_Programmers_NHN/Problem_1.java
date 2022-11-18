package _220529_Programmers_NHN;

import java.util.HashSet;
import java.util.Set;

public class Problem_1 {

	public static void main(String[] args) {
		int[][] cards1 = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 } };
		int[][] cards2 = { { 5, 7, 9, 11, 13 }, { 11, 13, 15, 17, 19 } };
		System.out.println(solution(cards1, cards2));

		int[][] cards3 = { { 13, 21, 24, 29, 50 }, { 1, 12, 20, 21, 32 }, { 16, 26, 34, 46, 52 }, { 9, 11, 16, 16, 21 },
				{ 3, 8, 10, 16, 20 } };
		int[][] cards4 = { { 5, 10, 15, 41, 49 }, { 6, 14, 15, 19, 46 }, { 5, 42, 43, 51, 52 }, { 5, 6, 11, 13, 45 },
				{ 5, 9, 11, 13, 45 } };
		System.out.println(solution(cards3, cards4));

	}

	public static int solution(int[][] cards1, int[][] cards2) {

		boolean[] rounds = new boolean[cards1.length];

		// checking duplicate cards in a same round
		for (int i = 0; i < cards1.length; i++) {
			Set<Integer> set = new HashSet<>();
			for (int j = 0; j < cards1[0].length; j++)
				set.add(cards1[i][j]);

			for (int j = 0; j < cards1[0].length; j++)
				set.add(cards2[i][j]);

			if (set.size() != 10)
				rounds[i] = true;
		}

		// checking duplicate cards in a before round
		// player 1
		for (int i = 1; i < cards1.length; i++) {
			Set<Integer> set = new HashSet<>();
			for (int j = 0; j < cards1[0].length; j++) {
				set.add(cards1[i][j]);
				set.add(cards1[i - 1][j]);
			}
			if (set.size() <= 6)
				rounds[i] = true;
		}

		// player 2
		for (int i = 1; i < cards1.length; i++) {
			Set<Integer> set = new HashSet<>();
			for (int j = 0; j < cards1[0].length; j++) {
				set.add(cards2[i][j]);
				set.add(cards2[i - 1][j]);
			}
			if (set.size() <= 8)
				rounds[i] = true;
		}


		int ans = 0;
		for (int i = 0; i < rounds.length; i++) {
			if (rounds[i])
				ans++;
		}

		return ans;
	}
}
