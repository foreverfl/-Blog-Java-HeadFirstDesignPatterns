package Simulator;

import Duck.Duck;
import Duck.MallardDuck;

public class MiniDucksSimulator {

	public static void main(String[] args) {
		Duck mallard = new MallardDuck();
		mallard.performQuack();
		mallard.performFly();
	}
}
