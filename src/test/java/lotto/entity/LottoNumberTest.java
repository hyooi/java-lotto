package lotto.entity;

import lotto.utils.CommonUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {
    @Test
    @DisplayName("로또티켓은 6개 숫자를 가질 수 있다.")
    void lotto() {
        var lotto = new LottoNumber(CommonUtils.intListToNumberList(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(lotto.getLottoNumber())
                .hasSize(6);
    }

    @Test
    @DisplayName("로또티켓에 6개가 아닌 숫자가 들어갈 경우 에러가 발생한다.")
    void lottoException() {
        assertThatThrownBy(() -> {
            var lotto = new LottoNumber(CommonUtils.intListToNumberList(List.of(1, 2, 3, 4, 5, 6, 7)));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("numbers cannot exceed 6.");
    }
}