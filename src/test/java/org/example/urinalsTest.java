package org.example;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class urinalsTest {

@Test
void countUrinalsTest()
 {
  Assertions.assertEquals(1, urinals.countUrinals("10001"));
  System.out.println("====== Sai Sunil Neralla == countUrinalsTest EXECUTED =======");
 }

 @Test
 void goodStringTest()
 {
  Assertions.assertEquals(true, urinals.goodString("10001"));
  System.out.println("====== Sai Sunil Neralla == goodStringTest EXECUTED =======");

 }

 @Test
 void readFileTest() throws IOException {
 File file= new File("C:\\Users\\snerall1\\Documents\\SER_515\\urinal.dat");
 String[] exp=
         {"10001", "1001", "00000", "0000", "01000", "011"};
 String expected=Arrays.toString(exp);
 String actual=Arrays.deepToString(urinals.readFile());
 Assertions.assertEquals(expected,actual);
 System.out.println("====== Sai Sunil Neralla == readFileTest EXECUTED =======");

 }

 @Test
 void writeFileTest() throws IOException {

 }


}