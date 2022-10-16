package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BreakfastMenu implements Menu{
	List<MenuItem> menuItems;

	public BreakfastMenu() {
		menuItems = new ArrayList<MenuItem>();

		addItem("K&B 팬케이크 세트", "스크램블드 에크와 토스트가 곁들여진 샌드위치", true, 3000);
		addItem("레귤러 팬케이크 세트", "달걀 후라이와 소시지가 곁들여진 팬케이크", false, 3000);
		addItem("블루베리 팬케이크", "신선한 블루베리와 블루베리 시럽으로 만든 팬케이크", true, 3500);
		addItem("와플", "와플, 취향에 따라 블루베리나 딸기를 얹을 수 있습니다.", true, 3600);
	}

	public void addItem(String name, String description, boolean vegetarian, int price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.add(menuItem);
	}

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public Iterator<MenuItem> createIterator() {
		return menuItems.iterator();
	}

	public String toString() {
		return "Objectville Pancake House Menu";
	}
}
