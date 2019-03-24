package com.auto.day02;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class OperationTest {
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
     * 输入selenium,点击百度一下，跳转成功
     */
    @Test
    public  void  clickTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        WebElement ele = driver.findElement(By.id("kw"));
        ele.sendKeys("selenium");
        WebElement su = driver.findElement(By.id("su"));
        su.click();
        Thread.sleep(3000);
        String title = driver.getTitle();
        Assert.assertEquals(title,"selenium_百度搜索");
    }

    /**
     * 输入selenium,点击百度一下，清空文本框
     */
    @Test
    public  void  clickTest2() throws InterruptedException {
        driver.get("https://www.baidu.com");
        WebElement ele = driver.findElement(By.id("kw"));
        ele.sendKeys("selenium");
        Thread.sleep(3000);
        ele.clear();
        TakesScreenshot shot= (TakesScreenshot) driver;
        File file = shot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("D:\\截图\\test1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread.sleep(3000);

    }

    /**
     * 元素是否显示
     */
    @Test
    public void isDisplayed(){
        driver.get("https://www.baidu.com");
        Boolean b=driver.findElement(By.id("su")).isDisplayed();
//        System.out.println(b);
        Assert.assertTrue(b);
    }

    /**
     * 获取元素的value值
     */
     @Test
     public  void  getValueTest(){
         driver.get("https://www.baidu.com");
         String attribute = driver.findElement(By.id("su")).getAttribute("value");
         System.out.println(attribute);

     }
    //判断是否选中
    @Test
    public void getSelected() throws InterruptedException {
         driver.get("file:///C:/Users/wanglf/Desktop/goods_list.html");
        WebElement element = driver.findElement(By.xpath("/html/body/form[1]/input[1]"));
        Thread.sleep(3000);
        element.click();
        Thread.sleep(3000);
        boolean b = element.isSelected();
        Assert.assertTrue(b);
    }
    //判断是否激活
    @Test
    public void  isEnabled(){
         driver.get("file:///D:/BaiduNetdiskDownload/03-%E5%89%8D%E7%AB%AFHTML%E9%A1%B9%E7%9B%AE/MyStore/login.html");
        boolean b = driver.findElement(By.xpath("//*[@id=\"login_body\"]/div/div/div[3]/input")).isEnabled();
        Assert.assertTrue(b);
    }

    /**
     * 截图功能
     */
    @Test
    public void pictureTest(){
        driver.get("file:///D:/BaiduNetdiskDownload/03-%E5%89%8D%E7%AB%AFHTML%E9%A1%B9%E7%9B%AE/MyStore/login.html");
        TakesScreenshot shot= (TakesScreenshot) driver;
        File file = shot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("D:\\截图\\test1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //关闭浏览器
    @AfterMethod
    public void closeTest(){
        //关闭浏览器
        driver.quit();

    }

}
