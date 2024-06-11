package lotto.entity;

import lotto.utils.CommonUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    public static final int TICKET_PRICE = 1000;

    public List<LottoNumber> buy(Amount amount) {
        var ticketCount = amount.getAmount() / TICKET_PRICE;

        var tickets = new ArrayList<LottoNumber>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(new LottoNumber(getRandomNumber()));
        }

        return tickets;
    }

    private List<Number> getRandomNumber() {
        var numbers = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(numbers);
        return CommonUtils.intListToNumberList(numbers.subList(0, 6));
    }

    public Amount calculateRemainAmount(Amount oldAmount, List<LottoNumber> manualTickets) {
        return new Amount(oldAmount.getAmount() - manualTickets.size() * TICKET_PRICE);
    }
}
