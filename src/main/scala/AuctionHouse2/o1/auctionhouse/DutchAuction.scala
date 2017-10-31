package o1.auctionhouse

import scala.math._

class DutchAuction(description:   String,
                   val startingPrice: Int,
                   val decrement:     Int,
                   val minimumPrice:  Int) extends InstantPurchase(description) {

  private var curprice = startingPrice
  private var curbuyer: Option[String] = None
  private var stagnant = 0

  def advanceOneDay(): Unit = {
    if (!this.isOpen)
      None
    else if (this.curprice > minimumPrice)
      this.curprice = max(this.minimumPrice, this.curprice - this.decrement)
    else
      this.stagnant += 1
  }

  def price = this.curprice
  def isExpired: Boolean = this.stagnant > 3
  def priceRatio: Double = 1.0 * this.curprice / this.startingPrice

}
