package Subject;

import java.util.ArrayList;

import Observer.Observer;


public class WeatherData implements Subject {

	// Observer 객체를 저장하기 위한 ArrayList
	private ArrayList observers; 
	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherData() {
		observers = new ArrayList();
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}

	// Observer들에게 상태에 대해 알려줌
	@Override
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer) observers.get(i);
			observer.update(temperature, humidity, pressure);
		}

	}

	// 기상스테이션으로부터 갱신된 측정치를 받으면 Observer들에게 알려줌
	public void measurementsChanged() {
		notifyObservers();
	}

	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();

	}

}
