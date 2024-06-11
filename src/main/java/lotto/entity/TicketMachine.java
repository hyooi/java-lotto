package lotto.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TicketMachine {
    public static final int TICKET_PRICE = 1000;

    public List<Ticket> autoPurchase(Amount amount) {
        var ticketCount = amount.getAmount() / TICKET_PRICE;

        var tickets = new ArrayList<Ticket>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(new Ticket(getRandomNumber()));
        }

        return tickets;
    }

    // TODO 이름좀 바꿔;;
    public List<Ticket> manualPurchase(Amount amount, List<Ticket> lottoManualTickets) {
        var ticketCount = (amount.getAmount() / TICKET_PRICE) - lottoManualTickets.size();

        var tickets = new ArrayList<Ticket>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(new Ticket(getRandomNumber()));
        }

        return tickets;
    }

    private List<Integer> getRandomNumber() {
        var numbers = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }
}
