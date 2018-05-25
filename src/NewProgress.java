import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.File;

public class NewProgress extends Application {
  float slideNum = 1;
  float maxSlides = 20;
  int progWidth = 500;
  Slider slider = new Slider(slideNum/maxSlides, 1, slideNum/maxSlides);
  ProgressBar pb = new ProgressBar(slideNum/maxSlides);
  Button nextBtn = new Button("Next");
  Label label = new Label("0%");
  Label slide = new Label("Slide 1/"+(int)maxSlides);
  File styleSheet = new File("../resources/style.css");


  @Override
  public void start(Stage stage) {
    Group group = new Group();
    Scene scene = new Scene(group, 1000, 500);
    scene.getStylesheets().clear();
    scene.getStylesheets().add("file:///" + styleSheet.getAbsolutePath().replace("\\","/"));
    slider.setDisable(true);
    slider.setMinWidth(progWidth+25);
    slider.setMaxWidth(progWidth+25);
    pb.setMinWidth(progWidth);
    pb.setMaxWidth(progWidth);

    this.nextBtn.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        nextSlide();
        slider.setValue(slideNum/maxSlides);
        pb.setProgress(slideNum/maxSlides);
        label.setText(((int)(slideNum/maxSlides*100))+"%");
      }
    });


    HBox hb = new HBox();
    hb.setSpacing(5);
    hb.setAlignment(Pos.CENTER);
    StackPane stack = new StackPane();
    stack.getChildren().addAll(pb, slider);
    hb.getChildren().addAll(nextBtn, slide, stack, label);
    scene.setRoot(hb);

    stage.setScene(scene);
    stage.setTitle("Progress Bar  2.0");
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

  public void nextSlide() {
    if(this.slideNum < this.maxSlides) {
      this.slideNum++;
    }
    this.slide.setText("Slide "+(int)(this.slideNum)+"/"+(int)maxSlides);
  }
}
