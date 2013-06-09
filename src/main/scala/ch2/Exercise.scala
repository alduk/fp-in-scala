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

  def isSorted[A](as: Array[A], gt: (A, A) => Boolean): Boolean = {
    @tailrec
    def go(as: Array[A], gt: (A, A) => Boolean, i: Int): Boolean = {
      i match {
        case x if (x >= as.length - 1) => true
        case _ => gt(as(i), as(i + 1)) && go(as, gt, i + 1)
      }
    }
    go(as, gt, 0)
  }

  def partial1[A, B, C](a: A, f: (A, B) => C): B => C = f(a, _)

  def curry[A, B, C](f: (A, B) => C): A => (B => C) = (a) => f(a, _)

  def uncurry[A, B, C](f: A => B => C): (A, B) => C = f(_)(_)

  def compose[A, B, C](f: B => C, g: A => B): A => C = (a) => f(g(a))
}