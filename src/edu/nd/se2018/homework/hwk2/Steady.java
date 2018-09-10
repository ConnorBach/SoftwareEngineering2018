package edu.nd.se2018.homework.hwk2;

public class Steady implements Strategy {
	double position = 0; // position in miles
	double speed = 0; // current speed of the horse
	double startSpeed = 0; // speed at the start
	String name = ""; // horse name
	
	@Override
	public void run(double distance) {
		// stay at 80% the entire time
		if(this.speed == this.startSpeed) changeSpeed();
		this.position += speed;
	}

	@Override
	public void changeSpeed() {
		// TODO Auto-generated method stub
		speed = .8 * startSpeed;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;	
	}
	
	@Override
	public double getPosition() {
		return this.position;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public void setStartSpeed(double speed) {
		this.startSpeed = speed;
		this.speed = startSpeed;
	}
}
