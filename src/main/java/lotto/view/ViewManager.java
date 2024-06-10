package lotto.view;

import lotto.entity.GameManager;
import lotto.entity.TicketMachine;

public class ViewManager {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void start() {
        var amount = inputView.inputAmount();

        var ticketMachine = new TicketMachine();
        var tickets = ticketMachine.buy(amount);
        resultView.showTicketDetail(tickets);

        var winningNumber = inputView.inputWinningNumber();
        var bonusNumber = inputView.inputBonusNumber();

        var gameManager = new GameManager();
        var result = gameManager.getWinningDetails(winningNumber, bonusNumber, tickets);

        resultView.showStatistics(result);
        resultView.showProfitRate(gameManager.getProfitRate(amount, result));
    }
}
