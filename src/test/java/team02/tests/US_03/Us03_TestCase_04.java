package team02.tests.US_03;

import org.testng.Assert;
import org.testng.annotations.Test;
import team02.pages.UserMyAccountPage;
import team02.utilities.ReusableMethods;

public class Us03_TestCase_04 {
    @Test
    public void test04() {
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

        // Last name bos birak
        myAccountPage.billingLastNameKutusu.clear();
        ReusableMethods.bekle(1);
        // Save Address butonuna tikla
        ReusableMethods.scroll(myAccountPage.billingsaveAddressKutusu);
        ReusableMethods.bekle(3);
        myAccountPage.billingsaveAddressKutusu.click();
        ReusableMethods.bekle(3);
        // "Last name is a required field." Uyarisini gör
        ReusableMethods.scroll(myAccountPage.billingLastnameNegatifMesaji);
        Assert.assertEquals(myAccountPage.billingLastnameNegatifMesaji.getText(),"Last name is a required field.");

        // Billing sayfasindaki Address butonuna tikla
      //  ReusableMethods.scroll(myAccountPage.billingIcindekiAddressesButonu);
      //  myAccountPage.billingIcindekiAddressesButonu.click();
        // Billing Address altinda Last name'in otomatik geldigini dogrula
    }
}
