package lab06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Node {
	public static final int N = 8;
	private Queen[] state;

	public Node() {
		// generateBoard();
		state = new Queen[N];
	}

	public Node(Queen[] state) {
		this.state = new Queen[N];
		for (int i = 0; i < state.length; i++) {
			this.state[i] = new Queen(state[i].getRow(), state[i].getColumn());
		}
	}

	public Node(Node n) {
		this.state = new Queen[N];
		for (int i = 0; i < N; i++) {
			Queen qi = n.state[i];
			this.state[i] = new Queen(qi.getRow(), qi.getColumn());
		}
	}

	public void generateBoard() {
		Random random = new Random();
		for (int i = 0; i < N; i++) {
			state[i] = new Queen(random.nextInt(N), i);
		}
	}

	public int getH() {
		int heuristic = 0;
		for (int i = 0; i < state.length - 1; i++) {
			for (int j = i + 1; j < state.length; j++) {
				if (state[i].isConflict(state[j])) {
					heuristic++;
				}
			}
		}
		return heuristic;
	}

	public Node getBestCandidate() {
//		List<Node> listsubnode = generateAllCandidates();
//		Node n = listsubnode.get(0);
//		for (Node node : listsubnode) {
//			if (n.getH() > node.getH()) {
//				n = node;
//			}
//		}
//		return n;
		List<Node> neighbor = generateAllCandidates();
		int min = Integer.MAX_VALUE;
		Node re = null;
		for (Node node : neighbor) {
			if (node.getH() < min) {
				min = node.getH();
				re = node;
			}
		}
		return re;
	}

	// tung queen move + cac queen con lai static
	public List<Node> generateAllCandidates() {
		List<Node> result = new ArrayList<Node>();
		for (int i = 0; i < state.length; i++) {
			Node n = new Node(state);
			n.state[i].move();
			result.add(n);
		}
		return result;
	}

	public Node selectNextRandomCandidate() {
		Random r = new Random();
		int i = r.nextInt(N);
		int row = r.nextInt(N);
		Node n = new Node(state);
		n.state[i].setRow(row);
		state[i].setRow(row);
		return n;
	}

	public void displayBoard() {
		int[][] board = new int[N][N];
		// set queen position on the board
		for (int i = 0; i < N; i++) {
			board[state[i].getRow()][state[i].getColumn()] = 1;
		}
		// print board
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1) {
					System.out.print("Q" + " ");
				} else {
					System.out.print("-" + " ");
				}
			}
			System.out.println();
		}
	}
}
