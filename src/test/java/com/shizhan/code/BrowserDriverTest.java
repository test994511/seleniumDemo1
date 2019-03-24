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

public class BrowserDriverTest {

        @DataProvider(name="account")
        public  Object[][] userPwd(){

            return  new Object[][]{
                    {"chrome"},
                    {"ie"}
            };
    }
    WebDriver driver ;

    /***
     *
     * 一套脚本在不同的浏览器跑
     */
    @Test(dataProvider="account")
    public   void test(String browser) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc=null;
        if(browser.equals("chrome")){
            dc=DesiredCapabilities.chrome();
        }else if(browser.equals("ie")){
            dc=DesiredCapabilities.internetExplorer();
        }else {
            System.out.println("————————————");
        }
        driver = new RemoteWebDriver(new URL("http://192.168.1.105:4444/wd/hub"), dc);
        driver.get("https://www.baidu.com/");
        Thread.sleep(3000);
        driver.quit();




    }

}
