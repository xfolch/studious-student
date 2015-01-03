package me.xfolch.kata

/**
 * Provides classes for dealing with the lexicographic game proposed
 * by '''Leo Antoli''' in the Barcelona SW Craftsmanship session on
 * December 2th, 2014
 *
 * [[http://goo.gl/eLQl8E Exercise description]]
 *
 * Created by xfolch on 1/1/15.
 */
package object studiousstudent {

  type Word = String

  def toInt(text: String): Option[Int] = {
    try {
      Some(text.toInt)
    } catch {
      case _: Exception => None
    }
  }

}
