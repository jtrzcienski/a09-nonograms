package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.PuzzleLibrary;
import com.comp301.a09nonograms.controller.Controller;
import com.comp301.a09nonograms.controller.ControllerImpl;
import com.comp301.a09nonograms.model.Model;
import com.comp301.a09nonograms.model.ModelImpl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.sql.SQLOutput;

public class AppLauncher extends Application {
  @Override
  public void start(Stage stage) {

    Model model = new ModelImpl(PuzzleLibrary.create());
    Controller controller = new ControllerImpl(model);
    View view = new View(controller);
    stage.setTitle("Play Nanograms!");
    Scene scene = new Scene(view.render());
    // scene.getStylesheets().add("styles/styles.css");
    model.addObserver(
        (Model m) -> {
          scene.setRoot(view.render());
          stage.sizeToScene();
        });
    stage.setScene(scene);
    stage.show();
  }
}
