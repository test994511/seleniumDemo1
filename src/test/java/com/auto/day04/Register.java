package com.auto.day04;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Register {
    WebDriver driver;

    //启动谷歌浏览器
    @BeforeMethod
    public  void  openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\Application-wlf\\IdeaProjects\\seleniumDemo1\\drivers\\chromedriver.exe");
        driver= new ChromeDriver();
    }



    @AfterMethod
    public  void  close(){
        driver.quit();
    }
}
