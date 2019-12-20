package com.kaswiner.learning.entity;

public class Transition {
	private int id;
	private State source;
	private State destination;
	private int cost;
	
	public Transition(int id, State source, State destination, int cost) {
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public State getSource() {
		return source;
	}

	public State getDestination() {
		return destination;
	}

	public int getCost() {
		return cost;
	}

}
