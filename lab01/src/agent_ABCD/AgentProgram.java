package agent_ABCD;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.tools.DocumentationTool.Location;

import agent_ABCD.Environment.LocationState;

public class AgentProgram {

	public Action execute(Percept p) {
		List<Action> actions = new ArrayList<>();
		actions.add(Environment.MOVE_RIGHT);
		actions.add(Environment.MOVE_LEFT);
		actions.add(Environment.MOVE_UP);
		actions.add(Environment.MOVE_DOWN);

		Action random_action = actions.get(new Random().nextInt(actions.size()));

		if (p.getLocationState() == LocationState.DIRTY) {
			return Environment.SUCK_DIRT;
		} else if (p.getLocationState() == LocationState.CLEAN) {
			return random_action;
		}
		return NoOpAction.NO_OP;
	}
}