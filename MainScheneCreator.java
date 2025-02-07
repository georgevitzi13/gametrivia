package ergasia.kanoniki;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

public class MainSceneCreator implements EventHandler<MouseEvent> {
    // Flow Pane (root node)
    private FlowPane rootFlowPane;
    // Main scene buttons
    private Button startBtn, settingsBtn;

    public MainSceneCreator() {
        rootFlowPane = new FlowPane();
        startBtn = new Button("Start");
        settingsBtn = new Button("Choose settings");

        // Attach handle event to buttons
        startBtn.setOnMouseClicked(this);
        settingsBtn.setOnMouseClicked(this);

        // Set up flow pane
        rootFlowPane.setAlignment(Pos.CENTER);
        rootFlowPane.setHgap(10);
        startBtn.setMinSize(120, 30);
        settingsBtn.setMinSize(120, 30);

        // Add buttons to rootFlowPane
        rootFlowPane.getChildren().addAll(startBtn, settingsBtn);
    }

    public Scene createScene() {
        return new Scene(rootFlowPane, 650, 300);
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getSource() == startBtn) {
            App.primaryStage.setScene(App.gameScene);
        } else if (event.getSource() == settingsBtn) {
            App.primaryStage.setScene(App.settingsScene);
        }
    }
}
