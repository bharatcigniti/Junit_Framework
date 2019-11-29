package com.TestAutomationDemo.base;

import com.TestAutomationDemo.driver.DriverConfig;
import com.TestAutomationDemo.utils.*;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * @Author Bharath Kumar Reddy V
 * @Date 21-Nov-2019
 */

public class ConfigBase {
    public ConfigTestData configTestData=new ConfigTestData();
    public static ExtentManager extentManager=new ExtentManager();
    public Generic generic;
    public ScreenshotGenarator screenshotGenarator;
    public ThreadLocal<RemoteWebDriver> remoteWebDriver = null;

    public static ResourceBundle rbTestdata;
    HashMap<String, String> enviornmentHashmap;

    @Before
    public void setUP(){
        try {
            generic = new Generic(configTestData);
            generic.readConfigProp();



//            configTestData.testMethodName = testMethod.getName();
            remoteWebDriver = new ThreadLocal<>();
            DriverConfig driverConfig = new DriverConfig(configTestData);
            remoteWebDriver.set(driverConfig.getDriver());

            configTestData.driver = remoteWebDriver.get();
            configTestData.groupName = configTestData.testBrowser;
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        try{
            configTestData.driver.quit();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
