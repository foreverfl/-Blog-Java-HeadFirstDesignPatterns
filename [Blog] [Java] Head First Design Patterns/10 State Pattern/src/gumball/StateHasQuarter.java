package gumball;

import java.util.Random;

public class StateHasQuarter implements State {
	Random randomWinner = new Random(System.currentTimeMillis());
	GumballMachine gumballMachine;

	public StateHasQuarter(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("이미 동전이 있습니다. 동전을 삽입할 수 없습니다.");

	}

	@Override
	public void ejectQuarter() {
		System.out.println("동전이 반환되었습니다.");
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}

	@Override
	public void turnCrank() {
		System.out.println("손잡이를 돌려서 뽑기가 진행되었습니다.");
		int winner = randomWinner.nextInt(10);
		
		// 0~9까지의 숫자 중에서 0이 나오면 당첨되는 로직
		if ((winner == 0) && (gumballMachine.getCount() > 1)) {
			gumballMachine.setState(gumballMachine.getWinnerState());
		} else {
			gumballMachine.setState(gumballMachine.getSoldState());
		}
	}

	@Override
	public void dispense() {
		System.out.println("뽑기가 나갈 수 없습니다. 손잡이를 돌려주세요.");
	}

	@Override
	public void refill() {

	}

	@Override
	public String toString() {
		return "손잡이를 돌려주세요.";
	}

}
