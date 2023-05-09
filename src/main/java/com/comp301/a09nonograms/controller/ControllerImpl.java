package com.comp301.a09nonograms.controller;

import com.comp301.a09nonograms.PuzzleLibrary;
import com.comp301.a09nonograms.model.Clues;
import com.comp301.a09nonograms.model.Model;

public class ControllerImpl implements Controller {

  private Model model;

  public ControllerImpl(Model model) {
    this.model = model;
  }

  @Override
  public Clues getClues() {
    return PuzzleLibrary.create().get(model.getPuzzleIndex());
  }

  @Override
  public boolean isSolved() {
    return model.isSolved();
  }

  @Override
  public boolean isShaded(int row, int col) {
    return model.isShaded(row, col);
  }

  @Override
  public boolean isEliminated(int row, int col) {
    return model.isEliminated(row, col);
  }

  @Override
  public void toggleShaded(int row, int col) {
    model.toggleCellShaded(row, col);
  }

  @Override
  public void toggleEliminated(int row, int col) {
    model.toggleCellEliminated(row, col);
  }

  @Override
  public void nextPuzzle() {
    if (model.getPuzzleIndex() == model.getPuzzleCount() - 1) {

    } else {
      model.setPuzzleIndex(model.getPuzzleIndex() + 1);
    }
  }

  @Override
  public void prevPuzzle() {
    if (model.getPuzzleIndex() == 0) {

    } else {
      model.setPuzzleIndex(model.getPuzzleIndex() - 1);
    }
  }

  @Override
  public void randPuzzle() {
    int rand = (int) (Math.random() * ((4) + 1));
    while (rand == model.getPuzzleIndex()) {
      rand = (int) (Math.random() * ((4) + 1));
    }
    model.setPuzzleIndex(rand);
  }

  @Override
  public void clearBoard() {
    model.clear();
  }

  @Override
  public int getPuzzleIndex() {
    return model.getPuzzleIndex();
  }

  @Override
  public int getPuzzleCount() {
    return model.getPuzzleCount();
  }
}
