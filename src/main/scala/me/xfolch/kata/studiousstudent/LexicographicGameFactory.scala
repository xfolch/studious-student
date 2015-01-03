package me.xfolch.kata.studiousstudent

import me.xfolch.kata.studiousstudent.impl.LexicographicGameImpl

/**
 * Factory method design pattern for [[LexicographicGame]]
 *
 * Separates the implementation details to the client
 *
 * Created by xfolch on 1/1/15.
 */
object LexicographicGameFactory {
  def apply(): LexicographicGame = new LexicographicGameImpl()
}
