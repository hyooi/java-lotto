package lotto.view;

import lotto.entity.LottoNumber;

import java.util.List;

public class AutoLottoViewManager extends ViewManager {

    @Override
    void printPurchasedLotto0(List<LottoNumber> autoLottos) {
        resultView.printPurchasedAutoLotto(autoLottos);
    }
}
