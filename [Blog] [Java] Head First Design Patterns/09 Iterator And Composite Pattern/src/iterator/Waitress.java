package iterator;

import java.util.Iterator;

public class Waitress {
	Menu breakfastMenu;
	Menu lunchMenu;
	Menu dinnerMenu;

	public Waitress(Menu breakfastMenu, Menu lunchMenu, Menu dinnerMenu) {
		this.breakfastMenu = breakfastMenu;
		this.lunchMenu = lunchMenu;
		this.dinnerMenu = dinnerMenu;
	}

	public void printMenu() {
		Iterator<MenuItem> breakfastIterator = breakfastMenu.createIterator();
		Iterator<MenuItem> lunchIterator = dinnerMenu.createIterator();
		Iterator<MenuItem> dinnerIterator = dinnerMenu.createIterator();
		System.out.println("메뉴\n----\n아침 메뉴");
		printMenu(breakfastIterator);
		System.out.println("\n점심 메뉴");
		printMenu(lunchIterator);
		System.out.println("\n저녁 메뉴");
		printMenu(dinnerIterator);

	}

	private void printMenu(Iterator<MenuItem> iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = (MenuItem) iterator.next();
			System.out.print(menuItem.getName() + ", ");
			System.out.print(menuItem.getPrice() + " -- ");
			System.out.println(menuItem.getDescription());
		}
	}

	public void printVegetarianMenu() {
		printVegetarianMenu(breakfastMenu.createIterator());
		printVegetarianMenu(dinnerMenu.createIterator());
	}

	public boolean isItemVegetarian(String name) {
		Iterator<MenuItem> breakfastIterator = breakfastMenu.createIterator();
		if (isVegetarian(name, breakfastIterator)) {
			return true;
		}
		Iterator<MenuItem> dinnerIterator = dinnerMenu.createIterator();
		if (isVegetarian(name, dinnerIterator)) {
			return true;
		}
		return false;
	}

	private void printVegetarianMenu(Iterator<MenuItem> iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = (MenuItem) iterator.next();
			if (menuItem.isVegetarian()) {
				System.out.print(menuItem.getName());
				System.out.println("\t\t" + menuItem.getPrice());
				System.out.println("\t" + menuItem.getDescription());
			}
		}
	}

	private boolean isVegetarian(String name, Iterator<MenuItem> iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = (MenuItem) iterator.next();
			if (menuItem.getName().equals(name)) {
				if (menuItem.isVegetarian()) {
					return true;
				}
			}
		}
		return false;
	}
}
