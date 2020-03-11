package state;

import lab5.random.ExponentialRandomStream;
import lab5.random.UniformRandomStream;
import lab5.simuator.Event;
import lab5.simulator.SimState;

public class SuperMarketState extends SimState{
	/**
	 * Static variables is introduced.
	 * 
	 * First set: Gross amount of checkouts and the avaliable amount of checkouts.
	 * Second set: Upper & Lower quartile value of slow and fast checkouts.
	 *Third set: Self Explaining 
	 *Fourth set: Self Explaining
	 *Fifth set: S
	 * @param
	 */
	private static int grossFastCheckouts = 2;
	private	static int grossSlowCheckouts = 2;
	static int	avaliableFastCheckouts = 2;
	static int	avaliableSlowCheckouts = 2;
	
	static double spreadFastInferior = 1.0;
	static double spreadFastSuperior = 4.0;
	static double spreadSlowInferior = 3.0;
	static double spreadSlowSuperior = 6.0;
	
	static double currentTime = 0.00;
	
	static double grossQueueTime = 0.00;
	static double grossIdleTime = 0.00;
	
	static double formerCurrentTime = 0.00;
	static double formerGrossQueueTime = 0.00;
	
	static double lambda = 4; //Increase uniqueness
	static int seed = 1234;
	
	private UniformRandomStream slowCheckoutTime = new UniformRandomStream(spreadSlowInferior,spreadSlowSuperior,seed);
	private	UniformRandomStream fastCheckoutTime = new UniformRandomStream(spreadFastInferior,spreadFastSuperior,seed);
	private ExponentialRandomStream timeToNextCustomerArrival = new ExponentialRandomStream(lambda,seed);
	
	double	novelEventTime() {
		currentTime += timeToNextCustomerArrival.next();
		return currentTime;
	}
	double getFastCheckoutTime() {
		return fastCheckoutTime.next();
	}	
	double getSlowCheckoutTime() {
		return slowCheckoutTime.next();
		
	}
	void updateGrossIdleTime(Event evt) {
		grossIdleTime += (evt.time - formerCurrentTime) * (avaliableFastCheckouts + avaliableSlowCheckouts);
		formerCurrentTime = evt.time;
	}
	static boolean fastCheckoutsAvaliable() {
		return (avaliableCheckouts > 0) ? true:false;
	}
	static boolean slowAvaliable() {
		return (avaliableSlowCheckouts > 0) ? true:false;
	}
	static int getGrossSlowCheckouts() {
		return grossSlowCheckouts;
	}
	
	static int getGrossFastCheckouts() {
		return grossFastCheckouts;
	}
	
	static int declinedCustomers() {
		return declinedCustomers;
	}
	
	
	
	

}
