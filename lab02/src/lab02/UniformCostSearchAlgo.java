package lab02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class UniformCostSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		Queue<Node> fronted = new LinkedList<>();
		fronted.add(root);
		List<Node> explored = new ArrayList<>();
		while (!fronted.isEmpty()) {
			Node current = fronted.poll();
			if (current.getLabel().equals(goal)) {
				return current;
			} else {
				List<Node> Nodechldren = current.getChildrenNodes();
				explored.add(current);
				for (Node child : Nodechldren) {
					if (!fronted.contains(child) && !explored.contains(child)) {
						fronted.add(child);
						child.setParent(current);
					}
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Queue<Node> fronted = new LinkedList<>();
		boolean started = false;
		fronted.add(root);
		List<Node> explored = new ArrayList<>();
		while (!fronted.isEmpty()) {
			Node current = fronted.poll();
			if (current.getLabel().equals(start)) {
				started = true;
				fronted.clear();
				explored.clear();
				current.setParent(null);
				return execute(current, goal);
			}
			if (current.getLabel().equals(goal) && started) {
				return current;
			} else {
				List<Node> Nodechldren = current.getChildrenNodes();
				explored.add(current);
				for (Node child : Nodechldren) {
					if (!fronted.contains(child) && !explored.contains(child)) {
						fronted.add(child);
						child.setParent(current);
					}
				}
			}
		}
		return null;
	}

}
