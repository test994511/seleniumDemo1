package com.auto.day03;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class GridTest {
    WebDriver driver;

    @BeforeMethod
    public void  openBrowser() throws MalformedURLException {
        DesiredCapabilities chromeDC = DesiredCapabilities.chrome();
        //指定node节点运行,目前配置有2个节点，分别是5555和6666
//        driver = new RemoteWebDriver(new URL("http://192.168.1.105:5555/wd/hub"),chromeDC);
//        driver = new RemoteWebDriver(new URL("http://192.168.1.105:6666/wd/hub"),chromeDC);
        //使用hub自动分发到node节点，4444为hub端口号
        driver = new RemoteWebDriver(new URL("http://192.168.1.105:4444/wd/hub"),chromeDC);
    }
    @Test
    public  void gridTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        Thread.sleep(10000);
    }


    @AfterMethod
    public  void  closeBrowser(){
        driver.quit();
    }


}
