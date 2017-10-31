package o1.election


class District(val name: String, val seats: Int, val candidates: Vector[Candidate]) {

  //def candidatesByParty: Map[String, Vector[Candidate]]
  //NOTE TO STUDENTS: THIS METHOD IS ONLY INTENDED FOR IMPLEMENTATION IN CHAPTER 9.4!

  def candidatesFrom(party: String): Vector[Candidate] = this.candidates.filter(_.party == party)

  //def distributionFigures: Map[Candidate, Double]
  //NOTE TO STUDENTS: THIS METHOD IS ONLY INTENDED FOR IMPLEMENTATION IN CHAPTER 9.4!
  //def electedCandidates: Vector[Candidate]
  //NOTE TO STUDENTS: THIS METHOD IS ONLY INTENDED FOR IMPLEMENTATION IN CHAPTER 9.4!

  def printCandidates(): Unit = {
    for (c <- candidates)
      println(c)
  }

  //def rankingOfParties: Vector[String]
  //NOTE TO STUDENTS: THIS METHOD IS ONLY INTENDED FOR IMPLEMENTATION IN CHAPTER 9.4!
  //def rankingsWithinParties: Map[String, Vector[Candidate]]
  //NOTE TO STUDENTS: THIS METHOD IS ONLY INTENDED FOR IMPLEMENTATION IN CHAPTER 9.4!

  override
  def toString(): String = "%s: %d candidates, %d seats".format(this.name, this.candidates.size, this.seats)

  def topCandidate: Candidate = this.candidates.maxBy(_.votes)

  //def topCandidatesByParty: Map[String, Candidate]
  //NOTE TO STUDENTS: THIS METHOD IS ONLY INTENDED FOR IMPLEMENTATION IN CHAPTER 9.4!

  def totalVotes(party: String): Int = this.candidatesFrom(party).foldLeft(0)(_ + _.votes)
  def totalVotes: Int = this.candidates.foldLeft(0)(_ + _.votes)

  //def votesByParty: Map[String, Int]
  //NOTE TO STUDENTS: THIS METHOD IS ONLY INTENDED FOR IMPLEMENTATION IN CHAPTER 9.4!
}
