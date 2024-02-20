package bank;
import java.util.ArrayList;

public class BankAccount {
    private final String accountName;
    private String pin;
    private int accountNumber;
    private final ArrayList<Double> transactionRecords = new ArrayList<>();
    private static  int countUsers = 1009876543;

    public BankAccount(String name, String pin) {
        validatePin(pin);
        this.accountName = name;
        this.accountNumber = countUsers++;
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
    public String getPin(){

        return pin;
    }
    public int getAccountNumber(String pin) {
        if(this.pin.equals(this.pin))
        return countUsers;
        else throw new InvalidPinException("Incorrect pin." +
                "");
    }
    public double checkBalance(String pin){
        boolean condition = pin.equals(this.pin);
        if(!condition)
            throw new InvalidPinException("Incorrect pin");
        double total= 0.0;
        for(double transaction : transactionRecords)
            total += transaction;
        return total;

    }

    public void withdraw(double amount, String pin)throws InvalidAmountException{
        if(amount < 0)
            throw new InvalidAmountException("Invalid Withdrawal Amount.");
        else if(checkBalance(pin) - amount < 0)
            throw new InvalidAmountException("Invalid Withdrawal Amount.");
        transactionRecords.add(0-amount);
    }

}
