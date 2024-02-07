package team02.tests.US_04;

import org.testng.Assert;
import org.testng.annotations.Test;
import team02.pages.UserMyAccountPage;
import team02.tests.US_03.ClearMethods;
import team02.tests.US_03.SignInMethods;
import team02.tests.US_04.ClearMethods.ShippingClearMethod;
import team02.utilities.ReusableMethods;

public class US04_TC01 {
    @Test
    public void test01() {
       // Siteye git
       // Sign In`e tıkla
       // Username or email address kutusuna bir kullanıcı adı gir
       // Password kutusuna bir şifre gir
       // SIGN IN butonuna tikla
        SignInMethods.signInMethods();
       // My Account sekmesine tikla
        UserMyAccountPage myAccountPage=new UserMyAccountPage();myAccountPage.MyAccountButonu.click();
        ReusableMethods.bekle(5);
       // Adresses butonuna tikla
        ReusableMethods.scroll(myAccountPage.AddressesButonu);
        ReusableMethods.bekle(2);
        myAccountPage.AddressesButonu.click();
        ReusableMethods.bekle(2);
       // Shipping Adress basligi altinda ADD butonuna tikla
        ReusableMethods.scroll(myAccountPage.shippingAddButonu);
        ReusableMethods.bekle(2);
        myAccountPage.shippingAddButonu.click();
        ReusableMethods.bekle(2);
        ShippingClearMethod.shippingClearMethods();
       // First name kutusunu doldur
       // Last name kutusunu doldur
       // Company name (optional) kutusunu doldur
       // Street address alanini doldur
       // Town/City alanini doldur
       // Zip Code alanini doldur
       // Country/Region dropdown menüsünden secim yap
       // Save Address butonuna tikla
        ReusableMethods.shippingAddressDoldurmaMethodu();
        //  Save Address butonuna tikladiktan sonra "Address changed successfully." metnini  gör
        ReusableMethods.scroll(myAccountPage.shippingAddressSuccessfullMesaji);
        ReusableMethods.bekle(1);
        Assert.assertEquals(myAccountPage.shippingAddressSuccessfullMesaji.getText(),
                "Address changed successfully.");
    }
}
