package team02.tests.US_03;

import org.testng.Assert;
import org.testng.annotations.Test;
import team02.pages.UserMyAccountPage;
import team02.utilities.ReusableMethods;

public class Us03_TestCase_08 {
    @Test
    public void test07() {
        // Web sitesine gidiniz
        // Kullanici olarak giris yapiniz
        SignInMethods.signInMethods();
        // My Account alanina tiklayiniz
        UserMyAccountPage myAccountPage=new UserMyAccountPage();myAccountPage.MyAccountButonu.click();
        ReusableMethods.bekle(5);
        //  Acilan sayfadan Adresses alanina tiklayiniz
        ReusableMethods.scroll(myAccountPage.AddressesButonu);
        ReusableMethods.bekle(3);
        myAccountPage.AddressesButonu.click();
        ReusableMethods.bekle(3);
        // EditYourBILLINGADDRESS butonuna tikla
        ReusableMethods.scroll(myAccountPage.billingEDITYOURBILLINGADDRESSButonu);
        ReusableMethods.bekle(3);
        myAccountPage.billingEDITYOURBILLINGADDRESSButonu.click();

        // Post Code/ZIP  bos birak
        myAccountPage.billingZipCodeKutusu.clear();
        ReusableMethods.bekle(1);
        // Save Address butonuna tikla
        ReusableMethods.scroll(myAccountPage.billingsaveAddressKutusu);
        ReusableMethods.bekle(3);
        myAccountPage.billingsaveAddressKutusu.click();
        ReusableMethods.bekle(3);
        // "Postcode / ZIP is a required field." Uyarisini gör
        ReusableMethods.scroll(myAccountPage.billingPostCodeZIPMesaji);
        Assert.assertEquals(myAccountPage.billingPostCodeZIPMesaji.getText(),"Postcode / ZIP is a required field.");

    }
}
