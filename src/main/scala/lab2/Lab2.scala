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
