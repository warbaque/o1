package o1.time


object TimeTest extends App{
  def ctor(begin: Int, end: Int): Interval =
    new Interval(new Moment(begin), new Moment(end))

  var a = new Moment(1919)
  var b = new Moment(2000)
  var c = new Moment(1990)
  var d = new Moment(2018)


  var x = new Interval(new Moment(1954), new Moment(1960))
  var y = new Interval(new Moment(1960), new Moment(2011))

  println(x.overlaps(y))
  println(x.intersection(y))
  println(x.union(y))

  println(ctor(1937, 2003).contains(ctor(1930, 2010)))
}
