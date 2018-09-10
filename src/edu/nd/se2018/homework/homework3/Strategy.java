package edu.nd.se2018.homework.homework3;

public interface Strategy {
	void run(double distance);
	void changeSpeed();
	void setName(String name);
	void setStartSpeed(double speed);
	double getPosition();
	String getName();
}
