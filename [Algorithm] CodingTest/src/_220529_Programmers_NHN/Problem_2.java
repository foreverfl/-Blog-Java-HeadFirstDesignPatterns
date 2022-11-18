package _220529_Programmers_NHN;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Problem_2 {

	public static void main(String[] args) {
		int[] balance_1 = { 30, 30, 30, 30 };
		int[][] transaction_1 = { { 1, 2, 10 }, { 2, 3, 20 }, { 3, 4, 5 }, { 3, 4, 30 } };
		int[] abnormal_1 = { 1 };
		int[] result_1 = solution(balance_1, transaction_1, abnormal_1);
		for (int i = 0; i < result_1.length; i++) {
			System.out.print(result_1[i] + " ");
		}
		System.out.println();

	}

	static class Money {
		int from;
		int money;

		Money(int from, int money) {
			this.from = from;
			this.money = money;
		}
	}

	public static int[] solution(int[] balance, int[][] transaction, int[] abnormal) {

		HashMap<Integer, List<Money>> users = new HashMap<>();
		for (int i = 1; i <= balance.length; i++) {

			List<Money> list = new ArrayList<>();
			list.add(new Money(i, balance[i - 1]));
			users.put(i, list);
		}

		for (int i = 0; i < transaction.length; i++) {
			int from = transaction[i][0];
			int to = transaction[i][1];
			int money = transaction[i][2];

			// subtraction
			List<Money> list_1 = users.get(from);
			list_1.add(new Money(from, -money));
			users.put(from, list_1);
			
			// addition
			List<Money> list_2 = users.get(to);
			list_2.add(new Money(from, money));
			users.put(to, list_2);

		}

		for (int i = 0; i < abnormal.length; i++) {
			int bug_user = abnormal[i];

			Iterator<Integer> iterator = users.keySet().iterator();
			while (iterator.hasNext()) {
				int victim = iterator.next();
				List<Money> list = users.get(victim);
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j).from == bug_user)
						list.get(j).money = 0;
				}
			}

		}

		List<Integer> ans_tmp = new ArrayList<>();
		Iterator<Integer> iterator = users.keySet().iterator();
		while (iterator.hasNext()) {
			List<Money> list = users.get(iterator.next());
			int tmp = 0;
			for (int i = 0; i < list.size(); i++) {
				tmp += list.get(i).money;
			}
			ans_tmp.add(tmp);
		}

		int[] answer = new int[ans_tmp.size()];

		for (int i = 0; i < ans_tmp.size(); i++)
			answer[i] = ans_tmp.get(i);

		return answer;
	}

}
