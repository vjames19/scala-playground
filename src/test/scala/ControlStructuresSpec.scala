import java.io.File

import org.scalatest.{FlatSpec, Matchers}

import scala.collection.mutable.ListBuffer
import scala.io.Source

/**
  * Created by vjames19 on 3/6/16.
  */
class ControlStructuresSpec extends FlatSpec with Matchers {

  "An if/else" must "evaluate to an expression" in {
    val x = if (false) 1 else 2
    val y = if (true) 1 else 2
    val z = if (false) 0 else if (true) 1 else 2

    x shouldBe 2
    y shouldBe 1
    z shouldBe 1
  }

  "A while" can "loop" in {
    var i = 0

    while (i < 10) {
      i += 1
    }

    i shouldEqual 10
  }

  "A for" can "iterate over a range" in {
    var x = 1
    for (i <- 1 to 4) {
      i shouldEqual x
      x += 1
    }
  }

  it can "iterate over a collection" in {
    val list = List(1, 2, 3)

    val actual = ListBuffer[Int]()
    for (i <- list) {
        actual += i
    }

    actual shouldEqual list
  }

  it can "iterate and filter" in {
    val actual = ListBuffer[Int]()

    for (i <- 1 to 4 if i % 2 == 0) {
      actual += i
    }

    actual shouldEqual List(2, 4)
  }

  it can "iterate and filter with multiple ifs" in {
    val actual = ListBuffer[Int]()

    for (i <- 1 to 4
     if i % 2 == 0
     if i == 2
    ) {
      actual += i
    }

    actual shouldEqual List(2)
  }

  it can "accept variable declarations and nested iterations" in {
    def fileLines(file: File) = Source.fromFile(file).getLines().toList

    for {
      file <- new File(".").listFiles()
      if file.isFile
      if file.getName.endsWith(".scala")
      line <- fileLines(file)
      trimmed = line.trim
      if trimmed.matches(".*ControlStructuresSpec.*")
    } file + ": " + trimmed shouldEqual "ControlStructuresSpec.scala: class ControlStructuresSpec extends FlatSpec with Matchers {"
  }

  it can "yield a collection" in {
    val even = for (i <- 1 to 5 if i % 2 == 0) yield i
    even shouldBe List(2, 4)
  }
}
