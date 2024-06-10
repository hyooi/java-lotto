package lotto.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TicketTest {
    @Test
    @DisplayName("로또티켓은 6개 숫자를 가질 수 있다.")
    void ticket() {
        var ticket = new Ticket(List.of(1, 2, 3, 4, 5, 6));
        assertThat(ticket.getNumbers())
                .hasSize(6);
    }

    @Test
    @DisplayName("로또티켓에 6개가 아닌 숫자가 들어갈 경우 에러가 발생한다.")
    void ticketException() {
        assertThatThrownBy(() -> {
            var ticket = new Ticket(List.of(1, 2, 3, 4, 5, 6, 7));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("numbers cannot exceed 6.");
    }
}