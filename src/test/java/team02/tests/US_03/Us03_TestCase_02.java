package team02.tests.US_03;

import org.testng.Assert;
import org.testng.annotations.Test;
import team02.pages.UserMyAccountPage;
import team02.utilities.ReusableMethods;

public class Us03_TestCase_02 {
    @Test
    public void TC02() {

     //  Web sitesine gidiniz
     //  Kullanici olarak giris yapiniz
        ReusableMethods.signInMethods();
     //  My Account alanina tiklayiniz
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

        ClearMethods.userBillingClearMethod();
     //  First name bilgilerini gir
     //  Last name bilgilerini gir
     //  Country/Region sec
     //  Street Address gir
     //  Post Code/Zip gir
     //  Town/City gir
     //  State/Province sec
     //  Telefon numarasi gir
     //  Save Address butonuna tikla
        AdresDoldurmaMethods.billingAddressDoldurmaMethodu();
     //  "Address changed successfully." metnini gör
        ReusableMethods.scroll(myAccountPage.billingAddressChangedSuccessfullyMesaji);
        Assert.assertEquals(myAccountPage.billingAddressChangedSuccessfullyMesaji.getText(),"Address changed successfully.");


    }
}
