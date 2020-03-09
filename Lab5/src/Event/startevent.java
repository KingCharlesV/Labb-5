package Event;

import java.simulator.Event;
import java.simulator.State;
import java.simulator.EventQueue;


public class startevent extends Event{ //Has Errors
	
	public startevent(SimState SS) {
		time = 0.00;
		
		
	}

	
	public void Execute (SortedSequence SSeq, SimState SS) {//metoden Execute som kör allt.
		StoreState.currentEvent = "START!" ;
		SS.setRUNNING(true);
		SSeq.sortEvents(new Arrival(SSeq, SS));
		SS.observable(this);
	}
}
