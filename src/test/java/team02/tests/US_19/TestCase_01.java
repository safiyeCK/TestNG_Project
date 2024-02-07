package team02.tests.US_19;

import org.openqa.selenium.By;
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
        RegisterPage registerPage = new RegisterPage();
        registerPage.signInKutusu.click();
        ReusableMethods.bekle(5);

        //Username girilmeli
        registerPage.userName.sendKeys(ConfigReader.getProperty("emailRA"), Keys.TAB, ConfigReader.getProperty("passwordRA"));
        ReusableMethods.bekle(5);
        registerPage.signInLoginButton.click();
        ReusableMethods.bekle(5);


        //Arama kutusunu seçilmeli
        HomePage homePage = new HomePage();
        CartPage cartPage = new CartPage();
        ReusableMethods.bekle(2);
        cartPage.searchButtonRA.sendKeys("iPad Pro 12.9-inch",Keys.ENTER);

        //Ürune sepete ekleyebilmeli
        ReusableMethods.addToCartRA();
        ReusableMethods.bekle(2);
        ReusableMethods.scroll(homePage.addToCartButtonRA);
        ReusableMethods.bekle(2);
        homePage.addToCartButtonRA.click();
        ReusableMethods.bekle(2);
        homePage.CartButtonRA.click();
        ReusableMethods.bekle(2);

        //kullanıcı sepeti görüntüleye bilmeli
        cartPage.viewCartRA.click();
        cartPage.kuponCodRA.click();
        cartPage.enterCouponCodeRA.sendKeys(ConfigReader.getProperty("coupon01RA"));

        //9	Apply coupon butonuna tikla
        ReusableMethods.scroll(cartPage.applyCouponCodeRA);
        ReusableMethods.bekle(2);
        cartPage.applyCouponCodeRA.click();

        //10 Gecerli coupon kodu girilidigini dogrula
        // Assert.assertTrue(cartPage.thankYouRA.getText().contains("Thank you"));
        ReusableMethods.bekle(3);

        ReusableMethods.scroll(Driver.getDriver().findElement(By.xpath("//span//input")));
        ReusableMethods.bekle(1);
        cartPage.proceedToCheckoutRA.click();
        ReusableMethods.bekle(2);

        ReusableMethods.click(cartPage.placeeOrderRA);
        //Siparişin tamamlandığı doğrulanmalı
        Assert.assertTrue(cartPage.siparisTamanlandiRA.isDisplayed());

        Driver.closeDriver();





    }

}


