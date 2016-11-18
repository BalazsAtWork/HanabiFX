package deprecatedStuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import com.google.inject.Singleton;

import de.novatec.cg.sc.hanabi.common.Card;
import de.novatec.cg.sc.hanabi.common.enums.Color;
import de.novatec.cg.sc.hanabi.common.enums.Number;

@Singleton
public class CardService {

    public List<Card> generateCards() {
        List<Pair<Integer, Number>> occurencePerValue = Arrays.asList(Pair.of(3, Number.ONE), Pair.of(2, Number.TWO), Pair.of(2, Number.THREE),
                Pair.of(2, Number.FOUR), Pair.of(1, Number.FIVE));

        List<Card> cards = new ArrayList<>();
        for (Color color : Color.values()) {
            for (Pair<Integer, Number> occurence : occurencePerValue) {
                for (int i = 0; i < occurence.getLeft(); i++) {
                    cards.add(new Card(color, occurence.getRight()));
                }
            }
        }
        return cards;
    }

    public void shuffleCards(List<Card> cards) {
        Collections.shuffle(cards);
    }
}
