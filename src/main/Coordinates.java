package main;

import java.util.Random;

public class Coordinates {
	
	private int xCoordinate;
	private int yCoordinate;
	private int[][] cityMatrix;
	private int fitness;
	
	public Coordinates(int xCoordinate, int yCoordinate, int[][] cityMatrix) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.cityMatrix = cityMatrix;
		this.fitness = calculateFitness();
	}
	
	public int getX() {
		return this.xCoordinate;
	}
	
	public int getY() {
		return this.yCoordinate;
	}
	
	public int[][] getCityMatrix() {
		return this.cityMatrix;
	}
	
	public int getFitness() {
		return this.fitness;
	}
	
	private int calculateFitness() {
		final int MAX_ROW = 10, MAX_COL = 10;
		int fitness = 0;
		for(int i = 0; i < MAX_ROW; i++) {
			for(int j = 0; j < MAX_COL; j++) {
				fitness += this.cityMatrix[i][j] * (Math.sqrt(Math.pow((i + 1)
						- this.xCoordinate, 2)) + (Math.sqrt(Math.pow((j + 1) - this.yCoordinate, 2))));
			}
		}
		return fitness;
	}
	
	public Coordinates crossOver(Coordinates partner) {
		final double CROSSOVER_RATE = 0.5;
		return new Coordinates(
				Math.random() <= CROSSOVER_RATE ? this.xCoordinate : partner.getX(),
				Math.random() <= CROSSOVER_RATE ? this.yCoordinate : partner.getY(),
				this.cityMatrix);
	}
	
	public Coordinates mutate() {
		final double MUTATION_RATE = 0.015;
		return new Coordinates(
				Math.random() <= MUTATION_RATE ? randomNumber() : this.xCoordinate,
				Math.random() <= MUTATION_RATE ? randomNumber() : this.yCoordinate,
				this.cityMatrix);
	}
	
	private int randomNumber() {
		final int MAX = 10;
		return new Random().nextInt(MAX) + 1;
	}
	
	@Override
	public String toString() {
		return "X : " + this.xCoordinate + " | Y : " + this.yCoordinate;
	}
}
