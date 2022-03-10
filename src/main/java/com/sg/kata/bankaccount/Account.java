package com.sg.kata.bankaccount;

public class Account {

	private Balance balance = new Balance(0L);
	
	public void deposit(final Amount amount) {
	}

	public Balance getBalance() {
		return balance;
	}
}
