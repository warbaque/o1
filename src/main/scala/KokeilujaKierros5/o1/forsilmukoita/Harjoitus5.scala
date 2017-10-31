package o1.forsilmukoita

// TÄMÄ TEHTÄVÄ LIITTYY LUKUUN 5.4.

import scala.io.StdIn._

object Harjoitus5 extends App {

  val syoteteksti = readLine("Anna jokin positiivinen kokonaisluku: ").toInt // readLine-funktio; ks. luku 2.6
  for (i <- 1 to syoteteksti)
    println(i*i)

  // Täydennä tähän alle ohjelma, joka tulostaa positiivisten lukujen
  // neliöitä allekkain omille riveilleen aina käyttäjän antamaan lukuun saakka.
  //
  // Esimerkiksi jos käyttäjä antaa luvun 3, pitää tulostaa:
  // 1
  // 4
  // 9
  //
  // Käytä for-silmukkaa lukujen tulostamiseen.
  // Sinun ei tarvitse huomioida virheellisiä syötteitä (esim. kissa, -100, 10.5).
  //
  // Vinkki: Muuta syöte luvuksi toInt-metodilla (luku 4.4).

}

