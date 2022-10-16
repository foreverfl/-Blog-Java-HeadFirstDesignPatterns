package iterator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LunchMenu implements Menu {
	HashMap<String, MenuItem> menuItems = new HashMap<String, MenuItem>();

	public LunchMenu() {
		addItem("베지 버거와 에어 프라이", "통밀빵, 상추, 토마토, 감자튀김이 첨가된 베지 버거", true, 4000);
		addItem("오늘의 스프", "샐러드가 곁들여진 오늘의 스프", false, 3700);
		addItem("부리또", "통 핀토콩과 살사, 구아카몰이 곁들여진 푸짐한 부리또", true, 4200);
	}

	public void addItem(String name, String description, boolean vegetarian, int price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.put(name, menuItem);
	}

	public Map<String, MenuItem> getItems() {
		return menuItems;
	}

	// HashMap 객체에 대한 반복자가 아닌 값들에 대한 반복자를 리턴함
	public Iterator<MenuItem> createIterator() {
		return menuItems.values().iterator();
	}
}
