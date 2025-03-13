package lab2

object Lab2 extends App:
  // Task 2
  // a
  val positive: (Int) => String = (n) => n match
      case n if n >= 0 => "positive"
      case _ => "negative"

  val positiveNumber = 4
  val negativeNumber = -7

  println(s"${positiveNumber} is a ${positive(positiveNumber)} number")
  println(s"${negativeNumber} is a ${positive(negativeNumber)} number")

  
