package edu.nd.se2018.homework.homework3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test1 {

	@Test
	void test() {
		RunRace race = new RunRace();
		race.createHorse(new Horse(10, "Franklin", "Slow"));
		race.createHorse(new Horse(10, "Truman", "Steady"));
		race.createHorse(new Horse(10, "Washington", "Early"));
		race.createHorse(new Horse(10, "Jefferson", "Slow"));
		race.createHorse(new Horse(10, "Kennedy", "Early"));
		assert(race.runRace() == "Franklin");
	}

}
