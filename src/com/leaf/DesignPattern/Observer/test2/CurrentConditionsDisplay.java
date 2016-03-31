package com.leaf.DesignPattern.Observer.test2;

import java.util.Observable;
import java.util.Observer;


public class CurrentConditionsDisplay implements Observer ,DisplayElement{
	private Observable observable;
	private float temperature;
	private float humidity;
	
	
	public CurrentConditionsDisplay(Observable observable){
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Observable){
			WeatherData weatherData = (WeatherData)o;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			display();
		}
	}

	@Override
	public void display() {
		System.out.println("Current Conditions: "+temperature
				+"F degrees and "+humidity+"% humddity");
	}

}
