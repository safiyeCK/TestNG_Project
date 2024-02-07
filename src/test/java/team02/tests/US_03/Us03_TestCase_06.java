package team02.tests.US_03;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import team02.pages.RegisterPage;
import team02.pages.UserMyAccountPage;
import team02.utilities.ConfigReader;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

public class Us03_TestCase_06 {
    @Test
    public void test06() {
        // Web sitesine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        ReusableMethods.bekle(1);
        // Kullanici olarak giris yapiniz(Faker ile SignUp)
        RegisterPage registerPage=new RegisterPage();
        registerPage.register.click();
        ReusableMethods.bekle(2);
        Faker faker=new Faker();
        String name = faker.name().firstName();
        registerPage.UserNameSo.sendKeys(name);
        String fakeMail= faker.internet().emailAddress();
        registerPage.SUpYourEMail.sendKeys(fakeMail);
        String fakePass= faker.internet().password();
        registerPage.SUpYourPass.sendKeys(fakePass);
        registerPage.policyTikSo.click();
        registerPage.signUpLoginButtonSo.click();
        ReusableMethods.bekle(3);


        // My Account alanina tiklayiniz
        UserMyAccountPage myAccountPage=new UserMyAccountPage();
        ReusableMethods.scroll(myAccountPage.MyAccountButonu);
        ReusableMethods.bekle(2);
        myAccountPage.MyAccountButonu.click();
        ReusableMethods.bekle(3);
        //  Acilan sayfadan Adresses alanina tiklayiniz
        ReusableMethods.scroll(myAccountPage.AddressesButonu);
        ReusableMethods.bekle(3);
        myAccountPage.AddressesButonu.click();
        ReusableMethods.bekle(3);
        // EditYourBILLINGADDRESS butonuna tikla
        ReusableMethods.scroll(myAccountPage.billingAddButonu);
        ReusableMethods.bekle(3);
        myAccountPage.billingAddButonu.click();
        // State'de secim yapmadan save kutusuna bas
        ReusableMethods.scroll(myAccountPage.billingsaveAddressKutusu);
        ReusableMethods.bekle(3);
        myAccountPage.billingsaveAddressKutusu.click();
        ReusableMethods.bekle(3);

        // "State/Province is a required field." Uyarisini gör
        ReusableMethods.scroll(myAccountPage.billingstateDdmNegatifMesaji);
        Assert.assertEquals(myAccountPage.billingstateDdmNegatifMesaji.getText(),"State is a required field.");



    }
}
