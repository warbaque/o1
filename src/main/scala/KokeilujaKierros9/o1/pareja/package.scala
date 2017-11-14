package o1

// TÄMÄ KOODI LIITTYY LUKUUN 9.1.

package object pareja {

  // Tämä esimerkkifunktio käsitellään luvussa 9.1.
  def ekaEiIsompi(lukupari: (Int, Int)) = lukupari._1 <= lukupari._2
  def minuuteiksiJaSekunneiksi(x: Int) = (x/60, x%60)

}