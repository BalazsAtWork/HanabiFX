package de.novatec.cg.sc.hanabi.client.fx;

import com.google.inject.Inject;

import de.novatec.cg.sc.hanabi.GuiceInjector;
import de.novatec.cg.sc.hanabi.client.fx.renderer.GameStateRenderer;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class HanabiAppController {

    @FXML
    private AnchorPane mainAnchorPane;

    @Inject
    private GameStateRenderer gameStateRenderer;

    public HanabiAppController() {
        GuiceInjector.injectMembersInto(this);
    }

    @FXML
    private void initialize() {
        gameStateRenderer.setMainAnchorPanel(mainAnchorPane);
    }
}
