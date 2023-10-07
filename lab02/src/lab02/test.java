package lab02;

import java.util.ArrayList;
import java.util.List;

public class test {
//	Node s = new Node("S");
//	Node a = new Node("A");
//	Node b = new Node("B");
//	Node c = new Node("C");
//	Node d = new Node("D");
//	Node e = new Node("E");
//	Node f = new Node("F");
//	Node g = new Node("G");
//	Node h = new Node("H");
//	
//	Edge e1 = new Edge(s, a);
//	Edge e2 = new Edge(s, b);
//	Edge e3 = new Edge(s, c);
//	Edge e4 = new Edge(a, d);
//	Edge e5 = new Edge(a, e);
//	Edge e6 = new Edge(b, g);
//	Edge e7 = new Edge(c, f);
//	Edge e8 = new Edge(d, h);
//	Edge e9 = new Edge(e, g);
//	Edge e10 = new Edge(f, g);
	
	public static void main(String[] args) {
		Node nodeS = new Node("S");
		Node nodeA = new Node("A"); 
		Node nodeB = new Node("B");
		Node nodeC = new Node("C"); 
		Node nodeD = new Node("D");
		Node nodeE = new Node("E"); 
		Node nodeF = new Node("F");
		Node nodeG = new Node("G"); 
		Node nodeH = new Node("H");
		nodeS.addEdge(nodeA, 5);
		nodeS.addEdge(nodeB, 2);
		nodeS.addEdge(nodeC, 4); 
		nodeA.addEdge(nodeD, 9);
		nodeA.addEdge(nodeE, 4); 
		nodeB.addEdge(nodeG, 6);
		nodeC.addEdge(nodeF, 2); 
		nodeD.addEdge(nodeH, 7);
		nodeE.addEdge(nodeG, 6); 
		nodeF.addEdge(nodeG, 1);
		ISearchAlgo algo1 = new BreadthFirstSearchAlgo();
//		Node result = algo1.execute(nodeS, "G");
//		NodeUtils nodeUtils = new NodeUtils();
		
//		Node result1 = algo1.execute(nodeS, "A" , "G");
//		NodeUtils nodeUtils = new NodeUtils();
//		
		ISearchAlgo algo2 = new DepthFirstSearchAlgo();
		Node result2 = algo2.execute(nodeS, "G");
		NodeUtils nodeUtils = new NodeUtils();
		
//		Node result3 = algo2.execute(nodeS, "A" , "G");
//		NodeUtils nodeUtils = new NodeUtils();
		
		System.out.println(nodeUtils.printPath(result2));
//		System.out.println(result2);
	}
}
