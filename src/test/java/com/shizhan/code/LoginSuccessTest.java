package com.shizhan.code;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginSuccessTest {

    public static  WebDriver driver;

    @BeforeMethod
    public void openBrowser() throws MalformedURLException {
        DesiredCapabilities chromeDC = DesiredCapabilities.chrome();
        //指定node节点运行,目前配置有2个节点，分别是5555和6666
//        driver = new RemoteWebDriver(new URL("http://192.168.1.105:5555/wd/hub"),chromeDC);
        //使用hub自动分发到node节点，4444为hub端口号
//        driver = new RemoteWebDriver(new URL("http://192.168.1.105:4444/wd/hub"),chromeDC);
        driver = new RemoteWebDriver(new URL("http://192.168.1.105:4444/wd/hub"), chromeDC);
    }


    /**
     * QQ邮箱登录功能
     * 怎么定位隐藏的元素?
     * 正确账号登录
     */
    @Test
    public static  void loginQqTest() throws InterruptedException {
        driver.get("https://mail.qq.com/cgi-bin/loginpage");
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("document.getElementById(\"login\")[0].style.display='visible'");
        WebElement login_frame = driver.findElement(By.id("login_frame"));
        driver.switchTo().frame(login_frame);
        //注意顺序，账号密码登录在frame内部，需要先转交控制权，再点击账号密码登录按钮
        driver.findElement(By.id("switcher_plogin")).click();
        driver.findElement(By.id("u")).sendKeys("2161335089@qq.com");
        driver.findElement(By.id("p")).sendKeys("wanglf994511");
        driver.findElement(By.id("login_button")).click();
        Thread.sleep(3000);
        String composebtn = driver.findElement(By.id("composebtn")).getText();
        System.out.println(composebtn);
        Assert.assertEquals(composebtn,"写信");
    }

    /**
     * QQ邮箱登录功能
     * 怎么定位隐藏的元素?
     * 错误账号登录
     */
    @Test
    public void loginQqTest2() throws InterruptedException {
        driver.get("https://mail.qq.com/cgi-bin/loginpage");
        WebElement login_frame = driver.findElement(By.id("login_frame"));
        driver.switchTo().frame(login_frame);
        //注意顺序，账号密码登录在frame内部，需要先转交控制权，再点击账号密码登录按钮
        driver.findElement(By.id("switcher_plogin")).click();
        driver.findElement(By.id("u")).sendKeys("2161335089@qq.com");
        driver.findElement(By.id("p")).sendKeys("wanglf9945");
        driver.findElement(By.id("login_button")).click();
        Thread.sleep(3000);
        String err_m = driver.findElement(By.id("err_m")).getText();
        System.out.println(err_m);
        Assert.assertEquals(err_m,"你输入的帐号或密码不正确，请重新输入。");
    }


    @AfterMethod
    public  void  close(){
        driver.quit();
    }
}
