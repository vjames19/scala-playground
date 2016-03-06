import org.scalatest.{Matchers, FlatSpec}

/**
  * Created by vjames19 on 3/6/16.
  */
class OperatorMethodSpec extends FlatSpec with Matchers {

  "Any method" can "be an operator" in {
    val name = "Victor"

    name.indexOf('c') shouldBe 2
    name indexOf 'c' shouldBe 2
  }

  it must "let me call it in both forms" in {
    val integer = 2

    integer + 2 shouldEqual 4
    (integer).+(2) shouldEqual 4
  }

  "A defined method" can "be used as on operator" in {
    case class Person(val name: String) {

      def + (other: Person): Person = {
        new Person(name + other.name)
      }
    }

    val p1 = new Person("Vic")
    val p2 = new Person("Vic")

    p1 + p2 shouldEqual new Person("VicVic")

    var p3 = p1
    p3 += p1

    p3 shouldEqual new Person("VicVic")
  }

  "A prefix unary operator" must "be defined as unary_<operator>" in {
    case class Person(val name: String) {
      def unary_~ (): Person = {
        new Person(name.reverse)
      }
    }

    val p = new Person("Vic")
    ~p shouldEqual new Person(p.name.reverse)
  }

  it should "only be defined with the following operators +,-,! and ~" in {
    case class Person(val name: String) {
      def unary_~ (): Person = {
        new Person(name.reverse)
      }

      def unary_+ (): Person = {
        new Person(name.reverse)
      }

      def unary_- (): Person = {
        new Person(name.reverse)
      }

      def unary_! (): Person = {
        new Person(name.reverse)
      }

      def unary_* (): Person = {
        new Person(name.reverse)
      }
    }

    val p = new Person("Vic")
    ~p shouldEqual new Person(p.name.reverse)
    +p shouldEqual new Person(p.name.reverse)
    -p shouldEqual new Person(p.name.reverse)
    !p shouldEqual new Person(p.name.reverse)

    "*p" shouldNot compile
  }
}
