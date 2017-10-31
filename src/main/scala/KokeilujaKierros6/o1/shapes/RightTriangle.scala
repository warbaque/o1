package o1.shapes

import scala.math._

class RightTriangle(val x: Double, val h: Double) extends Shape {

  def area = this.x * this.h / 2
  def perimeter = this.x + this.h + this.hypotenuse
  def hypotenuse = sqrt(this.x*this.x + this.h*this.h)

}
