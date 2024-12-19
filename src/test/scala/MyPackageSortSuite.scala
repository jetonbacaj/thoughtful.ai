// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
class MyPackageSortSuite extends munit.FunSuite {
  test("Test happy path => STANDARD") {
    val obtained = sort(10, 10, 10, 12)
    val expected = "STANDARD"
    assertEquals(obtained, expected)
  }

  test("Test SPECIAL for input width=150") {
    val obtained = sort(150, 100, 10, 1)
    val expected = "SPECIAL"
    assertEquals(obtained, expected)
  }

  test("Test SPECIAL for input height=150") {
    val obtained = sort(10, 150, 10, 1)
    val expected = "SPECIAL"
    assertEquals(obtained, expected)
  }

  test("Test SPECIAL for input length=150") {
    val obtained = sort(10, 10, 150, 1)
    val expected = "SPECIAL"
    assertEquals(obtained, expected)
  }

  test("Test SPECIAL for input mass=21") {
    val obtained = sort(10, 10, 10, 21)
    val expected = "SPECIAL"
    assertEquals(obtained, expected)
  }

  test("Test REJECTED for input width=150, mass=21") {
    val obtained = sort(150, 10, 10, 21)
    val expected = "REJECTED"
    assertEquals(obtained, expected)
  }

  test("Test REJECTED for input height=150, mass=21") {
    val obtained = sort(10, 150, 10, 21)
    val expected = "REJECTED"
    assertEquals(obtained, expected)
  }

  test("Test REJECTED for input length=150, mass=21") {
    val obtained = sort(10, 10, 150, 21)
    val expected = "REJECTED"
    assertEquals(obtained, expected)
  }

  test("Test ERROR for input mass=-1".fail) {
    val obtained = sort(10, 10, 10, -1)
  }

  test("Test ERROR for input width=0".fail) {
    val obtained = sort(0, 10, 10, 1)
  }

  test("Test ERROR for input height=0".fail) {
    val obtained = sort(10, 0, 10, 1)
  }

  test("Test ERROR for input length=0".fail) {
    val obtained = sort(10, 10, 0, 1)
  }

  test("Test ERROR for input length=0".fail) {
    val obtained = sort(10, 10, 0, 1)
  }
}
