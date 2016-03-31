package com.leaf.DesignPattern.Observer.test2;

import java.util.Observable;
import java.util.Observer;


public class ChineseDisplay implements Observer ,DisplayElement{
	private Observable observable;
	private float temperature;
	private float humidity;
	private float pressure;
	
	
	public ChineseDisplay(Observable observable){
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Observable){
			WeatherData weatherData = (WeatherData)o;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			this.pressure = weatherData.getPressure();
			display();
		}
	}

	@Override
	public void display() {
		System.out.println("天气情况   气温： "+temperature
				+"F  湿度：  "+humidity+"%  气压： "+pressure);
	}

}
