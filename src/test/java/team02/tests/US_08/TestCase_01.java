package team02.tests.US_08;

import org.testng.annotations.Test;
import team02.pages.HomePage;
import team02.utilities.ConfigReader;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

public class TestCase_01 {

    HomePage homePage = new HomePage();

    @Test
    public void test01() {
        //1) AlloverCommerce websayfasina git	"https://allovercommerce.com"
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        ReusableMethods.bekle(2);

        //2) Bir ürün seç
        ReusableMethods.scroll(homePage.urun1YK);
        ReusableMethods.bekle(2);


        //3) Kalp butonuna tıkla.
        homePage.kalpButonu1YK.click();
        ReusableMethods.bekle(2);

        //Kalp butonunun tıklandığını doğrula.
        ReusableMethods.tumSayfaResmi("kalpButonuEkranResmi");

        //Sayfayı kapat.
        Driver.getDriver().close();


    }
}
