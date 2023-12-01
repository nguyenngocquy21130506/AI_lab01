package lab09;

import lab09.Node;

public class MinimaxAlgo {
	public void execute(Node node) {
		int v = minValue(node);
		System.out.println(v);
	}

	public int maxValue(Node node) {
		int k = Integer.MIN_VALUE;
		if (node.isTerminal()) {
			node.setValue(0);
			return node.getValue();
		} else {
			for (Node no : node.getSuccessors()) {
				no.setValue(k);
				k = Math.max(k, minValue(no));
			}
		}
		return k;
	}

	public int minValue(Node node) {
		int k = Integer.MAX_VALUE;
		if (node.isTerminal()) {
			node.setValue(1);
			return node.getValue();
		} else {
			for (Node no : node.getSuccessors()) {
				no.setValue(k);
				k = Math.min(k, maxValue(no));
			}
		}
		return k;
	}
}
