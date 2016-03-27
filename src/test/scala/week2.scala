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

  trait TestSets {
    val s = singletonSet(1)
    val t = singletonSet(2)
    val z = singletonSet(3)
  }

  new TestSets {
    val u = union(s, t)

    describe("After a union of two sets, s and t, forming u") {
      describe("An element belonging to s, and not t, also belongs also to u") {
        assert(contains(u, 1))
      }

      describe("An element belonging to t, and not s, also belongs to u") {
        assert(contains(u, 2))
      }

      describe("An element that belongs to neither t nor s, doesn't belong to u") {
        assert(!contains(u, 3))
      }

    }
  }


}