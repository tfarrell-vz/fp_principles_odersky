package week1.assignments

object PascalsTriangle {
  def pascal(c: Int, r: Int): Int = {
    if (c == 0) 1
    else if (c == r) 1
    else {
      pascal(c-1, r-1) + pascal(c, r-1)
    }
  }
}