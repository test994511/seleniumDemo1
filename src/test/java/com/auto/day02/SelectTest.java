package com.auto.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectTest {

    WebDriver driver;
    //每一个用例执行之前打开浏览器
    @BeforeMethod
    public  void openBrowserTest(){
        //设置浏览器路径
        System.setProperty("webdriver.chrome.driver","D:\\Application-wlf\\IdeaProjects\\seleniumDemo1\\drivers\\chromedriver.exe");
        //创建浏览器对象 可以先写右边，再使用快捷键生成左边，快捷键是ctrl+alt+v
        driver = new ChromeDriver();
    }
    //关闭浏览器
    @AfterMethod
    public void closeTest(){
        //关闭浏览器
        driver.quit();
    }

    /**
     * 下拉框
     */
   @Test
    public  void  selectTest() throws InterruptedException {
       driver.get("D:\\自动化学习\\index.html");
       WebElement element = driver.findElement(By.xpath("//*[@id=\"moreSelect\"]"));
       Select select = new Select(element);
       Thread.sleep(3000);
       select.selectByIndex(1);
       Thread.sleep(3000);
       select.selectByValue("huawei");
       Thread.sleep(3000);
       select.selectByVisibleText("xiaomi");
       Thread.sleep(3000);
   }
    /**
     * 多窗口处理
     */
    @Test
    public  void  windowsTest() throws InterruptedException {
        driver.get("D:\\自动化学习\\index.html");
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"open\"]/a"));
        element.click();
        Thread.sleep(3000);
        String handle = driver.getWindowHandle();
        for (String handles:driver.getWindowHandles()) {
            if(handles.equals(handle)){
                continue;
            }else{
                driver.switchTo().window(handles);
            }
        }
        driver.findElement(By.xpath("//*[@id=\"link\"]/a")).click();
        Thread.sleep(3000);
        driver.switchTo().window(handle);
        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"moreSelect\"]"));
        Select select = new Select(element1);
        Thread.sleep(3000);
        select.selectByIndex(1);
        Thread.sleep(3000);
    }
    /**
     *元素等待的方式
     *
     */
    @Test
    public void  waitTest() throws InterruptedException {
        driver.get("D:\\自动化学习\\index.html");
        driver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();
        WebDriverWait webDriverWait = new WebDriverWait(driver,30);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"display\"]/div")));
        String text = driver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
        Assert.assertEquals(text,"wait for display");
        Thread.sleep(3000);
    }
}
