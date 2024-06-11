package lotto.view;

import lotto.entity.GameManager;
import lotto.entity.LottoMachine;

public class ViewManager2 {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void start() {
        var amount = inputView.inputAmount();
        var lottoCount = inputView.inputLottoCount();
        var manualLottos = inputView.inputLottoNumbers(lottoCount);

        var lottoMachine = new LottoMachine();
        var remainAmount = lottoMachine.calculateRemainAmount(amount, manualLottos);
        var autoLottos = lottoMachine.buy(remainAmount);
        resultView.printPurchasedAllLotto(manualLottos, autoLottos);

        var winningNumber = inputView.inputWinningNumber();
        var bonusNumber = inputView.inputBonusNumber();

        var gameManager = new GameManager();
        manualLottos.addAll(autoLottos);
        var result = gameManager.getWinningDetails(winningNumber, bonusNumber, manualLottos);

        resultView.printStatisticsResult(result);
        resultView.printProfitRate(gameManager.getProfitRate(amount, result));
    }
}
