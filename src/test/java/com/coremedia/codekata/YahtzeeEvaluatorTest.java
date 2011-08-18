package com.coremedia.codekata;

import com.coremedia.codekata.YahtzeeEvaluator;
import com.coremedia.codekata.YahtzeeEvaluator.Category;
import org.junit.Assert;
import org.junit.Test;

public class YahtzeeEvaluatorTest {

  @Test
  public void testCatSameDices_01() {
    int[] roll = {1, 2, 3, 4, 5};
    Assert.assertEquals(1, YahtzeeEvaluator.evaluateRoll(roll, Category.SAME_ONES));
  }

  @Test
  public void testCatSameDices_01_2() {
    int[] roll = {1, 1, 3, 4, 5};
    Assert.assertEquals(2, YahtzeeEvaluator.evaluateRoll(roll, Category.SAME_ONES));
  }

  @Test
  public void testCatSameDices_02() {
    int[] roll = {1, 2, 3, 4, 5};
    Assert.assertEquals(2, YahtzeeEvaluator.evaluateRoll(roll, Category.SAME_TWOS));
  }

  @Test
  public void testCatSameDices_03() {
    int[] roll = {1, 2, 3, 4, 5};
    Assert.assertTrue(3 == YahtzeeEvaluator.evaluateRoll(roll, Category.SAME_THREES));
    Assert.assertEquals(2, YahtzeeEvaluator.evaluateRoll(roll, Category.SAME_TWOS));
  }

  @Test
  public void testCatSameDices_04() {
    int[] roll = {1, 2, 3, 4, 5};
    Assert.assertEquals(4, YahtzeeEvaluator.evaluateRoll(roll, Category.SAME_FOURS));
  }

  @Test
  public void testCatSameDices_05() {
    int[] roll = {1, 2, 3, 4, 5};
    Assert.assertEquals(5, YahtzeeEvaluator.evaluateRoll(roll, Category.SAME_FIVES));
  }

  @Test
  public void testCatSameDices_06() {
    int[] roll = {1, 2, 3, 4, 6};
    Assert.assertEquals(6, YahtzeeEvaluator.evaluateRoll(roll, Category.SAME_SIXES));
  }

  @Test
  public void testCatSameDices_07() {
    int[] roll = {1, 2, 3, 4, 5};
    Assert.assertEquals(0, YahtzeeEvaluator.evaluateRoll(roll, Category.SAME_SIXES));
  }

  @Test
  public void testCatSameDices_08() {
    int[] roll = {1, 6, 6, 6, 1};
    Assert.assertEquals(18, YahtzeeEvaluator.evaluateRoll(roll, Category.SAME_SIXES));
  }

  @Test
  public void testPair_01() {
    int[] roll = {1, 2, 3, 4, 5};
    Assert.assertEquals(0, YahtzeeEvaluator.evaluateRoll(roll, Category.PAIR_ONES));
  }

  @Test
  public void testPair_02() {
    int[] roll = {1, 1, 3, 4, 5};
    Assert.assertEquals(2, YahtzeeEvaluator.evaluateRoll(roll, Category.PAIR_ONES));
  }

  @Test
  public void testPair_02_2() {
    int[] roll = {5, 1, 3, 4, 5};
    Assert.assertEquals(10, YahtzeeEvaluator.evaluateRoll(roll, Category.PAIR_FIVES));
  }
}
