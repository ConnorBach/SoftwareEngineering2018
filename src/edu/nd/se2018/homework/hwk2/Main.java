package edu.nd.se2018.homework.hwk2;

public class Main {
	public static void main(String[] args) {
		RunRace race = new RunRace();
		race.createHorse(new Horse(10, "Franklin", "Slow"));
		race.createHorse(new Horse(10, "Truman", "Steady"));
		race.createHorse(new Horse(10, "Washington", "Early"));
		race.createHorse(new Horse(10, "Jefferson", "Slow"));
		race.createHorse(new Horse(10, "Kennedy", "Early"));
		race.runRace();
	}
}
