package lab06;

public class Test {
	public static void main(String[] args) {
		Node node = new Node();
		node.generateBoard();
		node.displayBoard();
		System.out.println();
//		for (Node n: node.generateAllCandidates()) {
//			System.out.println();
//			n.displayBoard();
//		}
		
		HillClimbingSearch climbingSearch = new HillClimbingSearch();
		climbingSearch.executeHillClimbingWithRandomRestart(node).displayBoard();
//		climbingSearch.execute(node).displayBoard();
	}
}
