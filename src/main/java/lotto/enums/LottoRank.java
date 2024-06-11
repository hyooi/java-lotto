package lotto.enums;

public enum LottoRank {
    FIFTH(3, 5000) {
        @Override
        public boolean isMatch(int matchCount, boolean bonusMatch) {
            return matchCount == getMatchCount();
        }
    },
    FOURTH(4, 50000) {
        @Override
        public boolean isMatch(int matchCount, boolean bonusMatch) {
            return matchCount == getMatchCount();
        }
    },
    THIRD(5, 1500000) {
        @Override
        public boolean isMatch(int matchCount, boolean bonusMatch) {
            return matchCount == getMatchCount() && !bonusMatch;
        }
    },
    SECOND(5, 30000000) {
        @Override
        public boolean isMatch(int matchCount, boolean bonusMatch) {
            return matchCount == getMatchCount() && bonusMatch;
        }
    },
    FIRST(6, 2000000000) {
        @Override
        public boolean isMatch(int matchCount, boolean bonusMatch) {
            return matchCount == getMatchCount();
        }
    };

    private final int matchCount;
    private final int reward;

    LottoRank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

    public abstract boolean isMatch(int matchCount, boolean bonusMatch);
}
