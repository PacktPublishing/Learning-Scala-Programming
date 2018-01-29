package chapter10

object ContraVariance extends App {
  class AircraftSeat[-T]

  def reserveSeatForCorporatePassengers(corporateSeats: AircraftSeat[CorporatePassengers]) = {
    //Performs some logic regarding the seat reservation!
    println(s"Seats Confirmed!")
  }

  abstract class Passengers
  class CorporatePassengers extends Passengers
  class RegularPassengers extends Passengers

  reserveSeatForCorporatePassengers(new AircraftSeat[CorporatePassengers])
  reserveSeatForCorporatePassengers(new AircraftSeat[Passengers])
  //reserveSeatForCorporatePassengers(new AircraftSeat[RegularPassengers])

}