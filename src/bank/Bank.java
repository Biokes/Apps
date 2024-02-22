


package bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {
    private final String bankName;
    private  List<BankAccount> customers = new ArrayList<>();
    private  int countUsers = 1009876543;

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
                    for (int counter = 0; counter < customers.size(); counter++) {
                        if ( customers.get(counter).checkAccountNumber() == receiverAccountNumber) {
                            customers.get(count).withdraw(amount,senderPin);
                            customers.get(counter).deposit(amount);
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
    public void removeAccount(int accountNumber, String pin) throws IncorrectAccountNumberException {
        if(findAccount(accountNumber).isCorrect(pin))
            customers.remove(findAccount(accountNumber));
        throw new InvalidPinException("Incorrect account Number");

    }

    public BankAccount findAccount(int accountNumber)throws IncorrectAccountNumberException{
        for (BankAccount acc : customers) {
            if (accountNumber == acc.checkAccountNumber())
                return acc;
        }
        throw new IncorrectAccountNumberException("No matching account found.");
    }
    public void display1(){
        Bank Mavericks = new Bank("Mavericks.");
        System.out.println("Welcome to Mavericks Bank PLC.");
        System.out.println
                ("""
                1. create Account
                2. Deposit
                3. Transfer
                4. check Balance
                5. Check Account Details
                6. Deactivate Account
                """);
        int choice = input.nextInt();
        switch(choice){
            case 1:
                menuOne();
            case 2:
                menuTwo();
            case 3:
                menuThree();
        }
    }
    private void menuOne(){
        boolean condition = false;
       do {
           try {
               System.out.println("Enter Your First name: ");
               String firstName = input.next();
               System.out.println("Enter Your Last name: ");
               String lastName = input.next();
               System.out.println("Enter your desired 4-digits pin for transactions \n(note: that this is private and should not be shared with any one): ");
               String pin = input.next();
               BankAccount account = registerCustomer(firstName,lastName,pin);
               System.out.printf("\nAccount created successfully\nYour Account number is %s👌👌.",account.checkAccountNumber());
           } catch (IllegalArgumentException error) {
               System.out.println(error.getMessage());
               input.close();
               condition = true;
           }
       }while(condition);

    }
    private void menuTwo(){
        boolean condition = true;
        do{
            try{
                System.out.println("Enter Account number To Deposit: ");
                int accNumber = input.nextInt();
                System.out.println("Enter Deposit Amount in Figure: ");
                double amount = input.nextDouble();
                deposit(accNumber,amount);
                condition = false;
            }catch(IllegalArgumentException error){
                System.out.println(error.getMessage());
            } catch (InvalidAmountException error) {
                throw new RuntimeException("You Enter an invalid amount.");
            } catch (IncorrectAccountNumberException error) {
                throw new RuntimeException("You Enter an invalid amount.");
            }
            input.close();
        }while(condition);
    }
    private void menuThree(){
        boolean condition = true;
        do{
            try{
                System.out.println("Enter your Account Number: ");
                int accNumber = input.nextInt();
                System.out.println("Enter Destination Account Number: ");
                int accNumber2 = input.nextInt();
                System.out.println("Enter Transfer Amount in Figure: ");
                double amount = input.nextDouble();
                System.out.println("Enter you 4-digits pin: ");
                String pin = input.next();
                transfer(accNumber,accNumber2,amount, pin);
                System.out.println("Transaction Succesful.");
                condition = false;
            }catch(IllegalArgumentException | InvalidAmountException | IncorrectAccountNumberException |
                   InsufficientBalanceException error){
                System.out.println(error.getMessage());
                input.close();
            }
        }while(condition);
    }


}