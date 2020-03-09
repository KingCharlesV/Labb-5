package Event;

public class stopevent { //Has Errors

		public stopevent() {
			time = 16.00;
		}
		public void Execute(SortedSequence SSeq, SimState SS) {
			StoreState.currentEvent = "STOP";
			SS.setRunning(false);
			StoreState STOSTA = (StoreState) SS;
			STOSTA.updateTotalQueueTime(this);
			STOSTA.observable(this);
		}
		
		
}
