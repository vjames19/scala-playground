import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by vjames19 on 3/6/16.
  */
class RationalSpec extends FlatSpec with Matchers {

  "A Rational" must "not accept 0 as denominator" in {
    intercept[IllegalArgumentException] {
      new Rational(1, 0)
    }
  }

  it should "allow using 0 as numerator" in {
    new Rational(0, 1).num shouldEqual 0
  }

  it should "allow to instantiate with just the numerator" in {
    new Rational(2) shouldEqual new Rational(2, 1)
  }

  it should "simplify the expression" in {
    new Rational(66, 42) shouldEqual new Rational(11, 7)

    new Rational(10, 2) shouldEqual new Rational(5)
  }

  it should "add rationals with same denominator" in {
    new Rational(10, 2) + new Rational(20, 2) shouldEqual new Rational(30, 2)
    new Rational(10, 2) + new Rational(20, 2) shouldEqual new Rational(15)
  }

  it should "add with different denominators" in {
    new Rational(10, 2) + new Rational(20, 3) shouldEqual new Rational(70, 6)
  }

  it should "add another integer" in {
    new Rational(1, 2) + 1 shouldEqual new Rational(3, 2)
  }

  it should "substract" in {
    new Rational(1, 2) - new Rational(1) shouldEqual new Rational(-1, 2)
    2 - new Rational(1, 2) shouldEqual new Rational(3, 2)
  }

  it should "multiply" in {
    new Rational(10, 2) * new Rational(20, 3) shouldEqual new Rational(200, 6)
  }

  it should "multiply another integer" in {
    new Rational(10, 2) * 2 shouldEqual new Rational(10)

    2 * new Rational(10, 2) shouldEqual new Rational(10)
  }

  it should "divide" in {
    new Rational(10, 2) / new Rational(1, 2) shouldEqual (new Rational(10))
  }

  it should "follow operator precedence" in {
    val x = new Rational(10, 2)
    val y = new Rational(5)
    val z = new Rational(2, 5)

    x + y * z shouldEqual new Rational(7)
    (x + y) * z shouldEqual new Rational(4)
  }
}
