package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class View implements FXComponent {

  private final Controller controller;

  public View(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {

    VBox layout = new VBox();
    HBox trial = new HBox();
    CluesTop top = new CluesTop(controller);
    PuzzleView puzzleView =
        new PuzzleView(
            controller, controller.getClues().getHeight(), controller.getClues().getWidth());
    Interactions interactions = new Interactions(controller);
    CluesSide side = new CluesSide(controller);
    TopBar bar = new TopBar(controller);
    layout.getChildren().add(bar.render());
    layout.getChildren().add(top.render());
    layout.getChildren().add(puzzleView.render());
    layout.getChildren().add(interactions.render());
    trial.getChildren().add(side.render());
    trial.getChildren().add(layout);

    return trial;
  }
}
