package com.comp301.a09nonograms.model;

public class CluesImpl implements Clues {

  private int width, height;
  private int[][] rowClues, colClues;

  public CluesImpl(int[][] rowClues, int[][] colClues) {
    if (rowClues == null || colClues == null) {
      throw new IllegalArgumentException();
    }
    width = colClues.length;
    height = rowClues.length;
    this.rowClues = rowClues;
    this.colClues = colClues;
  }

  @Override
  public int getWidth() {
    return colClues.length;
  }

  @Override
  public int getHeight() {
    return rowClues.length;
  }

  @Override
  public int[] getRowClues(int index) {
    return rowClues[index];
  }

  @Override
  public int[] getColClues(int index) {
    return colClues[index];
  }

  @Override
  public int getRowCluesLength() {
    return rowClues[0].length;
  }

  @Override
  public int getColCluesLength() {
    return colClues[0].length;
  }
}
