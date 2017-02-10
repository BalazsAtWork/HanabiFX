package de.novatec.cg.sc.hanabi.common;

import com.google.gson.annotations.SerializedName;

public class CardInHand {

    @SerializedName("card")
    private Card card;

    @SerializedName("knowledge")
    private CardKnowledge cardKnowledge;

    public CardInHand(Card card, CardKnowledge cardKnowledge) {
        this.card = card;
        this.cardKnowledge = cardKnowledge;
    }

    public Card getCard() {
        return card;
    }

    public CardKnowledge getCardKnowledge() {
        return cardKnowledge;
    }

    @Override
    public String toString() {
        return "CardInHand [card=" + card + ", cardKnowledge=" + cardKnowledge + "]";
    }
}
