package com.ashokit.interpreter;
import java.util.List;

interface Expression1 {
    boolean interpret(Account account);
}

class WithdrawalAmountExpression implements Expression1 {
    private final String comp;
    private final double amount;

    public WithdrawalAmountExpression(String comp, double amount) {
        this.comp = comp;
        this.amount = amount;
    }

    public boolean interpret(Account account) {
        double sum = account.getWithdrawalSum();
        switch (comp) {
            case "<":
                return sum < amount;//return 100<500 ->true
            case ">":
                return sum > amount;
            case "=":
                return sum == amount;
            default:
                return false;
        }
    }
}

class TransactionCountExpression implements Expression1 {
    private final String comp;
    private final int count;

    public TransactionCountExpression(String comp, int count) {
        this.comp = comp;
        this.count = count;
    }

    public boolean interpret(Account account) {
        int transactionCount = account.getTransactionCount();
        switch (comp) {
            case "<":
                return transactionCount < count;
            case ">":
                return transactionCount > count;
            case "=":
                return transactionCount == count;
            default:
                return false;
        }
    }
}

class Account {
    private final List<Double> withdrawalAmounts;
    private final int transactionCount;

    public Account(List<Double> withdrawalAmounts, int transactionCount) {
        this.withdrawalAmounts = withdrawalAmounts;
        this.transactionCount = transactionCount;
    }

    public double getWithdrawalSum() {
        return withdrawalAmounts.stream().mapToDouble(Double::doubleValue).sum();
    }

    public int getTransactionCount() {
        return transactionCount;
    }
}

class SuspiciousTransactionExpression {
    private final Expression1 expression;

    public SuspiciousTransactionExpression(String expressionStr) {
        String[] parts = expressionStr.split(" ");
        String field = parts[0];
        String comp = parts[1];
        double value = Double.parseDouble(parts[2]);

        switch (field) {
            case "withdrawalAmount":
                expression = new WithdrawalAmountExpression(comp, value);
                break;
            case "transactionCount":
                expression = new TransactionCountExpression(comp, (int) value);
                break;
            default:
                expression = null;
        }
    }

    public boolean interpret(Account account) {
        if (expression == null) {
            return false;
        } else {
            return expression.interpret(account);
        }
    }
}

public class BankingInterpreterExample {
    public static void main(String[] args) {
        Account account1 = new Account(List.of(100.0, 200.0, 300.0), 3);
        SuspiciousTransactionExpression expression1 = new SuspiciousTransactionExpression("withdrawalAmount > 500");
        System.out.println("Expression 1: " + expression1.interpret(account1));

        Account account2 = new Account(List.of(50.0, 75.0, 100.0), 5);
        SuspiciousTransactionExpression expression2 = new SuspiciousTransactionExpression("transactionCount > 10");
        System.out.println("Expression 2: " + expression2.interpret(account2));
    }
}

