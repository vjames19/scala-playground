/**
  * Created by vjames19 on 3/6/16.
  */
class Rational(numerator: Int, denominator: Int) {


  def this(n: Int) = this(n, 1) // aux constructor

  require(denominator != 0, "Denominator shouldn't be zero")

  private val g = gcd(numerator.abs, denominator.abs)
  val num = numerator / g
  val denom = denominator / g

  def +(that: Rational): Rational =
    new Rational(
      num * that.denom + that.num * denom,
      denom * that.denom)

  def -(that: Rational): Rational = this.+(new Rational(-that.num, that.denom))

  def *(that: Rational): Rational = new Rational(num * that.num, denom * that.denom)

  def /(that: Rational): Rational = this.*(new Rational(that.denom, that.num))

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  override def toString() = num + "/" + denom

  override def equals(other: Any): Boolean = other match {
    case that: Rational =>
        num == that.num &&
        denom == that.denom
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(num, denom)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

object Rational {
  // With this the compiler with implicitly convert an integer to a rational number
  implicit def intToRational(x: Int): Rational = new Rational(x)
}
