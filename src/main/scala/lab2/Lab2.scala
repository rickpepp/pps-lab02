package lab2

import lab2.Lab2.Expr.{Add, Literal}

object Lab2 extends App:
  // Task 2
  def positiveSyntax(b: Int): String = b match
    case b if b >= 0 => "positive"
    case _ => "negative"

  val positiveLiteral: (Int) => String = (n) => n match
    case n if n >= 0 => "positive"
    case _ => "negative"

  def neg(predicate: (String => Boolean)): (String => Boolean) =
    (s) => !predicate(s)

  def negGeneric[X](predicate: (X => Boolean)): (X => Boolean) =
    (x) => !predicate(x)

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
  def power(base: Double, exponent: Int): Double = exponent match
    case 0 => 1
    case _ => base * power(base, exponent - 1)

  def powerTail(base: Double, exponent: Int): Double =
    @annotation.tailrec
    def loop(actualResult: Double, exponents: Double): Double = exponents match
      case 0 => actualResult
      case _ => loop(actualResult * base, exponents - 1)
    loop(1, exponent)

  def reverseNumber(n: Int): Int =
    @annotation.tailrec
    def loop(actualResult: Int, residualDigits: Int): Int = residualDigits match
      case 0 => actualResult
      case _ => actualResult match
        case 0 => loop((residualDigits % 10), residualDigits / 10)
        case _ => loop((actualResult * 10) + (residualDigits % 10), residualDigits / 10)
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