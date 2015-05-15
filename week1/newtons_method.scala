object Newton {
  def sqr_nm(num: Double):Double = {
    def loop(est: Double, count: Int): Double  = {
      val quotient = num / est
      val mean = { (quotient + est) / 2.0 }
      if (count == 0) mean
      else {
        loop(mean, count - 1)
      }
    }
    loop(1.0, 5)
  }
}


// vim: set ts=2 sw=2 et sts=2:
