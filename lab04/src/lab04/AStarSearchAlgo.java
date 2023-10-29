package lab04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import lab04.Node;

public class AStarSearchAlgo implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>();
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
//					double newPathcost = current.getG() + child.getWeight();
					if (!frontier.contains(end) && !explored.contains(end)) {
						end.setParent(current);
						end.setG(current.getG() + child.getWeight());
						end.setF(end.getG() + end.getH());
						frontier.add(end);
					} else if (end.getF() > (current.getG() + child.getWeight() + end.getH())) {
						end.setG(current.getG() + child.getWeight());
						end.setParent(current);
					}
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>();
		frontier.add(root);
		boolean started = false;
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
			if (current.getLabel().equals(goal)) {
				return current;
			} else {
				List<Edge> Nodechldren = current.getChildren();
				explored.add(current);
				for (Edge child : Nodechldren) {
					Node end = child.getEnd();
//					double newPathcost = current.getG() + child.getWeight();
					if (!frontier.contains(end) && !explored.contains(end)) {
						end.setParent(current);
						end.setG(current.getG() + child.getWeight());
						end.setF(end.getG() + end.getH());
						frontier.add(end);
					} else if (end.getF() > (current.getG() + child.getWeight() + end.getH())) {
						end.setG(current.getG() + child.getWeight());
						end.setParent(current);
					}
				}
			}
		}
		return null;
	}
	
	// thoa dieu kien : duong di thuc te luon > du doan
	public boolean isAdmissibleH(Node root, String goal) {
		Node node = execute(root, goal);
		Node tmp = null;
		Node nodegoal = node;
		int i = 0;
		int count = 0;
		do {
			if (i != 0) {
				node = tmp;
			}
			i++;
//			System.out.println(node.getLabel()+" : " + (nodegoal.getG() - node.getG()));
			System.out.println(node.getLabel() + " : " + node.getH() + " - " + (nodegoal.getG() - node.getG()));
			if (node.getH() <= (nodegoal.getG() - node.getG())) {
				count++;
			}
		} while ((tmp = node.getParent()) != null);
//		System.out.println(count);
//		System.out.println(i);
		if (count == i)
			return true;
		else
			return false;
	}

}
