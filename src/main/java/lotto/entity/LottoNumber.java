package lotto.entity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumber {
    private static final int LOTTO_COUNT = 6;
    private final List<Number> lottoNumber;

    public LottoNumber(String[] lottoNumbers) {
        this(Arrays.stream(lottoNumbers)
                .map(s -> Number.of(Integer.parseInt(s.trim())))
                .collect(Collectors.toList()));
    }

    public LottoNumber(List<Number> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("numbers cannot exceed 6.");
        }

        this.lottoNumber = lottoNumbers;
    }

    public List<Number> getLottoNumber() {
        return lottoNumber;
    }
}
