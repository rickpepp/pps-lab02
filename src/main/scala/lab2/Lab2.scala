package lab2

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