


package bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {
    private final String bankName;
    private final List<BankAccount> customers = new ArrayList<>();
    private final int countUsers = 1009876543;

    private final Scanner input = new Scanner(System.in);


    public Bank(String bankName){
        this.bankName = bankName
        ;
    }
    public void addNewAccount(BankAccount bankAccount){

        customers.add(bankAccount);
    }

    public int numberOfCustomers() {

        return customers.size();
    }


    public void deposit(int accountNumber, double depositAmount)
            throws IncorrectAccountNumberException, InvalidAmountException{
        for (BankAccount account : customers)
            if (accountNumber == account.checkAccountNumber()) {
                account.deposit(depositAmount);
                return;
            }
        String errorMessage = String.format("Account number: %s does not Exist.", accountNumber);
        throw new IncorrectAccountNumberException(errorMessage);
    }

    public double checkBalance(int accountNumber, String pin)
            throws IncorrectAccountNumberException {
        for (BankAccount account : customers)
            if (accountNumber == account.checkAccountNumber())
                return account.checkBalance(pin);
        throw new IncorrectAccountNumberException("Incorrect Account number.");
    }

    public void withdraw(int accountNumber, double withdrawalAmount, String pin)
            throws InvalidAmountException, IncorrectAccountNumberException, InsufficientBalanceException {
        for (BankAccount account : customers)
            if (accountNumber == account.checkAccountNumber()) {
                account.withdraw(withdrawalAmount, pin);
                return;
            }
        throw new IncorrectAccountNumberException("Invalid Account number.");
    }

    public void transfer(int senderAccountNumber, int receiverAccountNumber, double amount, String senderPin)
            throws IncorrectAccountNumberException, InvalidAmountException, InsufficientBalanceException {
        boolean breaker = false;
            for(int count = 0; count < customers.size();count++) {
                if (customers.get(count).checkAccountNumber() == senderAccountNumber) {
                    for (BankAccount customer : customers) {
                        if (customer.checkAccountNumber() == receiverAccountNumber) {
                            customers.get(count).withdraw(amount, senderPin);
                            customer.deposit(amount);
                            breaker = true;
                        }
                    }
                }

            }
    }

    public BankAccount registerCustomer(String firstName, String lastName, String pin){
        BankAccount account = new BankAccount(String.format("%s %s", firstName, lastName), pin);
        account.setAccountNumber(generateAccountNumber());
        customers.add(account);
        return account;
    }
    private int generateAccountNumber(){
        return countUsers + numberOfCustomers()+1;

    }
    public String  removeAccount(int accountNumber, String pin) throws IncorrectAccountNumberException {
       for(BankAccount acc : customers){
           if(acc.checkAccountNumber() == accountNumber) {
               if(!acc.isCorrect(pin)){
                   throw new InvalidPinException("incporrect pin.");
               }
               customers.remove(acc);
               return "Account Successfully Deleted.";
           }
       }

        throw new InvalidPinException("Incorrect account Number");

    }

    public BankAccount findAccount(int accountNumber)throws IncorrectAccountNumberException{
        for (BankAccount acc : customers) {
            if (accountNumber == acc.checkAccountNumber())
                return acc;
        }
        throw new IncorrectAccountNumberException("No matching account found.");
    }

}