package o1.auctionhouse

abstract class InstantPurchase(description: String) extends ItemForSale(description) {

  private var curBuyer: Option[String] = None

  //def advanceOneDay(): Unit
  //def isExpired: Boolean
  //def price: Int

  def buy(curBuyer: String): Boolean = {
    val ok = this.isOpen
    if (ok)
      this.curBuyer = Some(curBuyer)
    ok
  }

  def buyer = this.curBuyer

  def isOpen: Boolean = this.curBuyer == None && !this.isExpired

  override
  def toString: String = this.description
}
