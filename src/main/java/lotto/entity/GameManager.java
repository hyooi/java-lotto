package lotto.entity;

import lotto.enums.LottoRank;

import java.util.List;
import java.util.Map;

public class GameManager {
    public WinningDetail getWinningDetails(LottoNumber winningNumber, Number bonusNumber, List<LottoNumber> userLottos) {
        var result = new WinningDetail();
        userLottos.forEach(userLotto -> {
            var matchCount = getMatchCount(winningNumber.getLottoNumber(), userLotto);
            var bonusMatch = userLotto.getLottoNumber().contains(bonusNumber);

            result.apply(matchCount, bonusMatch);
        });

        return result;
    }

    private int getMatchCount(List<Number> winningNumber, LottoNumber userLotto) {
        return (int) winningNumber.stream()
                .filter(userLotto.getLottoNumber()::contains)
                .count();
    }

    public double getProfitRate(Amount amount, Map<LottoRank, Integer> countByLottoRank) {
        var result = 0.0;
        for (LottoRank rank : LottoRank.values()) {
            result += rank.getReward() * countByLottoRank.getOrDefault(rank, 0);
        }

        return result / amount.getAmount();
    }
}
