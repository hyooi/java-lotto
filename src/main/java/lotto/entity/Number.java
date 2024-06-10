package lotto.entity;

public class Number {
    private final int number;

    public Number(String number) {
        this(Integer.parseInt(number));
    }

    public Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
