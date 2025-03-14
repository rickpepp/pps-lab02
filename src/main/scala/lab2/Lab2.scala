package lab2

import lab2.Lab2.Expr.{Add, Literal}
import task5.Optionals.Optional

object Lab2 extends App:

  private val positiveString = "positive"
  private val negativeString = "negative"

  // Task 1
  private val w = 1
  println(s"The result is ${w + 1}")

  def square(d: Double): Double = d * d

  def factorial(n: Int): Int = n match
    case 0 | 1 => 1
    case _ => n * factorial(n - 1)

  def abs(n: Double): Double = n match
    case x if x >= 0 => n
    case _ => -n

  val h: (Int, Int, (Int, Int) => Int) => Int =
    (a, b, f) => f(a, b)
  println(s"Sum of 4 and 5 is ${h(4, 5, (a, b) => a + b)}")

  private enum Device:
    case PC(vendor: String, serialNumber: Double)
    case Smartphone(vendor: String, screenSize: Double)

  private def vendor(device: Device): String = device match
    case Device.PC(s, _) => s
    case Device.Smartphone(s, _) => s
  println(vendor(Device.PC("HP", 98982)))

  // Task 2
  def positiveSyntax(b: Int): String = b match
    case b if b >= 0 => positiveString
    case _ => negativeString

  val positiveLiteral: (Int) => String = (n) => n match
    case n if n >= 0 => positiveString
    case _ => negativeString

  def neg(predicate: (String => Boolean)): (String => Boolean) =
    !predicate(_)

  def negGeneric[X](p: (X => Boolean)): (X => Boolean) =
    !p(_)

  def curriedFunDef(x: Double)(y: Double)(z: Double): Boolean =
    (x <= y) && (x + y) == z

  def nonCurriedFunDef(x: Double, y: Double, z: Double): Boolean =
    (x <= y) && (x + y) == z

  val curriedFunVal: Double => Double => Double => Boolean =
    x => y => z => (x <= y) && (x + y) == z

  val nonCurriedFunVal : (Double, Double, Double) => Boolean =
    (x, y, z) => (x <= y) && (x + y) == z

  def compose[X, Y, Z](f: Y => Z, g: X => Y): X => Z =
    x => f(g(x))

  def composeThree[A, B, C, D](f: C => D, g: B => C, h: A => B): A => D =
    x => compose(compose(f, g), h)(x)

  // Task 3
  def power(base: Double, exp: Int): Double = exp match
    case 0 => 1
    case _ => base * power(base, exp - 1)

  def powerTail(base: Double, exp: Int): Double =
    @annotation.tailrec
    def loop(actualResult: Double, exp: Double): Double = exp match
      case 0 => actualResult
      case _ => loop(actualResult * base, exp - 1)
    loop(1, exp)

  def reverseNumber(n: Int): Int =
    @annotation.tailrec
    def loop(accumulated: Int, residual: Int): Int = residual match
      case 0 => accumulated
      case _ => accumulated match
        case 0 => loop((residual % 10), residual / 10)
        case _ => loop((accumulated * 10) + (residual % 10), residual / 10)
    loop(0, n)

  //Task 4
  enum Expr:
    case Literal(number: Int)
    case Add(expr1: Expr, expr2: Expr)
    case Multiply(expr1: Expr, expr2: Expr)

  def evaluate(expr: Expr): Int = expr match
    case Expr.Literal(n) => n
    case Expr.Add(n1, n2) => evaluate(n1) + evaluate(n2)
    case Expr.Multiply(n1, n2) => evaluate(n1) * evaluate(n2)

  def show(expr: Expr): String = expr match
    case Expr.Literal(n) => s"${n}"
    case Expr.Add(n1, n2) => s"(${show(n1)}" + " + " + s"${show(n2)})"
    case Expr.Multiply(n1, n2) => s"(${show(n1)}" + " * " + s"${show(n2)})"

  // Task 5
  def map[A, B](optional: Optional[A], f: A => B): Optional[B] = optional match
    case Optional.Maybe(value) => Optional.Maybe(f(value))
    case Optional.Empty() => Optional.Empty()

  def filter[A](optional: Optional[A], f: A => Boolean): Optional[A] = optional match
    case Optional.Maybe(value) => f(value) match
      case true => optional
      case _ => Optional.Empty()
    case Optional.Empty() => optional
