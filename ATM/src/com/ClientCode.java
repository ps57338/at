package com;


import com.model.customer1.Customer;
import com.model.customer1.Manager;
import com.model.customer1.User;
import com.service.ATM2;

import java.util.Scanner;

public class ClientCode {

	public static void main(String[] args) {
		System.out.println("Starting ATM machine");
		ATM2 atm = ATM2.getATM();
		Customer c1 = new User("C1", 123456, 1111, 90000);

		atm.addCustomerToDB(c1);


		Customer m1 = new Manager("M1", 67890, 8888, 0);
		atm.addManagerToDB(m1);


		Scanner sc = new Scanner(System.in);
		int i = 0;
		while (i < 5) {
			i++;
			System.out.println();
			System.out.println("Please insert card");
			atm.insertDebitCard();
			System.out.println("\nHello Please enter card number:");
			int number = sc.nextInt();
			int maxAttempt = 0;
			while (maxAttempt <= 3) {
				System.out.println("\nPlease enter PIN:");
				int pin = sc.nextInt();
				boolean val = atm.validateCustomer(number, pin);
				if (!val) {
					System.out.println("Sorry wrong PIN enterd or another issue. try again");
					maxAttempt++;
					if (maxAttempt >= 3) {
						System.out.println("SORRY. Card blocked card Number: " + number);
						atm.ejectDebitCard();
						break;
					}
				} else {
					atm.displayOptions();
					break;
				}
			}
		}
	}

}
