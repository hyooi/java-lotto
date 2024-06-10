package lotto.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameManager {
    public Map<LottoRank, Integer> getWinningDetails(List<Integer> winningNumber, int bonusNumber, List<Ticket> userTickets) {
        Map<LottoRank, Integer> result = new HashMap<>();
        for (Ticket ticket : userTickets) {
            var matchCount = getMatchCount(winningNumber, ticket);
            if (ticket.getNumbers().contains(bonusNumber)
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

    private int getMatchCount(List<Integer> winningNumber, Ticket targetTicket) {
        var result = 0;
        for (var number : winningNumber) {
            if (targetTicket.getNumbers().contains(number)) {
                result++;
            }
        }

        return result;
    }
}
