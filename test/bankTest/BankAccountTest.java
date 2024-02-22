package bankTest;

import bank.BankAccount;
import bank.InsufficientBalanceException;
import bank.InvalidAmountException;
import bank.InvalidPinException;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {
    @Test
    void testThatBalanceCanBeChecked()throws InvalidPinException {
        BankAccount acc = new BankAccount("joy vic", "1001");
        assertEquals(0.0,acc.checkBalance("1001"));
    }
    @Test
    void testThatAccountCanDepositPositiveValues() throws InvalidAmountException {
        BankAccount acc = new BankAccount("joy vic", "1001");
        acc.deposit(500);
        assertEquals(500,acc.checkBalance("1001"));
    }
    @Test
    void testThatAccountCannotDepositNegativeValue() throws InvalidAmountException {
        BankAccount acc = new BankAccount("joy vic", "1001");
        acc.deposit(500);
        assertEquals(500,acc.checkBalance("1001"));
        assertThrows(InvalidAmountException.class,()->acc.deposit(-12));
    }
    @Test
    void testThatAmountLessThanBalanceCanBeWithdrawn() throws InvalidAmountException, InsufficientBalanceException {
        BankAccount acc = new BankAccount("joy vic", "1001");
        acc.deposit(500);
        assertEquals(500,acc.checkBalance("1001"));
        assertThrows(InvalidAmountException.class,()->acc.deposit(-900));
        acc.withdraw(200,"1001");
        assertEquals(300, acc.checkBalance("1001"));
    }
    @Test
    void testThatNegativeAmountCantBeWithdrawn()throws InvalidAmountException{
        BankAccount acc = new BankAccount("joy vic", "1001");
        acc.deposit(500);
        assertEquals(500,acc.checkBalance("1001"));
        assertThrows(InvalidAmountException.class,()->acc.withdraw(-12,"1001"));
    }
    @Test
    void testThatIncorrectPinCantBeUsedToWithdraw() throws InvalidAmountException {
        BankAccount acc = new BankAccount("joy vic", "1001");
        acc.deposit(500);
        assertEquals(500,acc.checkBalance("1001"));
        assertThrows(InvalidPinException.class,()->acc.withdraw(12,"1000"));
    }
    @Test
    void testAmountGreaterThanBalance_IsInvalid()throws InvalidAmountException,InvalidPinException{
        BankAccount acc = new BankAccount("joy vic", "1001");
        acc.deposit(500);
        assertEquals(500,acc.checkBalance("1001"));
        assertThrows(InsufficientBalanceException.class,()->acc.withdraw(9000,"1001"));
    }
}