package o1.odds

// This program is gradually developed in Chapters 2.8, 2.9, and 3.1.
// It creates two Odds objects and uses them.

import scala.io.StdIn._

object OddsTest2 extends App {

  println("Please enter the odds of the first event as two integers on separate lines.")
  val first = new Odds(readInt(), readInt())
  println("Please enter the odds of the second event as two integers on separate lines.")
  val second = new Odds(readInt(), readInt())

  println("The first event is " +
          (if (first.isLikelierThan(second)) "" else "not") +
          "likelier than the second.")

  if (first.isLikely && second.isLikely)
    println("Each of the events is odds-on to happen.")

  println("The odds of the first event not happening are: " + first.not)
  println("The odds of both events happening are: " + first.both(second))
  println("The odds of at least one of the events happening are: " + first.either(second))

  println("Thank you for using OddsTest2. Please come back often. Have a nice day!")
}