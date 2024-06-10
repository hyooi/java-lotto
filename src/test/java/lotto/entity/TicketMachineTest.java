package lotto.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TicketMachineTest {
    @Test
    @DisplayName("입력받은 금액만큼 티켓을 생성해서 반환한다.")
    void buyTickets() {
        var ticketMachine = new TicketMachine();
        var result = ticketMachine.buy(new Amount(14200));

        assertThat(result).hasSize(14);
    }
}