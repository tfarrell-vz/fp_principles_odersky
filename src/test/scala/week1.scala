import org.scalatest.FunSpec

import week1.assignments._

class ParenthesisBalancingSpec extends FunSpec {
  describe("A ParenthesisBalancer") {
    describe("when given a string containing balanced parenthesis") {
      it("should return true") {
        val str0 = "(if (zero? x) max (/ 1 x))".toList
        val str1 = "I told him (that it's not (yet) done). (But he wasn't listening)".toList

        assert(ParenthesesBalancing.balance(str0) == true)
        assert(ParenthesesBalancing.balance(str1) == true)
      }
    }
    describe("when given a string containing unbalanced parenthesis") {
      it("should return false") {
        val unbalanced0 = ":-)".toList
        assert(ParenthesesBalancing.balance(unbalanced0) == false)
      }

      it("should return false, even if it contains the same number of opening and closing parenthesis") {
        val unbalanced1 = "())(".toList
        assert(ParenthesesBalancing.balance(unbalanced1) == false)
      }
    }
  }
}

class PascalsTriangleSpec extends FunSpec {
  describe("Pascal's triangle") {
    it("should have value 1 at position(0,2)") {
      assert(PascalsTriangle.pascal(0,2) == 1)
    }

    it("should have value 2 at position (1,2)") {
      assert(PascalsTriangle.pascal(1,2) == 2)
    }

    it("should have value 6 at position (2,4)") {
      assert(PascalsTriangle.pascal(2,4) == 6)
    }
  }
}