package com.service.impl;

import com.model.options1.Option;
import com.service.Display;
import com.service.Transaction;
import com.states.Printer;

import java.util.Scanner;

public class ClientDisplay extends Display implements Printer {

	private static final ClientDisplay displayOption = new ClientDisplay();

	private ClientDisplay() {

	}

	public static Display getDisplay() {
		return displayOption;
	}

	public void show() {
		System.out.println("\t\t\tWelcome " + customer.getName());
		Scanner sc = new Scanner(System.in);
		boolean isCancelled = false;
		while (!isCancelled) {
			System.out.println("[Select option: ] 1. Withdrawl 2.Deposit 3.Check balance 4.Cancel");
			int op = sc.nextInt();
			Option option = Option.getOption(op);
			if (option == null) {
				System.out.println("Wrong option selected. Try again");
				continue;
			}
			switch (option) {
			case CHECKBALANCE:
				Transaction cbtx = new CheckBalance(customer);
				cbtx.perform();
				addTransaction(customer, cbtx.print());
				setCurrentTx(cbtx.print());
				break;
			case WITHDRAWL:
				Transaction wtx = new WithdrawlTransaction(customer);
				wtx.perform();
				addTransaction(customer, wtx.print());
				setCurrentTx(wtx.print());
				break;
			case DEPOSIT:
				Transaction dtx = new DepositMoney(customer);
				dtx.perform();
				addTransaction(customer, dtx.print());
				setCurrentTx(dtx.print());
				break;
			case CANCEL:
				System.out.println("Cancelling transaction");
				isCancelled = true;
				break;
			}
		}
		if (transactions.get(this.customer) != null && !transactions.get(this.customer).isEmpty()) {
			System.out.println("\n [DO u want to print?]");
			sc = new Scanner(System.in);
			String op = sc.nextLine();
			switch (op) {
			case "y":
			case "Y":
				print();
				break;
			default:
				break;
			}
		}
	}

	@Override
	public String print() {
		System.out.println(
				"############################################## Customer Transaction ########################################");
		System.out.println(getCurrentTx());

		System.out.println(
				"############################################ END #################################################################");
		return null;
	}

}
