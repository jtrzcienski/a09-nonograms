package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.awt.event.ActionEvent;

public class PuzzleView implements FXComponent {

  static Logger log = LogManager.getLogger(
          PuzzleView.class.getName()
  );

  private int height, width;
  private final Controller controller;
  Rectangle[][] rectangles;
  GridPane layout = new GridPane();

  public PuzzleView(Controller controller, int height, int width) {
    this.height = height;
    this.width = width;
    // System.out.println(width);
    this.controller = controller;
    rectangles = new Rectangle[width][height];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        rectangles[j][i] = new Rectangle(50, 50);
        if (controller.isShaded(i, j)) {
          rectangles[j][i].setStyle("-fx-fill: cyan; -fx-stroke: black; -fx-stroke-width: 1;");
        } else if (controller.isEliminated(i, j)) {
          rectangles[j][i].setStyle("-fx-fill: black; -fx-stroke: black; -fx-stroke-width: 1;");
        } else {
          rectangles[j][i].setStyle("-fx-fill: white; -fx-stroke: black; -fx-stroke-width: 1;");
        }
        layout.add(rectangles[j][i], j, i, 1, 1);
      }
    }
  }

  @Override
  public Parent render() {
    layout.setGridLinesVisible(true);
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int row = i;
        int col = j;
        rectangles[j][i].setOnMouseClicked(
            new EventHandler<MouseEvent>() {
              @Override
              public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                  rectangles[col][row].setFill(Color.DARKRED);
                  controller.toggleShaded(row, col);
                } else if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                  rectangles[col][row].setFill(Color.BLACK);
                  controller.toggleEliminated(row, col);
                }
              }
            });
      }
    }
    return layout;
  }
}
