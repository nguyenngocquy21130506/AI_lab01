package lab05;

import java.util.Arrays;
import java.util.List;

public class TestNode {

	public static void main(String[] args) {
		Puzzle p = new Puzzle();
		p.readInput("D:\\AI\\lab05\\src\\lab05\\PuzzleMap.txt", "D:\\AI\\lab05\\src\\lab05\\PuzzleGoalState.txt");

		Node initialState = p.getInitialState();
		Node tmp = new Node(initialState);
//		System.out.println(initialState.equals(tmp));
//		Node goalState = p.getGoalState();
//		System.out.println(p.getInitialState());
		initialState.setH(p.computeH1(tmp) + p.computeH2(tmp));
//		System.out.println("H: " + tmp.getH());
//		System.out.println(Arrays.toString(initialState.getWhiteTilePosition()));
//		System.out.println(p.getGoalState());
//		Node re = p.moveWhiteTile(initialState, 'r');
//
//		System.out.println(re);
//		System.out.println(re.getH());
//		System.out.println(initialState);
//		System.out.println(Arrays.toString(re.getWhiteTilePosition()));
//		System.out.println(p.computeH(init, goal));

		// System.out.println(p.getInitialState());
		// System.out.println(p.getGoalState());
		//
//		List<Node> children = p.getSuccessors(initialState);
//		System.out.println("Size: " + children.size());
//		for (Node child : children) {
//			System.out.println(child.getH() + " " + p.computeH2(child));
//		}
//		System.out.println(p.computeH1(tmp));
//		System.out.println(p.computeH2(tmp));
//		
//		System.out.println(p.moveWhiteTile(tmp, 'u'));
		System.out.println(tmp.toString());
		Greedy_AStar aStar = new Greedy_AStar();
		aStar.executeGreedy(p);
//		aStar.executeAStar(p);
	}
}
