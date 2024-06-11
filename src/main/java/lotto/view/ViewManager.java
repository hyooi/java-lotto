package lotto.view;

import lotto.entity.GameManager;
import lotto.entity.LottoMachine;
import lotto.entity.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public abstract class ViewManager {
    protected final InputView inputView = new InputView();
    protected final ResultView resultView = new ResultView();

    public void start() {
        var amount = inputView.inputAmount();
        var manualLottos = buyManualLotto();

        var lottoMachine = new LottoMachine();
        amount = lottoMachine.calculateRemainAmount(amount, manualLottos);

        var autoLottos = lottoMachine.buy(amount);
        printPurchasedLotto(manualLottos, autoLottos);

        var winningNumber = inputView.inputWinningNumber();
        var bonusNumber = inputView.inputBonusNumber();

        var gameManager = new GameManager();
        var allLottos = mergeLottos(manualLottos, autoLottos);
        var result = gameManager.getWinningDetails(winningNumber, bonusNumber, allLottos);

        resultView.printStatisticsResult(result);
        resultView.printProfitRate(gameManager.getProfitRate(amount, result.getResult()));
    }

    private List<LottoNumber> mergeLottos(List<LottoNumber> manualLottos, List<LottoNumber> autoLottos) {
        var result = new ArrayList<>(manualLottos);
        result.addAll(autoLottos);

        return result;
    }

    List<LottoNumber> buyManualLotto() {
        return List.of();
    }

    void printPurchasedLotto(List<LottoNumber> manualLottos, List<LottoNumber> autoLottos) {
        printPurchasedLotto0(autoLottos);
    }

    void printPurchasedLotto0(List<LottoNumber> autoLottos) {
    }
}
