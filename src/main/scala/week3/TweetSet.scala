package week3.assignments

import TweetReader._

class Tweet(val user: String, val text: String, val retweets: Int) {
  override def toString: String =
    "User: " + user + "\n" +
    "Text: " + text + " [" + retweets + "]"
}

abstract class TweetSet {
  def filter(p: Tweet => Boolean): TweetSet
  def filterAcc(p: Tweet => Boolean, acc: TweetSet): TweetSet
  //def union(that: TweetSet): TweetSet
  //def mostRetweeted: Tweet
  //def descendingByRetweet: TweetList
  def contains(x: Tweet): Boolean
  def incl(x: Tweet): TweetSet
  //def remove(tweet: Tweet): TweetSet
  def foreach(f: Tweet => Unit): Unit
}

object Empty extends TweetSet {
  def filter(p: Tweet => Boolean): TweetSet = filterAcc(p, Empty)
  def filterAcc(p: Tweet => Boolean, acc: TweetSet): TweetSet = acc
  def contains(tweet: Tweet): Boolean = false
  def incl(tweet: Tweet): TweetSet = new NonEmpty(tweet, Empty, Empty)
  def isEmpty = true
  //def remove(tweet: Tweet): TweetSet = this
  def foreach(f: Tweet => Unit): Unit = ()
}

class NonEmpty(elem: Tweet, left: TweetSet, right: TweetSet) extends TweetSet {
  def filter(p: Tweet => Boolean): TweetSet = filterAcc(p, Empty)
  def filterAcc(p: Tweet => Boolean, acc: TweetSet): TweetSet = {
    val nextAcc = {
      if (p(elem)) acc.incl(elem)
      else acc
    }

    right.filterAcc(p, left.filterAcc(p, nextAcc))
  }

  def contains(x: Tweet): Boolean =
    if (x.text < elem.text) left.contains(x)
    else if (elem.text < x.text) right.contains(x)
    else true

  def incl(x: Tweet): TweetSet = {
    if (x.text < elem.text) new NonEmpty(elem, left.incl(x), right)
    else if (x.text > elem.text) new NonEmpty(elem, left, right.incl(x))
    else this
  }

  def foreach(f: Tweet => Unit): Unit = {
    f(elem)
    left.foreach(f)
    right.foreach(f)
  }

  /*def remove(tw: Tweet): TweetSet = {
    if (tw.text < elem.text) new NonEmpty(elem, left.remove(tw), right)
    else if (tw.text > elem.text) new NonEmpty(elem, left, right.remove(tw))
    else left.union(right)
  }*/
}

trait TweetList {
  def head: Tweet
  def tail: TweetList
  def isEmpty: Boolean
  def foreach(f: Tweet => Unit): Unit =
    if (!isEmpty) {
      f(head)
      tail.foreach(f)
    }
}

object Nil extends TweetList {
  def head = throw new java.util.NoSuchElementException("head of EmptyList")
  def tail = throw new java.util.NoSuchElementException("tail of EmptyList")
  def isEmpty = true
}

class Cons(val head: Tweet, val tail: TweetList) extends TweetList {
  def isEmpty = false
}

object GoogleVsApple {
  val google = List("android", "Android", "galaxy", "Galaxy", "nexus", "Nexus")
  val apple = List("ios", "iOS", "iphone", "iPhone", "ipad", "iPad")

  lazy val googleTweets: TweetSet = ???
  lazy val appleTweets: TweetSet = ???

  lazy val trending: TweetList = ???
}

object Main extends App {
  GoogleVsApple.trending foreach println
}