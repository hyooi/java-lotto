package lotto.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoBudgetTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 1100, 1200})
    @DisplayName("budget은 0이상이어야 한다.")
    void budget(int money) {
        var budget = new LottoBudget(money);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("0이하의 budget은 예외를 발생시킨다.")
    void budget_error(int money) {
        assertThatThrownBy(() -> {
            var budget = new LottoBudget(money);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("budget은 0 이하일 수 없습니다.");
    }

    @Test
    @DisplayName("로또갯수를 넘겨주면 해당 금액을 제외한 budget을 반환한다.")
    void budget_lotto() {
        var budget = new LottoBudget(3000);
        var newBudget = budget.getBudgetExcludingLotto(2);
        assertThat(newBudget)
                .hasFieldOrPropertyWithValue("money", 1000);
    }

    @Test
    @DisplayName("로또갯수를 넘겨주면 해당 금액을 제외한 budget을 반환한다. 부족할 시 에러를 발생시킨다.")
    void budget_lotto_error() {
        var budget = new LottoBudget(1000);
        assertThatThrownBy(() -> {
            var newBudget = budget.getBudgetExcludingLotto(2);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("예산이 부족합니다. 필요 금액 : 2000, 현재 금액 : 1000");
    }
}