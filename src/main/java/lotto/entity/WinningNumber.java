package lotto.entity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {
    private static final int LOTTO_COUNT = 6;
    private final List<Integer> winningNumber;

    public WinningNumber(String[] winningNumbers) {
        this(Arrays.stream(winningNumbers)
                .mapToInt(value -> Integer.parseInt(value.trim()))
                .boxed()
                .collect(Collectors.toList()));
    }

    public WinningNumber(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("The winning number must be 6.");
        }

        this.winningNumber = winningNumbers;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }
}
