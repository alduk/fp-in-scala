package ch3

object Exercise {

  sealed trait List[+A]

  case object Nil extends List[Nothing]
  case class Cons[+A](head: A, tail: List[A]) extends List[A]

  object List {
    def sum(ints: List[Int]): Int = ints match {
      case Nil => 0
      case Cons(x, xs) => x + sum(xs)
    }
    def product(ds: List[Double]): Double = ds match {
      case Nil => 1.0
      case Cons(0.0, _) => 0.0
      case Cons(x, xs) => x * product(xs)
    }

    def sum2(l: List[Int]) =
      foldRight(l, 0.0)(_ + _)

    def product2(l: List[Double]) =
      foldRight(l, 1.0)(_ * _)

    def sum3(l: List[Int]) =
      foldLeft(l, 0.0)(_ + _)

    def product3(l: List[Double]) =
      foldLeft(l, 1.0)(_ * _)

    def length[A](l: List[A]): Int = foldRight(l, 0)((a, b) => b + 1)
    def length2[A](l: List[A]): Int = foldLeft(l, 0)((a, b) => a + 1)

    def apply[A](as: A*): List[A] =
      if (as.isEmpty) Nil
      else Cons(as.head, apply(as.tail: _*))

    def tail[A](xs: List[A]) = xs match {
      case Nil => Nil
      case Cons(x, xs) => xs
    }

    def tail2[A](xs: List[A]) = drop(xs, 1)

    def drop[A](xs: List[A], n: Int): List[A] =
      (n, xs) match {
        case (i, _) if (i <= 0) => xs
        case (i, Nil) => Nil
        case (i, Cons(h, t)) => drop(t, i - 1)
      }

    def dropWhile[A](xs: List[A])(f: A => Boolean): List[A] =
      xs match {
        case Nil => Nil
        case Cons(h, t) if (f(h)) => dropWhile(t)(f)
        case _ => xs
      }

    def setHead[A](xs: List[A], newHead: A): List[A] = xs match {
      case Nil => Nil
      case Cons(h, t) => Cons(newHead, t)
    }

    def init[A](l: List[A]): List[A] = l match {
      case Nil => Nil
      case Cons(h, Nil) => Nil
      case Cons(h, t) => Cons(h, init(t))
    }

    def foldRight[A, B](l: List[A], z: B)(f: (A, B) => B): B =
      l match {
        case Nil => z
        case Cons(x, xs) => f(x, foldRight(xs, z)(f))
      }

    def foldLeft[A, B](l: List[A], z: B)(f: (B, A) => B): B = l match {
      case Nil => z
      case Cons(h, t) => foldLeft(t, f(z, h))(f)
    }

    def foldLeft2[A, B](l: List[A], z: B)(f: (B, A) => B): B = ??? //foldRight(l, z)((a, b) => f(b, a))

    def reverse[A](l: List[A]) = foldLeft(l, Nil: List[A])((a, b) => Cons(b, a))

    def append[A](l1: List[A], l2: List[A]) = List.reverse(foldLeft(l2, l1)((a, b) => Cons(b, a)))

    def flat[A](ll: List[List[A]]) = foldLeft(ll, Nil: List[A])((a, b) => append(List.reverse(a), b))

    def plusOne(l: List[Int]) = foldRight(l, Nil: List[Int])((b, a) => Cons(b + 1, a))
    def doubleToString(l: List[Double]) = foldRight(l, Nil: List[String])((b, a) => Cons(b.toString, a))

    def map[A, B](l: List[A])(f: A => B): List[B] =
      foldRight(l, Nil: List[B])((a, b) => Cons(f(a), b))

    def filter[A](l: List[A])(f: A => Boolean): List[A] = l match {
      case Nil => Nil
      case Cons(h, t) if (f(h)) => filter(t)(f)
      case Cons(h, t) => Cons(h, filter(t)(f))
    }

    def flatMap[A, B](l: List[A])(f: A => List[B]): List[B] = foldRight(l, Nil: List[B])((a, b) => append(f(a), b))

    def filter2[A](l: List[A])(f: A => Boolean): List[A] = flatMap(l)((a) => if (f(a)) Nil else List(a))

    def listSum(l1: List[Int], l2: List[Int]): List[Int] = (l1, l2) match {
      case (Cons(h1, t1), Cons(h2, t2)) => Cons(h1 + h2, listSum(t1, t2))
      case _ => Nil
    }

    def hasSubsequence[A](l: List[A], sub: List[A]): Boolean = ???

    val example = Cons(1, Cons(2, Cons(3, Nil)))
    val example2 = List(1, 2, 3)
    val total = sum(example)
  }

  sealed trait Tree[+A]
  case class Leaf[A](value: A) extends Tree[A]
  case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

  object Tree {
    def size[A](t: Tree[A]): Int = t match {
      case Leaf(_) => 1
      case Branch(l, r) => size(l) + size(r)
    }
    
    def size2[A](t: Tree[A]): Int = fold(t,0)((x,y)=>y+1)

    def maximum(t: Tree[Int]): Int = t match {
      case Leaf(x) => x
      case Branch(l, r) => maximum(l) max maximum(r)
    }
    
    def maximum2(t: Tree[Int]): Int = fold(t,-1)(_ max _ )

    def depth(t: Tree[Int]): Int = {
      def go(t: Tree[Int], d: Int): Int = t match {
        case Leaf(x) => d + 1
        case Branch(l, r) => go(l, d + 1) max go(r, d + 1)
      }

      go(t, 0)
    }

    def map[A, B](t: Tree[A])(f: A => B): Tree[B] = t match {
      case Leaf(x) => Leaf(f(x))
      case Branch(l, r) => Branch(map(l)(f), map(r)(f))
    }

    def fold[A, B](t: Tree[A], z: B)(f: (A, B) => B): B =
      t match {
        case Leaf(x) => f(x, z)
        case Branch(l, r) => fold(r, fold(l, z)(f))(f)
      }
  }
}