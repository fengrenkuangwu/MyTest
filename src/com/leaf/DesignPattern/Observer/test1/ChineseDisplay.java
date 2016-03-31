package com.leaf.DesignPattern.Observer.test1;

public class ChineseDisplay implements Observer,DisplayElement{
	private float temperature;
	private float humidity;
	private float pressure;
	private Subject weatherData;
	
	public ChineseDisplay(Subject weatherData){
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		display();
	}
	
	@Override
	public void display() {
		System.out.println("天气情况   气温： "+temperature
				+"F  湿度：  "+humidity+"%  气压： "+pressure);
		
	}
}
