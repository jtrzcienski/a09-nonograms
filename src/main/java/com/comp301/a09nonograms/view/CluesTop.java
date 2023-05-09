package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.Arrays;

public class CluesTop implements FXComponent {

  private Controller controller;
  Rectangle[] clues;
  boolean[] empty;

  public CluesTop(Controller controller) {
    this.controller = controller;
    clues = new Rectangle[controller.getClues().getWidth()];
    empty = new boolean[controller.getClues().getWidth()];
  }

  @Override
  public Parent render() {
    HBox layout = new HBox();
    VBox[] numbers = new VBox[controller.getClues().getWidth()];
    StackPane[] pane = new StackPane[controller.getClues().getWidth()];

    for (int i = 0; i < controller.getClues().getWidth(); i++) {
      for (int j = 0; j < controller.getClues().getColCluesLength(); j++) {
        if (numbers[i] == null) {
          numbers[i] = new VBox();
        }
        if ((controller.getClues().getColClues(i)[j] != 0)) {
          numbers[i]
              .getChildren()
              .add(new Label((String.valueOf(controller.getClues().getColClues(i)[j]))));
          empty[i] = true;
          numbers[i].setAlignment(Pos.CENTER);
          // new Label(String.valueOf(controller.getClues().getColClues(0)[0]))
        }
      }
    }
    for (int i = 0; i < controller.getClues().getWidth(); i++) {
      if (empty[i] == false) {
        numbers[i].getChildren().add(new Label("0"));
        numbers[i].setAlignment(Pos.CENTER);
      }
    }

    for (int i = 0; i < controller.getClues().getWidth(); i++) {
      clues[i] = new Rectangle(50, 50);
      clues[i].setStyle("-fx-fill: white; -fx-stroke: white; -fx-stroke-width: 1;");
    }

    for (int i = 0; i < controller.getClues().getWidth(); i++) {
      pane[i] = new StackPane();
      pane[i].getChildren().addAll(clues[i], numbers[i]);
    }

    for (int i = 0; i < controller.getClues().getWidth(); i++) {
      layout.getChildren().addAll(pane[i]);
    }

    return layout;
  }
}
