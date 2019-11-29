package com.sugarCRM.runner;

import com.TestAutomationDemo.base.ConfigBase;
import com.TestAutomationDemo.utils.DateUtils;
import com.TestAutomationDemo.utils.ExtentManager;
import com.sugarCRM.runner.suite.SingleBrowser;
import com.sugarCRM.suites.demo.To_Create_a_Lead_in_SugarCRM;
import com.sugarCRM.suites.demo.To_Delete_a_Lead_in_SugarCRM;
import com.sugarCRM.suites.demo.To_Edit_a_Lead_in_SugarCRM;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MasterTestRunner extends ConfigBase {
    public static JUnitCore runner;

    public static void main(String[] args) {
        String reportName = "Sample_JUnit" + "_[" + DateUtils.getDate() +"]_"+ DateUtils.getTime()+".html";
        System.out.println("reportName::"+reportName);
        extentManager.setExtent(reportName);

        Result result;

        result = runner.runClasses(SingleBrowser.class);
        for (Failure failure : result.getFailures()) {
            System.out.println("Fail:"+failure.toString());
        }

        extentManager.endReport();
    }
}
