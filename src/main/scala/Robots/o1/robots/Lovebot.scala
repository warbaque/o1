package o1.robots

import scala.math._
import o1.grid._

class Lovebot(name: String, body: RobotBody, private val beloved: RobotBody) extends RobotBrain(name, body) {

  def moveBody() = {
    val dx = beloved.location.x - this.location.x
    val dy = beloved.location.y - this.location.y

    if (abs(dy) + abs(dx) > 1) {
      def f(x: Int, a: Direction, b: Direction) = if (x > 0) a else b
      val facing = f(abs(dy) - abs(dx), f(dy, South, North), f(dx, East, West))
      this.body.moveTowards(facing)
    }
  }

}
