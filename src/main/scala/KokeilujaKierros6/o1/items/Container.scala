package o1.items

import scala.collection.mutable.Buffer

class Container(name: String) extends Item(name) {
  private val cnt = Buffer[Item]()

  def addContent(newContent: Item): Unit = {
    cnt += newContent
  }

  override
  def toString = this.name + " containing " + this.cnt.size  + " item(s)"

}
