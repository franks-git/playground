package com.kaswiner.learning.algorithm;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.kaswiner.learning.entity.Graph;
import com.kaswiner.learning.entity.State;
import com.kaswiner.learning.entity.Transition;


public class DijkstraTest {
	
	@Test
	public void test() {
		State stateA = new State(1, "A");
		State stateB = new State(2, "B");
		State stateC = new State(3, "C");
		State stateD = new State(4, "D");
		State stateE = new State(5, "E");
		State stateF = new State(6, "F");
		List<State> states = Arrays.asList(stateA, stateB, stateC, stateD, stateE, stateF);
		
		Transition transitionAB = new Transition(1, stateA, stateB, 3);
		Transition transitionBC = new Transition(1, stateB, stateC, 3);
		Transition transitionAD = new Transition(1, stateA, stateD, 1);
		Transition transitionBE = new Transition(1, stateB, stateE, 2);
		Transition transitionCF = new Transition(1, stateC, stateF, 3);
		Transition transitionDE = new Transition(1, stateD, stateE, 7);
		Transition transitionEF = new Transition(1, stateE, stateF, 3);
		List<Transition> transitions = Arrays.asList(transitionAB, transitionBC, transitionAD, transitionBE, transitionCF, transitionDE, transitionEF);
		
		Graph graph = new Graph(states, transitions);
		new Dijkstra_v1(graph).execute(stateA);
		
		assertTrue(true);
	}

}
