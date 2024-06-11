package lotto.entity;

import lotto.enums.LottoRank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WinningDetail {
    private final Map<LottoRank, Integer> result;

    public WinningDetail() {
        this.result = new HashMap<>();
    }

    public void apply(int matchCount, boolean bonusMatch) {
        Arrays.stream(LottoRank.values())
                .forEach(rank -> {
                    if (rank.isMatch(matchCount, bonusMatch)) {
                        var count = result.getOrDefault(rank, 0);
                        result.put(rank, count + 1);
                    }
                });
    }

    public Map<LottoRank, Integer> getResult() {
        return result;
    }
}
