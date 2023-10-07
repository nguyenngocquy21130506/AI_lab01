package agent_ABCD_task3;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import agent_ABCD_task3.Environment;
import agent_ABCD_task3.Environment.LocationState;

public class TestSimpleReflexAgent {

	public static void main(String[] args) {
		LocationState[][] envgrid = Environment.envgrid;
		Environment env = new Environment(envgrid);
		Agent agent = new Agent(new AgentProgram());
		env.addAgent(agent, 0 + " x " + 0);

//		List<String> list = Arrays.asList("a","b","c","d","e");
//		list.stream().forEach(t -> System.out.println(t));
//		Arrays.stream(envgrid)
//        .forEach(row -> Arrays.stream(row)
//                              .forEach(System.out::println));
		env.step(30);
//		System.out.println(env.isdone()); 
//		System.out.println(Environment.envgrid[0].length);
//		System.out.println(Arrays.deepToString(Environment.envgrid));
//		System.out.println(env.envState.state);
//		System.out.println(env.envState.getAgentLocation());
//		System.out.println(env.move_up(env.envState.getAgentLocation()));
//		env.move_left(env.envState.getAgentLocation());
//		String str = "-1 x";
//		int i = Integer.valueOf(str.substring(0, str.indexOf(" x")));
//		System.out.println(i + 1);

	}

//	public static void main(String[] args) {
//		int numRows = 4;
//		int numCols = 5;
//		Environment.LocationState[][] grid = new Environment.LocationState[numRows][numCols];
//
//		// Sử dụng một đối tượng Random để tạo ngẫu nhiên trạng thái cho từng ô
//		Random random = new Random();
//
//		// Sử dụng DIRT_RATE để xác định tỷ lệ ô bẩn
//		double DIRT_RATE = 0.2;
//		double WALL_RATE = 0.1;
//
//		for (int row = 0; row < numRows; row++) {
//			for (int col = 0; col < numCols; col++) {
//				// Sử dụng random.nextDouble() để tạo một số ngẫu nhiên từ 0 đến 1
//				if (random.nextDouble() < DIRT_RATE) {
//					grid[row][col] = Environment.LocationState.DIRTY; // Gán "dirty" nếu nằm trong tỷ lệ bẩn
//				} else {
////					System.out.println(random.nextDouble());
////					if (random.nextDouble() < WALL_RATE) {
////						grid[row][col] = null;
////					}
//					grid[row][col] = Environment.LocationState.CLEAN; // Gán "clean" nếu không nằm trong tỷ lệ bẩn
//				}
//			}
//		}
//
//		// In lưới để kiểm tra kết quả
//		for (int row = 0; row < numRows; row++) {
//			for (int col = 0; col < numCols; col++) {
//				System.out.print(grid[row][col] + " ");
//			}
//			System.out.println();
//		}
//	}
}
