package ch2

import scala.annotation.tailrec

object Exercise {
  def fib(n: Int): Int = {

    @tailrec
    def go(a: Int, b: Int, i: Int): Int = {
      i match {
        case 0 => b
        case _ => go(b, a + b, i - 1)
      }
    }
    n match {
      case 0 => 0
      case 1 => 1
      case x if (x < 0) => -1
      case _ => go(0, 1, n)
    }

  }
}