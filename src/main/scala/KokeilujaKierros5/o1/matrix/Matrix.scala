package o1.matrix

// See Chapter 5.6 in the course materials.

class Matrix(val contents: Array[Array[Double]]) {  // contents is assumed to be "rectangular" and to have at least one row

  def width = this.contents(0).size

  def height = this.contents.size

  override def toString = {
    var picture = ""                          // gatherer
    for (currentRow <- this.contents) {
      for (currentElement <- currentRow) {
        picture += currentElement + "\t"
      }
      picture += "\n"
    }
    picture
  }

  def transpose = {
    val transposeWidth = this.height                                             // temporary
    val transposeHeight = this.width                                             // temporary
    val transposeContents = Array.ofDim[Double](transposeHeight, transposeWidth) // container
    for (row <- 0 until transposeHeight) {                                // row is a stepper
      for (col <- 0 until transposeWidth) {                               // col is a stepper
        transposeContents(row)(col) = this.contents(col)(row)
      }
    }
    new Matrix(transposeContents)
  }

  def rowSum(i: Int) = this.contents(i).sum
  def columnSum(i: Int) = this.contents.foldLeft(0.0)(_ + _(i))

}

