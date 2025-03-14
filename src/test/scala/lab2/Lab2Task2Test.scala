package lab2

import org.junit.*
import org.junit.Assert.*

class Lab2Task2Test:
  private val prova = Lab2
  private val positiveValue = 4
  private val negativeValue = -4
  private val positiveString = "positive"
  private val negativeString = "negative"
  private val evenNumber = 22
  private val oddNumber = 21
  private val emptyString = ""
  private val nonEmptyString = "foo"

  @Test def testPositiveLiteralPositiveValue(): Unit =
    assertEquals(positiveString, prova.positiveLiteral(positiveValue))

  @Test def testPositiveLiteralNegativeValue(): Unit =
    assertEquals(negativeString, prova.positiveLiteral(negativeValue))

  @Test def testPositiveSyntaxPositiveValue(): Unit =
    assertEquals(positiveString, prova.positiveSyntax(positiveValue))

  @Test def testPositiveSyntaxNegativeValue(): Unit =
    assertEquals(negativeString, prova.positiveSyntax(negativeValue))

  @Test def testNegFunctionNotEmpty(): Unit =
    val notEmpty = createNotEmptyPredicate()
    assertTrue(notEmpty(nonEmptyString))

  @Test def testNegFunctionEmpty(): Unit =
    val notEmpty = createNotEmptyPredicate()
    assertFalse(notEmpty(emptyString))

  @Test def testNegFunctionComposite(): Unit =
    val notEmpty = createNotEmptyPredicate()
    assertTrue(notEmpty(nonEmptyString) && !notEmpty(emptyString))

  @Test def testNegFunctionGenericEvenNumberTrue(): Unit =
    val isEven = createEvenFunctionWithNegGeneric()
    assertTrue(isEven(evenNumber))

  @Test def testNegFunctionGenericEvenNumberFalse(): Unit =
    val isEven = createEvenFunctionWithNegGeneric()
    assertFalse(isEven(oddNumber))

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
    val empty: String => Boolean = _ == emptyString
    return prova.neg(empty)
