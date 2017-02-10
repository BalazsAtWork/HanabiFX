package de.novatec.cg.sc.hanabi.client.fx;

import com.google.inject.Inject;

import de.novatec.cg.sc.hanabi.GuiceInjector;
import de.novatec.cg.sc.hanabi.client.Client;
import de.novatec.cg.sc.hanabi.common.configuration.ServerConfig;
import de.novatec.cg.sc.hanabi.common.service.RequestSenderService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

public class ConnectController {

    @FXML
    private Button connectBtn;

    @FXML
    private TextField hostTf;

    @FXML
    private TextField portTf;

    @FXML
    private TextField playerTf;

    @Inject
    private ServerConfig serverConfig;

    @Inject
    private RequestSenderService requestSenderService;

    @FXML
    private Button startGameBtn;

    public ConnectController() {
        GuiceInjector.injectMembersInto(this);
    }

    @FXML
    private void initialize() {
        startGameBtn.setVisible(false);
        playerTf.setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.ENTER)) {
                fireConnectToServer();
            }
        });
    }

    @FXML
    public void fireConnectToServer() {
        if (!playerTf.getText().isEmpty()) {
            serverConfig.setHostName(hostTf.getText());
            serverConfig.setPort(Integer.parseInt(portTf.getText()));
            connectBtn.setVisible(false);
            Client.connectToServer();
            requestSenderService.sendConnectionRequest(playerTf.getText());
            startGameBtn.setVisible(true);
        }
    }

    @FXML
    public void fireStartGame() {
        requestSenderService.sendGameStartRequest();
        startGameBtn.setVisible(false);
    }
}
