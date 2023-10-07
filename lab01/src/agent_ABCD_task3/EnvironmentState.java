package agent_ABCD_task3;

import java.util.HashMap;
import java.util.Map;

import agent_ABCD_task3.Environment.LocationState;

public class EnvironmentState {
	Map<String, Environment.LocationState> state = new HashMap<String, Environment.LocationState>();
	private String agentLocation = null;//

	public EnvironmentState(LocationState[][] locationStates) {
		for (int row = 0; row < locationStates.length; row++) {
			for (int col = 0; col < locationStates[0].length; col++) {
				this.state.put(row + " x " + col, locationStates[row][col]);
			}
		}
		
	}

	public void setAgentLocation(String location) {
		this.agentLocation = location;
	}

	public String getAgentLocation() {
		return this.agentLocation;
	}

	public LocationState getLocationState(String location) {
		return this.state.get(location);
	}

	public void setLocationState(String location, LocationState locationState) {
		this.state.put(location, locationState);
	}

	public void display() {
		System.out.println("Environment state: \n\t" + this.state);
	}
}