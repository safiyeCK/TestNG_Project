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

public class TestCase_09 {
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


        //E-mail kutusu boş bırak.
        //"Verification Code" kutusu boş bırak.
        registerPage.emailBoxYK.click();
        registerPage.emailBoxYK.sendKeys(Keys.TAB,Keys.TAB);

        //Password kutusuna geçerli bir password gir.
        //Confirm password kutusuna aynı passwordü tekrar gir.
        //Register butonuna tıkla.
        registerPage.passwordBoxYK.sendKeys("aA@12345", Keys.TAB, "aA@12345",Keys.TAB,Keys.ENTER);
        ReusableMethods.bekle(3);

        //"""Email: This field is required.
        //Email Verification Code: This field is required."" mesajlarının görüldüğünü doğrula."
        WebElement emailEmptyText = registerPage.emailEmptyTextYK;
        Assert.assertTrue(emailEmptyText.isDisplayed());

        //Sayfayı kapat.
        Driver.getDriver().close();

    }
}
