package lotto.entity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumber {
    private static final int LOTTO_COUNT = 6;
    private final List<Integer> lottoNumber;

    public LottoNumber(String[] lottoNumbers) {
        this(Arrays.stream(lottoNumbers)
                .mapToInt(value -> Integer.parseInt(value.trim()))
                .boxed()
                .collect(Collectors.toList()));
    }

    public LottoNumber(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("numbers cannot exceed 6.");
        }

        this.lottoNumber = lottoNumbers;
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }
}
