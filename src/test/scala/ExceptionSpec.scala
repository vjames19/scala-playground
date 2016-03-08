import java.io.{IOException, FileNotFoundException}

/**
  * Created by vjames19 on 3/6/16.
  */
class ExceptionSpec extends UnitSpec {
  "An exception" can "be thrown" in {
    intercept[Exception] {
      throw new Exception()
    }
  }

  it can "be catched" in {
    try {
      throw new Exception()
    } catch {
      case e: Exception => assert(true)
    }
  }

  it can "keep propagatin if its not handled" in {
    intercept[FileNotFoundException] {
      try {
        throw new FileNotFoundException()
      } catch {
        case e: RuntimeException => assert(false)
      }
    }
  }
}
