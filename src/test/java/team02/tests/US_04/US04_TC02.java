package team02.tests.US_04;

import org.testng.Assert;
import org.testng.annotations.Test;
import team02.pages.UserMyAccountPage;
import team02.tests.US_03.SignInMethods;
import team02.utilities.ReusableMethods;

public class US04_TC02 {
    @Test
    public void test02() {
      //  Siteye git
      //  Sign In`e tıkla
      //  Username or email address kutusuna bir kullanıcı adı gir
      //  Password kutusuna bir şifre gir
      //  SIGN IN butonuna tikla
        SignInMethods.signInMethods();
        // My Account sekmesine tikla
        UserMyAccountPage myAccountPage=new UserMyAccountPage();
        myAccountPage.MyAccountButonu.click();
        ReusableMethods.bekle(5);
        // Adresses butonuna tikla
        ReusableMethods.scroll(myAccountPage.AddressesButonu);
        ReusableMethods.bekle(2);
        myAccountPage.AddressesButonu.click();
        ReusableMethods.bekle(2);
        // Shipping Adress basligi altinda ADD butonuna tikla
        ReusableMethods.scroll(myAccountPage.shippingEditYourKutusu);
        ReusableMethods.bekle(2);
        myAccountPage.shippingEditYourKutusu.click();

      //  First name kutusunu bos birak
        myAccountPage.shippingFirstNameKutusu.clear();
        ReusableMethods.bekle(3);
        //  Save Address butonuna tikla
        ReusableMethods.scroll(myAccountPage.shippingSaveAddressKutusu);
        ReusableMethods.bekle(3);
        myAccountPage.shippingSaveAddressKutusu.click();
        ReusableMethods.bekle(3);
        //"First name is a required field." Uyarisini gör
        ReusableMethods.scroll(myAccountPage.shippingFirstNameNegatifMesaji);
        Assert.assertEquals(myAccountPage.shippingFirstNameNegatifMesaji.getText(),"First name is a required field.");

    }
}
