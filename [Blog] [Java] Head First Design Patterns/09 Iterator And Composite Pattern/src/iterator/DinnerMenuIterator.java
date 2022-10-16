package iterator;

import java.util.Iterator;

public class DinnerMenuIterator implements Iterator<MenuItem> {
	MenuItem[] items;
	int position = 0;

	public DinnerMenuIterator(MenuItem[] items) {
		this.items = items;
	}

	@Override
	public boolean hasNext() {
		return items.length > position;
	}

	@Override
	public MenuItem next() {
		return items[position++];
	}

	// remove()가 호출되면 모든 항목들을 한 칸씩 왼쪽으로 밀어준다.
	@Override
	public void remove() {
		if (position <= 0) {
			throw new IllegalStateException("next()를 한 번도 호출하지 않은 상태에서는 삭제할 수 없습니다.");
		}

		if (items[position - 1] != null) {
			for (int i = position - 1; i < (items.length - 1); i++) {
				items[i] = items[i + 1];
			}
			items[items.length - 1] = null;
		}
	}

}
