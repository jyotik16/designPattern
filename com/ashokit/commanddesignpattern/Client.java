package com.ashokit.commanddesignpattern;

import java.util.ArrayList;
import java.util.List;


//Command interface
interface BankCommand {
 void execute();
}

//Concrete Command 1: DepositCommand
 class DepositCommand implements BankCommand {
 private final Account account;
 private final double amount;

 public DepositCommand(Account account, double amount) {
     this.account = account;
     this.amount = amount;
 }

 @Override
 public void execute() {
     account.deposit(amount);
 }
}

//Concrete Command 2: WithdrawCommand
 class WithdrawCommand implements BankCommand {
 private final Account account;
 private final double amount;

 public WithdrawCommand(Account account, double amount) {
     this.account = account;
     this.amount = amount;
 }

 @Override
 public void execute() {
     account.withdraw(amount);
 }
}

//Receiver class: Account
 class Account {
 private double balance;

 public void deposit(double amount) {
     balance += amount;
     System.out.println(amount + " deposited. New balance is " + balance);
 }

 public void withdraw(double amount) {
     if (balance < amount) {
         System.out.println("Insufficient funds");
         return;
     }
     balance -= amount;
     System.out.println(amount + " withdrawn. New balance is " + balance);
 }

 public double getBalance() {
     return balance;
 }
}

//Invoker class: Bank
class TransactionLayer {
 private final List<BankCommand> commandHistory = new ArrayList<>();

 public void executeCommand(BankCommand command) {
     command.execute();
     commandHistory.add(command);
 }

 public void showCommandHistory() {
     for (BankCommand command : commandHistory) {
         System.out.println(command.getClass().getSimpleName());
     }
 }
}

//Client code
public class Client {
 public static void main(String[] args) {
     Account account = new Account();
     TransactionLayer transaction = new TransactionLayer();

     BankCommand depositCommand = new DepositCommand(account, 1000);
     BankCommand withdrawCommand = new WithdrawCommand(account, 500);

     transaction.executeCommand(depositCommand);
     transaction.executeCommand(withdrawCommand);

     transaction.showCommandHistory();
 }
}


