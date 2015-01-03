package me.xfolch.kata.studiousstudent

import scala.collection.immutable.Stream.Empty

/**
 * Trait that represents the input of the lexicographic game
 * <p/>
 * It is a simple data structure with a few constraints. It might
 * be a class, but I prefer to define as a trait
 *
 * Created by xfolch on 1/1/15.
 */
trait Input {
  def numberOfWordSets: Int
  def wordSets: Seq[WordSet]

  require(numberOfWordSets <= 100, "1 <= numberOfWordSets <= 100")
  require(numberOfWordSets == wordSets.size,
    s"Input must have exactly $numberOfWordSets wordSets, but has ${wordSets.size}")
}

/**
 * As explained in the exercise, a word set contains a list of words
 * and a number describing the amount of words it has
 */
trait WordSet {
  def numberOfWords: Int
  def words: Seq[Word]

  require(numberOfWords >= 1 && numberOfWords <= 9, "1 <= numberOfWords <= 9")
  require(numberOfWords == words.size,
    s"WordSet must have exactly $numberOfWords words, but has ${words.size} ($words)")
  require(words.forall(x => x.size >= 1 && x.size <= 10), "1 <= all words length <= 10")
}

case object EmptyInput extends Input {
  def numberOfWordSets: Int = 0
  def wordSets: Seq[WordSet] = Empty
}

/**
 * Factory method for [[Input]]
 *
 * It is not a flexible approach if you are expecting to have different
 * implementations.
 *
 * For example, you could have an string input and a file input. In that case,
 * I would prefer to move the implementation details into another file
 * in order not to create coupling
 */
object Input {
  def apply(total: Int, sets: Seq[WordSet]): Input = total match {
    case 0 => EmptyInput
    case x => new Input {
      def numberOfWordSets: Int = x
      def wordSets: Seq[WordSet] = sets
    }
  }

  def apply(text: String): Input = Vector(text.split("\n"): _*) match {
    case Vector("") => EmptyInput
    case total +: wordSets => Input(toInt(total).getOrElse(0), toWordSets(wordSets))
  }

  /** Extractor for pattern matching */
  def unapply(input: Input): Option[(Int, Seq[WordSet])] = Some((input.numberOfWordSets, input.wordSets))

  private def toWordSet(line: String): WordSet = Vector(line.split(" "): _*) match {
    case total +: w => new WordSet {
      def numberOfWords: Int = toInt(total).getOrElse(0)
      def words: Seq[Word] = w
    }
  }

  private def toWordSets(lines: Seq[String]): Seq[WordSet] = lines match {
    case Nil => Empty
    case x +: xs => toWordSet(x) +: toWordSets(xs)
  }
}
