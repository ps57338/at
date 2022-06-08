package com.chain;

import com.model.options1.Currency;

public class ThousandChain extends Chain {

	private Chain next;

	ThousandChain(Chain next) {
		this.next = next;
	}

	@Override
	public void dispense(int money) {
		int availableNotes = atm.getAvailableDenominationCount(Currency.THOUSAND);
		if (money >= 1000 && availableNotes > 0) {
			int rem = 0;
			int num = money / 1000;
			if (availableNotes < num) {
				rem = money % 1000 + (num - availableNotes) * 1000;
				num = availableNotes;
			} else {
				rem = money % 1000;
			}
			atm.setBalance(atm.getBalance() - (1000 * num));
			atm.setTotalWithdraw(atm.getTotalWithdraw() + (1000 * num));
			System.out.println("Dispensing " + num + " notes of 1000 RS");
			atm.deuctCurrency(Currency.THOUSAND, num);
			if (rem > 0) {
				next.dispense(rem);
			}
		} else {
			next.dispense(money);
		}
	}

}
