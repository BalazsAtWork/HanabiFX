package de.novatec.cg.sc.hanabi.client.fx;

import com.google.inject.Inject;

import de.novatec.cg.sc.hanabi.GuiceInjector;
import de.novatec.cg.sc.hanabi.client.fx.renderer.ActionLogRenderer;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class ActionLogController {

    @Inject
    private ActionLogRenderer actionLogRenderer;

    @FXML
    private HBox actionLogHBox;

    public ActionLogController() {
        GuiceInjector.injectMembersInto(this);
    }

    @FXML
    private void initialize() {
        TextArea actionLogTa = new TextArea();
        actionLogTa.setEditable(false);

        actionLogHBox.getChildren().add(actionLogTa);
        actionLogHBox.setPadding(new Insets(10));
        HBox.setHgrow(actionLogTa, Priority.ALWAYS);

        actionLogRenderer.setActionLogTextArea(actionLogTa);
    }
}
