package edu.nd.se2018.homework.hwk2;

public interface Strategy {
	void run(double distance);
	void changeSpeed();
	void setName(String name);
	void setStartSpeed(double speed);
	double getPosition();
	String getName();
}
