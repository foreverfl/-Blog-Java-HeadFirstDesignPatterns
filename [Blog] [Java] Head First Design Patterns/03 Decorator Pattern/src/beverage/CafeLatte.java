package beverage;

public class CafeLatte extends Beverage {
	public CafeLatte() {
		description = "카페라떼";
	}

	@Override
	public int cost() {
		return 4500;
	}
}
