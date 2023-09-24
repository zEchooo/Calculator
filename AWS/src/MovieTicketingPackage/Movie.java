package MovieTicketingPackage;

class Movie {
    private String name;
    private String dateAndTime;
    private int seatingCapacity;
    private int vipSeats;
    private int standardSeats;
    private int generalSeats;
    private String entryCutoffTime;
    private int[] seatAvailability;
    private Person[] seatOccupancy;
    private static final int MAX_TICKETS_PER_PERSON = 5;

    public Movie(String name, String dateAndTime, int vipSeats, int standardSeats, int generalSeats, String entryCutoffTime) {
        this.name = name;
        this.dateAndTime = dateAndTime;
        this.vipSeats = vipSeats;
        this.standardSeats = standardSeats;
        this.generalSeats = generalSeats;
        this.entryCutoffTime = entryCutoffTime;
        this.seatingCapacity = vipSeats + standardSeats + generalSeats;
        this.seatAvailability = new int[seatingCapacity];
        this.seatOccupancy = new Person[seatingCapacity];
    }

    public String getName() {
        return name;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public int getVipSeats() {
        return vipSeats;
    }

    public int getStandardSeats() {
        return standardSeats;
    }

    public int getGeneralSeats() {
        return generalSeats;
    }

    public String getEntryCutoffTime() {
        return entryCutoffTime;
    }

    public boolean isSeatOccupied(int seatNumber) {
        return seatAvailability[seatNumber - 1] == 1;
    }
    
    public boolean isValidSeatForTicketType(int seatNumber, String ticketType) {
        if ("VIP".equalsIgnoreCase(ticketType)) {
            return seatNumber >= 1 && seatNumber <= vipSeats;
        } else if ("Standard".equalsIgnoreCase(ticketType)) {
            return seatNumber >= 51 && seatNumber <= 80;
        } else if ("General Admission".equalsIgnoreCase(ticketType)) {
            return seatNumber >= 81 && seatNumber <= seatingCapacity;
        }
        return false;
    }
    
    public boolean isValidSeat(int seatNumber) {
        return seatNumber >= 1 && seatNumber <= seatingCapacity;
    }

    public boolean isSeatAvailable(int seatNumber) {
        return seatAvailability[seatNumber - 1] == 0;
    }

    public void reserveSeat(int seatNumber, Person person) {
        if (isValidSeat(seatNumber) && isSeatAvailable(seatNumber)) {
            seatAvailability[seatNumber - 1] = 1;
            seatOccupancy[seatNumber - 1] = person;
        }
    }

    public boolean canReserveMoreTickets(Person person) {
        int reservedTicketsCount = 0;
        for (int seatStatus : seatAvailability) {
            if (seatStatus == 1) {
                reservedTicketsCount++;
            }
        }
        return reservedTicketsCount < MAX_TICKETS_PER_PERSON;
    }

    public void displayOccupancy() {
        System.out.println("\nSeat Occupancy:");
        for (int i = 0; i < seatingCapacity; i++) {
            if (seatOccupancy[i] != null) {
                System.out.println("Seat " + (i + 1) + ": Occupied by " + seatOccupancy[i].getName());
            } else {
                System.out.println("Seat " + (i + 1) + ": Available");
            }
        }
    }
}
