package de.novatec.cg.sc.hanabi.client.fx.renderer;

import com.google.inject.Singleton;

import javafx.scene.control.TextArea;

@Singleton
public class ActionLogRenderer {

    private TextArea actionLogTextArea;

    public void setActionLogTextArea(TextArea actionLogTextArea) {
        this.actionLogTextArea = actionLogTextArea;
    }

    public void log(String action) {
        actionLogTextArea.appendText(action + "\n");
    }
}
