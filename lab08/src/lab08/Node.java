package lab08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Node {
	private String label;
	private int value;
	private List<Node> children = new ArrayList<Node>();

	// use for non-terminal node
	public Node(String label) {
		super();
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}

	public static Comparator<Node> getLabelComparator() {
		return LabelComparator;
	}

	public static void setLabelComparator(Comparator<Node> labelComparator) {
		LabelComparator = labelComparator;
	}

	// use for terminal node
	public Node(String label, int value) {
		super();
		this.label = label;
		this.value = value;
	}

	// ...
	// add a child to this node
	public void addChild(Node that) {
		this.children.add(that);
	}

	// check whether this node is terminal or not. The terminal node is assigned a
	// value.
	public boolean isTerminal() {
		return this.children.size() == 0;
	}

	// Defined comparator which is used for sorting children by alphabetical order
	public static Comparator<Node> LabelComparator = new Comparator<Node>() {
		@Override
		public int compare(Node o1, Node o2) {
			return o1.getLabel().compareTo(o2.getLabel());
		}
	};
}
