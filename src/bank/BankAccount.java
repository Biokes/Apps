package bank;
import java.util.ArrayList;

public class BankAccount {
    private final String accountName;
    private String pin;
    private int accountNumber;

    private final ArrayList<Double> transactionRecords = new ArrayList<>();

    public BankAccount(String name, String pin){
        validatePin(pin);
        this.accountName = name;
        this.accountNumber = 0;
    }
    public int checkAccountNumber() {

        return this.accountNumber;
    }

    private void validatePin(String pin){
        if (pin.length() != 4 && !pin.matches("\\d+"))
            throw new IllegalArgumentException("pls set a valid pin.");
        this.pin = pin;
    }

    public void deposit(double number) throws InvalidAmountException {
        if(number < 0)
            throw new InvalidAmountException("invalid deposit amount.");
        transactionRecords.add(number);
    }

//    public int getAccountNumber(String pin) {
//        if(this.pin.equals(pin))
//            return countUsers;
//        throw new InvalidPinException("Incorrect pin.");
//    }
    public double checkBalance(String pin){
        if(!isCorrect(pin))
            throw new InvalidPinException("Incorrect pin.");
        double total= 0.0;
        for(double transaction : transactionRecords)
            total += transaction;
        return total;

    }

    public void withdraw(double amount, String pin) throws InvalidAmountException, InsufficientBalanceException {
        if(amount < 0)
            throw new InvalidAmountException("Invalid Withdrawal Amount.");
        if(checkBalance(pin) - amount < 0)
            throw new InsufficientBalanceException("Insufficient balance.");
        if(!isCorrect(pin))
            throw new InvalidPinException("Incorrect Pin");
        transactionRecords.add(0-amount);
    }
    public void setAccountNumber(int accountNumber){
        this.accountNumber = accountNumber;

    }

    public boolean isCorrect(String pin) {
        return this.pin.equals(pin);

    }
}
