package lotto.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameManager {
    public Map<LottoRank, Integer> getWinningDetails(List<Integer> winningNumber, int bonusNumber, List<Ticket> userTickets) {
        Map<LottoRank, Integer> result = new HashMap<>();
        for (Ticket ticket : userTickets) {
            var matchCount = getMatchCount(winningNumber, ticket);
            if (ticket.getNumbers().contains(bonusNumber) && 5 == matchCount) {
                var count = result.getOrDefault(LottoRank.SECOND, 0);
                result.put(LottoRank.SECOND, count + 1);

                continue;
            }

            for (var statistics : LottoRank.values()) {
                if (statistics == LottoRank.SECOND) {
                    continue;
                }

                if (statistics.getMatchCount() == matchCount) {
                    var count = result.getOrDefault(statistics, 0);
                    result.put(statistics, count + 1);
                }
            }

        }

        return result;
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
