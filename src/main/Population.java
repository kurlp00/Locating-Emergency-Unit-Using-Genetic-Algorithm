package main;

import java.util.ArrayList;
import java.util.Random;

public class Population {
	
	private ArrayList<Coordinates> population;

	public Population(int initialPopulation, int[][] matrix) {
		final int MAX_ROW = 10, MAX_COL = 10;
		Random rand = new Random();
		population = new ArrayList<Coordinates>();
		
		for(int i = 0; i < initialPopulation; i++) {
			this.population.add(new Coordinates(rand.nextInt(MAX_ROW) + 1
					, rand.nextInt(MAX_COL) + 1, matrix));
		}
	}
	
	public ArrayList<Coordinates> getPopulation() {
		return this.population;
	}
	
	public Coordinates getCoordinate(int index) {
		return this.population.get(index);
	}
	
	public void setPopulation(ArrayList<Coordinates> population) {
		this.population = population;
	}
	
	public Coordinates getFittest() {
		Coordinates bestFitness = this.population.get(0);
		for(Coordinates coordinate : this.population) {
			if(bestFitness.getFitness() < coordinate.getFitness()) {
				bestFitness = coordinate;
			}
		}
		return bestFitness;
	}
	
	public ArrayList<Coordinates> evolvePopulation(Population population) {
		ArrayList<Coordinates> newPopulation = new ArrayList<Coordinates>();
		for(int i = 0; i < this.population.size(); i++) {
			Coordinates parentA = Selection.tournamentSelection(population);
			Coordinates parentB = Selection.tournamentSelection(population);
			Coordinates child = parentA.crossOver(parentB).mutate();
			newPopulation.add(child);
		}
		return newPopulation;
	}
	
	@Override
	public String toString() {
		String ret = "";
		ret += "Population\n";
		for(Coordinates coordinate : this.population) {
			ret += "X : " + coordinate.getX() + " Y : " + coordinate.getY() + "\n";
		}
		return ret;
	}
}
