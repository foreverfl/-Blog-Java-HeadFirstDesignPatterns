package adapter;

import java.util.Iterator;
import java.util.Vector;

public class EnumerationIteratorTest {
	public static void main(String args[]) {
		Vector<String> vector = new Vector<String>();

		for (int i = 0; i < 10; i++) {
			vector.add("elements" + i);
		}

		Iterator<?> iterator = new EnumerationIterator(vector.elements());
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
