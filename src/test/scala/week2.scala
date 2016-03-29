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
    val u = union(s, t) // (1, 2)
    val r = union(s, z) // (1, 3)
    val i = intersect(u, r)
  }

  new TestSets {
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

    describe("The intersect of two sets, r and u, forming i") {
      describe("An element that belongs to both r and u, belongs to i") {
        assert(contains(r, 1) && contains(u, 1) && contains(i, 1))
      }

      describe("An element that belongs to r but not u, doesn't belong to i") {
        assert(contains(r, 3) && !contains(u, 3) && !contains(i, 3))
      }
    }
  }


}