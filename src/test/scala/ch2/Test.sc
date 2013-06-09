package ch2

import ch2.Exercise._
object Test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  (0 to 10).map { ch2.Exercise.fib(_) }           //> res0: scala.collection.immutable.IndexedSeq[Int] = Vector(0, 1, 2, 3, 5, 8, 
                                                  //| 13, 21, 34, 55, 89)

  val f = (x: Int, y: Int) => x > y               //> f  : (Int, Int) => Boolean = <function2>
  isSorted(Array(1, 2, 3, 4), f)                  //> res1: Boolean = false
  isSorted(Array(), f)                            //> res2: Boolean = true
  isSorted(Array(1), f)                           //> res3: Boolean = true
  isSorted(Array(4, 3, 2, 1), f)                  //> res4: Boolean = true
  isSorted(Array(4, 3, 1, 2), f)                  //> res5: Boolean = false

  val f1 = partial1(3, f)                         //> f1  : Int => Boolean = <function1>
  f1(2)                                           //> res6: Boolean = true
  val c = curry(f)                                //> c  : Int => (Int => Boolean) = <function1>
  val u = uncurry(c)                              //> u  : (Int, Int) => Boolean = <function2>

  val x1 = (i: Int) => i + 2                      //> x1  : Int => Int = <function1>
  val x2 = (i: Int) => i * 3                      //> x2  : Int => Int = <function1>
  val x3 =compose(x1, x2)                         //> x3  : Int => Int = <function1>
  x3(2)                                           //> res7: Int = 8
  (x1 andThen x2)(2)                              //> res8: Int = 12
  (x1 compose x2)(2)                              //> res9: Int = 8
}