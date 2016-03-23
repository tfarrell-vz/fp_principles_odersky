import org.scalatest.FunSpec

import week1.assignments._

class ParenthesisBalancingSpec extends FunSpec {
  describe("A string, represented as a character list") {
    describe("when balanced") {
      it("should return true") {
        val str0 = "(if (zero? x) max (/ 1 x))".toList
        val str1 = "I told him (that it's not (yet) done). (But he wasn't listening)".toList

        assert(ParenthesesBalancing.balance(str0) == true)
        assert(ParenthesesBalancing.balance(str1) == true)
      }
    }
    describe("when unbalanced") {
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