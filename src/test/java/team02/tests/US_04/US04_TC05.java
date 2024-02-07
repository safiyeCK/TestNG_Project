package team02.tests.US_04;

import org.testng.Assert;
import org.testng.annotations.Test;
import team02.pages.UserMyAccountPage;
import team02.utilities.ReusableMethods;

public class US04_TC05 {
    @Test
    public void test05() {
      //  Siteye git
      //  Sign In`e tıkla
      //  Username or email address kutusuna bir kullanıcı adı gir
      //  Password kutusuna bir şifre gir
      //  SIGN IN butonuna tikla
        ReusableMethods.signInMethods();
      //  My Account sekmesine tikla
        UserMyAccountPage myAccountPage =new UserMyAccountPage();
        ReusableMethods.scroll(myAccountPage.MyAccountButonu);
        ReusableMethods.bekle(3);
        myAccountPage.MyAccountButonu.click();
        ReusableMethods.bekle(3);
      //  Adresses butonuna tikla
        ReusableMethods.scroll(myAccountPage.AddressesButonu);
        ReusableMethods.bekle(3);
        myAccountPage.AddressesButonu.click();
        ReusableMethods.bekle(3);
      //  Edit Your Shipping Address butonuna tikla
        ReusableMethods.scroll(myAccountPage.shippingEditYourKutusu);
        ReusableMethods.bekle(3);
        myAccountPage.shippingEditYourKutusu.click();
        ReusableMethods.bekle(3);
      //  Street Address alanlarini bos birak
        myAccountPage.shippingStreetAddressKutusu1.clear();
        myAccountPage.shippingStreetAddressKutusu2.clear();
        ReusableMethods.bekle(3);
      //  Save Address butonuna tikla
        ReusableMethods.scroll(myAccountPage.shippingSaveAddressKutusu);
        ReusableMethods.bekle(3);
        myAccountPage.shippingSaveAddressKutusu.click();
        ReusableMethods.bekle(3);
      //  "Street Address is a required field." Uyarisini gör
        ReusableMethods.scroll(myAccountPage.shippingStreetNegatifMesajKutusu);
        ReusableMethods.bekle(3);
        Assert.assertEquals(myAccountPage.shippingStreetNegatifMesajKutusu.getText(),
                "Street address is a required field.");

    }
}
