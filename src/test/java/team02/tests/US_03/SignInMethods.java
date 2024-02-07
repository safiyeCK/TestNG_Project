package team02.tests.US_03;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import team02.pages.RegisterPage;
import team02.utilities.ConfigReader;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

public class SignInMethods  {

    public static void signInMethods(){
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        RegisterPage registerPage =new RegisterPage();

        registerPage.signInKutusu.click();
        registerPage.userName.sendKeys(ConfigReader.getProperty("eMailSo"), Keys.TAB, ConfigReader.getProperty("pswSo"));
        registerPage.signInLoginButton.click();
        ReusableMethods.bekle(3);
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);
    }

}
