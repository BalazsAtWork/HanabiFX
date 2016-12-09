package de.novatec.cg.sc.hanabi.client.fx.renderer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.novatec.cg.sc.hanabi.common.Card;
import de.novatec.cg.sc.hanabi.common.CardBuilder;
import de.novatec.cg.sc.hanabi.common.CardInHand;
import de.novatec.cg.sc.hanabi.common.CardKnowledge;
import de.novatec.cg.sc.hanabi.common.CardKnowledgeBuilder;
import de.novatec.cg.sc.hanabi.common.Deck;
import de.novatec.cg.sc.hanabi.common.GameState;
import de.novatec.cg.sc.hanabi.common.Player;
import de.novatec.cg.sc.hanabi.common.enums.Number;
import de.novatec.cg.sc.hanabi.common.service.RequestSenderService;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

@Singleton
public class GameStateRenderer {

    private static final String STYLE_FOR_CURRENT_PLAYER = " -fx-border-color:blue; -fx-border-width: 5; -fx-border-style: solid;";
    private static final int CARD_WIDTH = 30;
    private static final int CARD_HEIGHT = 50;
    private static final int CARD_GAP = 10;

    @Inject
    private RequestSenderService requestSenderService;

    private String currentPlayerName;

    private AnchorPane mainAnchorPane;
    private VBox mainVbox = new VBox(10.0);
    private VBox playedCardsVbox = new VBox(10.0);
    private VBox gameInfoVbox = new VBox(10.0);
    private VBox playersVbox = new VBox(10.0);

    private TextField notColor = new TextField();
    private TextField notNumber = new TextField();

    public void setMainAnchorPanel(AnchorPane mainAnchorPane) {
        this.mainAnchorPane = mainAnchorPane;
        mainVbox.setLayoutX(20);
        mainVbox.setLayoutY(20);

        mainVbox.getChildren().add(playedCardsVbox);
        mainVbox.getChildren().add(gameInfoVbox);
        mainVbox.getChildren().add(playersVbox);

        mainAnchorPane.getChildren().add(mainVbox);
    }

    public void setCurrentPlayerName(String currentPlayerName) {
        if (this.currentPlayerName == null) {
            this.currentPlayerName = currentPlayerName;
        }
    }

    public void renderGameState(GameState gameState, String nextPlayerName) {
        if (gameState != null) {
            renderPlayedCards(gameState.getPlayedCards());
            renderGameInfo(gameState.getHintTokens(), gameState.getErrorTokens(), gameState.getDeck());
            renderPlayerWithCards(nextPlayerName, gameState.getPlayers());
        }
    }

    private void renderPlayedCards(HashMap<de.novatec.cg.sc.hanabi.common.enums.Color, Number> playedCards) {
        this.playedCardsVbox.getChildren().clear();

        List<Node> children = new ArrayList<>();
        for (de.novatec.cg.sc.hanabi.common.enums.Color color : de.novatec.cg.sc.hanabi.common.enums.Color.values()) {
            Canvas cardCanvas = createColoredCanvas(CARD_HEIGHT, CARD_WIDTH, color.getFxColor(), true, null);

            if (playedCards != null) {
                Number number = playedCards.get(color);
                if (number != null) {
                    GraphicsContext gc = cardCanvas.getGraphicsContext2D();
                    gc.setFont(new Font(30.0));
                    gc.setFill(color.getFxNumberColor());
                    gc.fillText(number.displayValue(), 7, 35);
                }
            }
            children.add(cardCanvas);
        }

        TitledPane playedCardsTitledPane = createTitledPaneWithHBox("Played cards", CARD_GAP, children);
        playedCardsVbox.getChildren().add(playedCardsTitledPane);
    }

    private void renderGameInfo(int hintTokens, int errorTokens, Deck deck) {
        this.gameInfoVbox.getChildren().clear();

        VBox vbox = new VBox();
        vbox.getChildren().add(new Label("Hint tokens: " + hintTokens));
        vbox.getChildren().add(new Label("Error tokens: " + errorTokens));
        vbox.getChildren().add(new Label("Cards in deck: " + deck.getCards().size()));

        TitledPane gameInfoTitledPane = createTitledPaneWithHBox("Game info", 10, Arrays.asList(vbox));
        gameInfoVbox.getChildren().add(gameInfoTitledPane);
    }

