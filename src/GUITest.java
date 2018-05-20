import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;


public class GUITest extends Application {


  @Override
  public void start(Stage primaryStage) {
    Button btn = new Button("Say 'Hello World!'");

    btn.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {
        System.out.println("Hello World!");
      }
    });

    StackPane root = new StackPane();
    Pane presentation = new Pane();
    Pane menu = new Pane();


    BorderPane borderLayout = new BorderPane();

    borderLayout.setCenter(presentation);
    borderLayout.setBottom(menu);

    root.getChildren().add(borderLayout);

    menu.setBackground(new Background(new BackgroundFill(Color.web("#FF0000"), CornerRadii.EMPTY, Insets.EMPTY)));
    presentation.setBackground(new Background(new BackgroundFill(Color.web("#FFFF00"), CornerRadii.EMPTY, Insets.EMPTY)));

    menu.getChildren().add(btn);
    presentation.getChildren().add(btn);

    Scene scene = new Scene(root, 500, 500);

    primaryStage.setTitle("GUI Testing");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  public static void main(String[] args) {
    launch(args);
  }
}
