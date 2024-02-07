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

public class TestCase_02 {
    @Test
    public void TC02() {
        //Siteye giriş yapılmalı
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        //Sign in butonuna tıklamalı
        RegisterPage registerPage =new RegisterPage();
        registerPage.signInKutusu.click();
        ReusableMethods.bekle(5);

        //Username girilmeli
        registerPage.userName.sendKeys(ConfigReader.getProperty("emailRA"), Keys.TAB,ConfigReader.getProperty("passwordRA"));
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
        ReusableMethods.click(homePage.ilkUrunRA);
        ReusableMethods.bekle(2);
        ReusableMethods.click(homePage.addToCartButtonRA);
        ReusableMethods.bekle(2);
        homePage.CartButtonRA.click();
        cartPage.viewCartRA.click();
        Assert.assertTrue(cartPage.urunDogrulamaRA.isDisplayed());

        //Miktar butonundan ürün artırılabilmeli
        cartPage.urunArttirmaRA.click();
        ReusableMethods.bekle(2);
        cartPage.upDateCartRA.click();
        ReusableMethods.bekle(2);


        Driver.closeDriver();

    }
}
