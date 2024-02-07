package team02.tests.US_08;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import team02.pages.HomePage;
import team02.pages.WishlistPage;
import team02.utilities.ConfigReader;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

public class TestCase_03 {
    HomePage homePage = new HomePage();
    WishlistPage wishlistPage = new WishlistPage();


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

        //Başka bir  ürün seç
        homePage.aramaButonuYK.sendKeys("Automatic Crusher", Keys.ENTER);
        ReusableMethods.bekle(2);
        ReusableMethods.scroll(homePage.kalpButonu1YK);
        ReusableMethods.bekle(2);

        //Kalp butonuna tıkla.
        homePage.kalpButonu1YK.click();
        ReusableMethods.bekle(2);

        //Wishlist butonuna tıkla.
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        homePage.wishlistButonuYK.click();
        ReusableMethods.bekle(5);

        //QUICK VIEW butonuna tıkla.
        ReusableMethods.scroll(wishlistPage.addToCartButonu1YK);
        ReusableMethods.bekle(2);
        wishlistPage.quickViewButonu1YK.click();
        ReusableMethods.bekle(2);

        //QUICK VIEW penceresi görüntülendiğini doğrula.
       String quickViewPenceresi = wishlistPage.quickViewUrun1YK.getText();
        Assert.assertEquals(quickViewPenceresi,"Automatic Crusher");

        //Sayfayı kapat.
        Driver.getDriver().close();

    }
}
