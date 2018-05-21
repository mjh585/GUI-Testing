import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class LevelMenu extends Application {
  int levelNum, qNum, i, j;
  public LevelMenu() {}

  public static void main(String[] args) {
    // LevelMenu();
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    levelNum = qNum = 1;
    // primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("File: ../resources/LQ_logo_2_32.png")));
    primaryStage.setTitle("Menu Testing");

    MenuBar menuBar = new MenuBar();
    Menu levels = new Menu("Levels");
    ArrayList<Menu> levelItems = new ArrayList<Menu>(); //Levels array
    ArrayList<ArrayList<MenuItem>> levelQuestions = new ArrayList<ArrayList<MenuItem>>(); //Array of the questions array for each level

      Label presentation = new Label("Level: " + Integer.toString(levelNum) + " Question: " + Integer.toString(qNum));

    //TODO Sort this out fot getting number of levels and questions
    for(i=0; i<5; i++) {
      levelItems.add(new Menu("Level " + (i+1)));
      ArrayList<MenuItem> questions = new ArrayList<MenuItem>();  //Array of questions in current level.
      for(j=0; j<5; j++) {
        questions.add(new MenuItem("Question: " + (j+1)));
        levelItems.get(i).getItems().add(questions.get(j));
        questions.get(j).setOnAction(new EventHandler<ActionEvent>() {

          @Override
          public void handle(ActionEvent event) {
            //NONE OF THIS WORKS LOL
            setSlide();
            presentation.setText("Level: " + Integer.toString(levelNum) + " Question: " + Integer.toString(qNum));
            System.out.println("Level: " + Integer.toString(levelNum) + " Question: " + Integer.toString(qNum));
          }
        });
      }
      levels.getItems().add(levelItems.get(i));
      levelQuestions.add(questions);
    }
    menuBar.getMenus().add(levels);






    VBox vBox = new VBox(menuBar);
    BorderPane borderLayout = new BorderPane();
    borderLayout.setTop(vBox);
    borderLayout.setCenter(presentation);

    Scene scene = new Scene(borderLayout, 960, 600);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public void setSlide() {
    this.levelNum = this.i;
    this.qNum = this.j;

  }


}
