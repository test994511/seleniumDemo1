package com.auto.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class CloseBrowser {


    @Test
    public void  closeTest() throws InterruptedException {
        //设置浏览器路径
        System.setProperty("webdriver.chrome.driver","D:\\Application-wlf\\IdeaProjects\\seleniumDemo1\\drivers\\chromedriver.exe");
        //创建浏览器对象 可以先写右边，再使用快捷键生成左边，快捷键是ctrl+alt+v
        ChromeDriver driver = new ChromeDriver();
        //打开百度
        driver.get("https://www.baidu.com");
        //等待3s
        Thread.sleep(3000);
        //关闭浏览器的当前窗口
        driver.close();
    }
    @Test
    public void  closeTest2() throws InterruptedException {
        //设置浏览器路径
        System.setProperty("webdriver.chrome.driver","D:\\Application-wlf\\IdeaProjects\\seleniumDemo1\\drivers\\chromedriver.exe");
        //创建浏览器对象 可以先写右边，再使用快捷键生成左边，快捷键是ctrl+alt+v
        ChromeDriver driver = new ChromeDriver();
        //打开百度
        driver.get("https://www.baidu.com");
        //等待3s
        Thread.sleep(3000);
        //关闭浏览器
        driver.quit();
    }

    /**
     * 关闭IE浏览器，关闭不了？
     * @throws InterruptedException
     */
    @Test
    public void  closeIETest() throws InterruptedException {
        //设置浏览器路径
        System.setProperty("webdriver.ie.driver","D:\\Application-wlf\\IdeaProjects\\seleniumDemo1\\drivers\\IEDriverServer.exe");
        //创建浏览器对象 可以先写右边，再使用快捷键生成左边，快捷键是ctrl+alt+v
        InternetExplorerDriver driver = new InternetExplorerDriver();
        //打开百度
        driver.get("https://www.baidu.com");
        //等待3s
        Thread.sleep(3000);
        //关闭浏览器
        driver.quit();
    }



}
