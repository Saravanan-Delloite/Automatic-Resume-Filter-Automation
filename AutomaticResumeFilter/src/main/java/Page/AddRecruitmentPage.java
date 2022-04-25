package Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class AddRecruitmentPage
{
    static WebDriver driver;
    //syu
    public static By username_box=By.id("emailAddress");
    public static By password_box=By.id("password");
    public static By loginBtn=By.xpath("//*[contains(text(),' Login ')]");
    public static By Add_recruitment_Page_Btn=By.xpath("//*[contains(text(),'Add recruitment')]");
    public static By Recruitment_Name=By.id("inputName");
    public static By recruit_Category=By.id("inputEmail");
    public static By Skill=By.id("inputSkills");
    public static By Expert=By.id("expert");
    public static By Start_Date=By.id("inputStartDate");
    public static By End_Date=By.id("inputEndDate");
    public static By Reset_Button=By.xpath("//*[contains(text(),'Reset')]");
    public static By Upload_Resume=By.id("resumes");
    //
    public static By Add_Recruitment_Btn=By.xpath("//button[@class='btn btn-warning']");
    public static By Recruitment_Name_Warning=By.xpath("//*[contains(text(),' Recruitment name is required')]");
    public static By Category_Warning=By.xpath("//*[contains(text(),' Category is required. ')]");
    public static By Skill_Warning=By.xpath("//*[contains(text(),' Skills are required to compare with Resume skills. ')]");
    public static By Expertee_Warning=By.xpath("//*[contains(text(),' Assigning an Expert is required ')]");
    public static By Start_DateWarning=By.xpath("//*[contains(text(),' Start Date is required. ')]");
    public static By End_Date_Warning=By.xpath("//*[contains(text(),' End Date is required. ')]");
    public static By Zip_File_Warning=By.xpath("//*[contains(text(),'Reset')]");

    /*public void clickHomeBtn()

        driver.findElement(homeBtn).click();
    }*/


}
