package com.ashokit.mediatorpattern;

import java.util.ArrayList;
import java.util.List;

// Mediator Interface
interface ChatMediator {
    public void sendMessage(String message, User user);
    public void addUser(User user);
}

// Concrete Mediator
class ChatMediatorImpl implements ChatMediator {
    private List<User> users;

    public ChatMediatorImpl() {
        this.users = new ArrayList<User>();
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void sendMessage(String message, User sender) {
        for(User user : this.users) {
            // Send the message to all users except the sender
            if(user != sender) {
                user.receiveMessage(message);
            }
        }
    }
}

// Colleague
abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void sendMessage(String message);
    public abstract void receiveMessage(String message);
}

// Concrete Colleague
class ChatUser extends User {

    public ChatUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    public void sendMessage(String message) {
        System.out.println(this.name + " sends message: " + message);
        mediator.sendMessage(message, this);
    }

    public void receiveMessage(String message) {
        System.out.println(this.name + " receives message: " + message);
    }
}

// Usage
public class ChatApplication {

    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImpl();

        User user1 = new ChatUser(mediator, "Karthik");
        User user2 = new ChatUser(mediator, "Ravi");
        User user3 = new ChatUser(mediator, "Ajay");

        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);

        user1.sendMessage("Hello, everyone!");
        System.out.println("************");
        user2.sendMessage("How are you guys");
		/*
		 * user2.sendMessage("Hi, @Alice!"); user3.sendMessage("Hey, guys!");
		 */
    }

}

