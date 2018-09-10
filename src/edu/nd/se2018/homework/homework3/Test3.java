package edu.nd.se2018.homework.homework3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test3 {

	@Test
	void test() {
		RunRace race = new RunRace();
		race.createHorse(new Horse(1, "Franklin", "Slow"));
		race.createHorse(new Horse(2, "Truman", "Slow"));
		race.createHorse(new Horse(3, "Washington", "Slow"));
		race.createHorse(new Horse(4, "Jefferson", "Slow"));
		race.createHorse(new Horse(5, "Kennedy", "Slow"));
		assert(race.runRace() == "Kennedy");
	}

}
