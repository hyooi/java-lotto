package lotto.view;

import lotto.entity.LottoNumber;

import java.util.List;

public class AllLottoViewManager extends ViewManager {
    @Override
    public List<LottoNumber> buyManualLotto() {
        var lottoCount = inputView.inputLottoCount();
        return inputView.inputLottoNumbers(lottoCount);
    }

    @Override
    void printPurchasedLotto(List<LottoNumber> manualLottos, List<LottoNumber> autoLottos) {
        resultView.printPurchasedAllLotto(manualLottos, autoLottos);
    }
}
