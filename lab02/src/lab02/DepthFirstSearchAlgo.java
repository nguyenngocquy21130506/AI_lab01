package lab02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		Stack<Node> fronted = new Stack<>();
		fronted.add(root);
		List<Node> explored = new ArrayList<>();
		while (!fronted.isEmpty()) {
			Node current = fronted.pop();
			if (current.getLabel().equals(goal)) {
				return current;
			} else {
				List<Node> Nodechldren = current.getChildrenNodes();
				explored.add(current);
				for (int i = Nodechldren.size() - 1; i >= 0; i--) {
					if (!fronted.contains(Nodechldren.get(i)) && !explored.contains(Nodechldren.get(i))) {
						fronted.add(Nodechldren.get(i));
						Nodechldren.get(i).setParent(current);
					}
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Stack<Node> fronted = new Stack<>();
		boolean started = false;
		fronted.add(root);
		fronted.add(root);
		List<Node> explored = new ArrayList<>();
		while (!fronted.isEmpty()) {
			Node current = fronted.pop();
			if (current.getLabel().equals(start)) {
				started = true;
				fronted.clear();
				explored.clear();
				current.setParent(null);
			}
			if (current.getLabel().equals(goal)) {
				return current;
			} else {
				List<Node> Nodechldren = current.getChildrenNodes();
				explored.add(current);
				for (int i = Nodechldren.size() - 1; i >= 0; i--) {
					if (!fronted.contains(Nodechldren.get(i)) && !explored.contains(Nodechldren.get(i))) {
						fronted.add(Nodechldren.get(i));
						Nodechldren.get(i).setParent(current);
					}
				}
			}
		}
		return null;
	}

}
