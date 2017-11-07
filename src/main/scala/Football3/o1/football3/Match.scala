package o1.football3

class Match(val home: Club, val away: Club, val homeScorers: Vector[Player], val awayScorers: Vector[Player]) {

  def winner = {
    if (this.goalDifference < 0)
      Some(this.away)
    else if (this.goalDifference > 0)
      Some(this.home)
    else
      None
  }

  def addGoal(scorer: Player) = {
    scorer.employer match {
      case this.home => new Match(this.home, this.away, this.homeScorers :+ scorer, this.awayScorers)
      case this.away => new Match(this.home, this.away, this.homeScorers, this.awayScorers :+ scorer)
      case _ => this
    }
  }

  def awayGoals: Int = this.awayScorers.size
  def homeGoals: Int = this.homeScorers.size
  def goalDifference: Int = this.homeGoals - this.awayGoals
  def isHigherScoringThan(other: Match): Boolean = this.totalGoals > other.totalGoals
  def isAwayWin: Boolean = this.goalDifference < 0
  def isHomeWin: Boolean = this.goalDifference > 0
  def isTied: Boolean = this.goalDifference == 0
  def totalGoals: Int = this.homeGoals + this.awayGoals
  def isGoalless: Boolean = this.totalGoals == 0
  def location: String = this.home.stadium

  def winningGoalScorer: Option[Player] = {
    if (this.isHomeWin)
      Some(this.homeScorers(this.awayGoals))
    else if (this.isAwayWin)
      Some(this.awayScorers(this.homeGoals))
    else
      None
  }

  override
  def toString = {
    val clubNamesAndStadium = this.home.name + " vs. " + this.away.name + " at " +
     this.home.stadium + ": "
    if (this.isGoalless)
      clubNamesAndStadium + "tied at nil-nil"
    else if (this.goalDifference == 0)
      clubNamesAndStadium + "tied at " + this.homeGoals + "-all"
    else if (this.goalDifference > 0 )
      clubNamesAndStadium + this.homeGoals + "-" + this.awayGoals + " to " + this.home.name
    else
      clubNamesAndStadium + this.awayGoals + "-" + this.homeGoals + " to " + this.away.name
  }

}
