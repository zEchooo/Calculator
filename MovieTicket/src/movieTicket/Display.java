package movieTicket;

public class Display {
	int seatCap;
	String movieName;
	String cutOffTime;
	String dateAndTime;
	
	public Display(int seatCap, String movieName, String cutOffTime,String dateAndTime) {
		
		this.seatCap = seatCap;
		this.movieName = movieName;
		this.cutOffTime = cutOffTime;
		this.dateAndTime = dateAndTime;
		
	}


	public String show() {
		
		return "Movie Name: " + movieName + 
				"\nDate and Time of Streaming: " + dateAndTime +
        "\nTheater Venue Number: 1 \nSeat Capacity: " + seatCap + "\nEntry Cutoff Time: " + cutOffTime;
		
	}
	
}

