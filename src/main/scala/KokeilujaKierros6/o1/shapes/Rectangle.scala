package o1.shapes

class Rectangle(val sideLength: Double, val anotherSideLength: Double) extends Shape {

  def area = this.sideLength * this.anotherSideLength
  def perimeter = 2 * this.sideLength + 2 * this.anotherSideLength

}
