package o1.robots

import o1.grid._

class Psychobot(name: String, body: RobotBody) extends RobotBrain(name, body) {

  def moveBody(): Unit = {
    for (direction <- Direction.Clockwise) {
      var location = this.location.neighbor(direction)
      while (this.world(location).isEmpty)
        location = location.neighbor(direction)
      val target = this.world(location).robot
      if (target.exists(!_.isBroken)) {
        this.body.spinTowards(direction)
        while (this.body.moveTowards(direction)) {}
        return
      }
    }
  }

}
