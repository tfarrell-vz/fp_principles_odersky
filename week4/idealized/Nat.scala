package idealized.scala

abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat
  def + (that: Nat): Nat
  def - (that: Nat): Nat
}

object Zero extends Nat {
  def isZero: Boolean = true
  def predecessor: Nat = throw new NoSuchElementException("Negative: Zero is the smallest natural number.")
  def successor: Nat = Succ(Zero)
  def + (that: Nat): Nat = that
  def - (that: Nat): if (that.isZero) this else throw new NoSuchElementException("Negative: Zero is the smallest natural number.")
}

/* Succ represents the natural number that is one bigger than the one given */
class Succ(n: Nat) extends Nat {
  def isZero: Boolean = false
  def predecessor: Nat = n
  def successor = new Succ(this)
  def + (that: Nat): Nat = new Succ(n + that) // Recurse down to n equals zero
  def - (that: Nat): Nat = if (that.isZero) this else n - that.predecessor // Recurse down to that equals zero
}

