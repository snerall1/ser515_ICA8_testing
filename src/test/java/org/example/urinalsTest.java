package org.example;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

public class urinalsTest {

@Test
void countUrinalsTest()
 {
  Assertions.assertEquals(1, urinals.countUrinals("10001"));
  System.out.println("====== Sai Sunil Neralla == TEST ONE EXECUTED =======");
 }

 @Test
 void goodStringTest()
 {
  Assertions.assertEquals(true, urinals.goodString("10001"));
  System.out.println("====== Sai Sunil Neralla == TEST TWO EXECUTED =======");

 }

}