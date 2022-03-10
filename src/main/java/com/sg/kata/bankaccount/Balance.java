package com.sg.kata.bankaccount;

public class Balance {

	private long balanceAfterOperation;

	public Balance(long balanceAfterOperation) {
		super();
		this.balanceAfterOperation = balanceAfterOperation;
	}
	
	public Balance update(final OperationType operationType, final Amount amount) {
		if(OperationType.DEPOSIT.equals(operationType)) {
			return new Balance(balanceAfterOperation + amount.getAmount());
		}
		throw new IllegalArgumentException("Operation is not supported");
	}
}
