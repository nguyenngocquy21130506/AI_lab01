package lab05;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Greedy_AStar {
	public static Node executeGreedy(Puzzle model) {
		PriorityQueue<Node> frontier = new PriorityQueue<>(PuzzleUtils.HeuristicComparatorByH);
		List<Node> explore = new ArrayList<>();
		frontier.add(model.getInitialState());
		int i = 0;
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			System.out.println("num step : " + i++);
			System.out.print("H :" + current.getH() + " ");
			System.out.println("G :" + current.getG());
			System.out.println(current);
			if (current.getH() == 0) {
				return current;
			} else {
				explore.add(current);
				List<Node> children = model.getSuccessors(current);
				for (Node child : children) {
					if (!frontier.contains(child) && !explore.contains(child)) {
						frontier.add(child);
						child.setG(current.getG() + 1);
					}
				}
			}
		}
		return null;
	}

	public static Node executeAStar(Puzzle model) {
		PriorityQueue<Node> frontier = new PriorityQueue<>(PuzzleUtils.HeuristicComparatorByF);
		List<Node> explore = new ArrayList<>();
		frontier.add(model.getInitialState());
		int i = 0;
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			System.out.println("num step : " + i++);
			System.out.print("H :" + current.getH() + " ");
			System.out.println("G :" + current.getG());
			System.out.println(current);
			if (current.getH() == 0) {
				return current;
			} else {
				explore.add(current);
				List<Node> children = model.getSuccessors(current);
				for (Node child : children) {
					if (!frontier.contains(child) && !explore.contains(child)) {
						frontier.add(child);
						child.setG(current.getG() + 1);
						child.setF(child.getG() + child.getH());
					} else if (child.getF() > (current.getG() + 1 + child.getH())) {
						child.setG(current.getG() + 1);
					}
				}
			}
		}
		return null;
	}
}
