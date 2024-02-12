package assignmentsAndTasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {
    @Test
    public void depositNegativeBalance_balanceRemainsUnchangedTest(){
        Account biokesAccount = new Account();
        assertEquals(0,biokesAccount.getBalance());
        biokesAccount.deposit(-50000);
        assertEquals(0, biokesAccount.getBalance());
    }
    @Test
    public void depositPositiveAmount_balanceIncreasesTest(){
        Account biokesAccount = new Account();
        assertEquals(0,biokesAccount.getBalance());
        biokesAccount.deposit(2000);
        assertEquals(2000, biokesAccount.getBalance());
    }
    @Test
    public void depositPositiveAmountTwice_balanceIncreasesTest(){
        Account biokesAccount = new Account();
        assertEquals(0,biokesAccount.getBalance());
        biokesAccount.deposit(2000);
        biokesAccount.deposit(4000);
        assertEquals(6000, biokesAccount.getBalance());
    }
    @Test
    public void withdrawNegativeAmount(){
        Account biokesAccount = new Account();
        biokesAccount.withdraw(-900);
        assertEquals(0,biokesAccount.getBalance());
    }
    @Test
    public void withdrawAmountGreaterThanBalance(){
        Account biokesAccount = new Account();
        biokesAccount.withdraw(120);
        assertEquals(0,biokesAccount.getBalance());
    }
    @Test
    public void withdrawAmountAllBalanace(){
        Account biokesAccount = new Account();
        biokesAccount.deposit(120);
        biokesAccount.withdraw(120);
        assertEquals(0,biokesAccount.getBalance());
    }
    @Test
    public void withdrawAmountLesserThanBalanaceTwice(){
        Account biokesAccount = new Account();
        biokesAccount.deposit(120);
        biokesAccount.withdraw(100);
        biokesAccount.withdraw(10);
        assertEquals(10,biokesAccount.getBalance());
    }
}
