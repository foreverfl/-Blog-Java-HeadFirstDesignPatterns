package makeCoffee;

import beverage.Americano;
import beverage.Beverage;
import beverage.CafeMoca;
import beverage.Espresso;
import condimentDecorator.Mocha;
import condimentDecorator.Soy;
import condimentDecorator.Whip;

public class StarbucksCoffee {
	public static void main(String[] args) {
		Beverage beverage1 = new Espresso();
		System.out.println(beverage1.getDescription() + " / " + beverage1.cost() + "원");
		
		Beverage beverage2 = new Americano();
		beverage2 = new Mocha(beverage2);
		beverage2 = new Mocha(beverage2);
		beverage2 = new Whip(beverage2);
		System.out.println(beverage2.getDescription() + " / " + beverage2.cost() + "원");
		
		Beverage beverage3 = new CafeMoca();
		beverage3 = new Soy(beverage3);
		beverage3 = new Mocha(beverage3);
		beverage3 = new Whip(beverage3);
		System.out.println(beverage3.getDescription() + " / " + beverage3.cost() + "원");
	}
}
