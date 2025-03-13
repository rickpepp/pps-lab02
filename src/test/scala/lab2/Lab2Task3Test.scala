package lab2

import org.junit.*
import org.junit.Assert.*

class Lab2Task3Test:
  private val prova = Lab2

  @Test def testPowerRecursive(): Unit =
    assertEquals((8.0, 25.0), (prova.power(2, 3), prova.power(5, 2)))

  @Test def testPowerTailRecursive(): Unit =
    assertEquals((8.0, 25.0), (prova.powerTail(2, 3), prova.powerTail(5, 2)))
