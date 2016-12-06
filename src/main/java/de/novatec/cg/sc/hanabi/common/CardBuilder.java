package de.novatec.cg.sc.hanabi.common;

import de.novatec.cg.sc.hanabi.common.enums.Color;
import de.novatec.cg.sc.hanabi.common.enums.Number;

public class CardBuilder {

    private Card card;

    private CardBuilder(Card card) {
        this.card = card;
    }

    public CardBuilder withColorBLUE() {
        card.setColor(Color.BLUE);
        return this;
    }

    public CardBuilder withColorGREEN() {
        card.setColor(Color.GREEN);
        return this;
    }

    public CardBuilder withColorRED() {
        card.setColor(Color.RED);
        return this;
    }

    public CardBuilder withColorWHITE() {
        card.setColor(Color.WHITE);
        return this;
    }

    public CardBuilder withColorYELLOW() {
        card.setColor(Color.YELLOW);
        return this;
    }

    public CardBuilder withNumberONE() {
        card.setNumber(Number.ONE);
        return this;
    }

    public CardBuilder withNumberTWO() {
        card.setNumber(Number.TWO);
        return this;
    }

    public CardBuilder withNumberTHREE() {
        card.setNumber(Number.THREE);
        return this;
    }

    public CardBuilder withNumberFOUR() {
        card.setNumber(Number.FOUR);
        return this;
    }

    public CardBuilder withNumberFIVE() {
        card.setNumber(Number.FIVE);
        return this;
    }

    public Card build() {
        return card;
    }

    public static final CardBuilder newCard() {
        return new CardBuilder(new Card());
    }

}
