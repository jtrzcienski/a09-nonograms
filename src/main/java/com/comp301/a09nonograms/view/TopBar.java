package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class TopBar implements FXComponent {

  private Controller controller;

  public TopBar(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    HBox layout = new HBox();
    Label puzzleNumber =
        new Label("Puzzle " + String.valueOf(controller.getPuzzleIndex() + 1) + " of 5");
    layout.getChildren().add(puzzleNumber);
    boolean solved = false;
    if (controller.isSolved()) {
      solved = true;
    }
    if (solved) {
      layout.getChildren().add(new Label("      You have solved the puzzle!"));
    }
    return layout;
  }
}
