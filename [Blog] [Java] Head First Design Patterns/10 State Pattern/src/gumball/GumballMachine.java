package gumball;

public class GumballMachine {
	State stateSoldOut;
	State stateNoQuarter;
	State stateHasQuarter;
	State stateSold;
	State stateWinner;

	State state = stateSoldOut;
	int count = 0;

	public GumballMachine(int numberGumballs) {
		stateSoldOut = new StateSoldOut(this);
		stateNoQuarter = new StateNoQuarter(this);
		stateHasQuarter = new StateHasQuarter(this);
		stateSold = new StateSold(this);
		stateWinner = new StateWinner(this);

		this.count = numberGumballs;
		if (numberGumballs > 0) {
			state = stateNoQuarter;
		}
	}

	public void insertQuarter() {
		state.insertQuarter();
	}

	public void ejectQuarter() {
		state.ejectQuarter();
	}

	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}

	void setState(State state) {
		this.state = state;
	}

	void releaseBall() {
		System.out.println("뽑기가 나오고 있습니다.");
		if (count > 0) {
			count = count - 1;
		}
	}

	int getCount() {
		return count;
	}

	void refill(int count) {
		this.count += count;
		System.out.println("뽑기 기계가 리필되었습니다. 현재 개수는 " + this.count + "개 입니다.");
		state.refill();
	}

	public State getState() {
		return state;
	}

	public State getSoldOutState() {
		return stateSoldOut;
	}

	public State getNoQuarterState() {
		return stateNoQuarter;
	}

	public State getHasQuarterState() {
		return stateHasQuarter;
	}

	public State getSoldState() {
		return stateSold;
	}

	public State getWinnerState() {
		return stateWinner;
	}

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\n====================");
		result.append("\n재고: " + count + "개");
		result.append("\n현재 상태: " + state);
		result.append("\n====================\n");
		return result.toString();
	}
}
