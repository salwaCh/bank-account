package com.sg.kata.bankaccount;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

	private Account account;
	
	@Before
	public void init() {
		account = new Account();
	}
	
	@Test
	public void should_success_deposit_50() throws InvalidBankTransactionException
	{
        final long amount = 50L;
        account.deposit(new Amount(amount));
        final Balance expectedBalance = new Balance(50L);
        assertEquals(expectedBalance, account.getBalance());
    }
	
	@Test(expected = InvalidBankTransactionException.class)
	public void should_throw_exception_when_invalid_bank_transaction() 
			throws InvalidBankTransactionException 
	{
		final long amount = -50L;
        account.deposit(new Amount(amount));
        Assert.fail();
    }
	
	@Test
    public void should_success_withdraw_of_100() 
    		throws InvalidBankTransactionException, InsufficientBalanceException {

    	account.deposit(new Amount(100L));
    	account.deposit(new Amount(300L));
    	account.withdraw(new Amount(100L));
    	final Balance expectedBalance = new Balance(300L);
    	assertEquals(expectedBalance, account.getBalance());
    }
	
	@Test(expected = InsufficientBalanceException.class)
    public void should_throw_exception_when_insufficient_balance() 
    		throws InvalidBankTransactionException, InsufficientBalanceException {

    	account.deposit(new Amount(100L));
    	account.deposit(new Amount(300L));
    	account.withdraw(new Amount(500L));
    	Assert.fail();
    }
}
