package edu.nd.se2018.homework.hwk2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test2 {

	@Test
	void test() {
		RunRace race = new RunRace();
		race.createHorse(new Horse(1, "Franklin", "Slow"));
		race.createHorse(new Horse(2, "Truman", "Steady"));
		race.createHorse(new Horse(10, "Washington", "Early"));
		race.createHorse(new Horse(1, "Jefferson", "Slow"));
		race.createHorse(new Horse(1, "Kennedy", "Early"));
		assert(race.runRace() == "Washington");
	}

}
