package de.novatec.cg.sc.hanabi.common;

import com.google.gson.annotations.SerializedName;

public class CardInHand {

    @SerializedName("card")
    private Card card;

    @SerializedName("card_knowledge")
    private CardKnowledge cardKnowledge;

    public Card getCard() {
        return card;
    }

    public CardKnowledge getCardKnowledge() {
        return cardKnowledge;
    }
}
