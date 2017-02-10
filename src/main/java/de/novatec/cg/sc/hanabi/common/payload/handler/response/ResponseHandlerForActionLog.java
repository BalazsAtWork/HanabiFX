package de.novatec.cg.sc.hanabi.common.payload.handler.response;

import java.text.MessageFormat;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.novatec.cg.sc.hanabi.client.fx.renderer.ActionLogRenderer;
import de.novatec.cg.sc.hanabi.common.ActionMessages;
import de.novatec.cg.sc.hanabi.common.response.ConnectionResponse;
import de.novatec.cg.sc.hanabi.common.response.DiscardCardResponse;
import de.novatec.cg.sc.hanabi.common.response.ErrorResponse;
import de.novatec.cg.sc.hanabi.common.response.GameOverResponse;
import de.novatec.cg.sc.hanabi.common.response.GameStartResponse;
import de.novatec.cg.sc.hanabi.common.response.HintColorResponse;
import de.novatec.cg.sc.hanabi.common.response.HintNumberResponse;
import de.novatec.cg.sc.hanabi.common.response.PlayCardResponse;

@Singleton
public class ResponseHandlerForActionLog implements ResponseHandler {

    @Inject
    private ActionLogRenderer actionLogRenderer;

    @Override
    public void handle(ConnectionResponse connectionResponse) {
        String message = MessageFormat.format(ActionMessages.CONNECTED_PLAYERS, connectionResponse.getNames());
        actionLogRenderer.log(message);
    }

    @Override
    public void handle(HintNumberResponse hintNumberResponse) {
        String message = MessageFormat.format(ActionMessages.NUMBER_HINT, hintNumberResponse.getHintingPlayer(), hintNumberResponse.getHintedNumber(),
                hintNumberResponse.getTargetPlayer());
        actionLogRenderer.log(message);
    }

    @Override
    public void handle(HintColorResponse hintColorResponse) {
        String message = MessageFormat.format(ActionMessages.COLOR_HINT, hintColorResponse.getHintingPlayer(), hintColorResponse.getHintedColor(),
                hintColorResponse.getTargetPlayer());
        actionLogRenderer.log(message);
    }

    @Override
    public void handle(PlayCardResponse playCardResponse) {
        String successOrFailed = playCardResponse.isSuccess() ? ActionMessages.SUCCESS : ActionMessages.FAILED;
        String message = MessageFormat.format(ActionMessages.PLAY_CARD, playCardResponse.getPlayingPlayer(), playCardResponse.getPlayedCard());
        actionLogRenderer.log(successOrFailed + " - " + message);
    }

    @Override
    public void handle(DiscardCardResponse discardCardResponse) {
        String message = MessageFormat.format(ActionMessages.DISCARD_CARD, discardCardResponse.getDiscardingPlayer(), discardCardResponse.getDiscardedCard());
        actionLogRenderer.log(message);
    }

    @Override
    public void handle(ErrorResponse errorResponse) {
        String message = MessageFormat.format(ActionMessages.ERROR_OCCURED, errorResponse.getErrDetails(), errorResponse.getExplanation());
        actionLogRenderer.log(message);
    }

    @Override
    public void handle(GameOverResponse gameOverResponse) {
        actionLogRenderer.log(ActionMessages.GAME_OVER);
    }

    @Override
    public void handle(GameStartResponse gameStartResponse) {
        actionLogRenderer.log(ActionMessages.GAME_START);
    }
}
