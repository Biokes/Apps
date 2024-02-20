package bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String bankName;
    private final List<BankAccount> customers = new ArrayList<>();

    public Bank(String name){
        this.bankName = name;
    }
    public void addNewAccount(BankAccount bankAccount) {

        customers.add(bankAccount);
    }

    public int numberOfCustomers() {

        return customers.size();
    }


    public void deposit(int accountNumber, double depositAmount) throws IncorrectAccountNumberException, InvalidAmountException {
        for (BankAccount account : customers)
            if (accountNumber == account.getAccountNumber(account.getPin())) {
                account.deposit(depositAmount);
                return;
            }
        String errorMessage = String.format("Account number: %s does not Exist.", accountNumber);
        throw new IncorrectAccountNumberException(errorMessage);
    }

    public double checkBalance(int accountNumber, String pin) throws IncorrectAccountNumberException {
        for (BankAccount account : customers)
            if (accountNumber == account.getAccountNumber(account.getPin()))
                return account.checkBalance(pin);
        throw new IncorrectAccountNumberException("Incorrect Account number.");
    }

    public void withdraw(int accountNumber, double withdrawalAmount, String pin) throws InvalidAmountException, IncorrectAccountNumberException {
        for (BankAccount account : customers)
            if (accountNumber == account.getAccountNumber(pin)) {
                account.withdraw(withdrawalAmount, pin);
                return;
            }
        throw new IncorrectAccountNumberException("Invalid Account number.");
    }

    public void transfer(BankAccount sender, BankAccount receiver, double amount, String senderPin) throws InsufficientBalanceException, InvalidAmountException {
        if (sender.checkBalance(senderPin) - amount < 0)
            throw new InsufficientBalanceException("Insufficient Balance.");
        sender.withdraw(amount, senderPin);
        receiver.deposit(amount);
    }

    public BankAccount registerCustomer(String firstName, String lastName, String pin) {
        BankAccount account = new BankAccount(String.format("%s %s", firstName, lastName), pin);
        customers.add(account);
        return account;
    }

    public void removeAccount(int accountNumber, String pin) {
        for (BankAccount acc : customers) {
            if (accountNumber == acc.getAccountNumber(pin)) {
                if (acc.getPin().equals(pin))
                    customers.remove(acc);
                else throw new InvalidPinException("wrong pin");
                return;
            }
            throw new IllegalArgumentException("Account does not exist");
        }
    }

    public BankAccount findAccount(int accountNumber) throws IncorrectAccountNumberException {
        for (BankAccount acc : customers) {
            if (accountNumber == acc.getAccountNumber(acc.getPin())) {
                return acc;
            }

        }
        throw new IncorrectAccountNumberException("No match found.");

    }

}