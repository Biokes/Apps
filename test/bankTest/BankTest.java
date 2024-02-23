
package bankTest;
import bank.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    @Test
    void testThatAccountCanBEAddedToListOfAccountInBank(){
        Bank bank = new Bank("wema");
        bank.addNewAccount(new BankAccount("bada mathew","2354"));
        assertEquals(1, bank.numberOfCustomers());
    }
    @Test
    void testBalanceCanBEChecked() throws IncorrectAccountNumberException {
        Bank bank = new Bank("ftyhg");
        BankAccount acc1 = new BankAccount("mike mike","9009");
        bank.addNewAccount(acc1);
        assertEquals(0,bank.checkBalance(acc1.checkAccountNumber(), "9009"));
    }
    @Test
    void testCustomerCanBeRegistered(){
        Bank bank = new Bank("iuisd");
        BankAccount acc =  bank.registerCustomer("new","Busy","0000");
        assertEquals(0,acc.checkBalance("0000"));
    }

    @Test
    void testThatIncorrectPin_IsRejectedWhenDeletingAccount(){
        Bank bank = new Bank("hikuj");
        BankAccount user1 = bank.registerCustomer("praise","ore","9089");
        assertThrows(InvalidPinException.class
                ,()->bank.removeAccount(user1.checkAccountNumber(),"91890"));
    }
    @Test
    void testThatAccountCanBeFound()throws IncorrectAccountNumberException {
        Bank bank = new Bank("snc");
        BankAccount acc = bank.registerCustomer("nmku","gky","9009");
        bank.addNewAccount(acc);
        assertEquals(acc.checkAccountNumber(),bank.findAccount(acc.checkAccountNumber()).checkAccountNumber());
    }

    @Test
    void testThatBankCanMakeDepositOnAccount()
            throws InvalidAmountException,IncorrectAccountNumberException{
        Bank bank = new Bank("Eco");
        BankAccount acc = bank.registerCustomer("bada"," mathew","2354");
        int account_number= acc.checkAccountNumber();
        assertEquals(1, bank.numberOfCustomers());
        bank.deposit(account_number, 500);
        assertEquals(500, bank.checkBalance(account_number, "2354"));
    }
    @Test
    void testDepositOnNonExistingUsers_throwsError()
            throws InvalidAmountException,IncorrectAccountNumberException {
        Bank bank = new Bank("uba");
        BankAccount acc = bank.registerCustomer("bada","mathew","2354");
        int account_number= acc.checkAccountNumber();
        assertEquals(1, bank.numberOfCustomers());
        bank.deposit(account_number, 500);
        assertThrows(IncorrectAccountNumberException.class,()->bank.checkBalance(1234567909, "2354"));
    }
    @Test
    void testThatTransactionOnNonExistingUsers_throwsError(){
        Bank bank = new Bank("newGo");
        assertThrows(IncorrectAccountNumberException.class,()->bank.deposit(1234567909, 1230));
    }
    @Test
    void testThatNonExistingAccountCantMakeWithdrawal(){
        Bank bank = new Bank("Newpa");
        assertThrows(IncorrectAccountNumberException.class,()->bank.withdraw(1234567890,800.0,"8909"));
    }
    @Test
    void testThatExistingUserCAntUseWrongPinToMAkeWithdrawal()
            throws InvalidAmountException,IncorrectAccountNumberException {
        Bank bank = new Bank("wema");
        BankAccount acc = new BankAccount("bada mathew","2354");
        bank.addNewAccount(acc);
        assertEquals(1, bank.numberOfCustomers());
        bank.deposit( acc.checkAccountNumber(), 500);
        assertThrows(InvalidPinException.class,()->bank.checkBalance( acc.checkAccountNumber(), "2350"));
    }
    @Test
    void testThatUsersCanWithdraw()
            throws InvalidAmountException, IncorrectAccountNumberException {
        Bank bank = new Bank("Zenith");
        BankAccount acc = new BankAccount("bada mathew","2354");
        bank.addNewAccount(acc);
        assertEquals(1, bank.numberOfCustomers());
        bank.deposit( acc.checkAccountNumber(), 500);
        assertEquals(500,bank.checkBalance( acc.checkAccountNumber(), "2354"));
    }

    @Test
    void testThatTransfer_withWWrongPinFails()
            throws InvalidAmountException, IncorrectAccountNumberException{
        Bank bank = new Bank("wema");
        BankAccount acc = new BankAccount("bada mathew","2354");
        bank.addNewAccount(acc);
        assertEquals(1, bank.numberOfCustomers());
        bank.deposit( acc.checkAccountNumber(), 500);
        assertEquals(500,bank.checkBalance( acc.checkAccountNumber(), "2354"));
        BankAccount acc2 = bank.registerCustomer("dare","toll","0000");
        assertThrows(InvalidPinException.class,
                ()->bank.transfer(acc.checkAccountNumber(),acc2.checkAccountNumber(),900,"2350"));
    }
    @Test
    void testThatWrongPinDuringTransferDoesNotChangeBalance()
            throws IncorrectAccountNumberException,InvalidAmountException{
        Bank bank = new Bank("hwkd");
        BankAccount acc = bank.registerCustomer("bada","mathew","2354");
        assertEquals(1, bank.numberOfCustomers());
        bank.deposit( acc.checkAccountNumber(), 500);
        assertEquals(500,bank.checkBalance( acc.checkAccountNumber(), "2354"));
        BankAccount acc2 = bank.registerCustomer("dare","toll","0000");
        assertThrows(InvalidPinException.class,
                ()->bank.transfer(acc.checkAccountNumber(),acc2.checkAccountNumber(),900,"2350"));
        assertEquals(500,acc.checkBalance("2354"));
    }
    @Test
    void testThatWrongPinDuringTransferDoesNotChangeBalanceOfReceiver()
            throws IncorrectAccountNumberException,InvalidAmountException{
        Bank bank = new Bank("hsd");
        BankAccount acc = bank.registerCustomer("bada"," mathew","2354");
        assertEquals(1, bank.numberOfCustomers());
        bank.deposit( acc.checkAccountNumber(), 500);
        assertEquals(500,bank.checkBalance( acc.checkAccountNumber(), "2354"));
        BankAccount acc2 = bank.registerCustomer("dare"," toll","0000");
        assertThrows(InvalidPinException.class,
                ()->bank.transfer(acc.checkAccountNumber(),acc2.checkAccountNumber(),900,"2350"));
        assertEquals(0,acc2.checkBalance("0000"));
    }
    @Test
    void testThatWrongPinDuringTransferDoesNotChangeAccountBalanceOfBothParties()
            throws IncorrectAccountNumberException,InvalidAmountException{
        Bank bank = new Bank("ydfn");
        BankAccount acc = bank.registerCustomer("bada"," mathew","2354");
        assertEquals(1, bank.numberOfCustomers());
        bank.deposit( acc.checkAccountNumber(), 500);
        assertEquals(500,bank.checkBalance( acc.checkAccountNumber(), "2354"));
        BankAccount acc2 = bank.registerCustomer("dare"," toll","0000");
        assertThrows(InvalidPinException.class,()->bank.transfer(
                acc.checkAccountNumber(),acc2.checkAccountNumber(),900,"2350"));
        assertEquals(0,acc2.checkBalance("0000"));
    }
    @Test
    void testTransferCanBeDone()
            throws IncorrectAccountNumberException, InvalidAmountException, InsufficientBalanceException {
        Bank bank = new Bank("foo");
        BankAccount acc = bank.registerCustomer("bada","mathew","2354");
        assertEquals(1, bank.numberOfCustomers());
        bank.deposit( acc.checkAccountNumber(), 900);
        assertEquals(900,bank.checkBalance( acc.checkAccountNumber(), "2354"));
        BankAccount acc2 = bank.registerCustomer("dare ","toll","0000");
        assertEquals(900,acc.checkBalance("2354"));
        assertEquals(2, bank.numberOfCustomers());
        assertTrue(acc.isCorrect("2354"));
        bank.transfer(acc.checkAccountNumber(),acc2.checkAccountNumber(),500,"2354");
        assertEquals(400,acc.checkBalance("2354"));
        assertEquals(500,acc2.checkBalance("0000"));

    }
    @Test
    void testThatTransfer_onInsufficientBalanceOfSenderUserCannotBeDone()
            throws InvalidAmountException,IncorrectAccountNumberException{
        Bank bank = new Bank("high");
        BankAccount acc = bank.registerCustomer("bada","matthew","2354");
        assertEquals(1, bank.numberOfCustomers());
        bank.deposit( acc.checkAccountNumber(), 500);
        assertEquals(500,bank.checkBalance( acc.checkAccountNumber(), "2354"));
        BankAccount acc2 = bank.registerCustomer("dare","toll","0000");
        assertThrows(InsufficientBalanceException.class,()->bank.transfer(
                acc.checkAccountNumber(),acc2.checkAccountNumber(),900,"2354"));
    }
    @Test
    void testThatTransfer_canBeDone()
            throws InvalidAmountException, IncorrectAccountNumberException, InsufficientBalanceException {
        Bank bank = new Bank("zenith");
        BankAccount acc =  bank.registerCustomer("bada ","mathew","2354");
        assertEquals(1, bank.numberOfCustomers());
        bank.deposit( acc.checkAccountNumber(), 500);
        assertEquals(500,bank.checkBalance( acc.checkAccountNumber(), "2354"));
        BankAccount acc2 = bank.registerCustomer("dare","toll","0000");
        bank.transfer(acc.checkAccountNumber(),acc2.checkAccountNumber(),500,"2354");
        assertEquals(0,bank.checkBalance( acc.checkAccountNumber(), "2354"));
        assertEquals(500,acc2.checkBalance("0000"));
    }
    @Test
    void removeAccount_testAccountISRemoved() throws IncorrectAccountNumberException {
        Bank bank = new Bank("zenith");
        BankAccount acc =  bank.registerCustomer("bada ","mathew","2354");
        assertEquals(1, bank.numberOfCustomers());
        bank.removeAccount(acc.checkAccountNumber(),"2354");
        assertEquals(0, bank.numberOfCustomers());
    }

}

