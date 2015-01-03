package me.xfolch.kata.studiousstudent

import scala.collection.immutable.Stream.Empty

/**
 * Output is a simply data structure that contains a list
 * of strings, each of them containing the lexicographically
 * shortest string of a word set
 *
 * Created by xfolch on 1/1/15.
 */
trait Output {
  def lines: Seq[String]
  override def toString: String = lines.mkString("\n")
}

case object EmptyOutput extends Output {
  def lines: Seq[String] = Empty
  override def toString: String = ""
}

/** Factory method for [[Output]] */
object Output {
  def apply(text: Seq[String]): Output = new Output {
    def lines: Seq[String] = text
  }
}



