import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.File;

public class Progress extends Application {
  float slideNum = 1;
  float maxSlides = 20;
  ProgressBar pb = new ProgressBar(slideNum/maxSlides);
  Button nextBtn = new Button("Next");
  Label label = new Label("0%");
  Label slide = new Label("Slide 1/"+(int)maxSlides);
  File styleSheet = new File("../resources/style.css");



  @Override
  public void start(Stage stage) {
    Group group = new Group();
    Scene scene = new Scene(group, 500, 250);
    scene.getStylesheets().clear();
    scene.getStylesheets().add("file:///" + styleSheet.getAbsolutePath().replace("\\","/"));

    this.nextBtn.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        nextSlide();
        pb.setProgress(slideNum/maxSlides);
        label.setText(((int)(slideNum/maxSlides*100))+"%");
      }
    });


    HBox hb = new HBox();
    hb.setSpacing(5);
    hb.setAlignment(Pos.CENTER);
    hb.getChildren().addAll(nextBtn, slide, pb, label);
    scene.setRoot(hb);

    stage.setScene(scene);
    stage.setTitle("Progress Bar Test");
    stage.show();

  }

  public void nextSlide() {
    if(this.slideNum < this.maxSlides) {
      this.slideNum++;
    }
    this.slide.setText("Slide "+(int)(this.slideNum)+"/"+(int)maxSlides);
  }

  public static void main(String[] args) {
    launch(args);
  }
}
