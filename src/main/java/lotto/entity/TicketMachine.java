package lotto.entity;

import lotto.utils.CommonUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TicketMachine {
    public static final int TICKET_PRICE = 1000;

    public List<LottoNumber> autoPurchase(Amount amount) {
        var ticketCount = amount.getAmount() / TICKET_PRICE;

        var tickets = new ArrayList<LottoNumber>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(new LottoNumber(getRandomNumber()));
        }

        return tickets;
    }

    // TODO 이름좀 바꿔;;
    public List<LottoNumber> manualPurchase(Amount amount, List<LottoNumber> lottoManualTickets) {
        var ticketCount = (amount.getAmount() / TICKET_PRICE) - lottoManualTickets.size();

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
}
