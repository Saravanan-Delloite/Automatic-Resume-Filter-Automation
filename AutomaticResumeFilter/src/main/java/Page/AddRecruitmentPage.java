package Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class AddRecruitmentPage
{
    static WebDriver driver;
    //System.out.println("hlo");
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

    /*public static By Add_Recruitment_Btn=By.className("btn btn-warning");
    public By Recruitment_Name_Warning=By.xpath("//*[contains(text(),'Reset')]");
    public By Category_Warning=By.xpath("//*[contains(text(),'Reset')]");
    public By Skill_Warning=By.xpath("//*[contains(text(),'Reset')]");
    public By Expertee_Warning=By.xpath("//*[contains(text(),'Reset')]");
    public By Start_DateWarning=By.xpath("//*[contains(text(),'Reset')]");
    public By End_Date_Warning=By.xpath("//*[contains(text(),'Reset')]");
    public By Zip_File_Warning=By.xpath("//*[contains(text(),'Reset')]");*/

    /*public void clickHomeBtn()
    {
        driver.findElement(homeBtn).click();
    }*/


}
