package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.SignInPage;
import pageObjects.MyAvantiPage;
import testBase.BaseClass;
import utilities.ScreenRecorderUtils;

public class TC_002_LoginTest extends BaseClass{
    @Test(groups= { "Master", "Sanity", "Regression"})
    public void test_Login()
    {
        ScreenRecorderUtils.startRecord("test_Login");
        logger.info("***  Starting TC_002_LoginTest  ***");

        try
        {
            SignInPage lp=new SignInPage(driver);
            logger.info("Providing login details");

            lp.setTxtUserName(rb.getString("email")); // valid email, get it from properties file
            Thread.sleep(2000);

            lp.setTxtPassword(rb.getString("password")); // valid password, get it from properties file
            Thread.sleep(2000);

            lp.clickSignIn();
            logger.info("Clicked on Login button");

            MyAvantiPage macc=new MyAvantiPage(driver);

            boolean targetpage=macc.isMyAvantiPageExists();

            Assert.assertTrue(targetpage, "Valid Login Data");

        }
        catch(Exception e)
        {
            logger.error("Test Failed");
            Assert.fail();
        }
        logger.info("***  Finished TC_002_LoginTest  ***");
        ScreenRecorderUtils.stopRecord();
    }
}
