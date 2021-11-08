package lotto.domain;

import lotto.module.NumberGeneratorStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {

    private final List<LottoNumbers> ticket;

    public LottoTicket(final List<LottoNumbers> ticket) {
        this.ticket = ticket;
    }

    public static LottoTicket generate(final int boughtCount, final NumberGeneratorStrategy strategy) {
        return new LottoTicket(
                IntStream.range(0, boughtCount)
                        .mapToObj(i -> strategy.createLotto())
                        .collect(Collectors.toList())
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket ticket1 = (LottoTicket) o;
        return Objects.equals(ticket, ticket1.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticket);
    }

    public List<LottoNumbers> getTicket() {
        return new ArrayList<>(ticket);
    }

}