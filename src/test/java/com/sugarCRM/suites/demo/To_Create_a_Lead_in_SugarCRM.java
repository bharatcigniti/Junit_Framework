package com.sugarCRM.suites.demo;

import com.TestAutomationDemo.constants.GlobalConstants;
import com.TestAutomationDemo.keywords.Verification;
import com.TestAutomationDemo.utils.Generic;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.sugarCRM.base.TestBase;
import com.sugarCRM.constatns.ProjectConstants;
import net.bytebuddy.asm.Advice;
import org.junit.Test;

/**
 * @Author Bharath Kumar Reddy V
 * @Date 22-Nov-2019
 */
public class To_Create_a_Lead_in_SugarCRM extends TestBase {

    @Test
    public void To_Create_a_Lead_in_SugarCRM() throws Exception {
       //Variable Declarion
        configTestData.testMethodName = "To_Create_a_Lead_in_SugarCRM";
        testData = generic.getTestData(GlobalConstants.TEST_DATA_PATH + GlobalConstants.TEST_DATA_FILE_NAME, ProjectConstants.TEST_DATA_LEAD_INFORMATION, configTestData.testMethodName);

        if(testData.get("Execute").equalsIgnoreCase("YES")) {
             ExtentTest test;
            test = extentManager.createTest(configTestData.testMethodName);
            extentManager.createNode("Browser  ::  " + configTestData.testBrowser, configTestData.testMethodName, test);
            extentManager.assignGroup(configTestData.testBrowser, test);
            initPageClass();

            //Step 1
            loginPage.navigate_SugarCRMLoginPage();
            verify(loginPage.verify_SugarCRMLoginPage_isDisplayed(), "user navigates to homepage", test);

            //Step 2
            loginPage.user_Login_To_SugarCRM(testData);
            verify(homePage.tab_Leads.isDisplayed(), "User enters credentials and Click on SignIn. Authunticated Page is displayed", test);

            //Step 3
            homePage.tab_Leads.click();
            Thread.sleep(15);
            verify(leadsPage.header_Leads.isDisplayed(), "user clicks on Leads tab", test);

            //Step 4
            leadsPage.user_click_on_CreateLead();
            leadsPage.user_fills_Lead_information(testData);
            action("User clicks on Crate user and Enters Lead information", test);

            //Step 5
            leadsPage.user_fills_the_address_information(testData);
            action("User fills the lead information", test);

            //Step 6
            leadsPage.user_fills_the_email_details(testData);
            action("user fills the email details", test);

            //Step 7
            leadsPage.user_clicks_on_save_button();
            action("user clicks on save button", test);

            //Step 8
            verify(leadsPage.user_verifies_the_creation_of_lead(), "user verifies the creation of lead", test);

            //Step 9
            leadsPage.user_logsout_from_application();
            Thread.sleep(2000);
            verify(Verification.verifyPageUrl(loginPage.login_URL), "user logsout from application", test);
        } else {
            configTestData.finalTestCaseStatus = Status.SKIP;
        }
    }

}
