package lotto.domain;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGame {
    private final LottoTickets lottoTickets;
    private final Money money;

    public LottoGame(LottoTickets lottoTickets, Money money) {
        this.lottoTickets = lottoTickets;
        this.money = money;
    }

    public void play() {
        ResultView.printCount(money.calculateLottoTicketCount());
        ResultView.printLottoTickets(lottoTickets);

        String winLottoNumbers = InputView.inputLatestLottoResult();

        List<LottoPrize> matchResults = lottoTickets.matchResults(new LottoTicket(LottoNumbers.of(winLottoNumbers)));
        ResultView.printStatistics(matchResults, money);
    }
}
