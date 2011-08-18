package com.coremedia.codekata;

/**
 * Evaluates the roll of five six-sided dices in the context of the Yahtzee (german: 'Kniffel') game.
 *
 * @see <a href="http://codingdojo.org/cgi-bin/wiki.pl?KataYahtzee">Description of this Kata @CodingDojo</a>
 */
public class YahtzeeEvaluator {

  static public enum Category {
    SAME_ONES,
    SAME_TWOS,
    SAME_THREES,
    SAME_FOURS,
    SAME_FIVES,
    SAME_SIXES,
    PAIR_ONES,
    PAIR_TWOS,
    PAIR_THREES,
    PAIR_FOURS,
    PAIR_FIVES,
    PAIR_SIXES;
  }

  public static int evaluateRoll(int[] roll, Category category) {
    switch (category) {
      case SAME_ONES:
        return calcSame(roll, 1);
      case SAME_TWOS:
        return calcSame(roll, 2);
      case SAME_THREES:
        return calcSame(roll, 3);
      case SAME_FOURS:
        return calcSame(roll, 4);
      case SAME_FIVES:
        return calcSame(roll, 5);
      case SAME_SIXES:
        return calcSame(roll, 6);
      case PAIR_ONES:
        return calcAtLeastSameOfDice(roll, 1, 2);
      case PAIR_FIVES:
        return calcAtLeastSameOfDice(roll, 5, 2);
    }

    return 0;
  }

  private static int calcAtLeastSameOfDice(int[] roll, int diceToCalc, int expectedDiceCount) {
    int hits = 0;
    for (int dice : roll) {
      if (dice == diceToCalc) {
        ++hits;
        if (hits == expectedDiceCount) {
          return calcSame(roll, diceToCalc);
        }
      }
    }

    // not as many hits as expected
    return 0;
  }

  private static int calcSame(int[] roll, int diceToCalc) {
    int sum = 0;
    for (int dice : roll) {
      if (dice == diceToCalc) {
        sum += diceToCalc;
      }
    }
    return sum;
  }
}
