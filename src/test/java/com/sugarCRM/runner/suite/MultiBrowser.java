package com.sugarCRM.runner.suite;


import com.TestAutomationDemo.constants.GlobalConstants;
import com.sugarCRM.suites.demo.To_Create_a_Lead_in_SugarCRM;
import com.sugarCRM.suites.demo.To_Delete_a_Lead_in_SugarCRM;
import com.sugarCRM.suites.demo.To_Edit_a_Lead_in_SugarCRM;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.io.File;

@RunWith(Suite.class)
@Suite.SuiteClasses({To_Create_a_Lead_in_SugarCRM.class, To_Delete_a_Lead_in_SugarCRM.class, To_Edit_a_Lead_in_SugarCRM.class})
public class MultiBrowser {

    public static void main(String[] args){
        String[] browsers = GlobalConstants.MULTI_BROWSER.split(",");
        for (String browser : browsers) {


        }
    }

    public void Run(){
        Thread object = new Thread(new TestScriptExecuter());
        object.start();
    }

    class TestScriptExecuter implements Runnable{
        @Override
        public void run() {
            try {

            }catch (Exception e)            {

            }

        }

    }
}
