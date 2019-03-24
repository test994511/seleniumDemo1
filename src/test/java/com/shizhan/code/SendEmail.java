package com.shizhan.code;

import com.auto.day05.LoginFengZhuangTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SendEmail {

    WebDriver driver;
    //启动谷歌浏览器
    @BeforeMethod
    public  void  openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\Application-wlf\\IdeaProjects\\seleniumDemo1\\drivers\\chromedriver.exe");
        driver= new ChromeDriver();
    }
    @DataProvider(name="account")
    public  Object[][] userPwd(){

        return  new Object[][]{
                {"2161335089@qq.com","wanglf994511"}
        };
    }
    @Test(dataProvider = "account")
    public  void  sendEmail(String user,String pwd) throws InterruptedException {
        LoginFengZhuangTest.login(driver,user,pwd);
         driver.findElement(By.id("composebtn")).click();
        driver.switchTo().frame("mainFrame");
        //可能找不到发件人的输入框，故需要一定的等待时间
        Thread.sleep(3000);
         driver.findElement(By.xpath("//*[@id='toAreaCtrl']/div[2]/input")).sendKeys("994511531");
         driver.findElement(By.id("subject")).sendKeys("测试测试");
         driver.findElement(By.name("UploadFile")).sendKeys("D:\\自动化学习\\aaa.jpg");
         Thread.sleep(3000);
        WebElement eleFrame = driver.findElement(By.className("qmEditorIfrmEditArea"));
        driver.switchTo().frame(eleFrame);
         driver.findElement(By.xpath("/html/body")).sendKeys("测试测试测试测");
         //将控制权交给父元素的frame
         driver.switchTo().parentFrame();
//         Thread.sleep(3000);
         driver.findElement(By.name("sendbtn")).click();
         Thread.sleep(7000);







    }
    @AfterMethod
    public  void  close(){

        driver.quit();
    }
}
