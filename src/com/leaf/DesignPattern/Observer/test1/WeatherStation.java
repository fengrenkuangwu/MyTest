package com.leaf.DesignPattern.Observer.test1;

public class WeatherStation {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		
		CurrentConditionsDisplay conditionsDisplay = new CurrentConditionsDisplay(weatherData);
		ChineseDisplay chineseDisplay = new ChineseDisplay(weatherData);
		
		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(79, 90, 29.2f);
	}

}
