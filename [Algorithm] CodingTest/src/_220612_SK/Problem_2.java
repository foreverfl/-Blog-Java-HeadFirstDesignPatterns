package _220612_SK;

public class Problem_2 {

	public static void main(String[] args) {
//		int[] periods = { 20, 23, 24 };
//		int[][] payments = {
//				{ 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000 },
//				{ 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000 },
//				{ 350000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 } };
//		int[] estimates = { 100000, 100000, 100000 };
//		int[] res = solution(periods, payments, estimates);
//		for (int i = 0; i < res.length; i++)
//			System.out.print(res[i] + " ");

		int[] periods_1 = { 24, 59, 59, 60 };
		int[][] payments_1 = { { 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 },
				{ 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 },
				{ 350000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 },
				{ 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 } };
		int[] estimates_1 = { 350000, 50000, 40000, 50000 };
		int[] res_1 = solution(periods_1, payments_1, estimates_1);
		for (int i = 0; i < res_1.length; i++)
			System.out.print(res_1[i] + " ");
	}

	static class Client {
		char status;
		int time;
		int payments;

		Client(char status, int time, int payments) {
			this.status = status;
			this.time = time;
			this.payments = payments;
		}
	}

	public static int[] solution(int[] periods, int[][] payments, int[] estimates) {

		Client[] clients = new Client[periods.length];
		for (int i = 0; i < periods.length; i++) {
			clients[i] = new Client('S', 0, 0); // start
		}

		for (int i = 0; i < periods.length; i++) {
			clients[i].time = periods[i];
		}

		for (int i = 0; i < payments.length; i++) {
			int total = 0;
			for (int j = 0; j < payments[0].length; j++) {
				total += payments[i][j];
			}
			clients[i].payments = total;
		}

		for (int i = 0; i < periods.length; i++) {
			if (clients[i].time < 24 && clients[i].payments >= 900000) {
				clients[i].status = 'G'; // the first line
			} else if (clients[i].time >= 24 && clients[i].payments >= 900000) {
				clients[i].status = 'V'; // the first line
			} else if (clients[i].time < 60 && (clients[i].payments >= 600000 && clients[i].payments < 900000)) {
				clients[i].status = 'G'; // the second line
			} else if (clients[i].time >= 60 && (clients[i].payments >= 600000 && clients[i].payments < 900000)) {
				clients[i].status = 'V';// the second line
			} else if (clients[i].time >= 24 && (clients[i].payments >= 480000 && clients[i].payments < 600000)) {
				clients[i].status = 'G'; // the third line
			} else if (clients[i].time >= 60 && (clients[i].payments >= 360000 && clients[i].payments < 480000)) {
				clients[i].status = 'G'; // the fourth line
			}
		}

		int[] answer = new int[2];

		for (int i = 0; i < estimates.length; i++) {
			clients[i].payments -= payments[i][0];
			clients[i].payments += estimates[i];
			clients[i].time++;
		}

		for (int i = 0; i < periods.length; i++) {
			if (clients[i].status == 'G') {
				if (clients[i].time >= 24 && clients[i].payments >= 900000) {
					answer[0]++;
				} else if (clients[i].time >= 60 && (clients[i].payments >= 600000 && clients[i].payments < 900000)) {
					answer[0]++;
				}
			} else if (clients[i].status == 'V') {
				if (clients[i].time < 24 && clients[i].payments >= 900000) {
					answer[1]++;
				} else if (clients[i].time < 60 && (clients[i].payments >= 600000 && clients[i].payments < 900000)) {
					answer[1]++;
				} else if (clients[i].time >= 24 && (clients[i].payments >= 480000 && clients[i].payments < 600000)) {
					answer[1]++; // the third line
				} else if (clients[i].time >= 60 && (clients[i].payments >= 360000 && clients[i].payments < 480000)) {
					answer[1]++; // the fourth line
				}
			}

		}

		return answer;
	}

}
