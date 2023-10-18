package lab03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class DepthLimitSearch {

	// DFS
	public Node execute(Node root, String goal, int limit) {
		Stack<Node> frontier = new Stack<>();
		frontier.add(root);
		List<Node> explored = new ArrayList<>();
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
			if (current.getLabel().equals(goal)) {
				return current;
			} else {
				explored.add(current);
				if (current.getDepth() < limit) {
					List<Edge> Nodechldren = current.getChildren();
					for (int i = Nodechldren.size() - 1; i >= 0; i--) {
						Node end = Nodechldren.get(i).getEnd();
						double newPathcost = current.getPathCost() + Nodechldren.get(i).getWeight();
						if (!frontier.contains(Nodechldren.get(i)) && !explored.contains(Nodechldren.get(i))) {
							frontier.add(end);
							end.setParent(current);
							end.setPathCost(newPathcost);
						}
					}
				}
			}
		}
		return null;
	}

	public Node execute(Node root, String start, String goal) {
		Queue<Node> frontier = new LinkedList<>();
		boolean started = false;
		frontier.add(root);
		List<Node> explored = new ArrayList<>();
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(start)) {
				started = true;
				frontier.clear();
				explored.clear();
				current.setParent(null);
			}
			if (current.getLabel().equals(goal) && started) {
				return current;
			} else {
				List<Edge> Nodechldren = current.getChildren();
				explored.add(current);
				for (Edge child : Nodechldren) {
					Node end = child.getEnd();
					double newPathcost = current.getPathCost() + child.getWeight();
					if (!frontier.contains(child) && !explored.contains(child)) {
						frontier.add(end);
						end.setParent(current);
						end.setPathCost(newPathcost);
					}
				}
			}
		}
		return null;
	}

}
