package lotto.entity;

public class LottoBudget {
    private static final int LOTTO_PRICE = 1000;
    private final int money;

    public LottoBudget(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException("budget은 0 이하일 수 없습니다.");
        }

        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public LottoBudget getBudgetExcludingLotto(int lottoCount) {
        var lottoPrice = LOTTO_PRICE * lottoCount;
        if (lottoPrice > money) {
            throw new IllegalArgumentException(
                    String.format("예산이 부족합니다. 필요 금액 : %s, 현재 금액 : %s", lottoPrice, money)
            );
        }

        return new LottoBudget(money - lottoPrice);
    }

    public int getAvailableLottoCount() {
        return money / LOTTO_PRICE;
    }
}
