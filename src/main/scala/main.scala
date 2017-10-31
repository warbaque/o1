import scala.collection.mutable.Buffer

import o1.train._

object Main extends App {
    val t = new Train("vr");
    val sc = new SittingCar(6, 5);

    def printCar(sc: SittingCar, rows: Int, seats: Int) = {
        for (row <- 1 to rows) {
            for (seat <- 'a' to ('a'.toInt + seats - 1).toChar) {
                print( if (sc.isReservedSeat(row, seat)) "x" else ".");
            }
            println();
        }
        println();
    }

    printCar(sc, 6, 5);

    sc.reservePlace(1, 'a');
    sc.reservePlace(1, 'e');
    printCar(sc, 6, 5);

    println("reserved:" + sc.reservePlaces(3));
    printCar(sc, 6, 5);
}
