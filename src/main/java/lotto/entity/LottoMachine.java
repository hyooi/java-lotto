package lotto.entity;

import lotto.utils.CommonUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    public static final int LOTTO_PRICE = 1000;

    public List<LottoNumber> buy(Amount amount) {
        var lottoCount = amount.getAmount() / LOTTO_PRICE;
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> new LottoNumber(getRandomNumber()))
                .collect(Collectors.toList());
    }

    private List<Number> getRandomNumber() {
        var numbers = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(numbers);
        return CommonUtils.intListToNumberList(numbers.subList(0, 6));
    }

    public Amount calculateRemainAmount(Amount oldAmount, List<LottoNumber> manualLottos) {
        return new Amount(oldAmount.getAmount() - manualLottos.size() * LOTTO_PRICE);
    }
}
