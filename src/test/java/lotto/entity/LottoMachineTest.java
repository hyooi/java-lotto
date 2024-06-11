package lotto.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    @DisplayName("입력받은 금액만큼 로또를 생성해서 반환한다.")
    void buyLotto() {
        var lottoMachine = new LottoMachine();
        var result = lottoMachine.buy(new Amount(14200));

        assertThat(result).hasSize(14);
    }

    @Test
    @DisplayName("이미 산 티켓을 제외하고 로또 구입 가능한 금액을 계산해서 반환한다.")
    void calculateRemainAmount() {
        var lottoMachine = new LottoMachine();
        var result = lottoMachine.calculateRemainAmount(new Amount(3500), List.of(
                new LottoNumber(new String[]{"1", "2", "3", "4", "5", "6"})));
        assertThat(result.getAmount())
                .isEqualTo(2500);
    }
}