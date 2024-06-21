package lotto.view;

import lotto.entity.Lotto;
import lotto.entity.LottoBudget;

import java.util.List;

public class AutoRottoRunner extends RottoRunner {

    @Override
    protected List<Lotto> buyManualLotto(LottoBudget budget) {
        return List.of();
    }

    @Override
    protected void printLotto(List<Lotto> manualLottos, List<Lotto> autoLottos) {
        resultView.printLottos(autoLottos);
    }
}
