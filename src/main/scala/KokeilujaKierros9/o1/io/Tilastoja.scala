package o1.io

import scala.io.Source
import scala.io.StdIn._

// TÄMÄ TEHTÄVÄ ON ESITELTY KURSSIMATERIAALIN LUVUSSA 9.3.

object Tilastoja extends App {

  def keskiarvo(lukuja: Vector[Double]) = lukuja.sum / lukuja.size

  def mediaani(lukuja: Vector[Double]) = {
    val puolivali = lukuja.size / 2
    val jarjestetyt = lukuja.sorted
    if (lukuja.size % 2 == 1)
      jarjestetyt(puolivali)
    else
      (jarjestetyt(puolivali - 1) + jarjestetyt(puolivali)) / 2
  }

  def yleisimmanMaara(lukuja: Vector[Double]) = lukuja.groupBy(identity).values.map( _.size ).max

  val fname = readLine("Syötetiedosto: ")
  val ifile = Source.fromFile(fname)

  try {
    val values = ifile.getLines.toVector.map(_.toDouble)
    println("Lukumäärä: " + values.size)
    println("Keskiarvo: " + keskiarvo(values))
    println("Mediaani: " + mediaani(values))
    println("Yleisimmän määrä:" + yleisimmanMaara(values))
  } finally {
    ifile.close()
  }

}