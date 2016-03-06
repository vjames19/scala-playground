import org.scalatest.{Matchers, FlatSpec}

/**
  * Created by vjames19 on 3/6/16.
  */
class ObjectEqualitySpec extends FlatSpec with Matchers {

  "Object equality" must "be tested with ==" in {
    1 == 1 shouldBe true

    List(1,2,3) == List(1,2,3) shouldBe true
  }

  it should "be able to test two different objects" in {
    1 == List(1) shouldBe false

    "A" == 1 shouldBe false
  }

  it should "be able to compare nulls" in {
    null == 0 shouldBe false
    List(1, 2) == null shouldBe false
  }

  it should "be able to test for inequality" in {
    1 != 1 shouldBe false
    1 != List(1, 2) shouldBe true
  }

}
