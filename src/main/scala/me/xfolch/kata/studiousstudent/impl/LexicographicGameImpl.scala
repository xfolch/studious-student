package me.xfolch.kata.studiousstudent.impl

import me.xfolch.kata.studiousstudent._

/**
 * Created by xfolch on 1/1/15.
 */
class LexicographicGameImpl extends LexicographicGame {

  def play(input: Input): Output = input match {
    case EmptyInput => EmptyOutput
    case Input(_, wordSets) => Output(process(wordSets))
  }

  private def process(wordSets: Seq[WordSet]): Seq[String] = for {
    wordSet <- wordSets
  } yield sortLexicographically(wordSet)

  private def sortLexicographically(wordSet: WordSet): String = wordSet.words.sorted.mkString

}
