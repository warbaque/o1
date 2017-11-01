package o1.funktioita

// TÄMÄ TEHTÄVÄ LIITTYY LUKUUN 7.3.

object Harjoitus5 extends App {

  // TEHTÄVÄN VAIHE 1:
  def koostaTulosAlkioista(lukuja: Vector[Int], alkuarvo: Int, operaatio: (Int, Int) => Int) = {
    lukuja.foldLeft(alkuarvo)(operaatio)
  }

  def laskeSumma(vanhaTulos: Int, seuraavaLuku: Int) = vanhaTulos + seuraavaLuku


  val esimerkkilukuja = Vector(100, 25, -12, 0, 50, 0)
  println("Luvut ovat: " + esimerkkilukuja.mkString(", "))

  println("Summa: " + koostaTulosAlkioista(esimerkkilukuja, 0, laskeSumma)) // pitäisi tulostaa: Summa: 163


  // TEHTÄVÄN VAIHE 2:
  def laskePositiiviset(a: Int, b: Int) = a + (if (b > 0) 1 else 0)
  def laskeTulo(a: Int, b: Int) = a * (if (b != 0) b else 1)

  val montakoPositiivista = koostaTulosAlkioista(esimerkkilukuja, 0, laskePositiiviset)
  val lukujenTulo = koostaTulosAlkioista(esimerkkilukuja, 1, laskeTulo)
  println("Positiivisia: " + montakoPositiivista + " kpl")
  println("Tulo: " + lukujenTulo)

}
