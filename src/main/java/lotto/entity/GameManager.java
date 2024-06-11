package lotto.entity;

import lotto.enums.LottoRank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameManager {
    public Map<LottoRank, Integer> getWinningDetails(LottoNumber lottoNumber, Number bonusNumber, List<LottoNumber> userTickets) {
        Map<LottoRank, Integer> result = new HashMap<>();
        for (LottoNumber ticket : userTickets) {
            var matchCount = getMatchCount(lottoNumber.getLottoNumber(), ticket);
            if (ticket.getLottoNumber().contains(bonusNumber)
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

    private int getMatchCount(List<Number> winningNumber, LottoNumber targetTicket) {
        var result = 0;
        for (var number : winningNumber) {
            if (targetTicket.getLottoNumber().contains(number)) {
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