    private void renderPlayerWithCards(String nextPlayerName, List<Player> players) {
        this.playersVbox.getChildren().clear();

        boolean amITheNextOne = currentPlayerName.equals(nextPlayerName);

        moveCurrentPlayerToFirstIndex(players);

        for (Player player : players) {
            boolean anotherPlayerToRender = !player.getName().equals(currentPlayerName);
            boolean playerIsTheNextOne = player.getName().equals(nextPlayerName);

            HBox cardHbox = new HBox(CARD_GAP);
            HBox negativeHintHbox = new HBox(CARD_GAP);

            List<Node> children = new ArrayList<>();
            children.add(cardHbox);
            children.add(negativeHintHbox);

            if (!anotherPlayerToRender) {
                children.add(notColor);
                children.add(notNumber);
            }

            TitledPane playerPane = createTitledPaneWithVBox(player.getName(), 10, children);
            if (playerIsTheNextOne) {
                playerPane.setStyle(STYLE_FOR_CURRENT_PLAYER);
            }
            playersVbox.getChildren().add(playerPane);

            List<CardInHand> cards = player.getCards();
            for (CardInHand cardInHand : cards) {
                Card card = cardInHand.getCard();
                CardKnowledge knowledge = cardInHand.getCardKnowledge();

                Color canvasColor = Color.BLACK;
                Color numberColor = Color.WHITE;
                if (anotherPlayerToRender || knowledge.playerKnowsColor()) {
                    canvasColor = card.getColor().getFxColor();
                    numberColor = card.getColor().getFxNumberColor();
                }

                EventHandler<? super MouseEvent> mouseClickedHandler = determineMouseClickedHandler(amITheNextOne, player, anotherPlayerToRender, card,
                        knowledge);
                Canvas cardCanvas = createColoredCanvas(CARD_HEIGHT, CARD_WIDTH, canvasColor, true, mouseClickedHandler);

                GraphicsContext gc = cardCanvas.getGraphicsContext2D();

                if (anotherPlayerToRender || knowledge.playerKnowsNumber()) {
                    gc.setFont(new Font(30.0));
                    gc.setFill(numberColor);
                    gc.fillText(card.getNumber().displayValue(), 7, 35);
                }
                cardHbox.getChildren().add(cardCanvas);
            }

            if (amITheNextOne && anotherPlayerToRender) {
                for (de.novatec.cg.sc.hanabi.common.enums.Color color : de.novatec.cg.sc.hanabi.common.enums.Color.values()) {
                    EventHandler<? super MouseEvent> mouseClickedHandler = mouseEvent -> {
                        requestSenderService.sendHintColorRequest(player.getName(), color, false);
                    };
                    negativeHintHbox.getChildren().add(createColoredCanvas(10, 10, color.getFxColor(), true, mouseClickedHandler));
                }

                for (Number number : Number.values()) {
                    EventHandler<? super MouseEvent> mouseClickedHandler = mouseEvent -> {
                        requestSenderService.sendHintNumberRequest(player.getName(), number, false);
                    };
                    Canvas numberCanvas = createColoredCanvas(10, 10, Color.BLACK, false, mouseClickedHandler);
                    GraphicsContext gc = numberCanvas.getGraphicsContext2D();

                    gc.setFont(new Font(10.0));
                    gc.setFill(Color.WHITE);
                    gc.fillText(number.displayValue(), 3, 9);

                    negativeHintHbox.getChildren().add(numberCanvas);
                }
            }
        }
    }

    private void moveCurrentPlayerToFirstIndex(List<Player> players) {
        while (!players.get(0).getName().equals(currentPlayerName)) {
            Collections.rotate(players, -1);
        }
    }

    private Canvas createColoredCanvas(int height, int width, Color color, boolean drawBorder, EventHandler<? super MouseEvent> mouseClickedHandler) {
        Canvas canvas = new Canvas();
        canvas.setHeight(height);
        canvas.setWidth(width);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(color);
        gc.fillRect(0, 0, width, height);

        if (drawBorder) {
            gc.setStroke(Color.BLACK);
            gc.strokeRect(0, 0, width, height);
        }

        if (mouseClickedHandler != null) {
            canvas.setOnMouseClicked(mouseClickedHandler);

            canvas.setOnMouseEntered(mouseEvent -> {
                mainAnchorPane.getScene().setCursor(Cursor.HAND);
            });
            canvas.setOnMouseExited(mouseEvent -> {
                mainAnchorPane.getScene().setCursor(Cursor.DEFAULT);
            });
        }
        return canvas;
    }

