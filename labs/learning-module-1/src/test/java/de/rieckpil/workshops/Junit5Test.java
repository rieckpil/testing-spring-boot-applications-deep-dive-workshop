package de.rieckpil.workshops;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Junit5Test {

  public Junit5Test() {
    System.out.println("instantiated");
  }

  @BeforeAll
  static void setUpClass() {
    System.out.println("Before Junit5Test");
  }

  @AfterAll
  static void tearDownClass() {
    System.out.println("After Junit5Test");
  }

  @BeforeEach
  void setUp() {
    System.out.println("Before each");
  }

  @AfterEach
  void tearDown() {
    System.out.println("After each");
  }

  @Test
  void firstTest() {

    int result = 2 + 2;

    assertEquals(4, result);

    assertThrows(NullPointerException.class, () -> {
      Double error = null;
      int value = error.intValue();
    });
  }

  @Test
  void secondTest() {
  }

  @Test
  void thirdTest() {
  }
}
