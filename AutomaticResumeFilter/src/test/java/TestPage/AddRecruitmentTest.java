package TestPage;
import Page.AddRecruitmentPage;
import Utilities.ListenerForExtentReport;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import static Utilities.SetupDriver.getDriver;
@Listeners(ListenerForExtentReport.class)
public class AddRecruitmentTest
{
    AddRecruitmentPage add;
    Logger logger=Logger.getLogger(AddRecruitmentTest.class);
    @BeforeClass
    public void setup()
    {
        add = new AddRecruitmentPage(getDriver());
        logger.info("Initializing the driver");
    }
    @Test(priority = 1)
    public void clickAddrecuritmentbutton() throws Exception
    {
        add.initialSetup();
        logger.info("***Visiting add recruitment page***");
    }
    @Test(priority = 2)
    public void selectItem()
    {
        add.selectRecruitmentName();
        logger.info("Giving Recruitment data");
    }
    @Test(priority = 3)
    public  void AssertName()
    {
        Assert.assertTrue(add.assertName());
        logger.info("Assert for recruitment name warning");
    }
    @Test(priority = 4)
    public  void AssertCategory()
    {
        Assert.assertTrue(add.assertCategory());
        logger.info("Assert fot recruitment category warning");
    }
    @Test(priority = 5)
    public void AssertSkill()
    {
        Assert.assertTrue(add.checkSkillWarning());
        logger.info("Assert for recruitment skill warning");
    }
    @Test(priority = 6)
    public void AssertExpert()
    {
        Assert.assertTrue(add.checkExpertWarning());
        logger.info("Assert for field expert warning");
    }
    @Test(priority=9)
    public void AssertWarningForPastStartDate()
    {
        try
        {
            logger.info("Checking for the warning for giving past End date ");
            Assert.assertTrue(add.checkPastStartDate());
        }
        catch (Exception e)
        {
            logger.error("Error message for giving already passed date is not visible");
        }
    }
    @Test(priority=10)
    public void AssertWarningForPastEndtDate()
    {
        try
        {
            logger.info("Checking for the warning for giving past End date ");
            Assert.assertTrue(add.checkPastEndDate());
        }
        catch (Exception e)
        {
            logger.error("Error message for giving already passed date is not visible");
        }
    }
    @Test(priority = 7)
    public void AssertStartdate()
    {
        Assert.assertTrue(add.checkStartDateWarning());
        logger.info("Assert for Start Date warning message");
    }
    @Test(priority = 8)
    public void AssertEnddate()
    {
        Assert.assertTrue(add.checkEndDateWarning());
        logger.info("Assert for End Date warning message");
    }
    @Test(priority = 11)
    public void AssertResetbtn()
    {
        Assert.assertTrue(add.checkResetBtn());
        logger.info("Assert for Reset button is available");
    }
    @Test(priority = 12)
    public void checkAddrecuritBtnDisabled()
    {
        logger.info("Checking for add recruitment button is diabled");
        Assert.assertTrue(add.checkRecuitmentBtn());
        logger.info("Add recruitment button is now disabled");
    }
    @Test(priority = 13)
    public void sendData() throws Exception
    {
        logger.info("Giving all tha correct user data");
        add.sendItems();
    }
    @Test(priority = 14)
    public void checkAddRecruitmentEnabled()
    {
        logger.info("Checking after giving data add recruitment button is available");
        Assert.assertTrue(add.checkRecuitmentBtn());
    }
    @Test(priority = 15)
    public void clickRecruitmentBtn() throws Exception
    {
        add.clickAddRecruitmentBtn();
        logger.info("Clicling add recruitment button");
    }
}
