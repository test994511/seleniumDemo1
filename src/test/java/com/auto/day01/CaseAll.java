package com.auto.day01;

import org.testng.annotations.*;

public class CaseAll {

    @BeforeTest
    public  void beforeTest(){
        System.out.println("BeforeTest");
    }
    @BeforeMethod
    public  void beforeMethod(){
        System.out.println("BeforeMethod");
    }

    @Test
    public  void  case1() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("case1");
    }
    @Test
    public  void  case2() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("case2");
    }

    @AfterTest
    public  void afterTest(){
        System.out.println("AfterTest");
    }
    @AfterMethod
    public  void afterMethod(){
        System.out.println("AfterMethod");
    }
}


