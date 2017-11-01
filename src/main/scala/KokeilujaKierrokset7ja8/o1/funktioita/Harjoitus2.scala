package o1.funktioita

// TÄMÄ TEHTÄVÄ LIITTYY LUKUUN 7.3.

import scala.math._
import scala.io.StdIn._

object Harjoitus2 extends App {

  // sin toiseen plus kosini toiseen, eli periaatteessa aina ykkönen
  def sin2cos2(luku: Int) = pow(sin(luku), 2) + pow(cos(luku), 2)

  val montako = readLine("Monenko luvun sin2cos2 lasketaan? ").toInt

  def ykkosiako = Vector.tabulate(montako)(sin2cos2)

  println(ykkosiako.mkString(", "))

}
