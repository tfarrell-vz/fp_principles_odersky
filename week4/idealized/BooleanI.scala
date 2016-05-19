package idealized.scala

abstract class BooleanI {
  def ifThenElse[T](t: => T, e: => T): T

  def && (x: => BooleanI): BooleanI = ifThenElse(x, falseI)
  def || (x: => BooleanI): BooleanI = ifThenElse(trueI, x)
  def unary_!: Boolean            = ifThenElse(falseI, trueI)

  def == (x: BooleanI): BooleanI    = ifThenElse(x, x.unary_!)
  def != (x: BooleanI): BooleanI    = ifThenElse(x.unary_!, x)

  def < (x: BooleanI): BooleanI     = ifThenElse(falseI, x)
}

object trueI extends BooleanI {
  def ifThenElse[T](t: => T, e: => T) = t
}

object falseI extends Boolean {
  def ifThenElse[T](t: => T, e: => T) = e
}