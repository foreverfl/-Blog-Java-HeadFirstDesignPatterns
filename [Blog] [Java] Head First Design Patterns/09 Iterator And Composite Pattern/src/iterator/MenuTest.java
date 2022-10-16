package iterator;

public class MenuTest {

	public static void main(String[] args) {
		BreakfastMenu breakfastMenu = new BreakfastMenu();
		LunchMenu lunchMenu = new LunchMenu();
		DinnerMenu dinnerMenu = new DinnerMenu();

		Waitress waitress = new Waitress(breakfastMenu, lunchMenu, dinnerMenu);

		waitress.printMenu();

	}

}
