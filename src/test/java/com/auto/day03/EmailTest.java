package com.auto.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class EmailTest {

    WebDriver driver;

    //启动谷歌浏览器
    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "D:\\Application-wlf\\IdeaProjects\\seleniumDemo1\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 163自动登录功能
     */
    @Test
    public void test163Send() throws InterruptedException {
        driver.get("https://mail.163.com/");
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"loginDiv\"]/iframe"));
        driver.switchTo().frame(element);
        driver.findElement(By.name("email")).sendKeys("test994511@163.com");
        driver.findElement(By.name("password")).sendKeys("asd123456");
        driver.findElement(By.id("dologin")).click();
        Thread.sleep(3000);
    }

    /**
     * 163注册功能
     */
    @Test
    public void register() throws InterruptedException {
        driver.get("https://mail.163.com/");
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"loginDiv\"]/iframe"));
        driver.switchTo().frame(element);
        driver.findElement(By.id("changepage")).click();
        String handle = driver.getWindowHandle();
        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle)) {
                continue;
            }
            driver.switchTo().window(handles);
        }
        Thread.sleep(3000);
        driver.findElement(By.id("nameIpt")).sendKeys("test123456");
        Thread.sleep(5000);

    }
    @AfterMethod
    public  void  closeBrowser(){
        driver.quit();
    }
}




