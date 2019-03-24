package com.auto.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class OpenBrowser {

     //启动火狐浏览器（由于版本不兼容，导致启动火狐浏览器失败）
    @Test
    public  void  openFF(){
//        System.setProperty("webdriver.firefox.bin","D:\\Application-wlf\\IdeaProjects\\seleniumDemo1\\drivers\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin","");
        WebDriver driver= new FirefoxDriver();
    }
    //启动谷歌浏览器
    @Test
    public  void  openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\Application-wlf\\IdeaProjects\\seleniumDemo1\\drivers\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
    }
   //启动IE浏览器
    @Test
    public void openIe(){
        System.setProperty("webdriver.ie.driver","D:\\Application-wlf\\IdeaProjects\\seleniumDemo1\\drivers\\IEDriverServer.exe");
        WebDriver driver=new InternetExplorerDriver();
    }
   //启动edge浏览器
    @Test
    public void openEdge(){
        System.setProperty("webdriver.edge.driver","D:\\Application-wlf\\IdeaProjects\\seleniumDemo1\\drivers\\MicrosoftWebDriver.exe");
        WebDriver driver=new EdgeDriver();

    }


}
