package o1.train

/** The class `SittingCar` represents passenger cars with seats in a train ticket reservation
  * system. Each sitting car has rows of seats, which are numbered starting from one upwards.
  * Each row has a number of seats, identified by letters starting from 'a'.
  *
  * When created, all the seats in a sitting car are unreserved; this changes as reservations
  * are made.
  *
  * In this simple implementation, no data is stored about who has reserved which seat.
  *
  * @param numberOfRows  the number of seat rows in the car
  * @param seatsPerRow   the number of seats in each row */
class SittingCar(val numberOfRows: Int, val seatsPerRow: Int) extends TrainCar {

  private val seatReservations = Array.ofDim[Boolean](numberOfRows, seatsPerRow)   // one-way flags; initially false (unreserved)


  /** Returns the number of places (seats) this car has for passengers. */
  def numberOfPlaces = this.numberOfRows * this.seatsPerRow


  /** Returns the number of free (unreserved) places (seats) in this car. */
  def numberOfFreePlaces = {
    var free = 0                                         // stepper
    for (rowOfSeats <- this.seatReservations) {          // most-recent holder
      for (seatReserved <- rowOfSeats) {                 // most-recent holder
        if (!seatReserved) {
          free += 1
        }
      }
    }
    free
  }


  /** Returns a boolean value indicating whether the indicated seat is reserved or not.
    * @param numberOfRow  row number (>=1)
    * @param seat         seat identifier (small letter, from 'a' onwards) */
  def isReservedSeat(numberOfRow: Int, seat: Char) = this.seatReservations(numberOfRow - 1)(seat - 'a')


  /** Reserves the indicated seat, if possible. The reservation is unsuccessful if the seat
    * was already reserved. In the latter case, the method returns `false`; it returns `true` otherwise.
    * @param numberOfRow  row number (>=1)
    * @param seat         seat identifier (small letter, from 'a' onwards) */
  def reservePlace(numberOfRow: Int, seat: Char) = {
    if (this.isReservedSeat(numberOfRow, seat)) {
      false
    } else {
      this.seatReservations(numberOfRow - 1)(seat - 'a') = true
      true
    }
  }


  /** Reserves places (seats) for a group of people whose size is indicated by the parameter.
    * For a sitting car, a group reservation means that the whole group must get adjacent seats
    * in the same row.
    *
    * Where it would be possible to make the reservation in many different ways, the smallest
    * possible row number and first (alphabetically) possible seat identifiers are selected.
    *
    * If it is not possible to reserve suitable seats for all members of the group, no places
    * are reserved at all. The return value of this method indicates whether the seats were
    * reserved or not. */
  def reservePlaces(numberOfPeople: Int) = {
    var seatsFound = false
    var rowIndex = 0
    while (rowIndex < this.numberOfRows) {
      var seatIndex = 0
      while (seatIndex < this.seatsPerRow && !seatsFound) {
        val adjacentsFound = this.findAdjacents(rowIndex, seatIndex, numberOfPeople)
        if (adjacentsFound == numberOfPeople) {
          this.reserveAdjacents(rowIndex, seatIndex, numberOfPeople)
          seatsFound = true
        }
        seatIndex += 1
      }
      rowIndex += 1
    }
    seatsFound
  }

  /** Checks whether the given number of adjacent seats are free at the given spot in the car.
    * @param rowIndex       the index (>=0) of a row
    * @param seatIndex      the index (>=0) of a seat
    * @param numberOfSeats  the desired number of adjacent seats
    * @return the number of adjacent seats starting at the seat indicated by the
    *         parameter values; this will be a number between 0 and `numberOfSeats` */
  private def findAdjacents(rowIndex: Int, seatIndex: Int, numberOfSeats: Int) = {
    var adjacents = 0               // stepper
    var checkingIndex = seatIndex   // stepper

    while (adjacents < numberOfSeats && checkingIndex < this.seatsPerRow && !this.seatReservations(rowIndex)(checkingIndex)) {
      adjacents += 1
      checkingIndex += 1
    }
    adjacents
  }


  /** Reserves the given number of adjacent seats starting at the given seat.
    * Assumes that those seats are free to begin with.
    * @param rowIndex       the index (>=0) of a row
    * @param seatIndex      the index (>=0) of a place
    * @param numberOfSeats  the number of seats to reserve, starting with the one indicated by the other parameters */
  private def reserveAdjacents(rowIndex: Int, seatIndex: Int, numberOfSeats: Int) = {
    for (toBeReservedIndex <- seatIndex until seatIndex + numberOfSeats) {
      this.seatReservations(rowIndex)(toBeReservedIndex) = true
    }
  }


}
