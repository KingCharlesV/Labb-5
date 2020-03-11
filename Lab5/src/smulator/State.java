package simulator;
import java.util.Observable;

public class State extends Observable {
	private double timeAggregate = 0;
	private boolean runnning = true;

	public State() {
	}

	public boolean runNextEvent() {

		return runnning;
	}
	
	public void stop() {
		runnning = false;
	}

	public void updateTimeAggregate(double addedTime) {
		timeAggregate = timeAggregate +addedTime;
	}
	
	public void updateObservers(Event event) {
		setChanged();
		notifyObservers(event);
	}
	
	public boolean isRunning() {
		return runnning;
	}
}