package o1.multitap

import scala.io.StdIn._

/** This singleton object is a runnable program that allows the user to experiment with
  * multi-tap input. See Chapter 6.1 in the course materials for details. */
object MultiTap extends App {

  val pad = new Keypad(Vector(" .,!?", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ", "ÅÄÖ"))

  // Below are some lines that call the methods of class KeyPad. If you wish, you can run the program
  // and see what they print out. However, you should eventually remove these lines (or comment them out)
  // and write new ones so that the program repeatedly asks the user for multi-tap input strings and
  // prints out the corresponding text.

  def loop(): Unit = {
    print("> ")
    val line = readLine()
    if (line != "") {
      println(pad.toText(line) + "\n")
      loop()
    }
  }
  loop()
  println("exit")

}
