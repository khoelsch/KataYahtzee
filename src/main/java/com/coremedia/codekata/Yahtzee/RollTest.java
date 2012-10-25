package com.coremedia.codekata.Yahtzee;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: khoelsch
 * Date: 25.10.12
 * Time: 21:27
 * To change this template use File | Settings | File Templates.
 */
public class RollTest {
  @Test(expected = IllegalArgumentException.class)
  public void add_lessThanOne() throws Exception {
    new Roll().add(0);
  }


  @Test(expected = IllegalArgumentException.class)
  public void add_greaterThanSix() throws Exception {
    new Roll().add(7);
  }

  @Test(expected = IllegalStateException.class)
  public void add_tooManyDiceRolls() {
    new Roll().add(1).add(2).add(3).add(4).add(5).add(6);
  }

  @Test(expected = IllegalStateException.class)
  public void eval_insufficientDicesAdded() {
    new Roll().add(1).add(2).add(3).add(4).eval(new Roll.DicesHaveTheSameNumberRule(1)); // Rule type does not matter here
  }

}
