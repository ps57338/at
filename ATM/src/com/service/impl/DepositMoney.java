package com.service.impl;

import com.model.customer1.Customer;
import com.service.Transaction;
import com.states.Printer;

import java.util.Scanner;

public class DepositMoney extends Transaction implements Printer {

	DepositMoney(Customer cus) {
		super(cus);
	}

	@Override
	public void perform() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please entry money to deposit\n");
		int money = sc.nextInt();
		if (money > 0) {
			int balance = customer.getBalance();
			balance += money;
			customer.setBalance(balance);
			tx += customer.getName() + " depositing money " + money;
			System.out.println(customer.getName() + " depositing money " + money);
		} else
			System.out.println("Cant deposit. Provide valid amount");
	}

	@Override
	public String print() {
		return tx == "" ? null : tx;
	}

}
