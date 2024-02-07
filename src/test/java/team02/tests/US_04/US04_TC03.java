package team02.tests.US_04;

import org.testng.Assert;
import org.testng.annotations.Test;
import team02.pages.UserMyAccountPage;
import team02.utilities.ReusableMethods;

public class US04_TC03 {
    @Test
    public void test03() {
        // Siteye git
        // Sign In`e tıkla
        // Username or email address kutusuna bir kullanıcı adı gir
        // Password kutusuna bir şifre gir
        // SIGN IN butonuna tikla
        // My Account sekmesine tikla
        ReusableMethods.signInMethods();
        UserMyAccountPage myAccountPage =new UserMyAccountPage();
        myAccountPage.MyAccountButonu.click();
        ReusableMethods.bekle(3);
       // Adresses butonuna tikla
        ReusableMethods.scroll(myAccountPage.AddressesButonu);
        ReusableMethods.bekle(3);
        myAccountPage.AddressesButonu.click();
        ReusableMethods.bekle(2);

       // Edit your shipping butonuna tikla
        ReusableMethods.scroll(myAccountPage.shippingEditYourKutusu);
        ReusableMethods.bekle(3);
        myAccountPage.shippingEditYourKutusu.click();
        ReusableMethods.bekle(2);

       // Last name kutusunu bos birak
        myAccountPage.shippingLastNameKutusu.clear();
        ReusableMethods.bekle(2);
       // Save Address butonuna tikla
        ReusableMethods.scroll(myAccountPage.shippingSaveAddressKutusu);
        ReusableMethods.bekle(3);
        myAccountPage.shippingSaveAddressKutusu.click();

       // "Last name is a required field." Uyarisini gör
        ReusableMethods.scroll(myAccountPage.shippingLastNameNegatifMesaji);
        ReusableMethods.bekle(3);
        Assert.assertEquals(myAccountPage.shippingLastNameNegatifMesaji.getText(),"Last name is a required field.");
    }
}
