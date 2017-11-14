import scala.collection.mutable.Buffer
import scala.collection.immutable.Vector

import o1.train._

class Node(val a: Int) {
  var n = this
  var isOk = false
  def isLast = this.n == this
  def stopIteration = isLast || isOk
  def seek(n: Node): Node = if (n.isLast) n else n.seek(n.n)
  def last: Node = seek(this)
  def a(x: Int) = {
    this.last.n = new Node(x)
    this.last.n
  }
  def next(x: Int) = this.n
  override def toString = {
    def f(n: Node): String = n.a + ":" + n.isOk + (if (n.isLast) " ]" else ", " + f(n.n))
    "[ " + f(this)
  }
}

object Main extends App {
  def create(s: Int, o: Int = 9999) = {
    val n = new Node(0)
    for (i <- 1 to s) {
      n.a(i)
      if (i == o) n.last.isOk = true
    }
    n
  }

  println("iterable nodes ")
  val vec = Vector[Node](create(4), create(5,4), create(4,2))
  for (n <- vec)
    println(n)

  val opts = Vector[Int](0, 1, 2)


  def optimizeThis: Unit = {
    for (x <- opts) {
      var n = vec(x)
      while (!n.stopIteration)
        n = n.next(x)

      if (n.isOk) {
        println(x)
        return
      }
    }
  }

  optimizeThis

  def comp(x: Int) = {
    import scala.annotation.tailrec
    @tailrec
    def seek(n: Node): Node = if (n.stopIteration) n else seek(n.n)
    seek(vec(x)).isOk
  }
  def p(x: Int) = {
    println(x)
  }
  (for (x <- opts.toStream if comp(x)) yield x).headOption.foreach(p)
}
