import org.scalatest._

class VariableSpec extends FlatSpec with Matchers {
  "var" should "not be immutable" in {
    var a = 10
    a = 12
    a should be === 12
  }


  "val" should "be immutable" in {
    val a = 10
    "a = 12" shouldNot compile
  }

  it should "allow me to modify an object" in {
    val array = new Array[Int](2)
    array(0) = 10
    array(1) = 11

    array should have length(2)

    array should contain allOf(10, 11)
  }
}
