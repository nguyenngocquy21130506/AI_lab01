package lab09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestNode {
	public static void main(String[] args) {
		Node node = new Node();
		Integer[] data = { 7 };
		node.addAll(Arrays.asList(data));
//		System.out.println(node.getSuccessors());
//		for (Node n : node.getSuccessors()) {
//			System.out.println(n.isTerminal());
//			System.out.println("-" + n.getSuccessors());
//			for (Node a : n.getSuccessors()) {
//				System.out.println(a.isTerminal());
//				System.out.println("--" + a.getSuccessors());
//			}
//		}
		MinimaxAlgo algo = new MinimaxAlgo();
		algo.execute(node);
	}
	
//	static Node findTerminal(Node node) {
//		if(!node.isTerminal()) {
//			for (Node n : node.getSuccessors()) {
//				return findTerminal(n);
//			}
//		}else {
//			return node;
//		}
//		return node;
//	}
}