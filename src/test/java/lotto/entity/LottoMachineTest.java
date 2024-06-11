package lotto.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {
    @Test
    @DisplayName("입력받은 금액만큼 로또를 생성해서 반환한다.")
    void buyLotto() {
        var lottoMachine = new LottoMachine();
        var result = lottoMachine.buy(new Amount(14200));

        assertThat(result).hasSize(14);
    }
}