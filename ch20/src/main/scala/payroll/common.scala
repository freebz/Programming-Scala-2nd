package progscala2.dsls.payroll

object common {
  sealed trait Amount { def amount: Double }

  case class Percentage(amount: Double) extends Amount {
    override def toString = s"$amount%"
  }

  case class Dollars(amount: Double) extends Amount {
    override def toString = s"$$$amount"
  }

  implicit class Units(amount: Double) {
    def percent = Percentage(amount)
    def dollars = Dollars(amount)
  }

  case class Deduction(name: String, amount: Amount) {
    override def toString = s"$name: $amount"
  }

  case class Deductions(
    name: String,
    divisorFromAnnualPay: Double = 1.0,
    var deductions: Vector[Deduction] = Vector.empty) {

    def gross(annaulSalary: Double): Double =
      annaulSalary / divisorFromAnnualPay

    def net(annaulSalary: Double): Double = {
      val g = gross(annaulSalary)
      (deductions foldLeft g) {
        case (total, Deduction(deduction, amount)) => amount match {
          case Percentage(value) => total - (g * value / 100.0)
          case Dollars(value) => total - value
        }
      }
    }

    override def toString =
      s"$name Deductions:" + deductions.mkString("\n ", "\n ", "")
  }
}
