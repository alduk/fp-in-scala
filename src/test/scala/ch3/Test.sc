package ch3

import ch3.Exercise._
object Test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val z = Nil                                     //> z  : ch3.Exercise.Nil.type = Nil
  val o = List(7)                                 //> o  : ch3.Exercise.List[Int] = Cons(7,Nil)
  val m = List(1, 2, 3, 4)                        //> m  : ch3.Exercise.List[Int] = Cons(1,Cons(2,Cons(3,Cons(4,Nil))))
  val m1 = List(1.0, 2.0, 3.0, 4.0)               //> m1  : ch3.Exercise.List[Double] = Cons(1.0,Cons(2.0,Cons(3.0,Cons(4.0,Nil)))
                                                  //| )
  List.tail(z)                                    //> res0: ch3.Exercise.List[Nothing] = Nil
  List.tail(o)                                    //> res1: ch3.Exercise.List[Int] = Nil
  List.tail(m)                                    //> res2: ch3.Exercise.List[Int] = Cons(2,Cons(3,Cons(4,Nil)))

  List.tail2(z)                                   //> res3: ch3.Exercise.List[Nothing] = Nil
  List.tail2(o)                                   //> res4: ch3.Exercise.List[Int] = Nil
  List.tail2(m)                                   //> res5: ch3.Exercise.List[Int] = Cons(2,Cons(3,Cons(4,Nil)))

  List.drop(m, 2)                                 //> res6: ch3.Exercise.List[Int] = Cons(3,Cons(4,Nil))
  List.drop(m, 10)                                //> res7: ch3.Exercise.List[Int] = Nil
  List.dropWhile(m)(_ < 4)                        //> res8: ch3.Exercise.List[Int] = Cons(4,Nil)

  List.setHead(m, 10)                             //> res9: ch3.Exercise.List[Int] = Cons(10,Cons(2,Cons(3,Cons(4,Nil))))

  List.init(m)                                    //> res10: ch3.Exercise.List[Int] = Cons(1,Cons(2,Cons(3,Nil)))
  List.init(o)                                    //> res11: ch3.Exercise.List[Int] = Nil

  List.foldRight(List(1, 2, 3), Nil: List[Int])(Cons(_, _))
                                                  //> res12: ch3.Exercise.List[Int] = Cons(1,Cons(2,Cons(3,Nil)))

  List.length(m)                                  //> res13: Int = 4
  List.length2(m)                                 //> res14: Int = 4

  List.foldLeft(m, 1)(_ + _)                      //> res15: Int = 11

  List.sum2(m)                                    //> res16: Double = 10.0
  List.sum3(m)                                    //> res17: Double = 10.0

  List.product2(m1)                               //> res18: Double = 24.0
  List.product3(m1)                               //> res19: Double = 24.0
  List.reverse(m1)                                //> res20: ch3.Exercise.List[Double] = Cons(4.0,Cons(3.0,Cons(2.0,Cons(1.0,Nil))
                                                  //| ))
  List.append(o, m)                               //> res21: ch3.Exercise.List[Int] = Cons(7,Cons(1,Cons(2,Cons(3,Cons(4,Nil)))))
  List.flat(List(m, m, o))                        //> res22: ch3.Exercise.List[Int] = Cons(1,Cons(2,Cons(3,Cons(4,Cons(1,Cons(2,Co
                                                  //| ns(3,Cons(4,Cons(7,Nil)))))))))
  val s = List("a", "b", "c")                     //> s  : ch3.Exercise.List[String] = Cons(a,Cons(b,Cons(c,Nil)))
  //List.foldLeft2(m, 1)(_ - _)
  List.foldLeft(m, 1)(_ - _)                      //> res23: Int = -9
  List.foldRight(m, 1)(_ - _)                     //> res24: Int = -1
  List.plusOne(m)                                 //> res25: ch3.Exercise.List[Int] = Cons(2,Cons(3,Cons(4,Cons(5,Nil))))
  List.doubleToString(m1)                         //> res26: ch3.Exercise.List[String] = Cons(1.0,Cons(2.0,Cons(3.0,Cons(4.0,Nil))
                                                  //| ))
  List.map(m)(_.toLong)                           //> res27: ch3.Exercise.List[Long] = Cons(1,Cons(2,Cons(3,Cons(4,Nil))))
  List.filter(m)(_ % 2 == 0)                      //> res28: ch3.Exercise.List[Int] = Cons(1,Cons(3,Nil))
  List.filter2(m)(_ % 2 == 0)                     //> res29: ch3.Exercise.List[Int] = Cons(1,Cons(3,Nil))
  List.flatMap(m)(a => List(a, a))                //> res30: ch3.Exercise.List[Int] = Cons(1,Cons(1,Cons(2,Cons(2,Cons(3,Cons(3,Co
                                                  //| ns(4,Cons(4,Nil))))))))
  List.map(m)(a => List(a, a))                    //> res31: ch3.Exercise.List[ch3.Exercise.List[Int]] = Cons(Cons(1,Cons(1,Nil)),
                                                  //| Cons(Cons(2,Cons(2,Nil)),Cons(Cons(3,Cons(3,Nil)),Cons(Cons(4,Cons(4,Nil)),N
                                                  //| il))))
  List.listSum(m, m)                              //> res32: ch3.Exercise.List[Int] = Cons(2,Cons(4,Cons(6,Cons(8,Nil))))
  List.listSum(m, o)                              //> res33: ch3.Exercise.List[Int] = Cons(8,Nil)

  val b1 = Branch(Branch(Leaf(2),Leaf(2)), Branch(Leaf(3),Leaf(3)))
                                                  //> b1  : ch3.Exercise.Branch[Int] = Branch(Branch(Leaf(2),Leaf(2)),Branch(Leaf
                                                  //| (3),Leaf(3)))
  val b2 = Branch(Leaf(1), b1)                    //> b2  : ch3.Exercise.Branch[Int] = Branch(Leaf(1),Branch(Branch(Leaf(2),Leaf(
                                                  //| 2)),Branch(Leaf(3),Leaf(3))))
  val t = Branch(Branch(b2, Leaf(4)), Leaf(5))    //> t  : ch3.Exercise.Branch[Int] = Branch(Branch(Branch(Leaf(1),Branch(Branch(
                                                  //| Leaf(2),Leaf(2)),Branch(Leaf(3),Leaf(3)))),Leaf(4)),Leaf(5))
  Tree.size(t)                                    //> res34: Int = 7
  Tree.size2(t)                                   //> res35: Int = 7
  Tree.maximum(t)                                 //> res36: Int = 5
  Tree.maximum2(t)                                //> res37: Int = 5
  Tree.depth(t)                                   //> res38: Int = 6
  Tree.map(t)(_+1)                                //> res39: ch3.Exercise.Tree[Int] = Branch(Branch(Branch(Leaf(2),Branch(Branch(
                                                  //| Leaf(3),Leaf(3)),Branch(Leaf(4),Leaf(4)))),Leaf(5)),Leaf(6))
}