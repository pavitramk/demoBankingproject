package com.inetBanking.TestCases;

import com.inetBanking.pageObject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_login_001 extends Baseclass {

    @Test
    public void loginTest() {
        if (driver == null) {
            super.setup("chrome"); // Assuming "chrome" is the parameter for the browser type
        }
        driver.get(baseURL);

        LoginPage lp = new LoginPage(driver);
        logger.info("URL is opened");

        lp.setUserName(username);
        logger.info("User name entered");

        lp.setPassword(password);
        logger.info("Password entered");

        lp.clickSubmit();
        logger.info("Clicked the submit button");

        try {
            if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
                Assert.assertTrue(true);
                logger.info("Login test passed");
            } else {
                captureScreen(driver, "logintest");
                Assert.assertTrue(false);
                logger.info("Login test failed");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
