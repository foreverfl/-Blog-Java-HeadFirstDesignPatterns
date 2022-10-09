package condimentDecorator;

import beverage.Beverage;

public class Mocha extends CondimentDecorator {
	
	// 감싸고자 하는 음료를 저장하기 위한 인스턴스 변수
	Beverage beverage;

	// 인스턴수 변수를 감싸고자 하는 객체로 설정하기 위한 생성자
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", 모카";
	}

	@Override
	public int cost() {
		return beverage.cost() + 500;
	}

}