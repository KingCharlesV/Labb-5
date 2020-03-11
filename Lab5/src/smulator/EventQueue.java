package simulator;
import java.util.ArrayList;
import java.util.NoSuchElementException;

//Lägg til exempelvis en size metoden 
public class EventQueue {
	public ArrayList<Event> eventQueue = new ArrayList<>();

	public void addEvent(Event event) {
		eventQueue.add(event);
	}

	public Event firstInLine() throws NoSuchElementException {
		if (eventQueue.isEmpty()== true) {
			throw new NoSuchElementException();
		}

		else {
			return eventQueue.get(0);
		}
	}

	public void removeEvent()throws NoSuchElementException {
		if (eventQueue.isEmpty()) {
			System.out.println("no objects in queue");
			throw new NoSuchElementException();
		}

		else {
			eventQueue.remove(0);
		}
	}

	public boolean hasNext() {
		return false;
	}
	}
