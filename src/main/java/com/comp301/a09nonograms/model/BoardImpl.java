package com.comp301.a09nonograms.model;

import java.sql.SQLOutput;

public class BoardImpl implements Board {

  public int[][] Board;
  public Value[][] grid;
  private int width, height;

  public BoardImpl(int width, int height) {
    this.width = width;
    this.height = height;
    Board = new int[height][width];
    grid = new Value[height][width];
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        grid[j][i] = Value.CLEAR;
      }
    }
  }

  @Override
  public boolean isShaded(int row, int col) {
    if (grid[row][col] == null) {
      return false;
    } else {
      if (grid[row][col] == Value.SHADED) {
        return true;
      } else {
        return false;
      }
    }
  }

  @Override
  public boolean isEliminated(int row, int col) {
    if (grid[row][col] == null) {
      return false;
    } else {
      if (grid[row][col] == Value.ELIMINATED) {
        return true;
      } else {
        return false;
      }
    }
  }

  @Override
  public boolean isSpace(int row, int col) {
    if (grid[row][col] == null) {
      return false;
    } else {
      if (grid[row][col] == Value.CLEAR) {
        return true;
      } else {
        return false;
      }
    }
  }

  @Override
  public void toggleCellShaded(int row, int col) {
    if (grid[row][col] == Value.SHADED) {
      grid[row][col] = Value.CLEAR;
    } else {
      grid[row][col] = Value.SHADED;
    }
  }

  @Override
  public void toggleCellEliminated(int row, int col) {
    if (grid[row][col] == Value.ELIMINATED) {
      grid[row][col] = Value.CLEAR;
    } else {
      grid[row][col] = Value.ELIMINATED;
    }
  }

  @Override
  public void clear() {
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        grid[row][col] = Value.CLEAR;
      }
    }
  }
}
