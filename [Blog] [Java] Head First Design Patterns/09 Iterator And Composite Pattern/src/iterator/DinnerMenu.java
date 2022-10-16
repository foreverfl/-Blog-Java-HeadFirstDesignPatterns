package iterator;

import java.util.Iterator;

public class DinnerMenu implements Menu {
	static final int MAX_ITEMS = 6;
	int numberOfItems = 0;
	MenuItem[] menuItems;

	public DinnerMenu() {
		menuItems = new MenuItem[MAX_ITEMS];

		addItem("채식주의자용 BLT", "통밀 위에 식물성 베이컨, 상추, 토마토를 얹은 메뉴", true, 3000);
		addItem("BLT", "통밀 위에 베이컨, 상추, 토마토를 얹은 메뉴", false, 3000);
		addItem("오늘의 스프", "감자 샐러드를 곁을인 오늘의 스프", false, 3300);
		addItem("핫도그", "사워크라우트, 갖은 양념, 양파, 치즈가 곁들어진 핫도그", false, 3100);
		addItem("찐 야채와 밥", "찐야채가 얹어진 밥", true, 4000);
		addItem("파스타", "마리아나 소스와 사워도우 빵이 올려진 스파게티", true, 3900);
	}

	public void addItem(String name, String description, boolean vegetarian, int price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		if (numberOfItems >= MAX_ITEMS) {
			System.err.println("메뉴가 꽉 차서 더 이상 추가할 수 없어요... ㅠㅠ");
		} else {
			menuItems[numberOfItems] = menuItem;
			numberOfItems = numberOfItems + 1;
		}
	}

	public Iterator<MenuItem> createIterator() {
		return new DinnerMenuIterator(menuItems);
	}
}
