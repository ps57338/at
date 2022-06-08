package com.service.impl;

import com.model.customer1.Customer;
import com.service.ATM2;
import com.chain.Chain;
import com.service.Transaction;
import com.states.Printer;

import java.util.Scanner;

public class WithdrawlTransaction extends Transaction implements Printer {

	private Chain chain;

	WithdrawlTransaction(Customer cus) {
		super(cus);
		chain = new ThousandChain(new HundreadChain(new FiftyChain(new TenChain(null))));
	}

	@Override
	public void perform() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please entry money to withdraw\n");
		int money = sc.nextInt();
		if (money <= customer.getBalance() && money <= ATM2.getATM().getBalance()) {
			chain.dispense(money);
			int balance= customer.getBalance();
			balance -= money;
			customer.setBalance(balance);
			tx = customer.getName() + " withdrwaing money " + money;
			System.out.println(customer.getName() + " withdrwaing money " + money);
		} else {
			if (money > customer.getBalance())
				System.out.println("Sorry not sufficent balance in ur account ");
			else if (money > ATM2.getATM().getBalance())
				System.out.println("Sorry not sufficent balance in ATM2 machine ");
		}
	}

	@Override
	public String print() {
		return tx == "" ? null : tx;
	}

}
