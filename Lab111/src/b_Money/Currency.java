package b_Money;

public class Currency {
	private String name;
	private Double rate;

	Currency (String name, Double rate) {
		this.name = name;
		this.rate = rate;
	}

	public Integer universalValue(Integer amount) {
		return (int)(amount * rate);
	}

	public String getName() {
		return name;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Integer valueInThisCurrency(Integer amount, Currency othercurrency) {
		int universalValue = othercurrency.universalValue(amount);
		return (int)(universalValue / this.rate);
	}
}