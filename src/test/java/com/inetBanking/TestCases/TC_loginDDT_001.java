package com.inetBanking.TestCases;

import com.inetBanking.Utilities.XLUtils;
import com.inetBanking.pageObject.LoginPage;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import java.io.IOException;

public class TC_loginDDT_001 extends Baseclass {
    private static final Logger logger = Logger.getLogger(TC_loginDDT_001.class);

    @Test(dataProvider = "LoginData")
    public void loginDDT(String user, String pwd) {
        if (driver == null) {
            super.setup("chrome"); // Initialize the driver if it's not already done
        }

        LoginPage lp = new LoginPage(driver);
        lp.setUserName(user);
        logger.info("Username entered: " + user);

        lp.setPassword(pwd);
        logger.info("Password entered");

        lp.clickSubmit();
        logger.info("Submit button clicked");

        if (isAlertPresent() == true) {
            driver.switchTo().alert().accept();
            logger.warn("Login failed - Alert is present");
            driver.switchTo().defaultContent();
            Assert.assertTrue(false);
        } else {
            Assert.assertTrue(true);
            logger.info("Login successful");
            lp.clickLogout();
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
        }
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {
        String path = System.getProperty("user.dir") + "/src/test/java/com/inetBanking/Testdata/LoginData.xlsx";
        int rownum = XLUtils.getRowCount(path, "Sheet1");
        int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

        String logindata[][] = new String[rownum][colcount];

        for (int i = 1; i <= rownum; i++) {
            for (int j = 0; j < colcount; j++) {
                logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
            }
        }

        return logindata;
    }
}
