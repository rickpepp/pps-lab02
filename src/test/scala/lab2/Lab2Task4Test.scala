package lab2

import org.junit.*
import org.junit.Assert.*

class Lab2Task4Test:
  private val prova = Lab2

  @Test def testEvaluateExpr(): Unit =
    assertEquals(10,
      prova.evaluate(prova.Expr.Multiply(prova.Expr.Add(prova.Expr.Literal(6), prova.Expr.Literal(-1)), prova.Expr.Literal(2))))

  @Test def testShowExpr(): Unit =
    assertEquals("((6 + -1) * 2)",
      prova.show(prova.Expr.Multiply(prova.Expr.Add(prova.Expr.Literal(6), prova.Expr.Literal(-1)), prova.Expr.Literal(2))))
