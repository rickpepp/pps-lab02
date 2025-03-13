package lab2

import org.junit.*
import org.junit.Assert.*

class Lab2Test:
  private val prova = Lab2
  private val positiveValue = 4
  private val negativeValue = -4

  @Test def testPositiveLiteralPositiveValue(): Unit =
    assertEquals("positive", prova.positiveLiteral(positiveValue))

  @Test def testPositiveLiteralNegativeValue(): Unit =
    assertEquals("negative", prova.positiveLiteral(negativeValue))

  @Test def testPositiveSyntaxPositiveValue(): Unit =
    assertEquals("positive", prova.positiveSyntax(positiveValue))

  @Test def testPositiveSyntaxNegativeValue(): Unit =
    assertEquals("negative", prova.positiveSyntax(negativeValue))

  @Test def testNegFunctionNotEmpty(): Unit =
    val notEmpty = createNotEmptyPredicate()
    assertTrue(notEmpty("foo"))

  @Test def testNegFunctionEmpty(): Unit =
    val notEmpty = createNotEmptyPredicate()
    assertFalse(notEmpty(""))

  @Test def testNegFunctionComposite(): Unit =
    val notEmpty = createNotEmptyPredicate()
    assertTrue(notEmpty("foo") && !notEmpty(""))

  @Test def testNefFunctionGenericEvenNumberTrue(): Unit =
    val isEven = createEvenFunctionWithNegGeneric()
    assertTrue(isEven(22))

  @Test def testNefFunctionGenericEvenNumberFalse(): Unit =
    val isEven = createEvenFunctionWithNegGeneric()
    assertFalse(isEven(21))

  private def createEvenFunctionWithNegGeneric(): (Int => Boolean) =
    val isOdd: (Int => Boolean) = (x) => (x % 2) == 1
    return prova.negGeneric(isOdd)

  private def createNotEmptyPredicate(): (String => Boolean) =
    val empty: String => Boolean = _ == ""
    return prova.neg(empty)
