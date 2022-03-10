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
	public void should_success_deposit_50()
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
		long amount = -50L;
        account.deposit(new Amount(amount));
        Assert.fail();
    }
}
