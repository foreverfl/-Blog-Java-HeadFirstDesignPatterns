package _220312_SK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Test_01 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int money = Integer.parseInt(br.readLine());
		int[] costs = new int[6];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
			costs[i] = Integer.parseInt(st.nextToken());
		}
		int result = solution(money, costs);
		System.out.println(result);
	}

	public static int solution(int money, int[] costs) {
		HashMap<Integer, Integer> hashmap = new HashMap<>();
		hashmap.put(1, costs[0]);
		hashmap.put(5, costs[1]);
		hashmap.put(10, costs[2]);
		hashmap.put(50, costs[3]);
		hashmap.put(100, costs[4]);
		hashmap.put(500, costs[5]);

		double[] efficiency = new double[6];
		efficiency[0] = (double) costs[0] / 1;
		efficiency[1] = (double) costs[1] / 5;
		efficiency[2] = (double) costs[2] / 10;
		efficiency[3] = (double) costs[3] / 50;
		efficiency[4] = (double) costs[4] / 100;
		efficiency[5] = (double) costs[5] / 500;

		ArrayList<Integer> list = new ArrayList<>();
		double min = Integer.MAX_VALUE;

		while (true) {

			for (int i = 5; i >= 0; i--) {
				if (efficiency[i] <= min)
					min = efficiency[i];
			}

			for (int i = 5; i >= 0; i--) {
				if (efficiency[i] <= min)
					min = efficiency[i];

				if (efficiency[i] == min) {
					if (min == efficiency[0]) {
						list.add(1);
						efficiency[0] = 5001;
					}
					if (min == efficiency[1]) {
						list.add(5);
						efficiency[1] = 5001;
					}
					if (min == efficiency[2]) {
						list.add(10);
						efficiency[2] = 5001;
					}
					if (min == efficiency[3]) {
						list.add(50);
						efficiency[3] = 5001;
					}
					if (min == efficiency[4]) {
						list.add(100);
						efficiency[4] = 5001;
					}
					if (min == efficiency[5]) {
						list.add(500);
						efficiency[5] = 5001;
					}
				}
			}
			min = Integer.MAX_VALUE;

			if (list.size() == 6)
				break;
		}

		int answer = 0;
		int tmp = 0;
		for (int i = 0; i < list.size(); i++) {
			tmp = money / list.get(i) * hashmap.get(list.get(i));
			money = money % list.get(i);
			answer += tmp;
		}

		return answer;
	}

}
