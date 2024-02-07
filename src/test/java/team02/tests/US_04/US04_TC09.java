package team02.tests.US_04;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import team02.pages.RegisterPage;
import team02.pages.UserMyAccountPage;
import team02.utilities.ConfigReader;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

public class US04_TC09 {
    @Test
    public void test09() {
        // Web sitesine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        ReusableMethods.bekle(1);
        // Kullanici olarak giris yapiniz(Faker ile SignUp)
        RegisterPage registerPage = new RegisterPage();
        registerPage.register.click();
        ReusableMethods.bekle(2);
        Faker faker = new Faker();
        String name = faker.name().firstName();
        registerPage.UserNameSo.sendKeys(name);
        String fakeMail = faker.internet().emailAddress();
        registerPage.SUpYourEMail.sendKeys(fakeMail);
        String fakePass = faker.internet().password();
        registerPage.SUpYourPass.sendKeys(fakePass);
        registerPage.policyTikSo.click();
        registerPage.signUpLoginButtonSo.click();
        ReusableMethods.bekle(3);


        // My Account alanina tiklayiniz
        UserMyAccountPage myAccountPage = new UserMyAccountPage();
        ReusableMethods.scroll(myAccountPage.MyAccountButonu);
        ReusableMethods.bekle(2);
        myAccountPage.MyAccountButonu.click();
        ReusableMethods.bekle(3);
        //Adresses butonuna tikla
        ReusableMethods.scroll(myAccountPage.AddressesButonu);
        ReusableMethods.bekle(3);
        myAccountPage.AddressesButonu.click();
        ReusableMethods.bekle(3);
        // Add butonuna tikla
        ReusableMethods.scroll(myAccountPage.shippingAddButonu);
        ReusableMethods.bekle(3);
        myAccountPage.shippingAddButonu.click();
        // State secimi yapmadan save kutusuna bas
        ReusableMethods.scroll(myAccountPage.shippingSaveAddressKutusu);
        ReusableMethods.bekle(3);
        myAccountPage.shippingSaveAddressKutusu.click();
        ReusableMethods.bekle(3);

        // "State is a required field." Uyarisini gör
        ReusableMethods.scroll(myAccountPage.shippingStateDdmNegatifMesajKutusu);
        Assert.assertEquals(myAccountPage.shippingStateDdmNegatifMesajKutusu.getText(), "State is a required field.");


    }
    }
