package com.kaswiner.learning.entity;

import java.util.List;

public class Graph {
	public List<State> states;
	public List<Transition> transitions;
	
	public Graph(List<State> states, List<Transition> transitions) {
		this.states = states;
		this.transitions = transitions;
	}

	public List<State> getStates() {
		return states;
	}

	public List<Transition> getTransitions() {
		return transitions;
	}

}
