package com.kaswiner.learning.entity;

public class HTransition {
	private int id;
	private State source;
	private State destination;
	private int cost;
	private int hcost;
	
	public HTransition(int id, State source, State destination, int cost, int hcost) {
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.cost = cost;
		this.hcost = hcost;
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

	public int getHcost() {
		return hcost;
	}

	public int getTotalCost() {
		return this.cost + this.hcost;
	}

}
