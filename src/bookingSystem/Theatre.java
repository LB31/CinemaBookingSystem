package bookingSystem;

import java.util.ArrayList;

public class Theatre {
	private ArrayList<Show> shows;
	private boolean[][] seats;
	





	public Theatre(int rows, int cols, boolean less) {
		shows = new ArrayList<>();
		seats = new boolean[rows][cols];
		createSeats(rows, cols, less);
	}
	
	
	
	
	public boolean[][] getSeats() {
		return seats;
	}
	
	public void createSeats(int rows, int cols, boolean less){
		int lessSeats = 0;
		for(int i = 0; i < rows; i++){
			if(less){	
				lessSeats = (i%2 != 0) ? 2 : 0;			
			}
			for(int k = 0; k < cols-lessSeats; k++){
				seats[i][k] = true;
			}
		}
		
	}
	
	
	public void setShow(String name, String time){
		shows.add(new Show(name, time, seats));	
		
	}
	
	// returns a requested Show object
	public Show getShow(String name){
		for(int i = 0; i<shows.size(); i++){
			if(shows.get(i).getName().equals(name)) return shows.get(i);
		}
		return null;
		 
		
	}
	
	public boolean showAvailable(String name, String time){
		for(int i = 0; i < shows.size(); i++){
		if(shows.get(i).getName() == name && shows.get(i).getTime() == time) return true;
		}
		return false;
		
	}
	
	
	
	

	public static void main(String[] args) {
//		Theatre test = new Theatre(10,15,false);
//		test.setShow("Bal", "15");
//		
//		System.out.println(test.shows.get(0).bookSeats(4));
//		System.out.println(test.shows.get(0).bookSeats(3));
//		System.out.println(test.shows.get(0).bookSeats(8));
//		System.out.println(test.shows.get(0).bookSeats(4));
//		System.out.println(test.shows.get(0).bookSeats(15));

	}

}
