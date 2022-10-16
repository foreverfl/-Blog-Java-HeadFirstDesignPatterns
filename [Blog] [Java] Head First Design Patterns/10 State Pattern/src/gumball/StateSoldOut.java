package gumball;

public class StateSoldOut implements State {

	GumballMachine gumballMachine;

	public StateSoldOut(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("동전을 넣을 수 없습니다. 뽑기가 매진되었습니다.");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("동전을 반환할 수 없습니다. 뽑기가 매진되었습니다.");
	}

	@Override
	public void turnCrank() {
		System.out.println("손잡이를 돌렸지만 아무일도 일어나지 않았습니다. 뽑기가 매진되었습니다.");

	}

	@Override
	public void dispense() {
		System.out.println("뽑기가 나갈 수 없습니다. 뽑기가 매진되었습니다.");

	}

	@Override
	public void refill() {
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}

	@Override
	public String toString() {
		return "매진되었습니다.";
	}

}
