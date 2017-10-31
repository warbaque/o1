package o1.carsim

object Location {
  def apply(lat: Double, long: Double): Location = new Location(lat, long)
}

class Location(val lat: Double, val long: Double) {

  def latDiff(another: Location): Double = another.lat - this.lat
  def longDiff(another: Location): Double = another.long - this.long

  def relative(latOffset: Double, longOffset: Double): Location =
    Location(this.lat + latOffset, this.long + longOffset)

  override
  def toString(): String = this.lat + ", " + this.long
}
