package main;

public class Main {
	
	public static void main(String[] args) {
		int[][] cityMatrix = new int[][] {
			{5, 2, 4, 8, 9, 0, 3, 3, 8, 7},
			{5, 5, 3, 4, 4, 6, 4, 1, 9, 1},
			{4, 1, 2, 1, 3, 8, 7, 8, 9, 1},
			{1, 7, 1, 6, 9, 3, 1, 9, 6, 9},
			{4, 7, 4, 9, 9, 8, 6, 5, 4, 2},
			{7, 5, 8, 2, 5, 2, 3, 9, 8, 2},
			{1, 4, 0, 6, 8, 4, 0, 1, 2, 1},
			{1, 5, 2, 1, 2, 8, 3, 3, 6, 2},
			{4, 5, 9, 6, 3, 9, 7, 6, 5, 10},
			{0, 6, 2, 8, 7, 1, 2, 1, 5, 3}
		};
		
		Population population = new Population(30, cityMatrix);
		int generation = 1;
		while(generation != 500) {
			population.setPopulation(population.evolvePopulation(population));
			System.out.println("Coordinates : " + population.getFittest().toString());
			System.out.println("Fitness : " + population.getFittest().getFitness());
			System.out.println("Generation : " + generation);
			generation++;
		}
	}
}
