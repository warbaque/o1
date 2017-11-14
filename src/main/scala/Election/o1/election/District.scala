package o1.election


class District(val name: String, val seats: Int, val candidates: Vector[Candidate]) {

  def candidatesByParty: Map[String, Vector[Candidate]] = this.candidates.groupBy(_.party)
  def candidatesFrom(party: String): Vector[Candidate] = this.candidates.filter(_.party == party)

  def distributionFigures: Map[Candidate, Double] = {
    def distributionFigure(p: (Candidate, Int)) = votesByParty(p._1.party) / ( p._2 + 1.0 )
    rankingsWithinParties.flatMap(_._2.zipWithIndex).map(p => p._1 -> distributionFigure(p))
  }

  def electedCandidates: Vector[Candidate] = distributionFigures.toVector.sortBy(_._2).reverse.map(_._1).take(this.seats)

  def printCandidates(): Unit = {
    for (c <- candidates)
      println(c)
  }

  def rankingOfParties: Vector[String] = votesByParty.toVector.sortBy(_._2).reverse.map(_._1)
  def rankingsWithinParties: Map[String, Vector[Candidate]] = candidatesByParty.mapValues(_.sortBy(_.votes).reverse)

  override
  def toString(): String = "%s: %d candidates, %d seats".format(this.name, this.candidates.size, this.seats)

  def topCandidate: Candidate = this.candidates.maxBy(_.votes)

  def topCandidatesByParty: Map[String, Candidate] = candidatesByParty.mapValues(_.maxBy(_.votes))

  def totalVotes(party: String): Int = this.candidatesFrom(party).foldLeft(0)(_ + _.votes)
  def totalVotes: Int = this.candidates.foldLeft(0)(_ + _.votes)

  def votesByParty: Map[String, Int] = candidatesByParty.mapValues(_.map(_.votes).sum)

}
