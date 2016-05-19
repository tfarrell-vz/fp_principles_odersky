package idealized.scala

abstract class Boolean1 {
  def ifThenElse[T](t: => T, e: => T): T

  def && (x: => Boolean1): Boolean1 = ifThenElse(x, false1)
  def || (x: => Boolean1): Boolean1 = ifThenElse(true1, x)
  def unary_!: Boolean            = ifThenElse(false1, true1)

  def == (x: Boolean1): Boolean1    = ifThenElse(x, x.unary_!)
  def != (x: Boolean1): Boolean1    = ifThenElse(x.unary_!, x)

  def < (x: Boolean1): Boolean1     = ifThenElse(false1, x)
}

object true1 extends Boolean1 {
  def ifThenElse[T](t: => T, e: => T) = t
}

object false1 extends Boolean {
  def ifThenElse[T](t: => T, e: => T) = e
}