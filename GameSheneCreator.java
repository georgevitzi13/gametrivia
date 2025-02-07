package ergasia.kanoniki;

import java.util.List;
import service.TriviaAPIService;
import Exemption.TriviaAPIException;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import model.TriviaInfo;


public class GameSceneCreator implements EventHandler<MouseEvent> {
    // UI Components
    private GridPane rootGridPane, inputFieldsPane;
    private FlowPane buttonFlowPane;
    private Button loadQuestionsBtn, backBtn;
    private Label textLbl;
    private TextField paramField;
    private TableView<TriviaInfo> triviaTableView;
    
    public GameSceneCreator() {
        // Initialize components
        rootGridPane = new GridPane();
        inputFieldsPane = new GridPane();
        buttonFlowPane = new FlowPane();
        
        textLbl = new Label("Category: ");
        paramField = new TextField();
        
        loadQuestionsBtn = new Button("Load Questions");
        backBtn = new Button("Go Back");
        
        triviaTableView = new TableView<>();
        
        TableColumn<TriviaInfo, String> questionColumn = new TableColumn<>("Question");
        questionColumn.setCellValueFactory(new PropertyValueFactory<>("question"));
        triviaTableView.getColumns().add(questionColumn);
        
        TableColumn<TriviaInfo, String> correctAnswerColumn = new TableColumn<>("Correct Answer");
        correctAnswerColumn.setCellValueFactory(new PropertyValueFactory<>("correctAnswer"));
        triviaTableView.getColumns().add(correctAnswerColumn);
        
        TableColumn<TriviaInfo, String> difficultyColumn = new TableColumn<>("Difficulty");
        difficultyColumn.setCellValueFactory(new PropertyValueFactory<>("difficulty"));
        triviaTableView.getColumns().add(difficultyColumn);
        
        buttonFlowPane.getChildren().add(loadQuestionsBtn);
        buttonFlowPane.setAlignment(Pos.CENTER);
        buttonFlowPane.setHgap(10);
        
        inputFieldsPane.add(textLbl, 0, 0);
        inputFieldsPane.add(paramField, 1, 0);
        inputFieldsPane.setVgap(10);
        inputFieldsPane.setHgap(10);
        
        rootGridPane.add(triviaTableView, 0, 0);
        rootGridPane.add(inputFieldsPane, 1, 0);
        rootGridPane.add(buttonFlowPane, 0, 1);
        rootGridPane.add(backBtn, 1, 1);
        
        rootGridPane.setHgap(10);
        rootGridPane.setVgap(10);
        
        // Attach event handlers
        loadQuestionsBtn.setOnMouseClicked(this);
        backBtn.setOnMouseClicked(this);
    }
    
    public Scene createScene() {
        return new Scene(rootGridPane, 650, 300);
    }
    
    @Override
    public void handle(MouseEvent event) {
        if (event.getSource() == loadQuestionsBtn) {
            TriviaAPIService triviaService = new TriviaAPIService("https://opentdb.com");
            try {
                String category = paramField.getText();
                List<TriviaInfo> questionsList = triviaService.getQuestions(category);
                
                triviaTableView.getItems().clear();
                triviaTableView.getItems().addAll(questionsList);
                
            } catch (TriviaAPIException e) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error calling Trivia API");
                alert.setContentText(e.getMessage());
                alert.show();
            }
        } else if (event.getSource() == backBtn) {
            App.primaryStage.setScene(App.mainScene);
        }
    }
}
