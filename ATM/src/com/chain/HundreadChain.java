package com.chain;

import com.model.options1.Currency;

public class HundreadChain extends Chain {
	private Chain next;

	HundreadChain(Chain next) {
		this.next = next;
	}

	@Override
	public void dispense(int money) {
		int availableNotes = atm.getAvailableDenominationCount(Currency.HUNDREAD);
		if (money >= 100 && availableNotes > 0) {
			int num = money / 100;
			int rem = 0;
			if (availableNotes < num) {
				rem = money % 100 + (num - availableNotes) * 100;
				num = availableNotes;
			} else {
				rem = money % 100;
			}
			atm.setBalance(atm.getBalance() - (100 * num));
			atm.setTotalWithdraw(atm.getTotalWithdraw() + (100 * num));
			System.out.println("Dispensing " + num + " notes of 100 RS");
			atm.deuctCurrency(Currency.HUNDREAD, num);
			if (rem > 0) {
				next.dispense(rem);
			}
		} else {
			next.dispense(money);
		}

	}
}
