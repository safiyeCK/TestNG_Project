package team02.tests.US_04;

import org.bouncycastle.crypto.Mac;
import org.testng.annotations.Test;
import team02.pages.UserMyAccountPage;
import team02.utilities.ReusableMethods;

public class US04_TC04{
    @Test
    public void test04() {
       //Siteye git
       //Sign In`e tıkla
       //Username or email address kutusuna bir kullanıcı adı gir
       //Password kutusuna bir şifre gir
       //SIGN IN butonuna tikla
        ReusableMethods.signInMethods();
       //My Account sekmesine tikla
        UserMyAccountPage myAccountPage = new UserMyAccountPage();
        myAccountPage.MyAccountButonu.click();
        ReusableMethods.bekle(3);
       //Adresses butonuna tikla
        ReusableMethods.scroll(myAccountPage.AddressesButonu);
        ReusableMethods.bekle(3);
        myAccountPage.AddressesButonu.click();
        ReusableMethods.bekle(3);
       //Edit Your Shipping Address butonuna tikla
        ReusableMethods.scroll(myAccountPage.shippingEditYourKutusu);
        ReusableMethods.bekle(3);
        myAccountPage.shippingEditYourKutusu.click();
        ReusableMethods.bekle(3);
       //Company name kutusunu bos birak
        myAccountPage.shippingCompanyKutusu.clear();
        ReusableMethods.bekle(3);
       //Save Address butonuna tikla
        ReusableMethods.scroll(myAccountPage.shippingSaveAddressKutusu);
        ReusableMethods.bekle(3);
        myAccountPage.shippingSaveAddressKutusu.click();
    }
}
