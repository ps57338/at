package com.service;

import com.model.customer1.Customer;

import javax.security.auth.Destroyable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

abstract public class Display implements Destroyable {

	protected static Map<Customer, ArrayList<String>> transactions = new HashMap<Customer, ArrayList<String>>();
	protected Customer customer;
	protected String currentTx = "";
	abstract public void show();

	public String getCurrentTx() {
		return currentTx;
	}

	public void clearTransaction() {
		this.currentTx = "";
	}

	public void setCustomer(Customer cus) {
		this.customer = cus;
	}

	public void setCurrentTx(String currentTx) {
		if (currentTx == null)
			return;
		this.currentTx += "\n\t\t\t" + currentTx;

	}

	protected void addTransaction(Customer cus, String tx) {
		if (tx == null || tx.equals(""))
			return;
		if (transactions.get(cus) == null)
			transactions.put(customer, new ArrayList<String>());
		transactions.get(customer).add(tx);
	}

}
