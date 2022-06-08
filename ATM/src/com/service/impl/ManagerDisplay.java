package com.service.impl;

import com.model.options1.ManagerOptions;
import com.service.ATM2;
import com.service.Display;
import com.states.Printer;

import java.util.Scanner;

public class ManagerDisplay extends Display implements Printer {
	private static final Display display = new ManagerDisplay();

	private ManagerDisplay() {

	}

	public static Display getDisplay() {
		return display;
	}

	public void show() {
		System.out.println("\t\t\tWelcome Manager " + customer.getName());
		Scanner sc = new Scanner(System.in);
		boolean isCancelled = false;
		while (!isCancelled) {
			System.out.println(
					"[Select option: ] 1. Check total balance in machine 2.check total withdrawl amount 3.Chek all user transactions 4.See my transactions 5.Cancel");
			int op = sc.nextInt();
			ManagerOptions option = ManagerOptions.getOption(op);
			if (option == null) {
				System.out.println("Wrong option selected. Try again");
				continue;
			}
			switch (option) {
			case CHECKTOTALBALANCE:
				System.out.println("Total balance: " + ATM2.getATM().getBalance());
				addTransaction(customer, "Checked total amount in machine");
				break;
			case CHECKTOTALWITHDRAWL:
				System.out.println("Total withdraw: " + ATM2.getATM().getTotalWithdraw());
				addTransaction(customer, "Checked total amount withdrawn");
				break;
			case SEEALLTRANSACTIONS:
				seeAllTransactions();
				break;
			case SEEMYTRANSACTIONS:
				print();
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
				"############################################## Manager Transaction ########################################");
		transactions.entrySet().forEach(c -> {
			if (customer == c.getKey())
				for (String s : c.getValue())
					if (s != null)
						System.out.println("\t\t\tTx: " + s);
		});
		System.out.println(
				"############################################ END #################################################################");
		return null;
	}

	void seeAllTransactions() {
		System.out.println(
				"############################################## ALL customer Transaction ########################################");
		transactions.entrySet().forEach(c -> {
			if (customer != c.getKey())
				for (String s : c.getValue())
					if (s != null)
						System.out.println("\t\t\tTx: " + s);
		});
		System.out.println(
				"############################################ END #################################################################");

	}
}
