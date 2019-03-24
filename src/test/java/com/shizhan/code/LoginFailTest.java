package com.shizhan.code;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginFailTest {
    WebDriver driver;
    @BeforeMethod
    public void openBrowser() throws MalformedURLException {
        DesiredCapabilities chromeDC = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL("http://192.168.1.105:4444/wd/hub"), chromeDC);
    }
    @DataProvider(name="account")
    public  Object[][] userPwd(){

        return  new Object[][]{
                {"2161335089@qq.com","wanglf9945"},
                {"994511531@qq.com","wanglf994511"}
        };
    }

    /**
     * QQ邮箱登录功能
     * 怎么定位隐藏的元素?
     * 错误账号登录
     */
    @Test(dataProvider = "account")
    public void loginQqTest2(String user,String pwd) throws InterruptedException {
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
