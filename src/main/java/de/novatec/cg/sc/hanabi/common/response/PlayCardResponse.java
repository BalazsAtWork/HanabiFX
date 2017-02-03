package de.novatec.cg.sc.hanabi.common.response;

import de.novatec.cg.sc.hanabi.common.Card;

public class PlayCardResponse extends GameStateResponse {

    private String playingPlayer;
    private Card playedCard;
    private Card drawnCard;
    private boolean success;

    public String getPlayingPlayer() {
        return playingPlayer;
    }

    public Card getPlayedCard() {
        return playedCard;
    }

    public Card getDrawnCard() {
        return drawnCard;
    }

    public boolean isSuccess() {
        return success;
    }

    @Override
    public String toString() {
        return "PlayCardResponse [playingPlayer=" + playingPlayer + ", playedCard=" + playedCard + ", drawnCard=" + drawnCard + ", success=" + success + "]";
    }
}
