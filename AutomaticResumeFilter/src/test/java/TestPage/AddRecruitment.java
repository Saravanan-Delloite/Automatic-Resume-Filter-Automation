package TestPage;
import Page.AddRecruitmentPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Utilities.SetupDriver.getDriver;

public class AddRecruitment
{
    AddRecruitmentPage add;
    @BeforeClass
    public void setup()
    {
        add = new AddRecruitmentPage(getDriver());
    }
    @Test(priority = 1)
    public void clickAddrecuritmentbutton() throws Exception
    {
        add.initialSetup();
    }
    @Test(priority = 2)
    public void selectItem()
    {
        add.selectRecruitmentName();
    }
    @Test(priority = 3)
    public  void AssertName()
    {
        Assert.assertTrue(add.assertName());
    }
    @Test(priority = 4)
    public  void AssertCategory()
    {
        Assert.assertTrue(add.assertCategory());
    }
    @Test(priority = 5)
    public void AssertSkill()
    {
        Assert.assertTrue(add.checkSkillWarning());
    }
    @Test(priority = 6)
    public void AssertExpert()
    {
        Assert.assertTrue(add.checkExpertWarning());
    }
    @Test(priority = 7)
    public void AssertStartdate()
    {
        Assert.assertTrue(add.checkStartDateWarning());
    }
    @Test(priority = 8)
    public void AssertEnddate()
    {
        Assert.assertTrue(add.checkEndDateWarning());
    }
    @Test(priority = 10)
    public void AssertResetbtn()
    {
        Assert.assertTrue(add.checkResetBtn());
    }
    @Test(priority = 10)
    public void checkAddrecuritBtnDisabled()
    {
        Assert.assertFalse(add.checkRecuitmentBtn());
    }
    @Test(priority = 11)
    public void sendData() throws Exception {
        add.sendItems();
    }
    @Test(priority = 12)
    public void checkAddRecruitmentEnabled()
    {
        Assert.assertTrue(add.checkRecuitmentBtn());
    }
    @Test(priority = 13)
    public void clickRecruitmentBtn() throws Exception
    {
        add.clickAddRecruitmentBtn();
    }
}
