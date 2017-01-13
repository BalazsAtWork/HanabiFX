package de.novatec.cg.sc.hanabi.common.payload.handler.response;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.novatec.cg.sc.hanabi.common.response.ErrorResponse;
import de.novatec.cg.sc.hanabi.common.service.LoggingService;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

@Singleton
public class ErrorResponseHandler {

    @Inject
    private LoggingService loggingService;

    public void handle(ErrorResponse errorResponse) {
        loggingService.logClientMessage("HANDLE ERRORRESPONSE-->" + errorResponse);

        Platform.runLater(() -> {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error from Server");
            alert.setHeaderText(null);
            alert.setContentText("ERROR: " + errorResponse.getExplanation());
            alert.showAndWait();
        });
    }
}
