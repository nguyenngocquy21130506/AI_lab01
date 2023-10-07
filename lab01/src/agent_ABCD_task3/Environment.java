package agent_ABCD_task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import agent_ABCD_task3.Environment.LocationState;

public class Environment {
	public static final Action MOVE_LEFT = new DynamicAction("LEFT");
	public static final Action MOVE_RIGHT = new DynamicAction("RIGHT");
	public static final Action MOVE_UP = new DynamicAction("UP");
	public static final Action MOVE_DOWN = new DynamicAction("DOWN");
	public static final Action SUCK_DIRT = new DynamicAction("SUCK");
	public static final LocationState[][] envgrid = createEnv();

	public enum LocationState {
		CLEAN, DIRTY
	}

	EnvironmentState envState;
	private boolean isDone = false;// all squares are CLEAN
	private Agent agent = null;
	private int score = 0;
	private List<String> checked = new ArrayList<>();

//	public Environment(LocationState locAState, LocationState locBState, LocationState locCState,
//			LocationState locDState) {
//		envState = new EnvironmentState(locAState, locBState, locCState, locDState);
//	}
	public Environment(LocationState[][] envgrid) {
		envState = new EnvironmentState(envgrid);
	}

	public static LocationState[][] createEnv() { // create Environment by net n x m
		int numRows = 3;
		int numCols = 4;
		Environment.LocationState[][] grid = new Environment.LocationState[numRows][numCols];
		// Sử dụng một đối tượng Random để tạo ngẫu nhiên trạng thái cho từng ô
		Random random = new Random();

		// Sử dụng DIRT_RATE để xác định tỷ lệ ô bẩn
		double DIRT_RATE = 0.2;
		double WALL_RATE = 0.1;
		double DIRT_NUM = DIRT_RATE * (numCols * numRows);
		double WALL_NUM = WALL_RATE * (numCols * numRows);
		
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				// Sử dụng random.nextDouble() để tạo một số ngẫu nhiên từ 0 đến 1
				if (random.nextDouble() < DIRT_RATE && DIRT_NUM != 0) {
					grid[row][col] = Environment.LocationState.DIRTY; // Gán "dirty" nếu nằm trong tỷ lệ bẩn
					DIRT_NUM -= 1;
				} else {
					grid[row][col] = Environment.LocationState.CLEAN; // Gán "clean" nếu không nằm trong tỷ lệ bẩn
				}
//				if (random.nextDouble() < WALL_RATE && WALL_NUM != 0) {
//					grid[row][col] = null; // Gán "dirty" nếu nằm trong tỷ lệ bẩn
//					WALL_NUM -= 1;
//				}
			}
		}
		return grid;
	}

	// add an agent into the enviroment
	public void addAgent(Agent agent, String location) {
		this.agent = agent;
		envState.setAgentLocation(location);
	}

	public EnvironmentState getCurrentState() {
		return this.envState;
	}

	public String move_left(String agentlocation) {
		int newagentlocation = Integer
				.valueOf(agentlocation.substring(agentlocation.indexOf("x") + 2, agentlocation.length())) - 1;
		return agentlocation.substring(0, agentlocation.indexOf("x") + 2) + newagentlocation;
//		return agentlocation.replaceFirst(agentlocation.substring(0, 1), newagentlocation + "");
	}

	public String move_right(String agentlocation) {
		int newagentlocation = Integer
				.valueOf(agentlocation.substring(agentlocation.indexOf("x") + 2, agentlocation.length())) + 1;
		return agentlocation.substring(0, agentlocation.indexOf("x") + 2) + newagentlocation;
//		return agentlocation.replaceFirst(agentlocation.substring(0, 1), newagentlocation + "");
	}

	public String move_up(String agentlocation) {
		int newagentlocation = Integer.valueOf(agentlocation.substring(0, agentlocation.indexOf("x") - 1)) - 1;
//		return agentlocation.replaceFirst(agentlocation.substring(agentlocation.length() - 2, agentlocation.length()),
//				" " + newagentlocation);
		return newagentlocation + agentlocation.substring(agentlocation.indexOf("x") - 1, agentlocation.length());
	}

	public String move_down(String agentlocation) {
		int newagentlocation = Integer.valueOf(agentlocation.substring(0, agentlocation.indexOf("x") - 1)) + 1;
//		return agentlocation.replaceFirst(agentlocation.substring(agentlocation.length() - 2, agentlocation.length()),
//				" " + newagentlocation);
		return newagentlocation + agentlocation.substring(agentlocation.indexOf("x") - 1, agentlocation.length());
	}

	// Update enviroment state when agent do an action
	public EnvironmentState executeAction(Action action) {
		String agentlocation = envState.getAgentLocation(); // get current agent location
		if (!checked.contains(agentlocation)) {
			checked.add(agentlocation);
		}
		if (action == SUCK_DIRT) {
			envState.setLocationState(agentlocation, LocationState.CLEAN);
			score += 500;
		} else if (action == MOVE_LEFT) {
			if (!agentlocation.substring(agentlocation.indexOf("x") + 2, agentlocation.length()).equals("0")) {
//				if (!checked.contains(move_left(agentlocation))) {
				envState.setAgentLocation(move_left(agentlocation));
				score -= 10;
//				} else {
//					score -= 100;
//				}
			} else {
				score -= 100;
			}
		} else if (action == MOVE_UP) {
			if (!agentlocation.substring(0, agentlocation.indexOf("x") - 1).equals("0")) {
//				if (!checked.contains(move_up(agentlocation))) {
				envState.setAgentLocation(move_up(agentlocation));
				score -= 10;
//				} else {
//					score -= 100;
//				}
			} else {
				score -= 100;
			}
		} else if (action == MOVE_RIGHT) {
			if (!agentlocation.substring(agentlocation.indexOf("x") + 2, agentlocation.length())
					.equals("" + (envgrid[0].length - 1))) {
//				if (!checked.contains(move_right(agentlocation))) {
				envState.setAgentLocation(move_right(agentlocation));
				score -= 10;
//				} else {
//					score -= 100;
//				}
			} else {
				score -= 100;
			}
		} else if (action == MOVE_DOWN) {
			if (!agentlocation.substring(0, agentlocation.indexOf("x") - 1).equals("" + (envgrid.length - 1))) {
//				if (!checked.contains(move_down(agentlocation))) {
				envState.setAgentLocation(move_down(agentlocation));
				score -= 10;
//				} else {
//					score -= 100;
//				}
			} else {
				score -= 100;
			}
		}
		return envState;
	}

	// get percept<AgentLocation, LocationState> at the current location where agent
	// is in.
	public Percept getPerceptSeenBy() {
		Percept per = new Percept(envState.getAgentLocation(), envState.getLocationState(envState.getAgentLocation()));
		return per;
	}

	public int score() {
		return score;
	}

	public boolean isdone() {
//		int index = 0;
		for (int row = 0; row < Environment.envgrid.length; row++) {
			for (int col = 0; col < Environment.envgrid[0].length; col++) {
				if (envState.getLocationState(row + " x " + col) == Environment.LocationState.DIRTY) {
					return false;
				}
			}
		}
		return true;
	}

	public void step() {
		envState.display(); // get state of env
		String agentLocation = this.envState.getAgentLocation(); // get location
		Action anAction = agent.execute(getPerceptSeenBy()); // get sach / ban
		EnvironmentState es = executeAction(anAction);

		System.out.println("Agent Loc.: " + agentLocation + "\tAction: " + anAction);
		if (isdone()) {// Kiểm tra xem tất cả phần tử có sach hay chua)
			isDone = true;
		}
		es.display();
	}

	public void step(int n) {
		for (int i = 0; i < n; i++) {
//			System.out.println("step: " + i);
//			step();
//			System.out.println("Current score : " + score());
//			System.out.println("-------------------------");
			stepUntilDone();
		}
		System.out.println("-----------DONE----------");
	}

	public void stepUntilDone() {
		int i = 0;
		while (!isDone) {
			System.out.println("step: " + i++);
			step();
			System.out.println("Current score : " + score());
//			System.out.println(checked);
			System.out.println("-------------------------");
		}
	}
}
