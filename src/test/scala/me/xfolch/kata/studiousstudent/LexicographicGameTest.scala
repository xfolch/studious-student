package me.xfolch.kata.studiousstudent

import org.scalatest.{Matchers, FlatSpec}

/**
 * Tests use cases. I have tried to use TDD
 *
 * Created by xfolch on 28/12/14.
 */
class LexicographicGameTest extends FlatSpec with Matchers {

  "Given an empty input" should "return an empty output" in {
    LexicographicGameFactory().play(EmptyInput) should be (EmptyOutput)
  }

  "Given a text that contains an empty string" should "return an empty output" in {
    LexicographicGameFactory().play(Input("")) should be (EmptyOutput)
  }

  "Given more than 100 wordsets" should "throw an exception" in {
    val invalidInput = "101\n" + (1 to 101).map(_ => "1 hello").mkString("\n")
    an [IllegalArgumentException] should be thrownBy LexicographicGameFactory().play(Input(invalidInput))
  }

  "Given a text that contains the number '1' in the first line " +
    "and has no more lines" should "throw an exception" in {
     an [IllegalArgumentException] should be thrownBy LexicographicGameFactory().play(Input("1"))
  }

  "Given a text that contains a number greater than 0 " +
    "in the first line and has no more lines" should "throw an exception" in {
    an [IllegalArgumentException] should be thrownBy LexicographicGameFactory().play(Input("5"))
  }

  "Given a text that contains 1 wordset with 1 word" should "return that word" in {
    val input =
      """1
        |1 hello""".stripMargin

    val expectedOutput = "hello"

    LexicographicGameFactory().play(Input(input)).toString should be (expectedOutput)
  }

  "Given a text that contains any wordset with a word that has more than 10 letters" should
    "throw an exception" in {

    val invalidInput =
      """1
        |1 hellohowareyou""".stripMargin

    an [IllegalArgumentException] should be thrownBy LexicographicGameFactory().play(Input(invalidInput))
  }

  "Given a text that contains 1 wordset and it has more elements than expected" should
    "throw an exception" in {

    val invalidInput =
      """1
        |1 hello john""".stripMargin

    an [IllegalArgumentException] should be thrownBy LexicographicGameFactory().play(Input(invalidInput))
  }

  "Given a text that contains 1 wordset that has more than 9 words" should "throw an exception" in {
    val invalidInput =
      """1
        |10 hello john would you like to go to the cinema""".stripMargin

    an [IllegalArgumentException] should be thrownBy LexicographicGameFactory().play(Input(invalidInput))
  }

  "Given a text that contains 1 wordset (2 words ordered)" should "return the expected output" in {
    val input =
      """1
        |2 hello john""".stripMargin

    val expectedOutput = "hellojohn"

    LexicographicGameFactory().play(Input(input)).toString should be (expectedOutput)
  }

  "Given a text that contains 1 wordset (2 words disordered)" should "return the expected output" in {
    val input =
      """1
        |2 hello bob""".stripMargin

    val expectedOutput = "bobhello"

    LexicographicGameFactory().play(Input(input)).toString should be (expectedOutput)
  }

  "Given a text that contains 2 wordsets (2 words and 1 word respectively)" should
    "return the expected output" in {

    val input =
      """2
        |2 hello john
        |1 hi""".stripMargin

    val expectedOutput =
      """hellojohn
        |hi""".stripMargin

    LexicographicGameFactory().play(Input(input)).toString should be (expectedOutput)
  }

  "Given a text that contains 2 wordsets, each of them contains 2 words" should
    "return the expected output" in {

    val input =
      """2
        |2 hello john
        |2 hi anne""".stripMargin

    val expectedOutput =
      """hellojohn
        |annehi""".stripMargin

    LexicographicGameFactory().play(Input(input)).toString should be (expectedOutput)
  }

  "Given a text that contains 3 wordsets (two with 2 words and one with 3 words)" should
    "return the expected output" in {

    val input =
      """3
        |2 hello john
        |2 hi anne
        |3 would you like""".stripMargin

    val expectedOutput =
      """hellojohn
        |annehi
        |likewouldyou""".stripMargin

    LexicographicGameFactory().play(Input(input)).toString should be (expectedOutput)
  }

  "Given the text proposed in exercise" should "return the expected output" in {
    val exerciseInput =
      """5
        |6 facebook hacker cup for studious students
        |5 k duz q rc lvraw
        |5 mybea zdr yubx xe dyroiy
        |5 jibw ji jp bw jibw
        |5 uiuy hopji li j dcyi""".stripMargin

    val exerciseExpectedOutput =
      """cupfacebookforhackerstudentsstudious
        |duzklvrawqrc
        |dyroiymybeaxeyubxzdr
        |bwjijibwjibwjp
        |dcyihopjijliuiuy""".stripMargin

    LexicographicGameFactory().play(Input(exerciseInput)).toString should be (exerciseExpectedOutput)
  }

}
