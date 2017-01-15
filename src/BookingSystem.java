package bookingSystem;


import java.util.HashMap;


public class BookingSystem {
	private HashMap<String, Theatre> theatre;
	private HashMap<String, Ticket> bookings; 
	
	
	
	public BookingSystem() {
		theatre = new HashMap<>();
		bookings = new HashMap<>();
		theatre.put("Saal 1", new Theatre(10,15,true));
		theatre.put("Saal 2", new Theatre(14,20,false));
		
	}
	
	public String deleteBooking(String name){
		
		Ticket theFacts = bookings.get(name);
		if(theFacts != null){
			Show theShow = getTheShow(theFacts.getShowName(), theFacts.getTime());
			int[] returnSeats = theFacts.getReserve();
			int theRow = returnSeats[0];
			int startCol = returnSeats[1];
			int numberSeats = returnSeats[2];
			
			for(int i = startCol; i < numberSeats+startCol; i++){
				theShow.getSeats()[theRow][i] = true;
				
			}
			return "Buchung wurde gelöscht";
		}
		else return "Du hast überhaupt keine Buchungen";
		
		
	}
	
	
	public String requestBooking(Customer name, String showName, String time, int seats){
		// looks if the desired movie was found
		if(!findMovie(showName, time).contains("Show not found")){
			Show theShow = getTheShow(showName, time);
			double price;
			// looks if a show was found
			if(theShow != null) price = theShow.getPrice();
			else return "Show nicht gefunden.";
			// looks if the Customer object has enough money
			if(name.getMoney() >= seats * price && !(bookings.containsKey(name.getName()))){
				int[] reserve = theShow.bookSeats(seats);
				
				if(!(reserve[0] == -1 )){
					bookings.put(name.getName(), new Ticket(name.getName(), name.getTel(), showName, time, reserve));
					name.setMoney(price);
					return "Die Buchung ist erfolgt. " + reserve[0] + reserve[1] + reserve[2] + " " + name.getName();
					
				} else return "Es gibt keine " + seats + " freien Plätze mehr.";
			} else return "Du hast nicht genug Geld oder du hast bereits Tickets gekauft.";
				

		} else return "Die gewünschte Show wird zu der angegebenen Zeit nirgends gezeigt";
		
		
	}
	
	// returns the requested Show object
	public Show getTheShow(String showName, String time){
		Theatre foundShow = theatre.get(findMovie(showName, time));
		if(foundShow != null){
		return foundShow.getShow(showName);
		}
		else return null;
	}
	
	// Searches for a movie with a specific time in all Theatre objects
	// returns the Theatre that shows the movie
	public String findMovie(String name, String time){
		for(int i = 1; i<theatre.size()+1; i++){
			Theatre theOne = theatre.get("Saal " + i);
			if(theOne != null){
			boolean yn = theOne.showAvailable(name, time);
			if(yn) return "Saal " + i;
			}
		}
		return "Show not found";
	}
	

	public HashMap<String, Theatre> getTheatre() {
		return theatre;
	}


	public static void main(String[] args) {
		BookingSystem bookingSystem = new BookingSystem();
		bookingSystem.getTheatre().get("Saal 1").setShow("Herr der Dinge", "10:00 Uhr");
		bookingSystem.getTheatre().get("Saal 1").setShow("Bedman", "12:00 Uhr");
		bookingSystem.getTheatre().get("Saal 2").setShow("Iron Can", "10:00 Uhr");
		bookingSystem.getTheatre().get("Saal 2").setShow("Chopperman", "12:00 Uhr");
		
		Customer peter = new Customer("Peter Schmidt", "0162 579265", 500.50);
		Customer dieter = new Customer("Dieter Müller", "0162 456469", 200.50);
		Customer butz = new Customer("Butz Duh", "0162 456469", 400.50);
		
		String doIt = bookingSystem.requestBooking(peter, "Bedman", "12:00 Uhr", 5);
		System.out.println(doIt);
		String doIt2 = bookingSystem.requestBooking(dieter, "Bedman", "12:00 Uhr", 12);
		System.out.println(doIt2);
		String doIt3 = bookingSystem.requestBooking(butz, "Chopperman", "12:00 Uhr", 5);
		System.out.println(doIt3);
		
		System.out.println(bookingSystem.deleteBooking("Dieter Müller"));
		
		
		String printSeats = bookingSystem.getTheShow("Bedman", "12:00 Uhr").printAvailableSeats();
		System.out.println(printSeats);


		
		
	}

}
