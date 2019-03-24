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

public class LoginSuccessDriverTest {

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
    @DataProvider(name="account")
    public  Object[][] userPwd(){

        return  new Object[][]{
                {"2161335089@qq.com","wanglf994511"},
                {"2161335089@qq.com","wanglf994511"}
        };
    }
  
    /**
     * QQ邮箱登录功能
     * 怎么定位隐藏的元素?
     * 正确账号登录
     */
    @Test(dataProvider="account")
    public static  void loginQqTest(String user,String pwd) throws InterruptedException {
        driver.get("https://mail.qq.com/cgi-bin/loginpage");
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("document.getElementById(\"login\")[0].style.display='visible'");
        WebElement login_frame = driver.findElement(By.id("login_frame"));
        driver.switchTo().frame(login_frame);
        //注意顺序，账号密码登录在frame内部，需要先转交控制权，再点击账号密码登录按钮
        driver.findElement(By.id("switcher_plogin")).click();
        driver.findElement(By.id("u")).sendKeys(user);
        driver.findElement(By.id("p")).sendKeys(pwd);
        driver.findElement(By.id("login_button")).click();
        Thread.sleep(3000);
        String composebtn = driver.findElement(By.id("composebtn")).getText();
        System.out.println(composebtn);
        Assert.assertEquals(composebtn,"写信");
    }

    @AfterMethod
    public  void  close(){
        driver.quit();
    }
}
