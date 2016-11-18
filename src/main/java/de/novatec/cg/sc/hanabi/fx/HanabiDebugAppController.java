package de.novatec.cg.sc.hanabi.fx;

import com.google.inject.Inject;

import de.novatec.cg.sc.hanabi.GuiceInjector;
import de.novatec.cg.sc.hanabi.common.Card;
import de.novatec.cg.sc.hanabi.common.service.RequestSenderService;
import javafx.fxml.FXML;

public class HanabiDebugAppController extends HanabiDebugAppUiFields {

    @Inject
    private RequestSenderService requestSenderService;

    public HanabiDebugAppController() {
        GuiceInjector.injectMembersInto(this);
    }

    @FXML
    private void connectionRequestAction() {
        requestSenderService.sendConnectionRequest(getPlayerName());
    }

    @FXML
    private void discardCardRequestAction() {
        requestSenderService.sendDiscardCardRequest(new Card(getSelectedColor(), getSelectedNumber()));
    }

    @FXML
    private void hintColorRequestAction() {
        requestSenderService.sendHintColorRequest(getPlayerName(), getSelectedColor(), isPositiveCheckboxSelected());
    }

    @FXML
    private void hintNumberRequestAction() {
        requestSenderService.sendHintNumberRequest(getPlayerName(), getSelectedNumber(), isPositiveCheckboxSelected());
    }

    @FXML
    private void playCardRequestAction() {
        requestSenderService.sendPlayCardRequest(new Card(getSelectedColor(), getSelectedNumber()));
    }
}
