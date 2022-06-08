package com.model.customer1;

public class Customer {

	private String name;
	private int cardNumber;
	private int PIN;
	private int balance;

	public Customer(String name, int cardNumber, int pIN, int balance) {
		super();
		this.name = name;
		this.cardNumber = cardNumber;
		PIN = pIN;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getPIN() {
		return PIN;
	}

	public void setPIN(int PIN) {
		this.PIN = PIN;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + PIN;
		result = prime * result + balance;
		result = prime * result + cardNumber;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Customer other = (Customer) obj;
		if (PIN != other.PIN)
			return false;
		if (balance != other.balance)
			return false;
		if (cardNumber != other.cardNumber)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
