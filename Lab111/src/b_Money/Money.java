package b_Money;

import java.util.Objects;

public class Money implements Comparable {
	private int amount;
	private Currency currency;


	Money (Integer amount, Currency currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public Currency getCurrency() {
		return this.currency;
	}

	public String toString() {
		return this.getAmount() + " " + this.getCurrency().getName();
	}

	public Integer universalValue() {
		return (int)(this.getAmount() * currency.getRate());
	}

	public Boolean equals(Money other) {
		return this.currency.universalValue(this.getAmount()) - other.currency.universalValue(other.getAmount()) < 1e-3;
	}

	public Money add(Money other) {
		int resultValueForTheAmount = (
				this.amount += this.getCurrency().valueInThisCurrency(other.getAmount(), other.getCurrency())
		);
		return new Money(resultValueForTheAmount, this.getCurrency());
	}

	public Money sub(Money other) {
		int resultValueForTheAmount = (
				this.amount -= this.getCurrency().valueInThisCurrency(other.getAmount(), other.getCurrency())
		);
		return new Money(resultValueForTheAmount, this.getCurrency());
	}

	public Boolean isZero() {
		return this.getAmount() == .0f;
	}

	public Money negate() {
		return new Money(this.getAmount() * -1, this.getCurrency());
	}

	public int compareTo(Object other) {
		Money otherMoney = (Money)other;
		int universalCurrencyValOfThisMoney = this.currency.universalValue(this.getAmount());
		int universalCurrencyValOfOtherMoney = otherMoney.currency.universalValue(otherMoney.getAmount());

		return Integer.compare(universalCurrencyValOfThisMoney, universalCurrencyValOfOtherMoney);
	}
}