package o1.auctionhouse

import scala.math._

class DutchAuction(val description:   String,
                   val startingPrice: Int,
                   val decrement:     Int,
                   val minimumPrice:  Int) {

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

  def buy(curbuyer: String): Boolean = {
    if (this.isOpen) {
      this.curbuyer = Some(curbuyer)
      return true
    }
    false
  }

  def price = this.curprice
  def buyer = this.curbuyer
  def isExpired: Boolean = this.stagnant > 3
  def isOpen: Boolean = this.curbuyer == None && !this.isExpired
  def priceRatio: Double = 1.0 * this.curprice / this.startingPrice

  override
  def toString: String = this.description

}
