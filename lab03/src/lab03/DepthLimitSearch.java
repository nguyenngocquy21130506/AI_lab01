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
					List<Node> Nodechldren = current.getChildrenNodes();
					for (Node child : Nodechldren) {
						if (!frontier.contains(child) && !explored.contains(child)) {
							frontier.add(child);
							child.setParent(current);
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
