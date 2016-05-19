package week4.lecture

trait FList[T] {
  def isEmpty: Boolean
  def head: T
  def tail: FList[T]
}

class FCons[T](val head: T, val tail: FList[T]) extends FList[T] {
  override def toString = "FCons(" + head.toString + ", " + tail.toString + ")"
  def isEmpty = false
}

class FNil[T] extends FList[T] {
  override def toString = "FNil"
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException("FNil.head")
  def tail: Nothing = throw new NoSuchElementException("FNil.tail")
}

object FList {
  // List(1, 2) = List.apply(1, 2)
  def apply[T](x1: T, x2: T): FList[T] = new FCons(x1, new FCons(x2, new FNil))
  def apply[T]() = new FNil
}