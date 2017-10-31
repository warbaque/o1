package o1.auctionhouse

import scala.math._

class FixedPriceSale(val description: String, val price: Int, private var duration: Int) {
	private var buyerName: Option[String] = None

	def advanceOneDay(): Unit =
		if (this.isOpen)
			this.duration -= 1

	def buy(buyer: String): Boolean = {
		if (this.isOpen) {
			this.buyerName = Option(buyer)
			return true
		}
		false
	}

	def buyer: Option[String] = this.buyerName
	def daysLeft: Int = this.duration
	def isExpired: Boolean = this.daysLeft == 0
	def isOpen: Boolean = !this.isExpired && this.buyerName == None

	override
	def toString(): String = this.description
}
