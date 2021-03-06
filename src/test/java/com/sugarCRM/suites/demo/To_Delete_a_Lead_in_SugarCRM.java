package com.sugarCRM.suites.demo;

import com.TestAutomationDemo.constants.GlobalConstants;
import com.TestAutomationDemo.keywords.Verification;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.sugarCRM.base.TestBase;
import com.sugarCRM.constatns.ProjectConstants;
import net.bytebuddy.asm.Advice;
import org.junit.Test;

/**
 * @Author Bharath Kumar Reddy V
 * @Date 25-Nov-2019
 */
public class To_Delete_a_Lead_in_SugarCRM extends TestBase {

    @Test
    public void To_Delete_a_Lead_in_SugarCRM() throws Exception {
        //Variable Declarion
        configTestData.testMethodName = "To_Delete_a_Lead_in_SugarCRM";
        testData = generic.getTestData(GlobalConstants.TEST_DATA_PATH + GlobalConstants.TEST_DATA_FILE_NAME, ProjectConstants.TEST_DATA_LEAD_INFORMATION, configTestData.testMethodName);

        if (testData.get("Execute").equalsIgnoreCase("YES")) {

            ExtentTest test;
            test = extentManager.createTest("To_Delete_a_Lead_in_SugarCRM");
            extentManager.createNode("Browser  ::  " + configTestData.testBrowser, configTestData.testMethodName, test);
            extentManager.assignGroup(configTestData.testBrowser, test);
            initPageClass();

            //Step 1
            loginPage.navigate_SugarCRMLoginPage();
            verify(loginPage.verify_SugarCRMLoginPage_isDisplayed(), "user navigates to homepage", test);

            //Step 2
            loginPage.user_Login_To_SugarCRM(testData);
            verify(homePage.tab_Leads.isDisplayed(), "User enters credentials and cliks login", test);

            //Step 3
            homePage.tab_Leads.click();
            Thread.sleep(15);
            verify(leadsPage.header_Leads.isDisplayed(), "user clicks on Leads tab. Leads Tab displayed", test);

            // Step 4
            leadsPage.user_enter_lead_fname_lname(testData.get("First_Name"), testData.get("Last_Name"));
            action("user enters lead firstname and Lastname", test);

            // Step 5
            leadsPage.user_delete_lead_information();
            action("user selects the record and delete", test);

            //Step 6

            leadsPage.user_logsout_from_application();
            Thread.sleep(2000);
            verify(Verification.verifyPageUrl(loginPage.login_URL), "user logsout from application", test);


        } else {
            configTestData.finalTestCaseStatus = Status.SKIP;
        }
    }
}
