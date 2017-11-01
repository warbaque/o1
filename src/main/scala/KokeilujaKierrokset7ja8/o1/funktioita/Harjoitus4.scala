package o1.funktioita

// TÄMÄ TEHTÄVÄ LIITTYY LUKUUN 7.3.


object Harjoitus4 extends App {

  // Muodostaa lyhennetyn version kaksiosaisesta nimestä.
  // Esim. Sauli Niinistö --> S. Niinistö
  def lyhennaNimi(merkkijono: String) = {
    val palat = merkkijono.split(" ")
    palat(0)(0) + ". " + palat(1)
  }

  def muutaKaikki(buf: Array[String], f: String => String) = for (i <- 0 until buf.size) buf(i) = f(buf(i))

  val nimia = Array("Umberto Eco", "James Joyce", "Dorothy Dunnett")
  println(nimia.mkString(", "))        // tulostaa: Umberto Eco, James Joyce, Dorothy Dunnett
  muutaKaikki(nimia, lyhennaNimi)
  println(nimia.mkString(", "))        // pitäisi tulostaa: U. Eco, J. Joyce, D. Dunnett

}
