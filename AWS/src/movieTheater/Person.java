package movieTheater;
//this class defines and sets the variables and methods to be used for the customer/Person
//second try for connection
class Person {	
    private String name; 
    private int seatNumber;
    private boolean ticketPurchased = false;

    public Person(String name, int seatNumber) {
        this.name = name;
        this.seatNumber = seatNumber;
    }

    public void purchaseTicket() {
        this.ticketPurchased = true;
    }

    public boolean hasTicket() {
        return ticketPurchased;
    }

    public String getName() {
        return name;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    
    @Override
    public String toString() {
        return "Name: " + name + "\nSeat Number(s): " + seatNumber;//fixed seat cap
    }
}