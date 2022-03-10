package com.sg.kata.bankaccount;

public class Account {

	private Balance balance = new Balance(0L);
	
	public void deposit(final Amount amount) throws InvalidBankTransactionException {
		if(amount.getAmount() < 0) {
			throw new InvalidBankTransactionException("Invalid Deposit Amount!");
		}
		balance = balance.update(OperationType.DEPOSIT, amount);
	}
	
	public void withdraw(Amount amount) {
	}

	public Balance getBalance() {
		return balance;
	}
}
