import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by vjames19 on 3/2/16.
  */
class ListSpec extends FlatSpec with Matchers{

  "List" should "be immutable" in {
    val a = List(1, 2, 3)
    val b = List(4, 5, 6)

    val c = a ::: b

    a should equal (List(1, 2, 3))

    b should equal (List(4, 5, 6))

    c should equal (List(1, 2, 3, 4, 5, 6))
  }

  it should "create a list using the cons :: operator" in {
    val list = 1 :: 2 :: 3 :: 4 :: Nil

    list shouldEqual List(1, 2, 3, 4)
  }

  it should "concatenate two lists" in {
    val a = List(1, 2)
    val b = List(3, 4)
    val c = a ::: b

    c shouldEqual List(1, 2, 3, 4)
  }

  it should "return the head" in {
    val a = List(1, 2)

    a.head shouldEqual 1
  }

  it should "return a list of mapped values" in {
    val a = List(1, 2).map(_*2)

    a shouldEqual List(2, 4)
  }

  it should "sort using a comparator function" in {
    val a = List(1, 2, 3)

    val sorted = a.sortWith((a, b) => a > b)

    sorted shouldEqual a.reverse
  }

  it should "be able to use foreach" in {
    val a = List(1, 2, 3)

    var index = 0
    a.foreach((integer) => {
      integer shouldEqual a(index)
      index += 1
    })
  }

  it should "be able to filter elements" in {
    val a = List(1, 2, 3)

    val filtered = a.filterNot(integer => integer <= 2)

    filtered shouldEqual List(3)
  }
}
