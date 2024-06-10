package lotto.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameManagerTest {
    @Test
    @DisplayName("당첨번호와 티켓리스트를 받아서 그에 맞는 통계를 리턴한다.")
    void statistics() {
        var manager = new GameManager();
        var result = manager.getWinningDetails(List.of(6, 5, 4, 3, 2, 1),
                7,
                List.of(
                        new Ticket(List.of(11, 22, 33, 10, 20, 30)),
                        new Ticket(List.of(1, 2, 3, 4, 5, 6)),
                        new Ticket(List.of(1, 2, 3, 4, 5, 7))
                ));

        assertThat(result)
                .hasSize(2)
                .containsEntry(LottoRank.FIRST, 1)
                .containsEntry(LottoRank.SECOND, 1)
                .doesNotContainKeys(LottoRank.THIRD, LottoRank.FOURTH, LottoRank.FIFTH);
    }
}