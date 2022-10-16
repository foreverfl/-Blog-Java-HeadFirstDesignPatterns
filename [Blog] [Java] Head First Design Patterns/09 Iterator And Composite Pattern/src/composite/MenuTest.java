package composite;

public class MenuTest {
	public static void main(String args[]) {
		MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
		MenuComponent dinerMenu = new Menu("DINER MENU", "Lunch");
		MenuComponent cafeMenu = new Menu("CAFE MENU", "Dinner");
		MenuComponent dessertMenu = new Menu("DESSERT MENU", "Dessert of course!");
		MenuComponent coffeeMenu = new Menu("COFFEE MENU", "Stuff to go with your afternoon coffee");

		MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");

		allMenus.add(pancakeHouseMenu);
		allMenus.add(dinerMenu);
		allMenus.add(cafeMenu);

		pancakeHouseMenu
				.add(new MenuItem("K&B's Pancake Breakfast", "Pancakes with scrambled eggs and toast", true, 3000));
		pancakeHouseMenu
				.add(new MenuItem("Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", false, 3000));
		pancakeHouseMenu.add(new MenuItem("Blueberry Pancakes",
				"Pancakes made with fresh blueberries, and blueberry syrup", true, 3500));
		pancakeHouseMenu
				.add(new MenuItem("Waffles", "Waffles with your choice of blueberries or strawberries", true, 3600));

		dinerMenu
				.add(new MenuItem("Vegetarian BLT", "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 3000));
		dinerMenu.add(new MenuItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 3000));
		dinerMenu.add(new MenuItem("Soup of the day", "A bowl of the soup of the day, with a side of potato salad",
				false, 3300));
		dinerMenu.add(
				new MenuItem("Hot Dog", "A hot dog, with saurkraut, relish, onions, topped with cheese", false, 3000));
		dinerMenu.add(new MenuItem("Steamed Veggies and Brown Rice", "Steamed vegetables over brown rice", true, 4000));

		dinerMenu.add(
				new MenuItem("Pasta", "Spaghetti with marinara sauce, and a slice of sourdough bread", true, 3900));

		dinerMenu.add(dessertMenu);

		dessertMenu.add(
				new MenuItem("Apple Pie", "Apple pie with a flakey crust, topped with vanilla icecream", true, 1600));

		dessertMenu.add(
				new MenuItem("Cheesecake", "Creamy New York cheesecake, with a chocolate graham crust", true, 2000));
		dessertMenu.add(new MenuItem("Sorbet", "A scoop of raspberry and a scoop of lime", true, 1900));

		cafeMenu.add(new MenuItem("Veggie Burger and Air Fries",
				"Veggie burger on a whole wheat bun, lettuce, tomato, and fries", true, 4000));
		cafeMenu.add(new MenuItem("Soup of the day", "A cup of the soup of the day, with a side salad", false, 3700));
		cafeMenu.add(new MenuItem("Burrito", "A large burrito, with whole pinto beans, salsa, guacamole", true, 4300));

		cafeMenu.add(coffeeMenu);

		coffeeMenu.add(new MenuItem("Coffee Cake", "Crumbly cake topped with cinnamon and walnuts", true, 1600));
		coffeeMenu
				.add(new MenuItem("Bagel", "Flavors include sesame, poppyseed, cinnamon raisin, pumpkin", false, 700));
		coffeeMenu.add(new MenuItem("Biscotti", "Three almond or hazelnut biscotti cookies", true, 900));

		Waitress waitress = new Waitress(allMenus);

		waitress.printMenu();
	}
}
