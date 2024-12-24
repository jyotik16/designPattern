package com.ashokit.compositepattern;

import java.util.HashMap;
import java.util.Map;

// Flyweight interface
interface Ticket {
    void sell();
}

// Concrete Flyweight class
class MovieTicket implements Ticket {
    private String movieName;
    private String theater;
    private double price;

    public MovieTicket(String movieName, String theater, double price) {
        this.movieName = movieName;
        this.theater = theater;
        this.price = price;
    }

    @Override
    public void sell() {
        System.out.println("Movie Ticket for " + movieName + " at " + theater + " sold for $" + price);
    }
}

// Flyweight Factory class
class TicketFactory {
    private Map<String, Ticket> tickets = new HashMap<>();

    public Ticket getTicket(String movieName, String theater, double price) {
        String key = movieName + theater;
        Ticket ticket = tickets.get(key);

        if (ticket == null) {
            ticket = new MovieTicket(movieName, theater, price);
            tickets.put(key, ticket);
        }

        return ticket;
    }
}

// Client class
public class TicketingSystem {
    public static void main(String[] args) {
        TicketFactory ticketFactory = new TicketFactory();

        Ticket ticket1 = ticketFactory.getTicket("Avengers: Endgame", "Regal Cinemas", 12.50);
        ticket1.sell();

        Ticket ticket2 = ticketFactory.getTicket("Avengers: Endgame", "AMC Theatres", 13.50);
        ticket2.sell();

        Ticket ticket3 = ticketFactory.getTicket("Joker", "Regal Cinemas", 11.50);
        ticket3.sell();

        Ticket ticket4 = ticketFactory.getTicket("Joker", "AMC Theatres", 12.50);
        ticket4.sell();
    }
}

