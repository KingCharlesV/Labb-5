package Event;

import java.simulator.Event;
import java.simulator.State;
import java.simulator.EventQueue;


public class arrival  extends Event{ //Has Errors

	public Store store;
	StoreState STOSTA;
	private double leadTime;
	
	public Arrival(SortedSequence SSeq,SimState SS) {
		STOSTA = (StoreState SSeq,SimState SS){
		this.customer = CustomerFactory.newCostumer();
		time = STOSTA.newEventTime();

		}
	
	public void Execute()
	
		StoreState.currentEvent = "ARRIVE";
		SSeq.sortEvents(new Arrive(SSeq,SS));
		STOSTA.updateTotalQueueTime(this);
		
		if(StoreState.fastAvalibale()) {
			store.previousCheckout = "Fast";
			storeTime = STOSTA.getFastCheckoutTime();
			SSeq.sortEvent(new Leave(STOSTA,store,time,storeTime));
			STOSTA.updateTotalIdleTime(this);
			STOSTA.observable(this);
			StoreState.avaliableFastCheckouts--;
			
		}else if(StoreState.slowAvaliable()) {
			customer.previousCheckout = "Slow";
			checkoutTime = STOSTA.getSlowCheckoutTime();
			SSeq.sortEvents(new Leave(STOSTA,customer,time,checkoutTime));
			STOSTA.updateTotalIdleTime(this);
			STOSTA.observable(this);
			StoreState.avaliableSlowCheckouts--;
			
			//Förslag på konvertering CarWashState => CheckoutSrae
		
		}else if(StoreState.fastAvaliable() == false && StoreState.slowAvaliable() == false) && FIFO.customerCustomerQueue.size()<FIFO.maxSize()){
			customer.previousCheckout = "FIFO";
			STOSTA.observable(this);
			FIFO.add(new Leave(STOSTA,customer,time,checkoutTime));
		
		}else {
			STOSTA.observable(this);
			StoreState.rejectedCustomers++;
			
			
				
			}
					
		}
	
	}
}
