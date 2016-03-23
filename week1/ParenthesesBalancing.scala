object ParenthesesBalancing {
  /**
   * Verifies whether the parentheses in a given character list (string) are balanced.
   */
  def balance(chars: List[Char]): Boolean = {
    def loop(chars: List[Char], balance: Int): Int = {
      if (chars.isEmpty) balance
      else {
        if (balance < 0) balance
        else {
          val head = chars.head
          val tail = chars.tail
          if (head == '(') loop(tail, balance+1)
          else if (head == ')') loop(tail, balance-1)
          else loop(tail, balance)
        }
      }
    }
    val balance = loop(chars, 0)
    if (balance == 0) true
    else false
  }
}