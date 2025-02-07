package ergasia.kanoniki;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
	static Stage primaryStage;
	static Scene mainScene, movieScene;

	

    @Override
    public void start(Stage Stage) {
  
    	this.primaryStage=Stage;
     	

    	MainSceneCreator mainSceneCreator=new MainSceneCreator();
    	mainScene=mainSceneCreator.createScene();
 
    	GameSceneCreator gameSceneCreator=new GameSceneCreator();
    	gameScene=gameSceneCreator.createScene();

    	
    	primaryStage.setTitle("Trivia Window");
    	primaryStage.setScene(mainScene);

    	primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
