package o1.robots

import scala.util.Random
import o1.grid._

class Staggerbot(name: String, body: RobotBody, randomSeed: Int) extends RobotBrain(name, body) {
  private var random = new Random(randomSeed)

  def moveBody() = {
    var direction = Direction.Clockwise(random.nextInt(4))
    if (this.body.moveTowards(direction))
      direction = Direction.Clockwise(random.nextInt(4))
    this.body.spinTowards(direction)
  }

}
