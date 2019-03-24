package com.auto.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class ActionsTest {

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
    @Test
    public void action1Test() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"su\"]"));
        Actions actions = new Actions(driver);
        //右击百度一下按钮
        actions.contextClick(element).perform();
        Thread.sleep(3000);
    }

    @Test
    public void action2Test() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"su\"]"));
        Actions actions = new Actions(driver);
        //双击百度一下按钮
        actions.doubleClick(element).perform();
        Thread.sleep(3000);
    }
    @Test
    public void  action3Test() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"u1\"]/a[8]"));
        Actions actions = new Actions(driver);
        //鼠标移动到某个元素上
        actions.moveToElement(element).perform();
        Thread.sleep(3000);
    }
    //下拉框多选
    @Test
    public void  action4Test() throws InterruptedException {
        driver.get("file:///D:/%E8%87%AA%E5%8A%A8%E5%8C%96%E5%AD%A6%E4%B9%A0/index.html");
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]"));
        List<WebElement> options = element.findElements(By.tagName("option"));
        actions.keyDown(Keys.SHIFT).click(options.get(0)).click(options.get(2)).build().perform();
        Thread.sleep(3000);
    }

    //选择下拉框中的第一个和第三个
    @Test
    public void  action5Test() throws InterruptedException {
        driver.get("file:///D:/%E8%87%AA%E5%8A%A8%E5%8C%96%E5%AD%A6%E4%B9%A0/index.html");
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]"));
        List<WebElement> options = element.findElements(By.tagName("option"));
        actions.keyDown(Keys.CONTROL).click(options.get(2)).build().perform();
        Thread.sleep(3000);
    }

    //保存百度页面
    @Test
    public void  action6Test() throws AWTException, InterruptedException {
        driver.get("https://www.baidu.com/");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(3000);
        int a =(int) new Character('S');
        robot.keyRelease(a);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(6000);
    }

    //上传文件
    @Test
    public void action7Test() throws InterruptedException {
        driver.get("file:///D:/%E8%87%AA%E5%8A%A8%E5%8C%96%E5%AD%A6%E4%B9%A0/index.html");
        driver.findElement(By.id("load")).sendKeys("C:\\Users\\wanglf\\Desktop\\新建文本文档.txt");
        Thread.sleep(3000);
    }






}
