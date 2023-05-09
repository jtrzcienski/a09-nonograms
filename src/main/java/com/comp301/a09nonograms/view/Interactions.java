package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.awt.event.ActionEvent;

public class Interactions implements FXComponent {

  private final Controller controller;

  public Interactions(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    HBox layout = new HBox();
    Button b1 = new Button("Next Puzzle");
    Button b2 = new Button("Previous Puzzle");
    Button b3 = new Button("Random Puzzle");
    Button b4 = new Button("Reset");

    b1.setOnAction(
        event -> {
          controller.nextPuzzle();
        });
    b2.setOnAction(
        event -> {
          controller.prevPuzzle();
        });
    b3.setOnAction(
        event -> {
          controller.randPuzzle();
        });
    b4.setOnAction(
        event -> {
          controller.clearBoard();
        });

    layout.getChildren().add(b1);
    layout.getChildren().add(b2);
    layout.getChildren().add(b3);
    layout.getChildren().add(b4);

    return layout;
  }
}
