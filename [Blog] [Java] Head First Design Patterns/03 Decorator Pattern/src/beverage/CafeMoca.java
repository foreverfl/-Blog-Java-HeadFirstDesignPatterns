package beverage;

public class CafeMoca extends Beverage {
	public CafeMoca() {
		description = "카페모카";
	}
	
	@Override
	public int cost() {
		return 5000;
	}
}
