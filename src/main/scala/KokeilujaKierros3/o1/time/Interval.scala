package o1.time
import scala.math._


class Interval(val start: Moment, val end: Moment) {
  def contains(another: Interval): Boolean = another.start.isIn(this) && another.end.isIn(this)
  def contains(moment: Moment): Boolean = moment.isIn(this)

  def intersection(another: Interval): Option[Interval] = {
    var start = this.start.later(another.start)
    var end = this.end.earlier(another.end)
    if (start.isLaterThan(end))
      None
    else
      Some(new Interval(start, end))
  }

  def isLaterThan(another: Interval): Boolean = this.isLaterThan(another.end)
  def isLaterThan(moment: Moment): Boolean = this.start.isLaterThan(moment)
  def length: Int = this.end.distance(this.start)
  def overlaps(another: Interval): Boolean = this.intersection(another) != None

  def union(another: Interval): Interval =
    new Interval(this.start.earlier(another.start), this.end.later(another.end))

  override
  def toString(): String = {
    if (this.length == 0){
      this.start.toString()
    }
    else if (this.length <= 50){
      this.start + "-" * this.length + this.end
    }
    else {
      this.start + "..." + this.end
    }
  }

}
