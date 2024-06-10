import lotto.entity.GameManager;
import lotto.entity.LottoRank;
import lotto.entity.TicketMachine;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);

        var ticketMachine = new TicketMachine();
        var amount = Integer.parseInt(scanner.nextLine());
        var tickets = ticketMachine.buy(amount);
        System.out.printf("%s개를 구매했습니다. \n", tickets.size());
        for (var ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }

        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        var winningNumber = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(value -> Integer.parseInt(value.trim()))
                .boxed()
                .collect(Collectors.toList());

        System.out.println("보너스 볼을 입력해 주세요.");
        var bonusNumber = Integer.parseInt(scanner.nextLine());

        System.out.println("당첨 통계");
        System.out.println("-------");
        var gameManager = new GameManager();
        var result = gameManager.getWinningDetails(winningNumber, bonusNumber, tickets);

        var revenue = 0.0;
        for (LottoRank rank : LottoRank.values()) {
            revenue += rank.getReward() * result.getOrDefault(rank, 0);
            System.out.printf("%s개 일치 (%s원)-%s개\n", rank.getMatchCount(), rank.getReward(), result.getOrDefault(rank, 0));
        }

        System.out.printf("총 수익률은 %s입니다. %s", revenue / amount, revenue / amount < 1 ? "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" : "");
    }
}
