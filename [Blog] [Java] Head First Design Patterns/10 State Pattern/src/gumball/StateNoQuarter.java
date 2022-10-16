package gumball;

public class StateNoQuarter implements State {

	GumballMachine gumballMachine;

	public StateNoQuarter(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("동전을 넣었습니다.");
		gumballMachine.setState(gumballMachine.getHasQuarterState());

	}

	@Override
	public void ejectQuarter() {
		System.out.println("동전을 반환할 수 없습니다. 동전이 없습니다.");
	}

	@Override
	public void turnCrank() {
		System.out.println("손잡이를 돌렸지만 아무일도 일어나지 않았습니다. 동전이 없습니다.");

	}

	@Override
	public void dispense() {
		System.out.println("뽑기가 나갈 수 없습니다. 동전이 없습니다.");

	}

	@Override
	public void refill() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "동전을 넣어주세요.";
	}

}
