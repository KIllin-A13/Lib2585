package org._2585robophiles.lib2585;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.SensorBase;

/**
 * Solenoid with relays going in opposite directions
 */
public class DoubleSolenoid extends SensorBase {

	private Relay relayOne, relayTwo;
	private boolean defaultState = true;

	/**
	 * init the the relays with the port numbers
	 * @param portOne port for the first relay
	 * @param portTwo port for the second relay
	 */
	public DoubleSolenoid(int portOne, int portTwo) {
		relayOne = new Relay(portOne);
		relayTwo = new Relay(portTwo);
	}

	/**
	 * init the two relays
	 * @param relayOne first relay
	 * @param relayTwo second relay
	 */
	public DoubleSolenoid(Relay relayOne, Relay relayTwo) {
		this.relayOne = relayOne;
		this.relayTwo = relayTwo;
	}

	/**
	 * toggles the relays
	 */
	public void toggle() {
		if (defaultState) {
			setRelayValues(Relay.Value.kForward, Relay.Value.kOff);
			defaultState = !defaultState;
		} else {
			setRelayValues(Relay.Value.kOff, Relay.Value.kForward);
			defaultState = !defaultState;
		}
	}

	/**
	 * set relay values
	 * @param relayOne the value to set the first relay to
	 * @param relayTwo the value to set the second relay to
	 */
	public void setRelayValues(Relay.Value relayOne, Relay.Value relayTwo) {
		this.relayOne.set(relayOne);
		this.relayTwo.set(relayTwo);
	}

	/*
	 * (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.SensorBase#free()
	 */
	public void free() {
		this.relayOne.free();
		this.relayTwo.free();
	}

	/**
	 * @return returns the state of pneumatics (default or not default)
	 */
	public boolean isDefaultState() {
		return defaultState;
	}

	/**
	 * @param defaultState state of pneumatics
	 */
	protected void setDefaultState(boolean defaultState) {
		this.defaultState = defaultState;
	}

}