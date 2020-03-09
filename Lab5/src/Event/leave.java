package Event;

import java.simulator.Event;
import java.simulator.State;
import java.simulator.EventQueue;


public class leave extends Event{ //Has Errors
	
	StoreState STOSTA;
	public Customer customer;
	
	public Leave(SimState SS, Customer customer, double time, double checkoutTime) {
		this.customer = customer;
		this.time = time + checkoutTime;
		STOSTA = (StoreState) SS;
		
	}
	public void Execute(SortedSequence SSeq, SimState SS) {
		STOSTA = (StoreState) SS;
	
			CheckoutState.currentEvent = "Leave";
			STSOSTA.updateTotalQueueTime(this);
			
			if(car.previousCheckout().equals("Fast")) {
				StoreState.avaliableFastCheckout++;
				if(FIFO.isEmpty() == false) {
					Leave firstInLine = (Leave) FIFO.getFirst();
					FIFO.removeFirst();
					
					firstInLine.time = this.time + STOSTA.getSlowCheckoutTime();
					firstInLine.customer.previousCheckout = "Slow";
					CheckoutState.avaliableSlowCheckouts--;
					SSeq.sortEvents(firstInLine);
					CWS.observable(this);
					
				}
			}
		
	}
	

}
