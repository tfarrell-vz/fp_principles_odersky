object Factorial {
  def factorial(n: Int):Int = {
    @annotation.tailrec
    def loop(count: Int, acc: Int):Int = {
      if (count == 0) acc
      else loop(count - 1, acc * count)
    }
    loop(n, 1)
  }
}