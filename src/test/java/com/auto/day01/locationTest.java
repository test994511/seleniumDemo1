package com.auto.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class locationTest {

    WebDriver driver;
    //每一个用例执行之前打开浏览器

    @BeforeMethod
    public  void openBrowserTest(){


        //设置浏览器路径
        System.setProperty("webdriver.chrome.driver","D:\\Application-wlf\\IdeaProjects\\seleniumDemo1\\drivers\\chromedriver.exe");
        //创建浏览器对象 可以先写右边，再使用快捷键生成左边，快捷键是ctrl+alt+v
        driver = new ChromeDriver();
    }

    //通过id定位
    @Test
    public void byIDTest() {
        //打开百度
      driver.get("https://www.baidu.com");
        WebElement ele1= driver.findElement(By.id("kw"));
    }


    //通过id定位
    @Test
    public void byNameTest() {
        //打开百度
        driver.get("https://www.baidu.com");
        WebElement ele1= driver.findElement(By.name("wd"));
    }

    //通过className定位
    @Test
    public void  locationTest () {
        //打开百度
        driver.get("https://www.baidu.com");
        WebElement ele1= driver.findElement(By.className("bri"));
    }
    //a标签通过linkText
    @Test
    public  void byLinkTextTest(){
        driver.get("https://www.baidu.com");
        WebElement element = driver.findElement(By.linkText("新闻"));

    }
    //a标签通过partialLinkText
    @Test
    public  void byPartialLinkText(){
        driver.get("https://www.baidu.com");
        WebElement element = driver.findElement(By.partialLinkText("闻"));

    }
   //通过CSS选择器来定位
    @Test
    public void  byCssTest(){
        driver.get("https://www.baidu.com");
        WebElement element = driver.findElement(By.cssSelector("#lg > img.index-logo-src"));

    }
    //通过Xpath定位
    @Test
    public  void byXpath(){
        driver.get("https://www.baidu.com");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"u1\"]/a[1]"));
    }
    //通过Xpath定位多个元素
    @Test
    public  void byXpath02(){
        driver.get("https://www.baidu.com");
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"u1\"]/a"));
        for (WebElement ele:elements) {
            System.out.println(ele.getText());
        }
    }




    //每一个用例执行之后，关闭浏览器
    @AfterMethod
    public void closeTest(){
        //关闭浏览器
        driver.quit();

    }

}
