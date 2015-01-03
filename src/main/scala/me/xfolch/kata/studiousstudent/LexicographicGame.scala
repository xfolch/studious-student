package me.xfolch.kata.studiousstudent

/**
 * Since a list of word sets, this game has to find the
 * lexicographically shortest string for each word set
 *
 * Example:
 *
 * {{{
 *   val exerciseInput =
 *     """5
 *       |6 facebook hacker cup for studious students
 *       |5 k duz q rc lvraw
 *       |5 mybea zdr yubx xe dyroiy
 *       |5 jibw ji jp bw jibw
 *       |5 uiuy hopji li j dcyi""".stripMargin
 *
 *   val exerciseOutput =
 *     """cupfacebookforhackerstudentsstudious
 *       |duzklvrawqrc
 *       |dyroiymybeaxeyubxzdr
 *       |bwjijibwjibwjp
 *       |dcyihopjijliuiuy""".stripMargin
 * }}}
 *
 * Created by xfolch on 28/12/14.
 */
trait LexicographicGame {

  /**
   * Returns the lexicographically shortest strings for each word
   * set included in the input
   *
   * @param input As input for playing this game you will receive
   *              a text file containing an integer N, the number of
   *              word sets you need to play your game against.
   *              This will be followed by N word sets, each starting
   *              with an integer M, the number of words in the set,
   *              followed by M words. All tokens in the input will be
   *              separated by some whitespace and, aside from N and M,
   *              will consist entirely of lowercase letters.
   * @return      lexicographically shortest strings for each
   *              corresponding word set, one per line and in order
   */
  def play(input: Input): Output
}
