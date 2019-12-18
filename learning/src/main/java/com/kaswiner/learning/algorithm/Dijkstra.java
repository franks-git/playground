package com.learn.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.learn.entity.Graph;
import com.learn.entity.State;
import com.learn.entity.Transition;

public class Dijkstra {
	private List<State> states;
	private List<Transition> transitions;
	private Set<State> openedStates;
	private Set<State> closedStates;
	private Map<State, State> predecessors;
	private Map<State, Integer> distance;
	
	public Dijkstra(Graph graph) {
		this.states = new ArrayList<State>(graph.getStates());
		this.transitions = new ArrayList<Transition>(graph.getTransitions());
	}
	
	public void execute(State source) {
		this.openedStates = new HashSet<State>();
		this.closedStates = new HashSet<State>();
		this.predecessors = new HashMap<>();
		this.distance = new HashMap<>();
		
		this.openedStates.add(source);
		this.distance.put(source, 0);
		
		while (this.openedStates.size() > 0) {
			State state = this.getMinimum(this.openedStates);
			this.openedStates.remove(state);
			this.closedStates.add(state);
			this.findMinimalDistance(state);
		}
		
	}
	
	public void findMinimalDistance(State state) {
		List<State> nextPossibleStates = this.getNextPossibleStates(state);
		
		for (State nextPossibleState : nextPossibleStates) {
			if (this.getDistance(nextPossibleState) == -1 || this.getDistance(nextPossibleState) > this.getDistance(state) + this.getDistance(state, nextPossibleState)) {
				this.openedStates.add(nextPossibleState);
				this.distance.put(nextPossibleState, this.getDistance(state) + this.getDistance(state, nextPossibleState));

				this.predecessors.put(nextPossibleState, state);
			}
		}
	}
	
	public State getMinimum(Set<State> states) {
		State minimum = null;
		
		for (State state : states) {
			if (minimum == null) {
				minimum = state;
			} else {
				if (this.getDistance(state) < this.getDistance(minimum)) {
					minimum = state;
				}
			}
		}
		
		return minimum;
	}
	
	public int getDistance(State destinationState) {
		Integer result = null;
		Integer distanceState = this.distance.get(destinationState);
		
		if (distanceState == null) {
			result = -1;
		} else {
			result = distanceState;
		}
		
		return result;
	}
	
	public int getDistance(State sourceState, State targetState) {
		int cost = -1;
		
		for (Transition transition : this.transitions) {
			if (transition.getSource().equals(sourceState) && transition.getDestination().equals(targetState)) {
				cost = transition.getCost();
			}
		}
		
		if (cost == -1) {
			throw new RuntimeException("No transition found");
		}
		
		return cost;
	}
	
	public List<State> getNextPossibleStates(State state) {
		List<State> neighbors = new ArrayList<>();
		
		for (Transition transition : this.transitions) {
			if (transition.getSource().equals(state) && !this.isSettled(transition.getDestination())) {
				neighbors.add(transition.getDestination());
			}
		}
		
		return neighbors;
	}
	
	public boolean isSettled(State state) {
		return this.closedStates.contains(state);
	}
	
	public LinkedList<State> getPath(State state) {
		LinkedList<State> path = new LinkedList<>();
		
		
	}
}
