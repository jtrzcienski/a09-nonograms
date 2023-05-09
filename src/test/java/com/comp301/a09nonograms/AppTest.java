package com.comp301.a09nonograms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.comp301.a09nonograms.model.Clues;
import com.comp301.a09nonograms.model.Model;
import com.comp301.a09nonograms.model.ModelImpl;
import com.comp301.a09nonograms.model.ModelObserver;
import org.junit.Test;

import java.util.List;
import java.util.Observer;

/** Unit test for simple App. */
public class AppTest {
  /** Rigorous Test :-) */
  @Test
  public void shouldAnswerWithTrue() {
    assertTrue(true);
  }

  @Test
  public void IndexErrors(){
    List<Clues> clues = PuzzleLibrary.create();
    Model model = new ModelImpl(clues);
    ModelObserver observer = null;
    model.addObserver(observer);
  }
}
