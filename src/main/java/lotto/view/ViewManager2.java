package lotto.view;

import lotto.entity.GameManager;
import lotto.entity.LottoMachine;

public class ViewManager2 {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void start() {
        var amount = inputView.inputAmount();
        var lottoCount = inputView.inputLottoCount();
        var manualTickets = inputView.inputLottoNumbers(lottoCount);

        var ticketMachine = new LottoMachine();
        var remainAmount = ticketMachine.calculateRemainAmount(amount, manualTickets);
        var autoTickets = ticketMachine.buy(remainAmount);
        resultView.showTicketDetail2(manualTickets, autoTickets);

        var winningNumber = inputView.inputWinningNumber();
        var bonusNumber = inputView.inputBonusNumber();

        var gameManager = new GameManager();
        manualTickets.addAll(autoTickets);
        var result = gameManager.getWinningDetails(winningNumber, bonusNumber, manualTickets);

        resultView.showStatistics(result);
        resultView.showProfitRate(gameManager.getProfitRate(amount, result));
    }
}
