package o1.viinaharava

import o1.grid._
import scala.util.Random


/** Each instance of the class `GameBoard` represents a board for a game of Viinaharava.
  * A game board is a `Grid` whose elements are `Glass` objects.
  *
  * Some of these glasses --- in random locations --- will be initialized to contain booze;
  * the rest keep their default content of water. The glasses are created and filled
  * as part of creating a `GameBoard`.
  *
  * @param width       the number of glasses in each row of the game board
  * @param height      the number of rows of glasses in the game board
  * @param boozeCount  the number of booze glasses on the game board. When a `GameBoard` object
  *                    is created, it randomly chooses this many different locations on the board
  *                    and pours booze in them.
  *
  * @see [[o1.grid.Grid]]
  * @see [[Glass.pourBooze]] */
class GameBoard(width: Int, height: Int, boozeCount: Int) extends Grid[Glass](width, height) {

  this.placeGlasses(boozeCount)

  private def placeGlasses(boozeCount: Int) = {

    for (x <- 0 until this.width)
      for (y <- 0 until this.height)
        this.update(new Coords(x, y), new Glass(this, new Coords(x, y)))

    var i = 0
    while (i < boozeCount) {
      val x = Random.nextInt(this.width)
      val y = Random.nextInt(this.height)
      val location = new Coords(x, y);
      if (!this(location).isBooze) {
        this(location).pourBooze
        i += 1
      }
    }
  }




  // Note to students: You don't need to (and shouldn't) modify the following methods.

  /** Returns a collection of all the booze glasses currently on the board. */
  def boozeGlasses = this.allElements.filter( _.isBooze ).toVector


  /** Determines whether all the water on the board has been drunk already. */
  def isOutOfWater = this.allElements.forall( glass => glass.isBooze || glass.isEmpty )




}

