package adapter;

import java.util.Enumeration;
import java.util.Iterator;

public class EnumerationIterator implements Iterator<Object> {

	Enumeration<?> enumeration;

	public EnumerationIterator(Enumeration<?> enumeration) {
		this.enumeration = enumeration;
	}

	@Override
	public boolean hasNext() {
		return enumeration.hasMoreElements();
	}

	@Override
	public Object next() {
		return enumeration.nextElement();
	}

	// Iterator의 remove() 메소드는 지원되지 않기 때문에 예외를 던짐
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
