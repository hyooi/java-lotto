package lotto.entity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ticket {
    private static final int LOTTO_COUNT = 6;
    private List<Integer> numbers;

    public Ticket(String[] winningNumbers) {
        this(Arrays.stream(winningNumbers)
                .mapToInt(value -> Integer.parseInt(value.trim()))
                .boxed()
                .collect(Collectors.toList()));
    }

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
