package lotto.view;

import lotto.entity.LottoNumber;
import lotto.enums.LottoRank;

import java.util.List;
import java.util.Map;

public class ResultView {
    public void showTicketDetail(List<LottoNumber> tickets) {
        System.out.printf("%s개를 구매했습니다. \n", tickets.size());
        for (var ticket : tickets) {
            System.out.println(ticket.getLottoNumber());
        }

        System.out.println();
    }

    public void showTicketDetail2(List<LottoNumber> manualTickets, List<LottoNumber> autoTickets) {
        System.out.printf("수동으로 %s장, 자동으로 %s개를 구매했습니다. \n", manualTickets.size(), autoTickets.size());
        for (var ticket : manualTickets) {
            System.out.println(ticket.getLottoNumber());
        }

        for (var ticket : autoTickets) {
            System.out.println(ticket.getLottoNumber());
        }

        System.out.println();
    }

    public void showStatistics(Map<LottoRank, Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("-------");

        for (LottoRank rank : LottoRank.values()) {
            System.out.printf("%s개 일치 (%s원)-%s개\n", rank.getMatchCount(), rank.getReward(), result.getOrDefault(rank, 0));
        }
    }

    public void showProfitRate(double profitRate) {
        if (profitRate < 1) {
            System.out.printf("총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)\n", profitRate);
            return;
        }

        System.out.printf("총 수익률은 %.2f입니다.\n", profitRate);
    }
}
