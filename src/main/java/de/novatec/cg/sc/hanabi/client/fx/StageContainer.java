package de.novatec.cg.sc.hanabi.client.fx;

import com.google.inject.Singleton;

import javafx.stage.Stage;

@Singleton
public class StageContainer {

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }
}
