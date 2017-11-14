package o1.robots

import o1.grid.Direction

class Nosebot(name: String, body: RobotBody) extends RobotBrain(name, body) {

  /** Moves the robot. A spinbot simply spins 90 degrees clockwise as its move. */
  def moveBody() = {
    var i = 0
    while (i < 4 && !this.moveCarefully) {
      this.body.spinClockwise
      i += 1
    }
  }

}
