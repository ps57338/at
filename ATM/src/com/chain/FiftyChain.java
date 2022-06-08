package com.chain;

import com.model.options1.Currency;

public class FiftyChain extends Chain {

	private Chain next;

	FiftyChain(Chain next) {
		this.next = next;
	}

	@Override
	public void dispense(int money) {
		int availableNotes = atm.getAvailableDenominationCount(Currency.FIFTY);
		if (money >= 50 && availableNotes > 0) {
			int num = money / 50;
			int rem = 0;
			if (availableNotes < num) {
				rem = money % 50 + (num - availableNotes) * 50;
				num = availableNotes;
			} else {
				rem = money % 50;
			}
			System.out.println("Dispensing " + num + " notes of 50 RS");
			atm.deuctCurrency(Currency.FIFTY, num);
			atm.setBalance(atm.getBalance() - (50 * num));
			atm.setTotalWithdraw(atm.getTotalWithdraw() + (50 * num));
			if (rem > 0) {
				next.dispense(rem);
			}
		} else {
			next.dispense(money);
		}

	}
}
