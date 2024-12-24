import java.math.BigDecimal;


abstract class BankTransaction {
    public final void execute() {
        // Perform common steps
        authenticate();
        validateInputs();

        // Perform transaction-specific steps
        performTransaction();

        // Perform common cleanup
        updateTransactionLog();
        notifyUser();
    }

    protected void authenticate() {
        System.out.println("Authenticating user...");
        // Authenticate user
    }

    protected abstract void validateInputs();

    protected abstract void performTransaction();

    protected void updateTransactionLog() {
        System.out.println("Updating transaction log...");
        // Log transaction details
    }

    protected void notifyUser() {
        System.out.println("Notifying user...");
        // Send notification to user
    }
}

 class DepositTransaction extends BankTransaction {
    private Account account;
    private BigDecimal amount;

    public DepositTransaction(Account account, BigDecimal amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    protected void validateInputs() {
        System.out.println("Validating deposit inputs...");
        // Validate deposit inputs
    }

    @Override
    protected void performTransaction() {
        System.out.println("Performing deposit transaction...");
        // Perform deposit transaction
        account.deposit(amount);
    }
}

class WithdrawTransaction extends BankTransaction {
    private Account account;
    private BigDecimal amount;

    public WithdrawTransaction(Account account, BigDecimal amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    protected void validateInputs() {
        System.out.println("Validating withdrawal inputs...");
        // Validate withdrawal inputs
    }

    @Override
    protected void performTransaction() {
        System.out.println("Performing withdrawal transaction...");
        // Perform withdrawal transaction
        account.withdraw(amount);
    }
}

public class TemplateDesignPattern {
    public static void main(String[] args) {
        Account account = new Account("1234567890", new BigDecimal("1000.00"));

        BankTransaction deposit = new DepositTransaction(account, new BigDecimal("500.00"));
        deposit.execute();

        BankTransaction withdraw = new WithdrawTransaction(account, new BigDecimal("200.00"));
        withdraw.execute();
    }
}

class Account {
    private String accountNumber;
    private BigDecimal balance;

    public Account(String accountNumber, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        balance = balance.subtract(amount);
    }
}

