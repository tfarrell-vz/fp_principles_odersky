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
    mean
  }

  def reduceErrorSqrIter(x: Double):Double = {
    def raisedTo(j: Double, k: Int): Double = {
      def loop(num: Double, acc: Double, count: Int): Double = {
        if (count == 0) acc
        else loop(num, acc*num, count-1)
      }
      loop(j, 1, k)
    }
    def downLoop(num: Double, count: Int): Double = {
      if (num < 10000) sqrt(num) * raisedTo(10.0, count)
      else downLoop(num / 100.0, count + 1)
    }

    def upLoop(num: Double, count: Int):Double = {
      if (num > 1) sqrt(num) / raisedTo(10.0, count)
      else upLoop(num * 100.0, count+1)
    }

    if (x > 10000) downLoop(x, 0)
    else upLoop(x, 0)

  }

  def sqrIter(guess:Double, x:Double):Double = {
    if (isGoodEnough(guess, x)) guess
    else sqrIter(improve(guess, x), x)
  }

  def sqrt(num: Double): Double = {
    if (num == 0) 0
    else if (num < 1 || num > 10000) {
      println("Using reduceErrorSqrIter")
      reduceErrorSqrIter(num)
    }
    else sqrIter(1.0, num)
  }

  def main(args: Array[String]): Unit = {
    println("The estimated square root of 5 starting with a guess of 1 is: " + sqrt(5))
  }
}