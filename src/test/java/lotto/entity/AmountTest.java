package lotto.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AmountTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void success1(int value) {
        var amount = new Amount(value);
        assertThat(amount.getAmount()).isEqualTo(value);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void success1(String value) {
        var amount = new Amount(value);
        assertThat(amount.getAmount()).isEqualTo(Integer.parseInt(value));
    }

    @Test
    void failed1() {
        assertThatThrownBy(() -> {
            var amount = new Amount(-1);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("The amount cannot be less than 0.");
    }
}