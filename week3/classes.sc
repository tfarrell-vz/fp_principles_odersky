abstract class IntSet {
  def add(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

class Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def add(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
  def union(other: IntSet): IntSet = other
  override def toString = "."
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true // x == elem

  def add(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left add x, right)
    else if (x > elem) new NonEmpty(elem, left, right add x)
    else this

  def union(other: IntSet): IntSet =
    ((left union right) union other) add elem

  override def toString = "{" + left + elem + right + "}"
}

object intsets {
  val t1 = new NonEmpty(7, new Empty, new Empty)
  val t2 = t1.add(8)
  val t3 = t2.add(3).add(5).add(12)
}

intsets.t2.contains(8)
intsets.t2
intsets.t3
