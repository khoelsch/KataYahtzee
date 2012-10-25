package com.coremedia.codekata.Yahtzee;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Implementation of <a href="http://codingdojo.org/cgi-bin/wiki.pl?KataYahtzee">KataYahtzee</a>.</p>
 * <p/>
 * <p>A dice roll in a game of yahtzee.</p>
 */
public final class Roll {
  private List<Integer> dicesRolled;

  public Roll() {
    dicesRolled = new ArrayList<Integer>();
  }

  /**
   * Adds a dice to the roll.
   *
   * @param numberOnDice The number on the dice added to the roll
   * @throws IllegalStateException if five dices have already been added to the roll
   * @return the {@link Roll} we add the dice to
   */
  public Roll add(int numberOnDice) {
    if (numberOnDice <= 0 || numberOnDice > 6) {
      throw new IllegalArgumentException("'" + numberOnDice + "' is an invalid dice number.");
    }

    if (dicesRolled.size() == 5) {
      throw new IllegalStateException("Cannot add more than five dices to the roll.");
    }

    dicesRolled.add(Integer.valueOf(numberOnDice));
    return this;
  }

  /**
   * Evaluates the whole dice roll.
   *
   * @return the total of points this roll would evaluate to in a game of Yahtzee
   * @throws IllegalStateException if an insufficient number of dice has been added to the roll
   */
  public int eval(Rule rule) {
    if (dicesRolled.size() < 5) {
      throw new IllegalStateException("an insufficient number of dice has been added to the roll");
    }

    return rule.apply(this);
  }

  /**
   * Counts the total of dices with the same number in the roll.
   * @param diceNumber number on the dice
   * @return the total of dices with the same number in the roll
   */
  int countSameOf(int diceNumber) {
    int sum = 0;
    for (Integer rolledDice : dicesRolled) {
      if (rolledDice.equals(diceNumber)) {
        ++sum;
      }
    }
    return sum;
  }

  interface Rule {
    int apply(Roll roll);
  }

  static class SameOf implements Rule {
    private int diceNumber;
    SameOf(int diceNumber) { this.diceNumber = diceNumber; }
     public int apply(Roll roll) {
      return roll.countSameOf(this.diceNumber);
    }
  }
}
