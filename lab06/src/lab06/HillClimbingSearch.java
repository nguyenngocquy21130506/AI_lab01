package lab06;

public class HillClimbingSearch {
//	public Node execute(Node initialState) {
//		Node current = initialState;
//		Node neighbor = null;
//		int stepClimbed = 0;
//		while (true) {
//			neighbor = current.getBestCandidate();
//			System.out.println(neighbor.getH());
//			if (neighbor.getH() < current.getH()) {
//				stepClimbed++;
//				current = neighbor;
//			} else {
//				return current;
//			}
//		}
//	}
//
//	public Node executeHillClimbingWithRandomRestart(Node initialState) {
//		Node current = execute(initialState);
//		int stepClimbed = 0;
//		int stepClimbedAfterRandomRestart = 0;
//		int randomRestarts = 0;
//		while (current.getH() != 0) {
//			current.generateBoard();
//			current.displayBoard();
//			current = execute(current);
//			randomRestarts++;
//			if (current.getH() == 0) {
//				System.out.println("stepClimbed :" + (randomRestarts * current.N));
//				System.out.println("RandomRestarts :" + randomRestarts);
//			}
//		}
//		return current;
//	}
	int stepClimbedAfterRandomRestart = 0;
	int randomRestarts = 0;

	public Node execute(Node initialState) {
		int stepClimbed = 0;
		Node current = new Node(initialState);
		Node neighbor = null;
		while (true) {
			neighbor = current.getBestCandidate();
			if (neighbor.getH() < current.getH()) {
				stepClimbed++;
				stepClimbedAfterRandomRestart++;
				current = neighbor;
			} else {
				if (current.getH() == 0) {
					System.out.println("Steps After Restart: " + stepClimbedAfterRandomRestart);
					System.out.println("Steps Climbed: " + stepClimbed);
				}
				return current;
			}
		}
	}

	public Node executeHillClimbingWithRandomRestart(Node initialState) {
		Node current = execute(initialState);

		while (current.getH() != 0) {
			current.generateBoard();
			current = execute(current);

			randomRestarts++;
		}
		System.out.println("Random Restarts: " + randomRestarts);

		return current;
	}
}
