package lotto.view;

import lotto.entity.Number;
import lotto.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCAN = new Scanner(System.in);

    public Amount inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Amount(SCAN.nextLine());
    }

    public LottoCount inputLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return new LottoCount(SCAN.nextLine());
    }

    public List<Ticket> inputLottoNumbers(LottoCount lottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        var result = new ArrayList<Ticket>();
        for (int i = 0; i < lottoCount.getLottoCount(); i++) {
            result.add(new Ticket(SCAN.nextLine().split(",")));
        }

        return result;
    }

    public WinningNumber inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new WinningNumber(SCAN.nextLine().split(","));
    }

    public Number inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new Number(SCAN.nextLine());
    }

}
