package de.novatec.cg.sc.hanabi.client.fx;

import java.io.IOException;

import com.google.inject.Inject;

import de.novatec.cg.sc.hanabi.GuiceInjector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HanabiApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Inject
    private StageContainer stageContainer;

    public HanabiApp() {
        GuiceInjector.injectMembersInto(this);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Hanabi");
        this.primaryStage.setMinWidth(500);
        stageContainer.setStage(primaryStage);

        initRootLayout();
        showHanabiClient();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            rootLayout = (BorderPane) loadResourceByFxml("Root.fxml");

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setResizable(true);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showHanabiClient() {
        try {
            rootLayout.setTop((AnchorPane) loadResourceByFxml("Connect.fxml"));
            rootLayout.setLeft((AnchorPane) loadResourceByFxml("Hanabi.fxml"));
            rootLayout.setBottom((HBox) loadResourceByFxml("ActionLog.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Object loadResourceByFxml(String fxmlFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(HanabiApp.class.getResource("view/" + fxmlFile));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
