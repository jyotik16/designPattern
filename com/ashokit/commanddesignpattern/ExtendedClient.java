package com.ashokit.commanddesignpattern;



//Client code
public class ExtendedClient {
 public static void main(String[] args) {
     Account account1 = new Account();
     Account account2 = new Account();
     TransactionLayer bank = new TransactionLayer();

     BankCommand depositCommand = new DepositCommand(account1, 1000);
     BankCommand transferCommand = new TransferCommand(account1, account2, 500);

     bank.executeCommand(depositCommand);
     bank.executeCommand(transferCommand);

     bank.showCommandHistory();
 }
}


//Concrete Command 3: TransferCommand
 class TransferCommand implements BankCommand {
 private final Account fromAccount;
 private final Account toAccount;
 private final double amount;

 public TransferCommand(Account fromAccount, Account toAccount, double amount) {
     this.fromAccount = fromAccount;
     this.toAccount = toAccount;
     this.amount = amount;
 }

 @Override
 public void execute() {
     fromAccount.withdraw(amount);
     toAccount.deposit(amount);
     System.out.println(amount + " transferred from account " + fromAccount + " to account " + toAccount);
 }
}

