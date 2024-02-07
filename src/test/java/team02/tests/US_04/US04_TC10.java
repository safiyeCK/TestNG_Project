package team02.tests.US_04;

import org.testng.Assert;
import org.testng.annotations.Test;
import team02.pages.UserMyAccountPage;
import team02.tests.US_04.ClearMethods.ShippingClearMethod;
import team02.utilities.ReusableMethods;

public class US04_TC10 {
    @Test
    public void test10() {
      //  Siteye git
      //  Sign In`e tıkla
      //  Username or email address kutusuna bir kullanıcı adı gir
      //  Password kutusuna bir şifre gir
      //  SIGN IN butonuna tikla
        ReusableMethods.signInMethods();
        //My Account alanina tikla
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
      //  Edit Your Address butonuna tikla
        ReusableMethods.scroll(myAccountPage.shippingEditYourKutusu);
        ReusableMethods.bekle(2);
        myAccountPage.shippingEditYourKutusu.click();
        ReusableMethods.bekle(3);
      //  First name kutusunu doldur
      //  Last name kutusunu doldur
      //  Company name (optional) kutusunu doldur
      //  Street address alanini doldur
      //  Town/City alanini doldur
      //  Zip Code alanini doldur
      //  Country/Region dropdown menüsünden secim yap
       // ShippingClearMethod.shippingClearMethods();
       // ReusableMethods.bekle(2);
       // ReusableMethods.shippingAddressDoldurmaMethodu();
       // ReusableMethods.bekle(3);
      //  Save Address butonuna tikla
        ReusableMethods.scroll(myAccountPage.shippingSaveAddressKutusu);
        ReusableMethods.bekle(2);
        myAccountPage.shippingSaveAddressKutusu.click();
        ReusableMethods.bekle(2);
      //  Save Address butonuna tikladiktan sonra "Address changed successfully." metnini  gör
        ReusableMethods.scroll(myAccountPage.shippingAddressSuccessfullMesaji);
        ReusableMethods.bekle(1);
        Assert.assertEquals(myAccountPage.shippingAddressSuccessfullMesaji.getText(),
                "Address changed successfully.");


    }
}
