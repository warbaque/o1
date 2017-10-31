package o1.hiddenpics


/** The class `Picture` represents an image that is used in the Hidden Pics application.
  * An image consists of pixels, represented here by `Pixel` objects. The pixels are
  * organized in rows and columns.
  *
  * Although individual pixels are represented as immutable objects, a `Picture` object
  * is mutable: any of its pixels can be changed for another. This facility is used by
  * the `filterReveal` methods, which, once implemented, can be used to "solve" the
  * garbled images provided with this application. For more information, see Chapter 5.6
  * in the course materials.
  *
  * @see [[Pixel]]
  * @param pixels  a "two-dimensional" array of pixels which form this picture. The outer array
  *                contains the "columns" of the image, each of which is an array of vertically
  *                aligned pixels. This array must be "rectangular" and must contain at least one pixel. */
class Picture(private val pixels: Array[Array[Pixel]]) {


  /** Returns the pixel at the given coordinates in this picture.
    * @param x  an x coordinate between 0 and `width - 1`
    * @param y  a y coordinate between 0 and `height - 1` */
  def apply(x: Int, y: Int) = this.pixels(x)(y)


  /** Returns the width of this picture, in pixels. */
  def width = this.pixels.size


  /** Returns the height of this picture, in pixels. */
  def height = this.pixels(0).size


  /** Runs a filter on the picture that "solves" the first hidden picture puzzle.
    * See Chapter 5.6 in the course materials for details. */
  def filterReveal1() = {
    for (y <- 0 until this.height)
      for (x <- 0 until this.width)
        this.pixels(x)(y) = new Pixel(this.pixels(x)(y).red * 10, 0, 0)

    //this.pixels = this.pixels.map(_.map(p => new Pixel(p.red * 10, 0, 0)))
  }


  /** Runs a filter on the picture that "solves" the second hidden picture puzzle.
    * See Chapter 5.6 in the course materials for details. */
  def filterReveal2() = {
    def f(p: Pixel) = {
      val c = if (p.blue < 16) p.blue * 16 else 0
      new Pixel(c, c, c)
    }
    for (y <- 0 until this.height)
      for (x <- 0 until this.width)
        this.pixels(x)(y) = f(this.pixels(x)(y))

    //this.pixels = this.pixels.map(_.map(p => f(p)))
  }


}
