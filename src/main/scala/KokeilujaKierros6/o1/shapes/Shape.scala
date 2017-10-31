package o1.shapes

trait Shape {

  def isBiggerThan(another: Shape) = this.area > another.area

  def area: Double
  def perimeter: Double

}
