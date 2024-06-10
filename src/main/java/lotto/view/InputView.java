package lotto.view;

import lotto.entity.Amount;
import lotto.entity.Number;
import lotto.entity.WinningNumber;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCAN = new Scanner(System.in);

    public Amount inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Amount(SCAN.nextLine());
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
