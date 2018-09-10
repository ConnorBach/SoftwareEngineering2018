package edu.nd.se2018.homework.hwk2;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class RunRace {
	List<Horse> horses;
	Horse horse;

	public RunRace() {
		horses = new ArrayList<>();
	}
	
	void createHorse(Horse h) {
		horses.add(h);
	}
	
	String runRace() {
		int numHorsesDone = 0;
		int loopCount = 0;
		List<Horse> finishedHorses = new ArrayList<>();
		while(numHorsesDone <= 5) {
			for(Horse horse : horses) {
				// update horse positions
				horse.getStrat().run(.01);
				
				//print locations
				DecimalFormat df = new DecimalFormat("#.0");
				if(loopCount % 1000 == 0) {
					double pos = horse.getStrat().getPosition();
					if(pos <= 10)
						System.out.println(horse.getName() + " has run " + df.format(pos) + "miles.");
				}
				
				// count finished horses
				if(horse.getStrat().getPosition() >= 10) {
					numHorsesDone++;
					if(!finishedHorses.contains(horse))
						finishedHorses.add(horse);
				}
			}
		}
		
		// print finishing table
		int place = 1;
		for(Horse horse : finishedHorses) {
			System.out.println(horse.getName() + " finished " + place);
			place++;
		}
		
		// return winner
		return finishedHorses.get(0).getName();
	}
	
	
}
