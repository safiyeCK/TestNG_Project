package team02.tests.US_09;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import team02.pages.HomePage;
import team02.pages.RegisterPage;
import team02.utilities.ConfigReader;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

public class TestCase_10 {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test
    public void test01() {
        //1) AlloverCommerce websayfasina git	"https://allovercommerce.com"
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        ReusableMethods.bekle(2);

        //Register butonuna tıkla.
        homePage.registerButtonYK.click();

        //SIGN UP sekmesinde ''Become a Vendor '' butonuna tıkla.
        homePage.becomeAVendorButtonYK.click();
        ReusableMethods.bekle(2);

        //Email kutusuna geçersiz bir e-mail gir
        registerPage.emailBoxYK.sendKeys("siwive6385armablog.com", Keys.TAB);
        ReusableMethods.bekle(2);

        //"Please provide a valid email address." mesajının görüldüğünü doğrula.
        WebElement emailFalseText = registerPage.emailFalseTextYK;
        Assert.assertTrue(emailFalseText.isDisplayed());

        //Sayfayı kapat.
        Driver.getDriver().close();
    }
}
