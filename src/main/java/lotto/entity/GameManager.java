package lotto.entity;

import lotto.enums.LottoRank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameManager {
    public Map<LottoRank, Integer> getWinningDetails(LottoNumber winningNumber, Number bonusNumber, List<LottoNumber> userLottos) {
        Map<LottoRank, Integer> result = new HashMap<>();
        for (LottoNumber lotto : userLottos) {
            var matchCount = getMatchCount(winningNumber.getLottoNumber(), lotto);
            if (lotto.getLottoNumber().contains(bonusNumber)
                    && LottoRank.SECOND.getMatchCount() == matchCount) {
                extracted(LottoRank.SECOND, result);

                continue;
            }

            for (var lottoRank : LottoRank.values()) {
                if (lottoRank == LottoRank.SECOND) {
                    continue;
                }

                if (lottoRank.getMatchCount() == matchCount) {
                    extracted(lottoRank, result);
                }
            }

        }

        return result;
    }

    private void extracted(LottoRank rank, Map<LottoRank, Integer> result) {
        var count = result.getOrDefault(rank, 0);
        result.put(rank, count + 1);
    }

    private int getMatchCount(List<Number> winningNumber, LottoNumber userLotto) {
        var result = 0;
        for (var number : winningNumber) {
            if (userLotto.getLottoNumber().contains(number)) {
                result++;
            }
        }

        return result;
    }

    public double getProfitRate(Amount amount, Map<LottoRank, Integer> countByLottoRank) {
        var result = 0.0;
        for (LottoRank rank : LottoRank.values()) {
            result += rank.getReward() * countByLottoRank.getOrDefault(rank, 0);
        }

        return result / amount.getAmount();
    }
}
