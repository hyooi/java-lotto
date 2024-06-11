package lotto.view;

import lotto.entity.GameManager;
import lotto.entity.LottoMachine;
import lotto.entity.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public abstract class ViewManager {
    protected final InputView inputView = new InputView();
    protected final ResultView resultView = new ResultView();

    private final LottoMachine lottoMachine = new LottoMachine();
    private final GameManager gameManager = new GameManager();

    public void start() {
        var amount = inputView.inputAmount();
        var manualLottos = buyManualLotto();

        var autoLottos = lottoMachine.buy(lottoMachine.calculateRemainAmount(amount, manualLottos));
        printPurchasedLotto(manualLottos, autoLottos);

        var result = gameManager.getWinningDetails(
                inputView.inputWinningNumber(),
                inputView.inputBonusNumber(),
                mergeLottos(manualLottos, autoLottos)
        );
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
