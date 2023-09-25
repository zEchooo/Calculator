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
	}


	public String show() {
		
		return "| \tMovie Name: " + movieName + 
				"\t\t\tDate and Time of Streaming: " + dateAndTime +
        "\n| \tTheater Venue Number: 1 \t\tSeat Capacity: " + seatCap + "\n| \tEntry Cutoff Time: " + cutOffTime;
		
	}
	
}
