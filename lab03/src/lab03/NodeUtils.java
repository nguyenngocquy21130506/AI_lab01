package lab03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NodeUtils {
	public static List<String> printPath(Node node) {
		if (node != null) {
			List<String> result = new ArrayList<String>();
			result.add(node.getLabel() + node.getPathCost());
			Node tmp;
			while ((tmp = node.getParent()) != null) {
				result.add(tmp.getLabel() + tmp.getPathCost());
				node = tmp;
			}
			Collections.reverse(result);
			return result;
		} else
			return new ArrayList<String>();
	}
}
