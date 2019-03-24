package com.auto.day01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertTest {

     @Test
    public void  equalsTest1(){

         String a="111";
        String b="222";
         Assert.assertEquals(a,b,"a=b");
    }
    @Test
    public  void  notEqualsTest(){
        String a="111";
        String b="222";
        Assert.assertNotEquals(a,b);
    }

    @Test
    public void  nullTest(){
         String a="";
         Assert.assertNotNull(a);


    }
    @Test
    public void  notNullTest(){
        String a="";
        Assert.assertNull(a);
    }
     @Test
    public  void   loginTest(){
         boolean a=false;
         Assert.assertTrue(a);
     }

    @Test
    public  void   loginTest2(){
        boolean a=false;
        Assert.assertFalse(a);
    }
}
