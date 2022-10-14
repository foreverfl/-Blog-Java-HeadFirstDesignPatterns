package barista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TeaWithHook extends Beverage {

	@Override
	void brew() {
		System.out.println("필터로 차를 우려내는 중...");
	}

	@Override
	void addCondiments() {
		System.out.println("레몬을 추가하는 중...");
	}

	public boolean customerWantsCondiments() {

		String answer = getUserInput();
		if (answer.toLowerCase().startsWith("y")) {
			return true;
		} else {
			return false;
		}

	}

	private String getUserInput() {
		String answer = null;

		System.out.println("커피에 레몬을 넣어드릴까요? (y/n) ");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			answer = br.readLine();
		} catch (IOException ioException) {
			System.err.println("IO 오류");
		}

		if (answer == null) {
			return "no";
		}

		return answer;
	}
}
