package com.auto.day02;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest {


    WebDriver driver;
    //每一个用例执行之前打开浏览器
    @BeforeMethod
    public  void openBrowserTest(){
        //设置浏览器路径
        System.setProperty("webdriver.chrome.driver","D:\\Application-wlf\\IdeaProjects\\seleniumDemo1\\drivers\\chromedriver.exe");
        //创建浏览器对象 可以先写右边，再使用快捷键生成左边，快捷键是ctrl+alt+v
        driver = new ChromeDriver();
    }

    /**
     * 点击alert的确定弹框
     */
    @Test
    public  void  alertTest() throws InterruptedException {
        driver.get("D:\\自动化学习\\index.html");
        driver.findElement(By.xpath("//*[@id=\"alert\"]/input")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(4000);
        //点击确定按钮
        alert.accept();
        Thread.sleep(4000);
    }

    /**
     *confirm,先点击取消，再次点击确定
     */

    @Test
    public void confirmTest() throws InterruptedException {
        driver.get("D:\\自动化学习\\index.html");
        driver.findElement(By.xpath("//*[@id=\"confirm\"]/input")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        //点击取消
        alert.dismiss();
        Thread.sleep(3000);
        //点击确定
        alert.accept();
        Thread.sleep(3000);
    }

    //点击prompt，弹出框中输入这个是myprompt,后点击确定按钮(谷歌浏览器无法输入内容，因为版本的问题)
    @Test
    public void promptTest() throws InterruptedException {
        System.setProperty("webdriver.edge.driver","D:\\Application-wlf\\IdeaProjects\\seleniumDemo1\\drivers\\MicrosoftWebDriver.exe");
        WebDriver driver=new EdgeDriver();
        driver.get("D:\\自动化学习\\index.html");
        driver.findElement(By.xpath("//*[@id=\"prompt\"]/input")).click();
        Alert promot = driver.switchTo().alert();
        Thread.sleep(3000);
        //输入框中输入内容
        promot.sendKeys("这个是mypromp");
        //点击确定按钮
        Thread.sleep(6000);
        promot.accept();
        Thread.sleep(3000);
        promot.accept();
        driver.quit();

    }

    /**
     * iframe测试
     */
    @Test
    public  void  iframeTest() throws InterruptedException {
        driver.get("D:\\自动化学习\\index.html");
        driver.switchTo().frame("aa");
        driver.findElement(By.id("user")).sendKeys("测试测试");
        Thread.sleep(3000);
    }
    /**
     * iframe测试
     */
    @Test
    public  void  iframeTest2() throws InterruptedException {
        driver.get("D:\\自动化学习\\index.html");
        //控制权交给frame
        driver.switchTo().frame("aa");
        driver.findElement(By.linkText("baidu")).click();
        Thread.sleep(3000);
        //控制权交回顶部
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[@id=\"link\"]/a")).click();
        Thread.sleep(3000);
    }

    //每一个用例执行之后，关闭浏览器
    @AfterMethod
    public void closeTest(){
        //关闭浏览器
        driver.quit();
    }

}
