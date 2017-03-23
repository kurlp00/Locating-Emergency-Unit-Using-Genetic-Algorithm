package main;

import java.util.Random;

public class Selection {
	
	public static Coordinates tournamentSelection(Population population) {
		final int TOURNAMENT_SIZE = 3, MAX = 10;
		Random rand = new Random();
		Coordinates bestFitness = population.getCoordinate(rand.nextInt(MAX));
		for(int i = 0; i < TOURNAMENT_SIZE; i++){
			Coordinates contFitness = population.getCoordinate(rand.nextInt(MAX));
			if(contFitness.getFitness() < bestFitness.getFitness()) {
				bestFitness = contFitness;
			}
		}
		return bestFitness;
	}
}
