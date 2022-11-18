package _220612_SK;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem_3 {

	public static void main(String[] args) {
		int n = 5;
		String[] plans = { "100 1 3", "500 4", "2000 5" };
		String[] clients = { "300 3 5", "1500 1", "100 1 3", "500 1 2" };
		int[] res = solution(n, plans, clients);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}

	}

	static class Plan {
		int data;
		ArrayList<Integer> list;

		Plan(int data, ArrayList<Integer> list) {
			this.data = data;
			this.list = list;
		}
	}

	public static int[] solution(int n, String[] plans, String[] clients) {

		Plan[] plans_toUse = new Plan[plans.length];

		for (int i = 0; i < plans.length; i++) {
			ArrayList<Integer> list;

			list = new ArrayList<>();

			plans_toUse[i] = new Plan(0, list);

			StringTokenizer st = new StringTokenizer(plans[i]);
			plans_toUse[i].data = Integer.parseInt(st.nextToken());

			if (i >= 1)
				list.addAll(plans_toUse[i - 1].list);

			while (st.hasMoreTokens()) {
				plans_toUse[i].list.add(Integer.parseInt(st.nextToken()));
			}
		}

		Plan[] clients_toUse = new Plan[clients.length];

		for (int i = 0; i < clients.length; i++) {
			ArrayList<Integer> list;

			list = new ArrayList<>();

			clients_toUse[i] = new Plan(0, list);

			StringTokenizer st = new StringTokenizer(clients[i]);
			clients_toUse[i].data = Integer.parseInt(st.nextToken());

			while (st.hasMoreTokens()) {
				clients_toUse[i].list.add(Integer.parseInt(st.nextToken()));
			}
		}

		int[] answer = new int[clients.length];

		for (int i = 0; i < clients.length; i++) {
			for (int j = 0; j < plans.length; j++) {
				if (plans_toUse[j].data >= clients_toUse[i].data
						&& plans_toUse[j].list.containsAll(clients_toUse[i].list)) {
					answer[i] = j + 1;
					break;
				}
			}
		}

		return answer;
	}
}
