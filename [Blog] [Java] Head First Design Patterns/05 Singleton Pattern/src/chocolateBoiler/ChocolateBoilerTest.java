package chocolateBoiler;

public class ChocolateBoilerTest {

	public static void main(String[] args) {
		ChocolateBoiler boiler1 = ChocolateBoiler.getInstance();
		ChocolateBoiler boiler2 = ChocolateBoiler.getInstance();
		
		System.out.println(boiler1);
		System.out.println(boiler2);
	}

}
