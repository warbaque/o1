package o1.football2

import scala.collection.mutable.Buffer
import scala.math._

class Season() {
  private val matches = Buffer[Match]()

  def addResult(newResult: Match): Unit = this.matches += newResult

  def biggestWin: Option[Match] = {
    val cmp = (a:Match, b:Match) =>
      if (abs(a.goalDifference) >= abs(b.goalDifference)) a else b
    if (matches.size == 0)
      None
    else
      Some(matches.reduceLeft(cmp))
  }

  def latestMatch: Option[Match] =
    if (matches.size == 0)
      None
    else
      Some(matches(matches.size - 1))

  def matchNumber(number: Int): Option[Match] =
    if (number >= matches.size)
      None
    else
      Some(matches(number))

  def numberOfMatches: Int = matches.size
}
