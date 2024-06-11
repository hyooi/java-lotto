package lotto.entity;

import java.util.Objects;

public class Number {
    private final int number;

    public Number(String number) {
        this(Integer.parseInt(number));
    }

    private Number(int number) {
        this.number = number;
    }

    public static Number of(int number) {
        return new Number(number);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Number && number == ((Number) obj).number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
