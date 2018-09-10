package edu.nd.se2018.homework.hwk2;

public class Horse {
	Strategy strat;
	String name;
	double position;
	double maxSpeed;
	double speed;
	
	public Horse(double maxSpeed, String name, String strat) {
		switch(strat) {
			case "Early":
				this.strat = new Early();
				break;
			case "Steady":
				this.strat = new Steady();
				break;
			case "Slow":
				this.strat = new Slow();
				break;
		}
		
		this.position = 0;
		this.speed = maxSpeed;
		this.maxSpeed = maxSpeed;
		this.name = name;
		this.strat.setStartSpeed(maxSpeed);
	}
	
	public double getPosition() {
		return this.position;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setStrat(String strat) {
		switch(strat) {
		case "Early":
			this.strat = new Early();
			break;
		case "Steady":
			this.strat = new Steady();
			break;
		case "Slow":
			this.strat = new Slow();
			break;
		}
		this.strat.setStartSpeed(maxSpeed);
	}
	
	public Strategy getStrat() {
		return this.strat;
	}
	
	public void run(double distance) {
		System.out.println("here");
		//this.strat.run(distance);
	}

}
