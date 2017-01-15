package bookingSystem;

public class Show {
	private String name;
	private String time;
	private double price = 8.50;
	private boolean[][] seats;
	
	
	
	public boolean[][] getSeats() {
		return seats;
	}

	public void setSeats(boolean[][] seats) {
		this.seats = seats;
	}

	public Show(String name, String time, boolean[][] seats) {
		this.name = name;
		this.time = time;
		this.seats = seats;
	}

	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}







	public String getName() {
		return name;
	}

	
	
	public String getTime() {
		return time;
	}

	public int[] bookSeats(int numberOfSeats){
		int moreSeats = numberOfSeats;
		int[] madeIt = new int[3];
		madeIt[0] = -1;
		for(int i = 0; i < seats.length; i++){		
			int lengthCols = seats[i].length; 	
			for(int k = 0; k < lengthCols ; k++){
				if(seats[i][k] && (lengthCols - k) >= moreSeats && moreSeats > 0){
					seats[i][k] = false;
					moreSeats--;
					madeIt[0] = i;
					madeIt[1] = k-numberOfSeats+1;
					madeIt[2] = numberOfSeats;
					// madeIt = "Reihe " + i + "; ab Platz " + (k-numberOfSeats+1) + "; " + numberOfSeats + " reservierte Plätze";
				}
				
				}
			}
		
		return madeIt;
		
	}
	
	public String printAvailableSeats(){
		String seatPicture = "";
		for(int i = 0; i < this.seats.length; i++){
			seatPicture += "\n";
			for(int k = 0; k < this.seats[i].length; k++){
				if(seats[i][k]){
					seatPicture += "["+ k + "]";
					
				}
			}
		}
		return seatPicture;
		
	}

	
	
	public static void main(String[] args) {
		
	}



	
	
	
	
}
