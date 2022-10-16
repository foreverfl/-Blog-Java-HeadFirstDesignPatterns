package iterator;

import java.util.Iterator;
import java.util.List;

public class BreakfastMenuIterator implements Iterator<MenuItem> {
	List<MenuItem> items;
	int position = 0;

	public BreakfastMenuIterator(List<MenuItem> items) {
		this.items = items;
	}

	@Override
	public boolean hasNext() {
		return items.size() > position;
	}

	@Override
	public MenuItem next() {
		return items.get(position++);
	}

}
