package lotto.view;

import lotto.entity.GameManager;
import lotto.entity.LottoMachine;

public class ViewManager {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void start() {
        var amount = inputView.inputAmount();

        var lottoMachine = new LottoMachine();
        var lottos = lottoMachine.buy(amount);
        resultView.printPurchasedAutoLotto(lottos);

        var winningNumber = inputView.inputWinningNumber();
        var bonusNumber = inputView.inputBonusNumber();

        var gameManager = new GameManager();
        var result = gameManager.getWinningDetails(winningNumber, bonusNumber, lottos);

        resultView.printStatisticsResult(result);
        resultView.printProfitRate(gameManager.getProfitRate(amount, result));
    }
}
