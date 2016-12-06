package de.novatec.cg.sc.hanabi.common;

import de.novatec.cg.sc.hanabi.common.enums.Color;
import de.novatec.cg.sc.hanabi.common.enums.Number;

public class CardKnowledgeBuilder {

    private CardKnowledge cardKnowledge;

    private CardKnowledgeBuilder(CardKnowledge card) {
        this.cardKnowledge = card;
    }

    public CardKnowledgeBuilder playerKnowsColor() {
        cardKnowledge.setPlayerKnowsColor(true);
        return this;
    }

    public CardKnowledgeBuilder playerKnowsNumber() {
        cardKnowledge.setPlayerKnowsNumber(true);
        return this;
    }

    public CardKnowledgeBuilder playerKnowsNotColor(Color color) {
        cardKnowledge.getKnowsColorNot().add(color);
        return this;
    }

    public CardKnowledgeBuilder playerKnowsNotNumber(Number number) {
        cardKnowledge.getKnowsNumberNot().add(number);
        return this;
    }

    public CardKnowledge build() {
        return cardKnowledge;
    }

    public static final CardKnowledgeBuilder newCardKnowledge() {
        return new CardKnowledgeBuilder(new CardKnowledge());
    }

}
