package lotto.service;

import lotto.entity.Lotto;
import lotto.entity.LottoBudget;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.entity.Lotto.*;

public class LottoSeller {
    private final List<Integer> lottos = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    public List<Lotto> buyLotto(LottoBudget budget) {
        return IntStream.range(0, budget.getAvailableLottoCount())
                .mapToObj(i -> new Lotto(randomNumbers()))
                .collect(Collectors.toList());
    }

    private Set<Integer> randomNumbers() {
        Collections.shuffle(lottos);
        return new HashSet<>(lottos.subList(0, LOTTO_NUMBER_COUNT));
    }
}
