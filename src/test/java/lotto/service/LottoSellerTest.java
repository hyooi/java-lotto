package lotto.service;

import lotto.entity.Lotto;
import lotto.entity.LottoBudget;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.entity.Lotto.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoSellerTest {
    private final LottoSeller seller = new LottoSeller();

    @Test
    @DisplayName("로또는 1~45의 6개 숫자로 구성된다.")
    void buy1() {
        var result = seller.buyLotto(new LottoBudget(2000));
        assertThat(result)
                .hasSize(2)
                .extracting(Lotto::getNumbers)
                .allSatisfy(numbers -> {
                    assertThat(numbers)
                            .hasSize(LOTTO_NUMBER_COUNT)
                            .allMatch(number -> number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER);
                });
    }

    @Test
    @DisplayName("최대로 구매 가능한 로또를 생성해 반환한다.")
    void buy3() {
        var result = seller.buyLotto(new LottoBudget(3500));
        assertThat(result)
                .hasSize(3)
                .extracting(Lotto::getNumbers)
                .allSatisfy(numbers -> {
                    assertThat(numbers)
                            .hasSize(LOTTO_NUMBER_COUNT)
                            .allMatch(number -> number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER);
                });
    }
}