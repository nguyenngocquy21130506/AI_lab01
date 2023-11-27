package lab081;

import java.util.Collections;
import java.util.List;

public class MiniMaxSearchAlgo implements ISearchAlgo {

	// function MINIMAX-DECISION(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		System.out.println(maxValue(node));
	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) {
		int k = Integer.MIN_VALUE;
		if (node.isTerminal()) {
			return node.getValue();
		} else {
			for (Node no : node.getChildren()) {
				k = Math.max(k, minValue(no));
			}
		}
		return k;
	}
	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v

	public int minValue(Node node) {
		int k = Integer.MAX_VALUE;
		if (node.isTerminal()) {
			return node.getValue();
		} else {
			for (Node no : node.getChildren()) {
				k = Math.min(k, maxValue(no));
			}
		}
		return k;
	}
}
