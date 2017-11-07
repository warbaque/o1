package o1

import collection.immutable.Vector


// TÄMÄ TEHTÄVÄ LIITTYY LUKUUN 8.1.

object rainfall {
  def averageRainfall(v: Vector[Int]): Option[Int] = {
    val w: Vector[Int] = v.takeWhile( _ < 999999 ).filter( _ >= 0 )
    if (w.size > 0) Some(w.sum / w.size) else None
  }
}
