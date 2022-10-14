package barista;

public abstract class Beverage {
	final void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		if (customerWantsCondiments()) {
			addCondiments();
		}
	}

	abstract void brew();

	abstract void addCondiments();

	void boilWater() {
		System.out.println("물 끓이는 중...");
	}

	void pourInCup() {
		System.out.println("컵에 따르는 중...");
	}

	// 서브클래스에서 필요에 따라 오버라이드할 수 있는 메소드인 후크
	boolean customerWantsCondiments() {
		return true;
	}

}
