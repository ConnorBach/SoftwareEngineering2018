package edu.nd.se2018.homework.hwk2;

public class Slow implements Strategy {
	double position = 0; // position in miles
	double speed = 0; // current speed of the horse
	double startSpeed = 0; // speed at the start
	String name = ""; // horse name
	
	@Override
	public void run(double distance) {
		this.position += speed;
		changeSpeed();
	}

	@Override
	public void changeSpeed() {
		if(this.position <= 6 && this.speed == startSpeed) 
			this.speed = .75 * startSpeed;
		if(this.position <= 9 && this.speed == .75 * startSpeed) 
			this.speed = .90 * startSpeed;
		if(this.position <= 10 && this.speed == .90 * startSpeed)
			this.speed = startSpeed;
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
		this.speed = speed;
	}
}
