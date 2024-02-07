package team02.tests.US_03;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import team02.pages.UserMyAccountPage;
import team02.utilities.ConfigReader;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

import javax.swing.*;

public class Us03_TestCase_01 {
    @Test
    public void TC01() {

        //  Web sitesine gidiniz
        //  Kullanici olarak giris yapiniz
        SignInMethods.signInMethods();
        //  My Account alanina tiklayiniz
        UserMyAccountPage myAccountPage=new UserMyAccountPage();myAccountPage.MyAccountButonu.click();
        ReusableMethods.bekle(5);
        //  Acilan sayfadan Adresses alanina tiklayiniz
        ReusableMethods.scroll(myAccountPage.AddressesButonu);
        ReusableMethods.bekle(3);
        myAccountPage.AddressesButonu.click();
        ReusableMethods.bekle(3);
        // EditYourBILLINGADDRESS butonuna tiklayiniz
        ReusableMethods.scroll(myAccountPage.billingEDITYOURBILLINGADDRESSButonu);
        ReusableMethods.bekle(3);
        myAccountPage.billingEDITYOURBILLINGADDRESSButonu.click();
        //  E - Mail address 'inin otomatik geldigini dogrula
         ReusableMethods.scroll(myAccountPage.billingMailAddressKutusu);
        ReusableMethods.bekle(3);

        Assert.assertEquals(myAccountPage.billingMailAddressKutusu.getAttribute("value"),ConfigReader.getProperty("eMailSo"));


    }

}
