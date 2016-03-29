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
    val d = diff(r, u)
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

      describe("An element that belongs to u but not r, doesn't belong to i") {
        assert(contains(u, 2) && !contains(r, 2) && !contains(i, 2))
      }
    }

    describe("The diff of two sets, r and u, form set d") {
      describe("An element that belongs to both r and u, doesn't belong to d") {
        assert(contains(r, 1) && contains(u, 1) && !contains(d, 1))
      }

      describe("An element that belongs to r, but not u, belongs to d") {
        assert(contains(r, 3) && !contains(u, 3) && contains(d, 3))
      }

      describe("An element that belongs to u, but not r, doesn't belong to d") {
        assert(contains(u, 2) && !contains(r, 2) && !contains(d, 2))
      }
    }

    describe("A filter of a set returns a set that satisfies the condition of the filter's predicate") {
      describe("Given a set e containing the first 5 integers, and a predicate of i => i % 2, the resulting set is the even subset of e") {
        val e = (x: Int) => x >= 0 && x < 5
        val p = (x: Int) => x % 2 == 0
        val result = filter(e, p)
        assert(contains(result, 0) && contains(result, 2) && contains(result, 4) && !contains(result, 1) && !contains(result, 3))
      }
    }
  }


}