package simulator;

public  abstract class Event {
private State currentState;
private EventQueue currentQueue;
private double currentTime;
	
//L�gg till jmf. med andra
//Denna tar jag
//SupermarketState & Supermarketview, fr�ga om formatering
//Suggestion

	public State getCurrentState() {
		return currentState;
	}

	public EventQueue getCurrentQueue() {
		return currentQueue;
	}

	public double  getCurrentTime () {
		return currentTime;
	}
	
	public void setTime(double time) {
		this.currentTime = time;				//Added
	}
	
		
	public abstract void execute() ;
	//Added
}



