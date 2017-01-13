package de.novatec.cg.sc.hanabi.common.payload.handler.response;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.novatec.cg.sc.hanabi.common.response.GameOverResponse;
import de.novatec.cg.sc.hanabi.common.service.LoggingService;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

@Singleton
public class GameOverResponseHandler {

    @Inject
    private LoggingService loggingService;

    public void handle(GameOverResponse gameOverResponse) {
        loggingService.logClientMessage("HANDLE GAMEOVERERSPONSE-->" + gameOverResponse);

        Platform.runLater(() -> {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("GAME OVER");
            alert.setHeaderText(null);
            alert.setContentText("The game is over! You and your teammates have reached (" + gameOverResponse.getScore() + ") Points!");
            alert.showAndWait();
        });
    }
}
