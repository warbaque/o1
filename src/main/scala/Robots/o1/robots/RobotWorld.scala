package o1.robots

import o1.grid._
import scala.collection.mutable.Buffer

/** An instance of the class `RobotWorld` represents a two dimensional world that
  * can be inhabited by virtual robots. This kind of "robot world" is a `Grid` whose
  * elements are `Square` objects.
  *
  * Robots -- `RobotBody` objects -- can be added to the robot world, and the robot
  * world object maintains a robot listing which allows robots to take their turns
  * in a round-robin fashion. Apart from robots, a robot world can also contain walls,
  * and indeed is bounded by walls on all sides: all the edge squares of
  * all robot worlds are always unpassable by robots.
  *
  * @param floorWidth   the width of the robot world, in squares, ''in addition to the walls on both sides''. The total width of the grid will be two plus this number.
  * @param floorHeight  the height of the robot world, in squares, ''in addition to the walls at the top and at the bottom''. The total height of the grid will be two plus this number.
  *
  * @see [[o1.grid.Grid]]
  * @see [[Square]] */
class RobotWorld(floorWidth: Int, floorHeight: Int) extends Grid[Square](floorWidth, floorHeight) {

  private val robots = Buffer[RobotBody]()
  private var turn = 0

  for (x <- 0 until this.width; y <- 0 until this.height) {
    this.update(new Coords(x, y), Wall)
  }


  /** Creates a new robot into this robot world. The newly created robot body does
    * not yet have a brain.
    *
    * This method is responsible for several related things: creating the robot (body), adding
    * the robot to the list of robots in this world (so it will get a turn to act), and
    * informing the robot's initial square that the robot is now there.
    *
    * @param initialLocation  the initial location of the new robot in this world. This method assumes that `location` points to an empty square.
    * @param initialFacing    the direction that the robot is initially facing in
    * @return the newly created robot body, which has been placed in the indicated square */
  def addRobot(initialLocation: Coords, initialFacing: Direction) = {
    this.robots.head // TODO: replace this line with a working implementation
  }


  /** Marks a square in this robot world as being an unpassable wall square. This method
    * assumes that the location of the wall, given as a parameter, points to an empty square. */
  def addWall(location: Coords) = {
    // TODO: implementation missing
  }


  /** Returns the number of robots (robot bodies) that have been added to this world. */
  def numberOfRobots = this.robots.size


  /** Returns the robot whose turn it is to act. That is, returns the robot who will be the
    * next one to act when [[advanceTurn]] or [[advanceFullTurn]] is called.
    *
    * The robots take turns in a round-robin fashion: the first one to act is the first one
    * that was added, the second to act is the second one to be added, and so on. When the
    * robot that was added last has taken its turn, it becomes the first one's turn again.
    *
    * Note that calling this method does not actually cause any robots to act or change the
    * state of the robot world in any way. The method merely returns the robot whose turn it is.
    *
    * (Clarifications: If a robot is added to the world while the last robot in the "queue"
    * has the turn, it is perfectly possible for the new robot to get its first turn very soon,
    * as soon as the previously added robot has acted. A newly added robot never ''immediately''
    * gains the turn, however, unless it is the first one to be added and therefore the only
    * robot in the whole world.)
    *
    * @return the robot whose turn it is next, wrapped in an `Option`; `None` if there are no robots in this world */
  def nextRobot = None // TODO: replace with a working implementation



  /** Causes the next robot to take a turn. The turn then immediately passes to the next robot.
    * @see [[nextRobot]]
    * @see [[RobotBody.takeTurn]] */
  def advanceTurn() = {
    // TODO: implementation missing
  }


  /** Causes all the robots in the world to take a turn, starting with the one whose turn it is next.
    * (After this is done, the robot who originally was next up, will be that once again.)
    * @see [[nextRobot]]
    * @see [[advanceTurn]]
    * @see [[RobotBody.takeTurn]] */
  def advanceFullTurn() = {
    // TODO: implementation missing
  }


  /** Returns a collection of all the robots in this robot world, in the order they were added to the world. */
  def robotList = this.robots.toVector

}



