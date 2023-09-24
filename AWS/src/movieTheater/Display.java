package movieTheater;


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
		System.out.println("commit try");//commit try
	}


	public String show() {
		
		return "Movie Name: " + movieName + 
				"\nDate and Time of Streaming: " + dateAndTime +
        "\nTheater Venue Number: 1 \nSeat Capacity: " + seatCap + "\nEntry Cutoff Time: " + cutOffTime;
		
	}
	
}
