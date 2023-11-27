package lab08;

public class MiniMaxSearchAlgo implements ISearchAlgo {
	@Override
	public void execute(Node node) {
		int bestValue = minimax(node, true);
		System.out.println("Best Value: " + bestValue);
	}

	// Hàm đệ quy thực hiện MiniMax
	private int minimax(Node node, boolean isMaximizingPlayer) {
//		if (depth == 3 || node.isTerminalNode()) {
//			// Điều kiện dừng: đạt đến độ sâu hoặc nút lá
//			return node.evaluate(); // Giả sử hàm evaluate trả về giá trị của trạng thái
//		}
		for (int i = 0; i < node.getChildren().size(); i++) {
			if (node.isTerminal()) {
				if (isMaximizingPlayer) {
					node.getChildren().get(i).setValue(maxValue(node));
				} else {
					node.getChildren().get(i).setValue(minValue(node));
				}
			} else {
				minimax(node.getChildren().get(i), isMaximizingPlayer);
			}
		}
	}

	public int maxValue(Node node) {
		int k = Integer.MIN_VALUE;
		for (Node child : node.getChildren()) {
			if (child.getValue() > k) {
				k = child.getValue();
			}
		}
		return k;
	}

	public int minValue(Node node) {
		int k = Integer.MAX_VALUE;
		for (Node child : node.getChildren()) {
			if (child.getValue() < k) {
				k = child.getValue();
			}
		}
		return k;
	}
}