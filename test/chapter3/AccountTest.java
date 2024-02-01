package chapter3;

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
  //  public
}
