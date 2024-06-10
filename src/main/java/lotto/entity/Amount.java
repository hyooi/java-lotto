package lotto.entity;

public class Amount {
    private final int amount;

    public Amount(String amount) {
        this(Integer.parseInt(amount));
    }

    public Amount(int amount) {
        this.amount = amount;
        if (this.amount < 0) {
            throw new IllegalArgumentException("The amount cannot be less than 0.");
        }
    }

    public int getAmount() {
        return amount;
    }
}
