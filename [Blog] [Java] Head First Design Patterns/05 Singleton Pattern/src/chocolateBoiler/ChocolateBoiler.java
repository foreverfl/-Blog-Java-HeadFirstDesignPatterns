package chocolateBoiler;

public class ChocolateBoiler {
	private boolean empty;
	private boolean boiled;

	// singleton pattern
	// double checking locking(DCL)
	private volatile static ChocolateBoiler uniqueInstance;

	private ChocolateBoiler() {
		empty = true;
		boiled = false;
	}

	public static ChocolateBoiler getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new ChocolateBoiler();
		}
		return uniqueInstance;
	}

	public void fill() {
		if (isEmpty()) {
			empty = false;
			boiled = false;
		}
	}

	public void boil() {
		if (!isEmpty() && !isBoiled()) {
			empty = true;
		}
	}

	public void drain() {
		if (!isEmpty() && isBoiled()) {
			boiled = true;
		}
	}

	public boolean isEmpty() {
		return empty;
	}

	public boolean isBoiled() {
		return boiled;
	}
}
