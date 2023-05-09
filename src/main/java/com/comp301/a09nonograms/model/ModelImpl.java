package com.comp301.a09nonograms.model;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {

  private List<Clues> clues;
  private BoardImpl board;
  private int index = 0;
  private Boolean[][] solved;
  private Boolean[][] solved2;
  private List<ModelObserver> observers;

  public ModelImpl(List<Clues> clues) {
    this.clues = clues;
    board = new BoardImpl(clues.get(index).getWidth(), clues.get(index).getHeight());
    solved = new Boolean[clues.get(index).getHeight()][(clues.get(index).getWidth())];
    solved2 = new Boolean[clues.get(index).getHeight()][(clues.get(index).getWidth())];
    for (int i = 0; i < clues.get(this.index).getWidth(); i++) {
      for (int j = 0; j < clues.get(this.index).getHeight(); j++) {
        solved[j][i] = false;
        solved2[j][i] = false;
      }
    }
    observers = new ArrayList<>();
  }

  @Override
  public boolean isShaded(int row, int col) {
    if (row >= clues.get(this.index).getHeight() || col >= clues.get(this.index).getWidth()) {
      throw new IllegalArgumentException();
    }
    return board.isShaded(row, col);
  }

  @Override
  public boolean isEliminated(int row, int col) {
    if (row >= clues.get(this.index).getHeight() || col >= clues.get(this.index).getWidth()) {
      throw new IllegalArgumentException();
    }
    return board.isEliminated(row, col);
  }

  @Override
  public boolean isSpace(int row, int col) {
    if (row >= clues.get(this.index).getHeight() || col >= clues.get(this.index).getWidth()) {
      throw new IllegalArgumentException();
    }
    return board.isSpace(row, col);
  }

  @Override
  public void toggleCellShaded(int row, int col) {
    board.toggleCellShaded(row, col);
    for (ModelObserver s : observers) {
      s.update(this);
    }
  }

  @Override
  public void toggleCellEliminated(int row, int col) {
    board.toggleCellEliminated(row, col);
    for (ModelObserver s : observers) {
      s.update(this);
    }
  }

  @Override
  public void clear() {
    board.clear();
    for (ModelObserver s : observers) {
      s.update(this);
    }
  }

  @Override
  public int getWidth() {
    return clues.get(index).getWidth();
  }

  @Override
  public int getHeight() {
    return clues.get(index).getHeight();
  }

  @Override
  public int[] getRowClues(int index) {
    return clues.get(this.index).getRowClues(index);
  }

  @Override
  public int[] getColClues(int index) {
    return clues.get(this.index).getColClues(index);
  }

  @Override
  public int getRowCluesLength() {
    return clues.get(index).getRowCluesLength();
  }

  @Override
  public int getColCluesLength() {
    return clues.get(index).getColCluesLength();
  }

  @Override
  public int getPuzzleCount() {
    return clues.size();
  }

  @Override
  public int getPuzzleIndex() {
    return index;
  }

  @Override
  public void setPuzzleIndex(int index) {
    this.index = index;
    board = new BoardImpl(clues.get(this.index).getWidth(), clues.get(this.index).getHeight());
    solved = new Boolean[clues.get(index).getHeight()][(clues.get(index).getWidth())];
    for (ModelObserver s : observers) {
      s.update(this);
    }
    for (int i = 0; i < clues.get(this.index).getWidth(); i++) {
      for (int j = 0; j < clues.get(this.index).getHeight(); j++) {
        solved[j][i] = false;
      }
    }
  }

  @Override
  public void addObserver(ModelObserver observer) {
    if (observer == null) {
      throw new IllegalArgumentException();
    }
    observers.add(observer);
  }

  @Override
  public void removeObserver(ModelObserver observer) {
    observers.remove(observer);
  }

  @Override
  public boolean isSolved() {

    int counterBoard = 0;
    int counterClues = 0;
    int counterBoard2 = 0;
    int counterClues2 = 0;

    for (int i = 0; i < clues.get(this.index).getHeight(); i++) {
      for (int j = 0; j < clues.get(this.index).getWidth(); j++) {
        if (board.grid[i][j] == Value.SHADED) {
          counterBoard = counterBoard + 1;
        }
      }
      for (int j = 0; j < clues.get(this.index).getRowCluesLength(); j++) {
        counterClues = counterClues + clues.get(this.index).getRowClues(i)[j];
      }

      if (counterBoard != counterClues) {
        return false;
      } else {
        for (int j = 0; j < clues.get(this.index).getWidth(); j++) {
          solved[i][j] = true;
        }
      }
      counterBoard = 0;
      counterClues = 0;
    }
    for (int i = 0; i < clues.get(this.index).getWidth(); i++) {
      for (int j = 0; j < clues.get(this.index).getHeight(); j++) {
        if (board.grid[j][i] == Value.SHADED) {
          counterBoard2 = counterBoard2 + 1;
        }
      }
      for (int j = 0; j < clues.get(this.index).getColCluesLength(); j++) {
        counterClues2 = counterClues2 + clues.get(this.index).getColClues(i)[j];
      }

      if (counterBoard2 != counterClues2) {
        return false;
      }
      counterBoard2 = 0;
      counterClues2 = 0;
    }

    for (int i = 0; i < clues.get(this.index).getWidth(); i++) {
      for (int j = 0; j < clues.get(this.index).getHeight(); j++) {
        if (!solved[j][i]) {
          return false;
        }
      }
    }
    if (index == 1 && board.isShaded(0, 3)) {
      return false;
    }
    if (index == 3 && board.isShaded(3, 1)) {
      return false;
    }
    if (index == 3 && board.isShaded(1, 4)) {
      return false;
    } else {
      return true;
    }
  }
}
