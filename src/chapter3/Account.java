package chapter3;

public class Account {
    private int balance;
    public int getBalance() {
        return balance;
    }
    public void deposit(int amount){
        if(amount > 0){
            balance += amount;
        }
    }
}
