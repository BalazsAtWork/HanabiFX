package de.novatec.cg.sc.hanabi.common.service;

import java.io.IOException;

import javax.websocket.RemoteEndpoint.Basic;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.novatec.cg.sc.hanabi.common.Card;
import de.novatec.cg.sc.hanabi.common.enums.Color;
import de.novatec.cg.sc.hanabi.common.enums.Number;
import de.novatec.cg.sc.hanabi.common.payload.RequestMessage;
import de.novatec.cg.sc.hanabi.common.request.ConnectionRequest;
import de.novatec.cg.sc.hanabi.common.request.DiscardCardRequest;
import de.novatec.cg.sc.hanabi.common.request.HintColorRequest;
import de.novatec.cg.sc.hanabi.common.request.HintNumberRequest;
import de.novatec.cg.sc.hanabi.common.request.PlayCardRequest;
import de.novatec.cg.sc.hanabi.common.request.Request;

@Singleton
public class RequestSenderService {

    @Inject
    private JsonService jsonService;

    @Inject
    private LoggingService loggingService;

    private Basic basicRemote;

    public void setMessageSender(Basic basicRemote) {
        this.basicRemote = basicRemote;
    }

    public void sendChatMessage(String chatMessage) {
        // FIXME CREATE A CHATMESSAGEREQUEST?!?!
        sendText(chatMessage);
    }

    public void sendConnectionRequest(String playerName) {
        sendRequest(new ConnectionRequest(playerName));
    }

    public void sendDiscardCardRequest(Card cardToDiscard) {
        sendRequest(new DiscardCardRequest(cardToDiscard));
    }

    public void sendHintColorRequest(String targetPlayer, Color color, boolean positive) {
        sendRequest(new HintColorRequest(targetPlayer, color, positive));
    }

    public void sendHintNumberRequest(String targetPlayer, Number number, boolean positive) {
        sendRequest(new HintNumberRequest(targetPlayer, number, positive));
    }

    public void sendPlayCardRequest(Card card) {
        sendRequest(new PlayCardRequest(card));
    }

    private void sendRequest(Request request) {
        String requestJson = jsonService.fromObjectToJson(request);

        RequestMessage requestMessage = new RequestMessage(request.getRequestType(), requestJson);
        String finalRequest = jsonService.fromObjectToJson(requestMessage);

        sendText(finalRequest);
    }

    private void sendText(String messageToServer) {
        try {
            loggingService.logClientMessage("Message to Server: " + messageToServer);
            basicRemote.sendText(messageToServer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
