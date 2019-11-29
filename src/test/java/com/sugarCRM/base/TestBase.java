package com.sugarCRM.base;

import com.TestAutomationDemo.base.ConfigBase;
import com.TestAutomationDemo.constants.GlobalConstants;
import com.TestAutomationDemo.keywords.Action;
import com.TestAutomationDemo.keywords.Verification;
import com.TestAutomationDemo.utils.ExcelUtils;
import com.TestAutomationDemo.utils.Generic;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.sugarCRM.pages.HomePage;
import com.sugarCRM.pages.LeadsPage;
import com.sugarCRM.pages.LoginPage;

import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @Author Bharath Kumar Reddy V
 * @Date 21-Nov-2019
 */
public class TestBase extends ConfigBase {
    // Variable declarions
    public Action action;
    public Verification verification;
    public ExcelUtils excelUtils;


    public LoginPage loginPage;
    public HomePage homePage;
    public LeadsPage leadsPage;

    public HashMap<String,String> testData;
//    public static HashMap<String,String> addressInfo;
//    public static HashMap<String,String> emailInfo;


    public void initPageClass(){
        action = new Action(configTestData);
        verification = new Verification(configTestData);
        excelUtils =new ExcelUtils();

        homePage = new HomePage(configTestData);
        loginPage=new LoginPage(configTestData);
        leadsPage = new LeadsPage(configTestData);
    }




    public void action(String msg, ExtentTest test){
        extentManager.addstep(Status.INFO,msg,test);
    }

    public void verify(boolean condition, String msg, ExtentTest test){
        if(condition){
            extentManager.addstep(Status.PASS,msg,test);
        } else{
            extentManager.addstep(Status.FAIL,msg,test);
            configTestData.finalTestCaseStatus = Status.FAIL;
        }
    }

}
