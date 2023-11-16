package lab07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GA_NQueenAlgo {
	public static final int POP_SIZE = 100;// Population size
	public static final double MUTATION_RATE = 0.03;
	public static final int MAX_ITERATIONS = 1000;
	List<Node> population = new ArrayList<Node>();
	Random rd = new Random();

// initialize the individuals of the population
	public void initPopulation() {
		for (int i = 0; i < POP_SIZE; i++) {
			Node ni = new Node();
			ni.generateBoard();
			population.add(ni);
		}
	}

	public Node execute() {
		Node x, y, child;
		int k = 0;
		initPopulation();
		while (k != MAX_ITERATIONS) {
			List<Node> newpopulation = new ArrayList<>();
			for (int i = 0; i < POP_SIZE; i++) {
				x = getParentByRandomSelection();
				y = getParentByRandomSelection();
				child = reproduce(x, y);
				if (rd.nextDouble() < MUTATION_RATE) {
					mutate(child);
				}
				if (child.getH() == 0) {
//					System.out.println("K : " +k);
					System.out.println(child.getH());
					return child;
				}
				newpopulation.add(child);
			}
			k++;
			population = newpopulation;
		}
		Collections.sort(population);
//		System.out.println("K : " +k);
		System.out.println(population.get(0).getH());
		return population.get(0);
	}

// Mutate an individual by selecting a random Queen and
//move it to a random row.
	public void mutate(Node node) {
		node.getState()[rd.nextInt(Node.N)].setRow(rd.nextInt(Node.N));
	}

//Crossover x and y to reproduce a child
	public Node reproduce(Node x, Node y) {
		int c = rd.nextInt(Node.N);
		Node spirits = new Node(); // tinh linh
		spirits.generateBoard();
		for (int i = 0; i < c; i++) {
			spirits.setRow(i, x.getRow(i));
//			spirits.setRow(Node.N - c - i, y.getRow(Node.N - c - i));
		}
		for (int i = c; i < Node.N; i++) {
			spirits.setRow(i, y.getRow(i));
//			spirits.setRow(Node.N - c - i, y.getRow(Node.N - c - i));
		}
		return spirits;
	}

// Select K individuals from the population at random and
//select the best out of these to become a parent.
	public Node getParentByTournamentSelection(int k) {
		List<Node> listnode = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			Node node = population.get(rd.nextInt(k));
			listnode.add(node);
		}
		Collections.sort(listnode);
		return listnode.get(0);
	}

//Select a random parent from the population
	public Node getParentByRandomSelection() {
//		System.out.println(population.size());
		Node node = population.get(rd.nextInt(POP_SIZE));
		return node;
	}
}