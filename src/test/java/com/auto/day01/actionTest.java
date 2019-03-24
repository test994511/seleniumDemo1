package com.auto.day01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class actionTest {
    WebDriver driver = null;


    //每一个用例执行之前打开浏览器

    @BeforeMethod
    public  void openBrowserTest(){

        //设置浏览器路径
        System.setProperty("webdriver.chrome.driver","D:\\Application-wlf\\IdeaProjects\\seleniumDemo1\\drivers\\chromedriver.exe");
        //创建浏览器对象 可以先写右边，再使用快捷键生成左边，快捷键是ctrl+alt+v
        driver = new ChromeDriver();
    }

    /**
     * 回退和前进功能
     *
     */

    @Test
    public void test1() throws InterruptedException {

        //打开百度
        driver.get("https://www.baidu.com");
        //等待3s
        Thread.sleep(3000);
        //回退
        driver.navigate().back();
        //等待3s
        Thread.sleep(3000);
        //向前进
        driver.navigate().forward();

    }
    /**
     * 浏览器刷新
     */
    @Test
    public void test2() throws InterruptedException {

        //打开百度
        driver.get("https://www.baidu.com");
        //等待3s
        Thread.sleep(3000);
        //刷新
        driver.navigate().refresh();
        //等待3s
        Thread.sleep(3000);

    }

    /**
     * 浏览器最大化
     *
     */
    @Test
    public void test3() throws InterruptedException {

        //打开百度
        driver.get("https://www.baidu.com");
        //等待3s
        Thread.sleep(3000);
        //浏览器最大化
        driver.manage().window().maximize();
        //等待3s
        Thread.sleep(3000);

    }

    /**
     * 设置浏览器大小
     *
     */
    @Test
    public void test4() throws InterruptedException {

        //打开百度
        driver.get("https://www.baidu.com");
        //等待3s
        Thread.sleep(3000);
        //浏览器最大化
        driver.manage().window().maximize();
        //等待3s
        Thread.sleep(3000);
        //设置浏览器大小
        Dimension dimension = new Dimension(900,900);
        driver.manage().window().setSize(dimension);
        //等待3s
        Thread.sleep(3000);

    }
    /**
     * 获取url
     */

    @Test
    public void test5() {

        //打开百度
        driver.get("https://www.baidu.com");
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.baidu.com/");

    }
    /**
     * 获取当前页面的标题
     */

    @Test
    public void test6() {

        //打开百度
        driver.get("https://www.baidu.com");
        String url = driver.getTitle();
        Assert.assertEquals(url,"百度一下，你就知道");

    }
    //每一个用例执行之后，关闭浏览器
    @AfterMethod
    public void closeTest(){
        //关闭浏览器
        driver.quit();

    }

}
