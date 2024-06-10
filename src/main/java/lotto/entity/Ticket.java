package lotto.entity;

import java.util.List;

public class Ticket {
    public static final int LOTTO_COUNT = 6;
    private List<Integer> numbers;

    public Ticket(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("numbers cannot exceed 6.");
        }

        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
