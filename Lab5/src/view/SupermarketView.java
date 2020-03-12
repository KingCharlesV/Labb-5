package view;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import jaba.util.Observable;
import lab5.simulator.Event;
import lab5.simulator.SimState;
import lab5.simulator.Simview;
import lab5.state.SupermarketState;


public class SupermarketView extends Simview{
	//Kom ihåg att ändra formateringen delar av denna klass.
	
	StoreState STOSTA;
	Store store;
	}
	public SupermarketView(SimState STOSTA) {
		super(STOSTA);
	}
	/**
	 * Javadoc comments
	 * @param
	 */
	public void initialPrint() {
		System.out.println("Fast Checkouts: "+ StoreState.getGrossFastCheckouts());
		System.out.println("Slow Checkouts: "+ StoreState.getGrossSlowCheckouts());
		System.out.println("Fast Distribution: ("+StoreState.spreadFastInferior+","+StoreState.spreadFastSuperior+")");
		System.out.println("Slow Distribution: ("+StoreState.spreadSlowInferior+","+StoreState.spreadSlowSuperior+")");
		System.out.println("Exponential distribution with lambda = "+StoreState.lambda);
		System.out.println("Seed = " + StoreState.seed);
		System.out.println("Max queue size: "+ StoreState.maxQueueSize);
		System.out.println("------------------------------------------");
		System.out.println("%5s %10s %8s %12s %14s %15s %15s %14s\n","Time","Fast","Slow","ID","Event","QueueTime","QueueSize","Rejected");
	}
	public void update(Observable obs, Object obj) {
		NumberFormat fmt = new DecimalFormat("#0.00");
		Event temp = (Event) obj;
		
		if(temp instanceof Start) {
			System.out.printf("%-5s %11s %9s %13s %15s %16s %16s %15s\n,",
					fmt.format(temp.time),
					StoreState.avaliableFastCheckouts,
					StoreState.avaliableSlowCheckouts,
					"-",
					"stop",
					fmt.format(StoreState.grossIdleTime),
					fmt.format(StoreState.grossQueueTime),
					FIFO.getSize(),
					StoreState.declinedCustomers());
		}
		if(temp instanceof arrival) {
			arrival temp2 = (arrival) temp;
			System.out.printf("%-5s %11s %9s %13s %15s %16s %16s %15s\n,",
			fmt.format(temp.time),
			StoreState.avaliableFastCheckouts,
			StoreState.avaliableSlowCheckouts,
			temp2.store.storeID(),
			//"ID",
			"Arrive",
			fmt.format(StoreState.grossIdleTime),
			fmt.format(StoreState.grossQueueTime),
			FIFO.getSize(),
			StoreState.declinedCustomers());
		}
		if(temp instanceof leave) {
			leave temp2 = (leave) temp;
			System.out.printf("%-5s %11s %9s %13s %15s %16s %16s %15s\n,",
			fmt.format(temp.time),
			StoreState.avaliableFastCheckouts,
			StoreState.avaliableSlowCheckouts,
			FIFO.getSize(),
			StoreState.declinedCustomers());
		}
		/*
		 * System.out.prinf works like this 
		 */
		public void finaleprint() {
			NumberFormat fmt = new DecimalFormat("#0.00");
			System.out.println("-------------------------------------------------");
			System.out.println("Average queueing time: " + fmt.format(StoreState.grossIdleTime/(CustomerFactory.amounOfCustomers() - StoreState.declinedCustomers())));
			System.out.println("Gross queueing time: " + fmt.format(StoreState.grossQueueTime));
			System.out.println("Total idle checkout time: " + fmt.format(StoreState.grossIdleTime));
			System.out.println("Declined Customers: " + StoreState.declinedCustomers());
		}
	
}
