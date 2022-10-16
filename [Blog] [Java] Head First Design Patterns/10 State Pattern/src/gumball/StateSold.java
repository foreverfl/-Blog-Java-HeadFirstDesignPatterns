package gumball;

public class StateSold implements State {

	GumballMachine gumballMachine;

	public StateSold(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("동전을 넣을 수 없습니다. 뽑기가 진행 중에 있습니다.");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("동전을 반환할 수 없습니다. 이미 손잡이를 돌렸습니다.");
	}

	@Override
	public void turnCrank() {
		System.out.println("뽑기는 동전 1개에 1번만 가능합니다. 이미 손잡이를 돌렸습니다.");

	}

	@Override
	public void dispense() {
		// 공을 기계에서 하나 뺀다.
		gumballMachine.releaseBall();
		
		if (gumballMachine.getCount() > 0) {
			gumballMachine.setState(gumballMachine.getNoQuarterState());
		} else {
			System.out.println("뽑기가 없습니다. 환불이 진행됩니다.");
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}
	}

	@Override
	public void refill() {

	}

	@Override
	public String toString() {
		return "뽑기를 내보내고 있습니다.";
	}

}
