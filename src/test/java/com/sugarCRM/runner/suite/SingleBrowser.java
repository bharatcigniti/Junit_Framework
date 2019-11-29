package com.sugarCRM.runner.suite;

import com.sugarCRM.suites.demo.To_Create_a_Lead_in_SugarCRM;
import com.sugarCRM.suites.demo.To_Delete_a_Lead_in_SugarCRM;
import com.sugarCRM.suites.demo.To_Edit_a_Lead_in_SugarCRM;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({To_Create_a_Lead_in_SugarCRM.class, To_Delete_a_Lead_in_SugarCRM.class, To_Edit_a_Lead_in_SugarCRM.class})
public class SingleBrowser {
}
