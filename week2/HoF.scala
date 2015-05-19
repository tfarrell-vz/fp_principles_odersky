object HoF {
  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    @annotation.tailrec
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a+1, f(a)+acc)
    }
    loop(a, 0)
  }

  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1
    else f(a) * product(f)(a+1, b)
  }

  def cube(x: Int): Int = x * x * x
  def square(x: Int): Int = x * x
  def id(x: Int): Int = x
}