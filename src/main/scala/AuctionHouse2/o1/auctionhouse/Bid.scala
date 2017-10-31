package o1.auctionhouse

class Bid(val bidder: Option[String], val limit: Int) {

  def isInitialBid = this.bidder.isEmpty
  def beats(another: Bid) = this.limit > another.limit || (another.isInitialBid && this.limit == another.limit)

}