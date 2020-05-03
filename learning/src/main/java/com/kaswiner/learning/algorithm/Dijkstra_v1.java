package com.kaswiner.learning.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.kaswiner.learning.entity.Graph;
import com.kaswiner.learning.entity.State;
import com.kaswiner.learning.entity.Transition;

public class Dijkstra_v1 {
	private List<State> states;
	private List<Transition> transitions;
	private Set<State> openedStates;
	private Set<State> closedStates;
	private Map<State, State> predecessors;
	private Map<State, Integer> mapDistances;
	
	public Dijkstra_v1(Graph graph) {
		this.states = new ArrayList<State>(graph.getStates());
		this.transitions = new ArrayList<Transition>(graph.getTransitions());
	}
	
	public void execute(State source) {
		this.openedStates = new HashSet<>();
		this.closedStates = new HashSet<>();
		this.predecessors = new HashMap<>();
		this.mapDistances = new HashMap<>();
		
		this.openedStates.add(source);
		this.mapDistances.put(source, 0);
		
		while (!this.openedStates.isEmpty()) {
			State state = this.calcMinimumDistanceOpenedState();
			this.openedStates.remove(state);
			this.closedStates.add(state);
			this.calcDistanceForNextPossibleStates(state);
		}
	}
	
	public State calcMinimumDistanceOpenedState() {
		State minimum = null;
		
		for (State state : this.openedStates) {
			if (minimum == null) {
				minimum = state;
			} else {
				if (this.calcDistance(state) < this.calcDistance(minimum)) {
					minimum = state;
				}
			}
		}
		
		return minimum;
	}
	
	public void calcDistanceForNextPossibleStates(State state) {
		List<State> nextPossibleStates = this.getNextPossibleStates(state);
		
		for (State nextPossibleState : nextPossibleStates) {
			if (this.calcDistance(nextPossibleState) == -1 || this.calcDistance(nextPossibleState) > this.calcDistance(state) + this.calcDistance(state, nextPossibleState)) {
				this.openedStates.add(nextPossibleState);
				this.mapDistances.put(nextPossibleState, this.calcDistance(state) + this.calcDistance(state, nextPossibleState));

				this.predecessors.put(nextPossibleState, state);
			}
		}
	}
	
	public int calcDistance(State destinationState) {
		Integer result = null;
		Integer distanceState = this.mapDistances.get(destinationState);
		
		if (distanceState == null) {
			result = -1;
		} else {
			result = distanceState;
		}
		
		return result;
	}
	
	public int calcDistance(State sourceState, State targetState) {
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
		List<State> nextPossibleStates = new ArrayList<>();
		
		for (Transition transition : this.transitions) {
			if (transition.getSource().equals(state) && !this.isSettled(transition.getDestination())) {
				nextPossibleStates.add(transition.getDestination());
			}
		}
		
		return nextPossibleStates;
	}
	
	public boolean isSettled(State state) {
		return this.closedStates.contains(state);
	}
	
	// TODO finish the implementation
	public LinkedList<State> getPath(State state) {
		LinkedList<State> path = new LinkedList<>();
		
		return null;
	}
}
