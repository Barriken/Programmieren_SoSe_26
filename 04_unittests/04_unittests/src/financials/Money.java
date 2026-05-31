package financials;

public class Money {
	public final float amount;
	// beware of static members in tested classes
	public static int counter = 0;

	public Money(float amount) {
		this.amount = amount;
		Money.counter++;
	}

	public Money add(Money money) {
		return new Money(this.amount + money.amount);
	}

	public Money subtract(Money money) {
		float temp = this.amount - money.amount;
		if (temp < 0)
			throw new NoNegMoney("amount would be: " + temp);
		return new Money(temp);
	}

	public String toString() {
		return Float.toString(amount);
	}

	public boolean equals(Object o) {
		if (!(o instanceof Money))
			return false;
		Money money = (Money) o;
		return (Math.round(100 * (this.amount - money.amount)) == 0);
	}

	public Money multiply(int i) {
		return new Money(amount * i);
	}

//    public Money multiply(int i) {
//        return new Money(amount * i);
//    }

	public int getCounter() {
		return Money.counter;
	}
}
