package edu.nd.se2018.homework.homework3;

public class Early implements Strategy {
	double position = 0; // position in miles
	double speed = 0; // current speed of the horse
	double startSpeed = 0; // speed at the start
	String name = ""; // horse name

	@Override
	public void run(double distance) {
		// update position
		this.position += speed;
		
		if(this.position >= 2 && this.speed == this.startSpeed) {
			changeSpeed();
		}
	}

	@Override
	public void changeSpeed() {
		// reduce speed
		this.speed = .75 * this.startSpeed;
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
