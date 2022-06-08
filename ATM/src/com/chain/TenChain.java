package com.chain;

import com.model.options1.Currency;

public class TenChain extends Chain {

	private Chain next;

	public TenChain(Chain next) {
		this.next = next;

	}

	@Override
	public void dispense(int money) {
		int availableNotes = atm.getAvailableDenominationCount(Currency.TEN);
		if (money<=10){
			System.out.println("Minimum balance not met");
		}
		if (money >= 10 && availableNotes > 0) {
			int num = money / 10;
			int rem = 0;
			if (availableNotes < num) {
				rem = money % 10 + (num - availableNotes) * 10;
				num = availableNotes;
			} else {
				rem = money % 10;
			}
			System.out.println("Dispensing " + num + " notes of 10 RS");
			atm.deuctCurrency(Currency.TEN, num);
			atm.setBalance(atm.getBalance() - (10 * num));
			atm.setTotalWithdraw(atm.getTotalWithdraw() + (10 * num));
			if (rem > 0) {
				next.dispense(rem);
			}
		} else {
			next.dispense(money);
		}

	}
}
