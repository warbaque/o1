package o1.auctionhouse

class EnglishAuction(description: String,
                     val startingPrice: Int,
                     duration: Int) extends ItemForSale(description) {

  private var highestBid = new Bid(None, startingPrice)
  private var secondHighestBid = new Bid(None, startingPrice)
  private var remainingDays = duration

  def daysLeft: Int = remainingDays

  def advanceOneDay(): Unit = if (this.isOpen) remainingDays -= 1

  def bid(bidder: String, amount: Int): Boolean = {
    var newBid = new Bid(Some(bidder), amount)
    if (!this.isOpen)
      false
    else if (newBid.beats(this.highestBid)) {
      this.secondHighestBid = this.highestBid
      this.highestBid = newBid
      true
    }
    else if (newBid.beats(this.secondHighestBid)) {
      this.secondHighestBid = newBid
      false
    }
    else
      false
  }

  def isOpen: Boolean = this.remainingDays > 0
  def isExpired: Boolean = !this.isOpen && this.highestBid.isInitialBid

  def buyer: Option[String] = this.highestBid.bidder

  def price: Int = {
    if (this.secondHighestBid.isInitialBid)
      this.startingPrice
    else if (this.highestBid.limit == this.secondHighestBid.limit)
      this.highestBid.limit
    else
      this.secondHighestBid.limit + 1
  }

  def requiredBid: Int = {
    if (this.highestBid.isInitialBid)
      this.startingPrice
    else
      this.price + 1
  }

  override
  def toString = this.description

}
