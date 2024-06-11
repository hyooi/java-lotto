package lotto.entity;

public class LottoCount {
    private final int lottoCount;

    public LottoCount(String lottoCount) {
        this(Integer.parseInt(lottoCount));
    }

    public LottoCount(int lottoCount) {
        this.lottoCount = lottoCount;
        if (this.lottoCount < 0) {
            throw new IllegalArgumentException("The lottoCount cannot be less than 0.");
        }
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
