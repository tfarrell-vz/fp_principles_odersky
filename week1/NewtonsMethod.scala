object NewtonsMethod {

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
    val mean = (quotient + guess) / 2
    return mean
  }

  def sqrIter(guess:Double, x:Double):Double = {
    if (isGoodEnough(guess, x)) guess
    else sqrIter(improve(guess, x), x)
  }

  def sqrt(num: Double): Double = sqrIter(1.0, num)

  def main(args: Array[String]): Unit = {
    println("The estimated square root of 5 starting with a guess of 1 is: " + sqrt(5))
  }
}