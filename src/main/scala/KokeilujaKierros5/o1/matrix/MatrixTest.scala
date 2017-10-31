package o1.matrix

// See Chapter 5.6 in the course materials. 

object MatrixTest extends App {

  val original = new Matrix(Array(Array(1, 2, 3), Array(4, 5, 6)))

  println("The Matrix:")
  println(original)

  println("The Matrix Revolutions:")
  println(original.transpose)
  println(original.transpose.transpose)

  
}