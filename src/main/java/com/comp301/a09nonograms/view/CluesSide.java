package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class CluesSide implements FXComponent {

  private Controller controller;
  Rectangle[] clues;
  boolean[] empty;

  public CluesSide(Controller controller) {
    this.controller = controller;
    clues = new Rectangle[controller.getClues().getHeight()];
    empty = new boolean[controller.getClues().getHeight()];
  }

  public Parent render() {
    VBox layout = new VBox();
    Rectangle rect = new Rectangle(70, 70);
    rect.setStyle("-fx-fill: white; -fx-stroke: white; -fx-stroke-width: 1;");
    layout.getChildren().add(rect);
    HBox[] numbers = new HBox[controller.getClues().getHeight()];
    StackPane[] pane = new StackPane[controller.getClues().getHeight()];

    for (int i = 0; i < controller.getClues().getHeight(); i++) {
      for (int j = 0; j < controller.getClues().getRowCluesLength(); j++) {
        if (numbers[i] == null) {
          numbers[i] = new HBox();
        }
        if (controller.getClues().getRowClues(i)[j] != 0) {
          numbers[i]
              .getChildren()
              .add(new Label((String.valueOf(controller.getClues().getRowClues(i)[j]) + " ")));
          empty[i] = true;
        }

        numbers[i].setAlignment(Pos.CENTER);
        // new Label(String.valueOf(controller.getClues().getColClues(0)[0]))
      }
    }
    for (int i = 0; i < controller.getClues().getHeight(); i++) {
      if (!empty[i]) {
        numbers[i].getChildren().add(new Label("0"));
      }
    }

    for (int i = 0; i < controller.getClues().getHeight(); i++) {
      clues[i] = new Rectangle(50, 50);
      clues[i].setStyle("-fx-fill: white; -fx-stroke: white; -fx-stroke-width: 1;");
    }

    for (int i = 0; i < controller.getClues().getHeight(); i++) {
      pane[i] = new StackPane();
      pane[i].getChildren().addAll(clues[i], numbers[i]);
    }

    for (int i = 0; i < controller.getClues().getHeight(); i++) {
      layout.getChildren().addAll(pane[i]);
    }

    return layout;
  }
}
