package lotto.view;

import lotto.entity.LottoNumber;
import lotto.enums.LottoRank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ResultView {
    public void printPurchasedAutoLotto(List<LottoNumber> lottos) {
        System.out.printf("%s개를 구매했습니다. \n", lottos.size());
        lottos.forEach(lottoNumber -> System.out.println(lottoNumber.getLottoNumber()));

        System.out.println();
    }

    public void printPurchasedAllLotto(List<LottoNumber> manualLottos, List<LottoNumber> autoLottos) {
        System.out.printf("수동으로 %s장, 자동으로 %s개를 구매했습니다. \n", manualLottos.size(), autoLottos.size());
        manualLottos.forEach(lottoNumber -> System.out.println(lottoNumber.getLottoNumber()));
        autoLottos.forEach(lottoNumber -> System.out.println(lottoNumber.getLottoNumber()));

        System.out.println();
    }

    public void printStatisticsResult(Map<LottoRank, Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("-------");

        Arrays.stream(LottoRank.values())
                .forEach(rank -> {
                    System.out.printf("%s개 일치 (%s원)-%s개\n", rank.getMatchCount(), rank.getReward(), result.getOrDefault(rank, 0));
                });
    }

    public void printProfitRate(double profitRate) {
        if (profitRate < 1) {
            System.out.printf("총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)\n", profitRate);
            return;
        }

        System.out.printf("총 수익률은 %.2f입니다.\n", profitRate);
    }
}
