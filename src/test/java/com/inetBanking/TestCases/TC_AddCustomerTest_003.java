package com.inetBanking.TestCases;

import java.io.IOException;

import com.inetBanking.pageObject.AddCustomerPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetBanking.pageObject.LoginPage;
import org.apache.log4j.Logger;

public class TC_AddCustomerTest_003 extends Baseclass {

    private static final Logger logger = Logger.getLogger(TC_AddCustomerTest_003.class);

    @Test
    public void addNewCustomer() throws IOException, InterruptedException {
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(username);
        logger.info("User name is provided");
        lp.setPassword(password);
        logger.info("Password is provided");
        lp.clickSubmit();

        Thread.sleep(3000);

        AddCustomerPage addcust = new AddCustomerPage(driver);
        addcust.clickAddNewCustomer();

        logger.info("Providing customer details...");

        addcust.custName("Pavan");
        addcust.custGender("male");
        addcust.custdob("10", "15", "1985");

        Thread.sleep(3000);

        addcust.custAddress("INDIA");
        addcust.custCity("HYD");
        addcust.custState("AP");
        addcust.custPinNo("5000074");
        addcust.custTelephoneNo("987890091");

        String email = randomestring() + "@gmail.com";
        addcust.custEmailId(email);
        addcust.custPassword("abcdef");
        addcust.custSubmit();

        Thread.sleep(3000);

        logger.info("Validation started...");

        boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

        if (res) {
            Assert.assertTrue(true);
            logger.info("Test case passed.");
        } else {
            logger.info("Test case failed.");
            captureScreen(driver, "addNewCustomer");
            Assert.assertTrue(false);
        }
    }
}
