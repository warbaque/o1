package o1.auctionhouse

class FixedPriceSale(description: String,
                     val price: Int,
                     private val duration: Int) extends InstantPurchase(description) {


  private var remainingDays = duration

  def advanceOneDay(): Unit = if (this.isOpen) remainingDays -= 1

  def isExpired: Boolean = this.remainingDays == 0 && this.buyer == None

  def daysLeft: Int = this.remainingDays

}
