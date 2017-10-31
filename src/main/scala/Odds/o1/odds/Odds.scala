package o1.odds

// This class is gradually developed between Chapters 2.4 and 3.1.

class Odds(val wont: Int, val will: Int) {

  def probability = 1.0 * this.will / (this.wont + this.will)

  def fractional = this.wont + "/" + this.will
  def decimal = 1.0 + 1.0 * this.wont / this.will
  def winnings(x: Double) = decimal * x

  def isLikely = probability > 0.5
  def isLikelierThan(other: Odds) = this.probability > other.probability

  def moneyline = {
    if (this.probability > 0.5)
      -100 * this.will / this.wont
    else
      100 * this.wont / this.will
  }

  def both(other: Odds) =
    new Odds(this.wont * other.wont + this.wont * other.will + this.will * other.wont,
             this.will * other.will)

  def not = new Odds(this.will, this.wont)

  def either(other: Odds) =
    this.not.both(other.not).not

  override
  def toString = fractional
}
