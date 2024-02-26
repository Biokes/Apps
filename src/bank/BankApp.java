package bank;

import javax.swing.*;
import java.util.Scanner;

public class BankApp {
    private final Scanner input = new Scanner(System.in);
    private final Bank bank = new Bank("Zenith Bank.");
    private void print(String output){

        JOptionPane.showInputDialog(output);
    }

    public void display1(){
        print("Welcome to Zenith Bank PLC.");
        print("""
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
            case 4:
                menuFour();
        }
    }
    private void menuOne(){
        boolean condition = false;
        do {
            try {
                print("Enter Your First name: ");
                String firstName = input.next();
                print("Enter Your Last name: ");
                String lastName = input.next();
                print("Enter your desired 4-digits pin for transactions \n(note: that this is private and should not be shared with any one): ");
                String pin = input.next();
                BankAccount account = bank.registerCustomer(firstName,lastName,pin);
                System.out.printf("\nAccount created successfully\nYour Account number is %s👌👌.",account.checkAccountNumber());
            } catch (IllegalArgumentException error) {
                print(error.getMessage());
                input.next();
                condition = true;
            }
        }while(condition);

    }
    private void menuTwo(){
        boolean condition = true;
        do{
            try{
                print("Enter Account number To Deposit: ");
                int accNumber = input.nextInt();
                print("Enter Deposit Amount in Figure: ");
                double amount = input.nextDouble();
                bank.deposit(accNumber,amount);
                condition = false;
            }catch(IllegalArgumentException error){
                System.out.println(error.getMessage());
            } catch (InvalidAmountException error) {
                throw new RuntimeException("You Enter an invalid amount.");
            } catch (IncorrectAccountNumberException error) {
                throw new RuntimeException("You Enter an invalid amount.");
            }
            input.next();
        }while(condition);
    }
    private void menuThree() {
        boolean condition = true;
        do {
            try {
                print("Enter your Account Number: ");
                int accNumber = input.nextInt();
                print("Enter Destination Account Number: ");
                int accNumber2 = input.nextInt();
                print("Enter Transfer Amount in Figure: ");
                double amount = input.nextDouble();
                print("Enter you 4-digits pin: ");
                String pin = input.next();
                bank.transfer(accNumber, accNumber2, amount, pin);
                print("Transaction Succesful.");
                condition = false;
            } catch (IllegalArgumentException | InvalidAmountException | IncorrectAccountNumberException |
                     InsufficientBalanceException error) {
                print(error.getMessage());
                input.close();
            }
        } while (condition);

    }
    private static void menuFour(){
        int number = Integer.parseInt(JOptionPane.showInputDialog("Enter a number"));
        JOptionPane.showConfirmDialog(null,new Bank("wema bank"));
    }

    public static void main(String[] args) {
        menuFour();
    }
}
