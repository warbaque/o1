package o1

object merkkijonoja {

  import scala.collection.mutable.Buffer

  def yhtaikaa(buf: Buffer[String], tempo: Int) = buf.mkString("&") + "/" + tempo
  def tempo(str: String) = str.split("/").lift(1).getOrElse("120").toInt

}
