package chapter11

import java.time.LocalDate

import chapter11.LocalDateOps.CustomDate

/*case class CustomDate(date: LocalDate) {
  def +(days: Day): CustomDate = CustomDate(this.date.plusDays(days.num))
  def -(days: Day): CustomDate = CustomDate(this.date.minusDays(days.num))

  def +(weeks: Week): CustomDate = CustomDate(this.date.plusWeeks(weeks.num))
  def -(weeks: Week): CustomDate = CustomDate(this.date.minusWeeks(weeks.num))

  def +(months: Month): CustomDate = CustomDate(this.date.plusMonths(months.num))
  def -(months: Month): CustomDate = CustomDate(this.date.minusMonths(months.num))

  def +(years: Year): CustomDate = CustomDate(this.date.plusYears(years.num))
  def -(years: Year): CustomDate = CustomDate(this.date.minusYears(years.num))

  def till(endDate: CustomDate): CustomDateRange = if(this.date isBefore endDate.date)
    CustomDateRange(this, endDate)
  else {
    throw new IllegalArgumentException("Can't create a DateRange with given start and end dates.")
  }

  override def toString: String = s"Date: ${this.date}"
}*/

case class Day(num: Int)
case class Week(num: Int)
case class Month(num: Int)
case class Year(num: Int)

case class CustomDateRange(sd: CustomDate, ed:CustomDate){
  override def toString: String = s"$sd till $ed "
}

object LocalDateOps {
  implicit class CustomDate(val date: LocalDate) {

    def +(days: Day): CustomDate = CustomDate(this.date.plusDays(days.num))
    def -(days: Day): CustomDate = CustomDate(this.date.minusDays(days.num))

    def +(weeks: Week): CustomDate = CustomDate(this.date.plusWeeks(weeks.num))
    def -(weeks: Week): CustomDate = CustomDate(this.date.minusWeeks(weeks.num))

    def +(months: Month): CustomDate = CustomDate(this.date.plusMonths(months.num))
    def -(months: Month): CustomDate = CustomDate(this.date.minusMonths(months.num))

    def +(years: Year): CustomDate = CustomDate(this.date.plusYears(years.num))
    def -(years: Year): CustomDate = CustomDate(this.date.minusYears(years.num))

    def till(endDate: CustomDate): CustomDateRange = if(this.date isBefore endDate.date)
      CustomDateRange(this, endDate)
    else {
      throw new IllegalArgumentException("Can't create a DateRange with given start and end dates.")
    }

    override def toString: String = s"Date: ${this.date}"
  }
}