package agent_ABCD_task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import agent_ABCD_task3.Environment;
import agent_ABCD_task3.Action;
import agent_ABCD_task3.Environment.LocationState;

public class AgentProgram {

	public Action execute(Percept p) {
		List<Action> action_top = new ArrayList<>();
		List<Action> action_bottom = new ArrayList<>();
		List<Action> action_right = new ArrayList<>();
		List<Action> action_left = new ArrayList<>();
		action_top.add(Environment.MOVE_RIGHT);
		action_top.add(Environment.MOVE_DOWN);
		action_top.add(Environment.MOVE_LEFT);
		action_bottom.add(Environment.MOVE_RIGHT);
		action_bottom.add(Environment.MOVE_UP);
		action_bottom.add(Environment.MOVE_LEFT);
		action_right.add(Environment.MOVE_LEFT);
		action_right.add(Environment.MOVE_DOWN);
		action_right.add(Environment.MOVE_UP);
		action_left.add(Environment.MOVE_RIGHT);
		action_left.add(Environment.MOVE_UP);
		action_left.add(Environment.MOVE_DOWN);
		List<Action> action_top_left = new ArrayList<>();
		List<Action> action_bottom_left = new ArrayList<>();
		List<Action> action_top_right = new ArrayList<>();
		List<Action> action_bottom_right = new ArrayList<>();
		action_top_left.add(Environment.MOVE_RIGHT);
		action_top_left.add(Environment.MOVE_DOWN);
		action_bottom_left.add(Environment.MOVE_RIGHT);
		action_bottom_left.add(Environment.MOVE_UP);
		action_top_right.add(Environment.MOVE_LEFT);
		action_top_right.add(Environment.MOVE_DOWN);
		action_bottom_right.add(Environment.MOVE_UP);
		action_bottom_right.add(Environment.MOVE_LEFT);
		List<Action> actions = new ArrayList<>();
		actions.add(Environment.MOVE_RIGHT);
		actions.add(Environment.MOVE_LEFT);
		actions.add(Environment.MOVE_UP);
		actions.add(Environment.MOVE_DOWN);

		Action random_action_top = action_top.get(new Random().nextInt(action_top.size()));
		Action random_action_bottom = action_bottom.get(new Random().nextInt(action_bottom.size()));
		Action random_action_right = action_right.get(new Random().nextInt(action_right.size()));
		Action random_action_left = action_left.get(new Random().nextInt(action_left.size()));

		Action random_action_top_left = action_top_left.get(new Random().nextInt(action_top_left.size()));
		Action random_action_bottom_left = action_bottom_left.get(new Random().nextInt(action_bottom_left.size()));
		Action random_action_top_right = action_top_right.get(new Random().nextInt(action_top_right.size()));
		Action random_action_bottom_right = action_bottom_right.get(new Random().nextInt(action_bottom_right.size()));

		Action random_action = actions.get(new Random().nextInt(actions.size()));

		if (p.getLocationState() == LocationState.DIRTY) {
//			System.out.println("SUCK------------------------------------------");
			return Environment.SUCK_DIRT;
		} else if (p.getAgentLocation().substring(0, p.getAgentLocation().indexOf("x") - 1).equals("0")) {
//			System.out.println("row 0");
			if (p.getAgentLocation().substring(p.getAgentLocation().indexOf("x") + 2, p.getAgentLocation().length())
					.equals("0")) {
//				System.out.println("row x col  0 x 0");
				return random_action_top_left;
			} else if (p.getAgentLocation()
					.substring(p.getAgentLocation().indexOf("x") + 2, p.getAgentLocation().length())
					.equals((Environment.envgrid[0].length - 1) + "")) {
//				System.out.println("row x col  0 x 4");
				return random_action_top_right;
			} else {
				return random_action_top;
			}

		} else if (p.getAgentLocation().substring(0, p.getAgentLocation().indexOf("x") - 1)
				.equals((Environment.envgrid.length - 1)+ "")) {
//			System.out.println("row 3");
			if (p.getAgentLocation().substring(p.getAgentLocation().indexOf("x") + 2, p.getAgentLocation().length())
					.equals("0")) {
//				System.out.println("row x col  3 x 0");
				return random_action_bottom_left;
			} else if (p.getAgentLocation()
					.substring(p.getAgentLocation().indexOf("x") + 2, p.getAgentLocation().length())
					.equals((Environment.envgrid[0].length - 1) + "")) {
//				System.out.println("row x col  3 x 4");
				return random_action_bottom_right;
			} else {
				return random_action_bottom;
			}

		} else if (p.getAgentLocation().substring(p.getAgentLocation().indexOf("x") + 2, p.getAgentLocation().length())
				.equals("0")) {
//			System.out.println("col 0");
			if (p.getAgentLocation().substring(0, p.getAgentLocation().indexOf("x") - 1).equals("0")) {
//				System.out.println("row x col  0 x 0");
				return random_action_top_left;
			} else if (p.getAgentLocation().substring(0, p.getAgentLocation().indexOf("x") - 1)
					.equals((Environment.envgrid.length - 1) + "")) {
//				System.out.println("row x col  3 x 0");
				return random_action_bottom_left;
			} else {
				return random_action_left;
			}
		} else if (p.getAgentLocation().substring(p.getAgentLocation().indexOf("x") + 2, p.getAgentLocation().length())
				.equals((Environment.envgrid[0].length - 1) + "")) {
//			System.out.println("col  4");
			if (p.getAgentLocation().substring(0, p.getAgentLocation().indexOf("x") - 1).equals("0")) {
//				System.out.println("row x col  0 x 4");
				return random_action_top_right;
			} else if (p.getAgentLocation().substring(0, p.getAgentLocation().indexOf("x") - 1)
					.equals((Environment.envgrid.length - 1) + "")) {
//				System.out.println("row x col  3 x 4");
				return random_action_bottom_right;
			} else {
				return random_action_right;
			}

		}
		return random_action;
	}
}