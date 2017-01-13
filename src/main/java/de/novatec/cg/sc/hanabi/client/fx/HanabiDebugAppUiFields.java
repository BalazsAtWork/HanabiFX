package de.novatec.cg.sc.hanabi.client.fx;

import de.novatec.cg.sc.hanabi.client.Client;
import de.novatec.cg.sc.hanabi.common.enums.Color;
import de.novatec.cg.sc.hanabi.common.enums.Number;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public abstract class HanabiDebugAppUiFields {

    @FXML
    private TextField playerNameTf;

    @FXML
    private Button connectionRequestBtn;

    @FXML
    private Button discardCardRequestBtn;

    @FXML
    private Button hintColorRequestBtn;

    @FXML
    private Button hintNumberRequestBtn;

    @FXML
    private Button playCardRequestBtn;

    @FXML
    private RadioButton blueRb;

    @FXML
    private RadioButton greenRb;

    @FXML
    private RadioButton redRb;

    @FXML
    private RadioButton whiteRb;

    @FXML
    private RadioButton yellowRb;

    @FXML
    private RadioButton oneRb;

    @FXML
    private RadioButton twoRb;

    @FXML
    private RadioButton threeRb;

    @FXML
    private RadioButton fourRb;

    @FXML
    private RadioButton fiveRb;

    private Color selectedColor;

    private Number selectedNumber;

    @FXML
    private void initialize() {
        Client.connectToServer();
        playerNameTf.setText("THYBRIS");

        ToggleGroup colorToggleGroup = new ToggleGroup();
        blueRb.setToggleGroup(colorToggleGroup);
        greenRb.setToggleGroup(colorToggleGroup);
        redRb.setToggleGroup(colorToggleGroup);
        whiteRb.setToggleGroup(colorToggleGroup);
        yellowRb.setToggleGroup(colorToggleGroup);

        blueRb.setOnAction(e -> selectedColor = Color.BLUE);
        greenRb.setOnAction(e -> selectedColor = Color.GREEN);
        redRb.setOnAction(e -> selectedColor = Color.RED);
        whiteRb.setOnAction(e -> selectedColor = Color.WHITE);
        yellowRb.setOnAction(e -> selectedColor = Color.YELLOW);

        ToggleGroup numberToggleGroup = new ToggleGroup();
        oneRb.setToggleGroup(numberToggleGroup);
        twoRb.setToggleGroup(numberToggleGroup);
        threeRb.setToggleGroup(numberToggleGroup);
        fourRb.setToggleGroup(numberToggleGroup);
        fiveRb.setToggleGroup(numberToggleGroup);

        oneRb.setOnAction(e -> selectedNumber = Number.ONE);
        twoRb.setOnAction(e -> selectedNumber = Number.TWO);
        threeRb.setOnAction(e -> selectedNumber = Number.THREE);
        fourRb.setOnAction(e -> selectedNumber = Number.FOUR);
        fiveRb.setOnAction(e -> selectedNumber = Number.FIVE);

        blueRb.fire();
        oneRb.fire();
    }

    public Color getSelectedColor() {
        return selectedColor;
    }

    public Number getSelectedNumber() {
        return selectedNumber;
    }

    public String getPlayerName() {
        return playerNameTf.getText();
    }
}
