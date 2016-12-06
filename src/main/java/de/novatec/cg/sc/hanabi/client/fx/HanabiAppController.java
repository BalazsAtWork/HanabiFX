package de.novatec.cg.sc.hanabi.client.fx;

import com.google.inject.Inject;

import de.novatec.cg.sc.hanabi.GuiceInjector;
import de.novatec.cg.sc.hanabi.client.Client;
import de.novatec.cg.sc.hanabi.client.fx.renderer.GameStateRenderer;
import de.novatec.cg.sc.hanabi.common.service.RequestSenderService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class HanabiAppController {

    @FXML
    private AnchorPane mainAnchorPane;

    @Inject
    private RequestSenderService requestSenderService;

    @Inject
    private GameStateRenderer gameStateRenderer;

    public HanabiAppController() {
        GuiceInjector.injectMembersInto(this);
    }

    @FXML
    private void connectionRequestAction() {
    }

    @FXML
    private void initialize() {
        Client.connectToServer();
        gameStateRenderer.setMainAnchorPanel(mainAnchorPane);

        HBox userConnectHbox = new HBox(10.0);
        mainAnchorPane.getChildren().add(userConnectHbox);

        TextField currentUserTf = new TextField();
        currentUserTf.setLayoutX(10);
        currentUserTf.setLayoutY(10);
        currentUserTf.setPrefWidth(90);
        currentUserTf.setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.ENTER)) {
                userConnectHbox.getChildren().clear();
                requestSenderService.sendConnectionRequest(currentUserTf.getText());
            }
        });
        userConnectHbox.getChildren().add(currentUserTf);

        Button connectBtn = new Button();
        connectBtn.setPrefWidth(40);
        connectBtn.setText("GO");
        connectBtn.setLayoutX(100);
        connectBtn.setLayoutY(10);
        connectBtn.setOnMouseClicked(e -> {
            userConnectHbox.getChildren().clear();
            requestSenderService.sendConnectionRequest(currentUserTf.getText());
        });
        userConnectHbox.getChildren().add(connectBtn);
    }
}
