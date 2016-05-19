package idealized.scala

abstract class Boolean1 {
  def ifThenElse[T](t: => T, e: => T): T

  def && (x: => Boolean1): Boolean1 = ifThenElse(x, false)
  def || (x: => Boolean1): Boolean1 = ifThenElse(true, x)
  def unary_!: Boolean            = ifThenElse(false, true)

  def == (x: Boolean1): Boolean1    = ifThenElse(x, x.unary_!)
  def != (x: Boolean1): Boolean1    = ifThenElse(x.unary_!, x)

  def < (x: Boolean1): Boolean1     = ifThenElse()
}

object true1 extends Boolean1 {
  def ifThenElse[T](t: => T, e: => T) = t
}

object false1 extends Boolean {
  def ifThenElse[T](t: => T, e: => T) = e
}