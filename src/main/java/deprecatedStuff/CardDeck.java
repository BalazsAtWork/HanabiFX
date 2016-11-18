package deprecatedStuff;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import de.novatec.cg.sc.hanabi.common.Card;

public class CardDeck {

    private final Queue<Card> deck = new LinkedList<>();

    public CardDeck(List<Card> cards) {
        deck.addAll(cards);
    }

    public Card getNextCard() {
        return deck.poll();
    }
}
