import org.scalatest.FunSpec

import week2.assignments._

class SetSpec extends FunSpec {
  import Sets._

  describe("Contains yields whether an element belongs to a set or not") {
    assert(contains((x: Int) => true, 100))
  }

  describe("A singleton set is a set that contains only one element") {
    val s = (x: Int) => x == 1
    assert(contains(s, 1))
    assert(!contains(s, 2))
  }

}