object NewtonsMethodImproved {

  def abs(x: Double): Double = {
    if (x >= 0) x
    else -x
  }

  def isGoodEnough(guess: Double, x: Double) = {
    if (abs((guess * guess - x)) < 0.001) true
    else false
  }

  def improve(guess: Double, x: Double): Double = {
    val quotient = x / guess
    val mean = (quotient + guess) / 2.0
    return mean
  }

  def reduceErrorSqrIter(x: Double):Double = {
    val num = {
      if (x < 0) 1.0/x
      else x
    }

    def loop(cur: Double, count: Int):(Double, Int) = {
      if (cur <= 10000) (cur, count)
      else loop(cur/100.0, count+1)
    }

    val reduce = loop(num, 0)
    val compute = sqrt(reduce._1) * (10.0 * reduce._1)

    if (x < 0) 1.0 / compute
    else compute
  }

  def sqrIter(guess:Double, x:Double):Double = {
    if (isGoodEnough(guess, x)) guess
    else sqrIter(improve(guess, x), x)
  }

  def sqrt(num: Double): Double = {
    if (num < 0 ||num > 10000) {
      println("Using reduceErrorSqrIter")
      reduceErrorSqrIter(num)
    }
    else sqrIter(1.0, num)
  }

  def main(args: Array[String]): Unit = {
    println("The estimated square root of 5 starting with a guess of 1 is: " + sqrt(5))
  }
}