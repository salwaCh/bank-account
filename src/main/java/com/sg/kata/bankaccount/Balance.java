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
		}else if (OperationType.WITHDRAWAL.equals(operationType)) {
			return new Balance(balanceAfterOperation - amount.getAmount());
		}
		throw new IllegalArgumentException("Operation is not supported");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (balanceAfterOperation ^ (balanceAfterOperation >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Balance other = (Balance) obj;
		if (balanceAfterOperation != other.balanceAfterOperation)
			return false;
		return true;
	}
	
	
}
