package lab09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Node {
	private List<Integer> data = new ArrayList<Integer>();
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void add(Integer val) {
		this.data.add(val);
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}

	// Get children of the current nodes
	public List<Node> getSuccessors() {
//		List<Node> list = null;
//		for (Integer item : data) {
//			list = new ArrayList<Node>();
//			for (int i = 1; i <= item / 2; i++) {
//				Node children = new Node();
//				children.data.add(item-i);
//				children.data.add(i);
//				for (int j = i; j < data.size(); j++) {
//					children.data.add(data.get(j));
//				}
//				list.add(children);
//			}
//		}
//		return list;
		List<Node> list = new ArrayList<Node>();
		for (int i = 0; i < data.size(); i++) {
			int current = data.get(i);
			for (int j = 1; j <= current / 2; j++) {
				if ((current - j) != current / 2) {
					Node n = new Node();
					n.add(j);
					n.add(current - j);
					for (int k = 0; k < data.size(); k++) {
						if (k != i) {
							n.add(data.get(k));
						}
					}
					if (!list.contains(n)) {
						list.add(n);
					}
				}
			}
		}
		return list;
	}

	// Check whether a node is terminal or not
	public boolean isTerminal() {
		Collections.sort(data, (o1,o2) -> o2 - o1);
		if (data.get(0) <= 2) {
			return true;
		}
		return false;
	}

	public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};

	@Override
	public int hashCode() {
		return Objects.hash(data);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		return Objects.equals(data, other.data);
	}

	@Override
	public String toString() {
		Collections.sort(this.data, DESCOMPARATOR);
		return this.data.toString();
	}

}
