package team02.tests.US_09;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import team02.pages.HomePage;
import team02.pages.RegisterPage;
import team02.utilities.ConfigReader;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

public class TestCase_06 {
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

        //Email kutusuna gecerli bir e-mail gir
        registerPage.emailBoxYK.sendKeys("tiyeha6031@finghy.com", Keys.TAB);
        ReusableMethods.scroll(registerPage.emailBoxYK);
        ReusableMethods.bekle(5);


        //"Verification Code" kutusuna, e-posta adresine gönderilen doğrulama kodunu gir.
        registerPage.verificationCodeBoxYK.sendKeys("128471");

        //Password kutusuna geçerli bir password gir.
        // Confirm password kutusuna aynı passwordü tekrar gir.
        registerPage.passwordBoxYK.sendKeys("aA@12345",Keys.TAB,"aA@12345");

        //Password alanlarının doldurulduğunu doğrula.
        ReusableMethods.bekle(2);
        ReusableMethods.tumSayfaResmi("passwordDoldurma");

        //Sayfayı kapat.
        Driver.getDriver().close();

    }
}
