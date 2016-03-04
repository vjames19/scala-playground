import org.scalatest.{Matchers, FlatSpec}

/**
  * Created by vjames19 on 3/2/16.
  */
class TupleSpec extends FlatSpec with Matchers {

  "Tuple" should "be immutable" in {
    val tuple = (1, "10")
    "tuple._1 = 2" shouldNot compile
  }

  it should "allow access to in a 1 base index of the form tuple._N" in {
    val tuple = ("a", 10, Array())

    tuple._1 shouldEqual "a"
    tuple._2 shouldEqual 10
    tuple._3 shouldEqual Array()
  }

}
