package team02.tests.US_06;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import team02.pages.CartPage;
import team02.pages.HomePage;
import team02.pages.RegisterPage;
import team02.utilities.ConfigReader;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

import java.io.File;
import java.io.IOException;

public class TestCase_04 {

    @Test
    public void TC_04() throws IOException {
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
        homePage.ilkUrunRA.click();
        ReusableMethods.bekle(5);
        ReusableMethods.click(homePage.addToCartButtonRA);
        ReusableMethods.bekle(5);
        homePage.CartButtonRA.click();
        cartPage.viewCartRA.click();
        Assert.assertTrue(cartPage.urunDogrulamaRA.isDisplayed());

        //Çıkışa doğru devam et butonuna tıklayabilmeli
        cartPage.proceedtoCheckoutButtonRA.click();


        //Fatura bilgilerinin ekran görüntüsü alınmalı
        ReusableMethods.tumSayfaResmi("fatura_Bilgileri_RE");


        //Ödeme seçenekleri görülebilmeli
        ReusableMethods.tumSayfaResmi("Odeme_Secenekleri_Gorulmeli");

        //Ödeme seçeneklerinden seçim yapılabilmeli
        cartPage.odemeSecenegiSecmeRA.isSelected();



        //Sipariş ver butonuna tıklayabilmeli
        ReusableMethods.click(cartPage.placeeOrderRA);
        //Siparişin tamamlandığı doğrulanmalı
        Assert.assertTrue(cartPage.siparisTamanlandiRA.isDisplayed());


        Driver.closeDriver();
    }


}
