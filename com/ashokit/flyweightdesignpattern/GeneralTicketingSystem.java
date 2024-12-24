package com.ashokit.flyweightdesignpattern;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;



interface Ticket {
    void bookTicket(String seatNumber);
    String getTicketInfo();
}

class MovieTicket implements Ticket {
    private String movieName;
    private String theaterName;
    private Date showTime;
    private String seatNumber;

    public MovieTicket(String movieName, String theaterName, Date showTime) {
        this.movieName = movieName;
        this.theaterName = theaterName;
        this.showTime = showTime;
    }

    public void bookTicket(String str) {
    	String[] tr=str.split("_");
    	for (int i = 0; i < tr.length; i++) {
			//booking ticket
		}
        this.seatNumber = seatNumber;
        System.out.println("Movie ticket booked for " + showTime + " for movie " + movieName + " at " + theaterName + " with seat number " + seatNumber);
    }

    public String getTicketInfo() {
        return "Movie ticket booked for " + showTime + " for movie " + movieName + " at " + theaterName + " with seat number " + seatNumber;
    }
}

class TrainTicket implements Ticket {
    private String trainName;
    private String source;
    private String destination;
    private Date travelDate;
    private String seatNumber;

    public TrainTicket(String trainName, String source, String destination, Date travelDate) {
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.travelDate = travelDate;
    }

    public void bookTicket(String seatNumber) {
        this.seatNumber = seatNumber;
        System.out.println("Train ticket booked for " + travelDate + " on Train " + trainName + " from " + source + " to " + destination + " with seat number " + seatNumber);
    }

    public String getTicketInfo() {
        return "Train ticket booked for " + travelDate + " on Train " + trainName + " from " + source + " to " + destination + " with seat number " + seatNumber;
    }
}

class TicketFactory1 {    	
	private static Map<String, Ticket> ticketCache = new HashMap<>();

	public static Ticket getTicket(String ticketType, String key, Date date) {
		Ticket ticket = ticketCache.get(ticketType);

		if (ticket == null) {
			if (ticketType.equals("MovieTicket")) {//->
				ticket = new MovieTicket(key.split("_")[0], key.split("_")[1], date);
			} else if (ticketType.equals("TrainTicket")) {//1
				ticket = new TrainTicket(key.split("_")[0], key.split("_")[1], key.split("_")[2], date);
			}
			ticketCache.put(ticketType, ticket);
		}

		return ticket;
	}

}

    public class GeneralTicketingSystem {
        public static void main(String[] args) {
            Date showTime = new Date();
            Date travelDate = new Date();

            Ticket ticket1 = TicketFactory1.getTicket("MovieTicket", "Avengers_InfinityWar_10am", showTime);
            ticket1.bookTicket("KGF_IMAX_11AM_A3");
            
            Ticket ticket4 = TicketFactory1.getTicket("MovieTicket", "RRR_InfinityWar_10am", showTime);
            ticket4.bookTicket("RRR_InfinityWar_10am_B2");

            Ticket ticket2 = TicketFactory1.getTicket("TrainTicket", "Rajdhani_Mumbai_Delhi", travelDate);
            ticket2.bookTicket("B3");

            Ticket ticket3 = TicketFactory1.getTicket("MovieTicket", "MissionImpossible_2pm", showTime);
            ticket3.bookTicket("A2");
        }
    }