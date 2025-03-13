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

  @Test def testNegFunctionGenericEvenNumberTrue(): Unit =
    val isEven = createEvenFunctionWithNegGeneric()
    assertTrue(isEven(22))

  @Test def testNegFunctionGenericEvenNumberFalse(): Unit =
    val isEven = createEvenFunctionWithNegGeneric()
    assertFalse(isEven(21))

  @Test def testCurriedFunDefTrue(): Unit =
    assertTrue(prova.curriedFunDef(3)(5)(8))

  @Test def testCurriedFunDefFalse(): Unit =
    assertFalse(prova.curriedFunDef(6)(5)(11))

  @Test def testNonCurriedFunDefTrue(): Unit =
    assertTrue(prova.nonCurriedFunDef(3, 5, 8))

  @Test def testNonCurriedFunDefFalse(): Unit =
    assertFalse(prova.nonCurriedFunDef(6, 5, 11))

  @Test def testCurriedFunValTrue(): Unit =
    assertTrue(prova.curriedFunVal(3)(5)(8))

  @Test def testCurriedFunValFalse(): Unit =
    assertFalse(prova.curriedFunVal(6)(5)(11))

  @Test def testNonCurriedFunValTrue(): Unit =
    assertTrue(prova.nonCurriedFunVal(3, 5, 8))

  @Test def testNonCurriedFunValFalse(): Unit =
    assertFalse(prova.nonCurriedFunVal(6, 5, 11))

  @Test def testComposeFunction(): Unit =
    assertEquals(9, prova.compose[Int, Int, Int](_ - 1, _ * 2)(5))

  @Test def testComposeThreeFunction(): Unit =
    assertEquals("6!", prova.composeThree[Int, Int, String, String](_ + "!", _.toString, _ * 2)(3))

  private def createEvenFunctionWithNegGeneric(): (Int => Boolean) =
    val isOdd: (Int => Boolean) = (x) => (x % 2) == 1
    return prova.negGeneric(isOdd)

  private def createNotEmptyPredicate(): (String => Boolean) =
    val empty: String => Boolean = _ == ""
    return prova.neg(empty)
