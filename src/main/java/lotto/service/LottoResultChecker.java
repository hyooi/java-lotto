package lotto.service;

import lotto.dto.LottoResult;
import lotto.entity.Lotto;
import lotto.entity.WinningLotto;
import lotto.enums.LottoRank;

import java.util.List;
import java.util.stream.Collectors;

public class LottoResultChecker {
    public LottoResult checkResult(List<Lotto> clientLottos, WinningLotto winningLotto) {
        return new LottoResult(clientLottos.stream()
                .collect(Collectors.toMap(
                        lotto -> LottoRank.of(winningLotto.getMatchCount(lotto), winningLotto.containsBonusNumber(lotto)),
                        lotto -> 1,
                        Integer::sum
                )));
    }
}
