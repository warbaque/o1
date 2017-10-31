package o1.football2

import scala.collection.mutable.Buffer


/** The class `Match` represents match results in a football match statistics program.
  * A match is played between teams from two clubs: a home club and an away club.
  * Goals scored by players of either team can be added to the match object with the
  * method `addGoal`.
  *
  * The class is expected to be used so that a match object with no goals is initially
  * created as a real-life match starts. Goals are added incrementally as the match
  * progresses. (A match object has mutable state.)
  *
  * @param home  the club whose team plays at home in the match
  * @param away  the club whose team plays away in the match */
class Match(val home: Club, val away: Club) {

  private val homeScorers = Buffer[Player]()
  private val awayScorers = Buffer[Player]()

  def winner = {
    if (this.goalDifference < 0)
      Some(this.away)
    else if (this.goalDifference > 0)
      Some(this.home)
    else
      None
  }

  def addGoal(scorer: Player): Unit = {
    if (scorer.employer == this.home)
      this.homeScorers += scorer
    else
      this.awayScorers += scorer
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