    private EventHandler<? super MouseEvent> determineMouseClickedHandler(boolean amITheNextOne, Player player, boolean anotherPlayerToRender, Card card,
            CardKnowledge knowledge) {

        if (amITheNextOne) {
            if (anotherPlayerToRender) {
                EventHandler<? super MouseEvent> anotherPlayerClickHandler = mouseEvent -> {

                    Alert alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("Give a hint to player");
                    alert.setHeaderText("Which hint do you want to give?");
                    alert.setContentText("Choose your hint.");

                    ButtonType colorHint = new ButtonType("Color hint of ");
                    ButtonType numberHint = new ButtonType("Number hint");
                    ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

                    alert.getButtonTypes().setAll(colorHint, numberHint, buttonTypeCancel);

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == colorHint) {
                        requestSenderService.sendHintColorRequest(player.getName(), card.getColor(), true);
                    } else if (result.get() == numberHint) {
                        requestSenderService.sendHintNumberRequest(player.getName(), card.getNumber(), true);
                    }
                };
                return anotherPlayerClickHandler;
            } else {
                EventHandler<? super MouseEvent> currentPlayerClickHandler = mouseEvent -> {
                    if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                        Alert alert = new Alert(AlertType.CONFIRMATION);
                        alert.setTitle("Player action");
                        alert.setHeaderText("Which action do you want to execute?");
                        alert.setContentText("Choose an action.");

                        ButtonType playCard = new ButtonType("Play card");
                        ButtonType discardCard = new ButtonType("Discard card");
                        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

                        alert.getButtonTypes().setAll(playCard, discardCard, buttonTypeCancel);

                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.get() == playCard) {
                            requestSenderService.sendPlayCardRequest(card);
                        } else if (result.get() == discardCard) {
                            requestSenderService.sendDiscardCardRequest(card);
                        }
                    } else if (mouseEvent.getButton().equals(MouseButton.SECONDARY)) {
                        List<String> notcolors = new ArrayList<>();
                        for (de.novatec.cg.sc.hanabi.common.enums.Color color : knowledge.getKnowsColorNot()) {
                            notcolors.add(color.name());
                        }
                        notColor.setText(String.join(",", notcolors));

                        List<String> notNumbers = new ArrayList<>();
                        for (Number number : knowledge.getKnowsNumberNot()) {
                            notNumbers.add(number.displayValue());
                        }
                        notNumber.setText(String.join(",", notNumbers));
                    }
                };
                return currentPlayerClickHandler;
            }
        }
        return null;
    }

    private TitledPane createTitledPaneWithHBox(String headerText, int horizontalSpacing, List<Node> children) {
        HBox hbox = new HBox(horizontalSpacing);
        hbox.getChildren().addAll(children);
        return createTitledPane(headerText, hbox);
    }

    private TitledPane createTitledPaneWithVBox(String headerText, int verticalSpacing, List<Node> children) {
        VBox vbox = new VBox(verticalSpacing);
        vbox.getChildren().addAll(children);
        return createTitledPane(headerText, vbox);
    }

    private TitledPane createTitledPane(String headerText, Node content) {
        TitledPane titledPane = new TitledPane();
        titledPane.setText(headerText);
        titledPane.setCollapsible(false);
        titledPane.setContent(content);
        return titledPane;
    }

    private List<Player> createDummyPlayers(String... otherPlayerNames) {
        List<Player> players = new ArrayList<>();

        Player currentPlayer = new Player(currentPlayerName, new ArrayList<>());

        Card c1 = CardBuilder.newCard().withColorBLUE().withNumberTWO().build();
        Card c2 = CardBuilder.newCard().withColorGREEN().withNumberONE().build();
        Card c3 = CardBuilder.newCard().withColorRED().withNumberFOUR().build();
        Card c4 = CardBuilder.newCard().withColorWHITE().withNumberFIVE().build();
        Card c5 = CardBuilder.newCard().withColorYELLOW().withNumberTHREE().build();

        CardKnowledge ck1 = CardKnowledgeBuilder.newCardKnowledge().playerKnowsColor().playerKnowsNumber().build();
        CardKnowledge ck2 = CardKnowledgeBuilder.newCardKnowledge().build();
        CardKnowledge ck3 = CardKnowledgeBuilder.newCardKnowledge().playerKnowsNumber().playerKnowsNotColor(de.novatec.cg.sc.hanabi.common.enums.Color.BLUE)
                .build();
        CardKnowledge ck4 = CardKnowledgeBuilder.newCardKnowledge().playerKnowsNumber().playerKnowsNotNumber(Number.TWO).playerKnowsNotNumber(Number.FIVE)
                .build();
        CardKnowledge ck5 = CardKnowledgeBuilder.newCardKnowledge().playerKnowsNumber().build();

        CardInHand cih1 = new CardInHand(c1, ck1);
        CardInHand cih2 = new CardInHand(c2, ck2);
        CardInHand cih3 = new CardInHand(c3, ck3);
        CardInHand cih4 = new CardInHand(c4, ck4);
        CardInHand cih5 = new CardInHand(c5, ck5);

        currentPlayer.getCards().add(cih1);
        currentPlayer.getCards().add(cih2);
        currentPlayer.getCards().add(cih3);
        currentPlayer.getCards().add(cih4);
        currentPlayer.getCards().add(cih5);
        players.add(currentPlayer);

        for (String othername : otherPlayerNames) {
            Player player = new Player(othername, new ArrayList<>());
            player.getCards().add(cih1);
            player.getCards().add(cih2);
            player.getCards().add(cih3);
            player.getCards().add(cih4);
            player.getCards().add(cih5);
            players.add(player);
        }
        return players;
    }
}
