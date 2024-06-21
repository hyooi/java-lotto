package lotto.view;

import lotto.entity.Lotto;
import lotto.entity.LottoBudget;

import java.util.List;

public class ManualRottoRunner extends RottoRunner {

    @Override
    protected List<Lotto> buyManualLotto(LottoBudget budget) {
        return inputView.inputManualLotto(budget);
    }

    @Override
    protected void printLotto(List<Lotto> manualLottos, List<Lotto> autoLottos) {
        resultView.printLottos(manualLottos, autoLottos);
    }
}
