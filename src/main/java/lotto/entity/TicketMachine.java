package lotto.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TicketMachine {

    public List<Ticket> buy(int price) {
        var ticketCount = price / 1000;

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
