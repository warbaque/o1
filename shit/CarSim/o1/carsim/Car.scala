package o1.carsim

import scala.math._

class Car(val fuelConsumption: Double, val tankSize: Double, initialFuel: Double, initialLocation: Location) {
  private var currentFuel = initialFuel
  private var currentLocation = initialLocation
  private var totalDistance = 0.0

  def location: Location = currentLocation

  def fuel(toBeAdded: Double): Double = {
    val diff = Math.min(this.tankSize - this.currentFuel, toBeAdded)
    this.currentFuel += diff
    diff
  }

  def fillUp(): Double = this.fuel(this.tankSize - this.currentFuel)

  def fuelRatio: Double = 100.0 * this.currentFuel / this.tankSize

  def fuelRange: Double = 100000 * this.currentFuel / this.fuelConsumption

  def metersDriven: Double = this.totalDistance

  def drive(destination: Location, metersToDestination: Double) = {
    val latOff = this.currentLocation.latDiff(destination)
    val longOff = this.currentLocation.longDiff(destination)
    val distance = Math.min(this.fuelRange, metersToDestination)
    val m = distance/metersToDestination
    this.totalDistance += distance
    this.currentFuel -= distance * this.fuelConsumption / 100000
    currentLocation = currentLocation.relative(latOff * m, longOff * m)
  }

}
