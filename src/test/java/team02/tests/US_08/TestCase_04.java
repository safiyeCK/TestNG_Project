package team02.tests.US_08;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import team02.pages.CartPage;
import team02.pages.HomePage;
import team02.pages.WishlistPage;
import team02.utilities.ConfigReader;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

public class TestCase_04 {
    HomePage homePage = new HomePage();
    WishlistPage wishlistPage = new WishlistPage();
    CartPage cartPage = new CartPage();

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

        //ADD TO CART butonuna tıkla.
        ReusableMethods.scroll(wishlistPage.addToCartButonu1YK);
        ReusableMethods.bekle(2);
        wishlistPage.addToCartButonu1YK.click();

        //Ürünün sepete eklendiğini doğrula.
        //"VIEW CART " butonu  görülmeli.
        Assert.assertTrue(wishlistPage.viewCartButonu1YK.isDisplayed());

        //CART butonuna tıkla.
        wishlistPage.cartButonu1YK.click();

        //CHECKOUT butonuna tıkla.
        wishlistPage.checkoutButonu1YK.click();
        ReusableMethods.bekle(2);

        //BILLING DETAILS (First Name,Last Name,Country / Region ,Street address ,Postcode / ZIP,Town / City,Phone ,Email address) alanlarını doldur.
        cartPage.firstNameBoxYK.sendKeys("Ali",Keys.TAB,"Cabbar",Keys.TAB,Keys.TAB,"Turkey",Keys.TAB,
                Keys.TAB, "Mecidiye",Keys.TAB,Keys.TAB,"34000"
                ,Keys.TAB,"Sarıyer",Keys.TAB);
        cartPage.provinceBoxYK.sendKeys("İstanbul",Keys.ENTER);
        ReusableMethods.bekle(2);
        cartPage.telBoxYK.sendKeys("05559991111",Keys.TAB,"alicabbar@gmail.com");

        //PLACE ORDER butonuna tıkla.
        cartPage.placeOrderButonuYK.click();
        ReusableMethods.bekle(2);
        //Ürün satın alındığını doğrula.
        //"Thank you. Your order has been received." mesajı görülmeli.
        WebElement orderText = cartPage.orderTextYK;
        Assert.assertTrue(orderText.isDisplayed());

        //Sayfayı kapat.
        Driver.getDriver().close();

    }
}
