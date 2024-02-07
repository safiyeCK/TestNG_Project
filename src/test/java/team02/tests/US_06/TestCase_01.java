package team02.tests.US_06;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import team02.pages.CartPage;
import team02.pages.HomePage;
import team02.pages.RegisterPage;
import team02.utilities.ConfigReader;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

public class TestCase_01 {
    @Test
    public void TC01() {

        //Siteye giriş yapılmalı
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        //Sign in butonuna tıklamalı
        RegisterPage registerPage =new RegisterPage();
        registerPage.signInKutusu.click();
        ReusableMethods.bekle(5);

        //Username girilmeli
        registerPage.userName.sendKeys(ConfigReader.getProperty("emailRA"),Keys.TAB,ConfigReader.getProperty("passwordRA"));
        ReusableMethods.bekle(5);
        registerPage.signInLoginButton.click();
        ReusableMethods.bekle(5);


        //Arama kutusunu seçilmeli
        HomePage homePage=new HomePage();
        CartPage cartPage=new CartPage();
        ReusableMethods.bekle(2);
        homePage.searchboxRA.sendKeys("iphone",Keys.ENTER);
        Assert.assertTrue(homePage.aramaSonucuRA.isDisplayed());

        //Ürune sepete ekleyebilmeli
        homePage.ilkUrunRA.click();
        ReusableMethods.bekle(2);
        ReusableMethods.scroll(homePage.addToCartButtonRA);
        ReusableMethods.bekle(2);
        homePage.addToCartButtonRA.click();
        ReusableMethods.bekle(2);
        homePage.CartButtonRA.click();
        ReusableMethods.bekle(2);
        cartPage.viewCartRA.click();
        Assert.assertTrue(cartPage.urunDogrulamaRA.isDisplayed());

        Driver.closeDriver();

    }
}
