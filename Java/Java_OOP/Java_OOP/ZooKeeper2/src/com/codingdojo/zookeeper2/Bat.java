package com.codingdojo.zookeeper2;

public class Bat {
	private int energy = 100;
	private int towns = 0;
	private int humans = 0;
	private int fly = 0;
	
	public int fly() {
		System.out.println("Flap, flap, flap. flew: " + fly);
		fly++;
		return energy - 50;
	}
	public int eatHumans() {
		humans++;
		System.out.println("So - well nevermind...Ate " + humans + " humans");
		return energy + 25;
		
	}
	public int attackTown() {
		towns++;
		System.out.println("Scorching... Snap! Snap! Attacked " + towns + " towns");
		return energy - 100;
	}
	public void displayEnergy() {
		System.out.println(energy);
	}
}
