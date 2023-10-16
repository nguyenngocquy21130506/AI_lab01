package lab03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class UniformCostSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o2.getPathCost() > o1.getPathCost() ? -1 : o2.getLabel().compareTo(o1.getLabel());
			}

		});
		frontier.add(root);
		List<Node> explored = new ArrayList<>();
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(goal)) {
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
					} else if (end.getPathCost() > newPathcost) {
						end.setPathCost(newPathcost);
						end.setParent(current);
					}
				}
			}
		}
		return null;
	}

	@Override
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
				return execute(current, goal);
			}
			if (current.getLabel().equals(goal) && started) {
				return current;
			} else {
				List<Node> Nodechldren = current.getChildrenNodes();
				explored.add(current);
				for (Node child : Nodechldren) {
					if (!frontier.contains(child) && !explored.contains(child)) {
						frontier.add(child);
						child.setParent(current);
					}
				}
			}
		}
		return null;
	}

}
