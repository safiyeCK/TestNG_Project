package team02.tests.US_17;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import team02.pages.CartPage;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

public class TestCase_02 {
    @AfterMethod
    public void tearDown() {
        ReusableMethods.sepetiBosaltRA();
        ReusableMethods.bekle(3);
        Driver.closeDriver();
    }

    //Chart - Chekout yapılarak alınacak ürün ve ürünler görülebilmeli
    @Test
    public void test01() {
        //Vendor olarak siteye git
        //Vendor olarak siteye sign in yap
        ReusableMethods.singInVendorRA();

        //Herhangi bir urune click yap
        ReusableMethods.urunSec();
        CartPage cartPage=new CartPage();

        //Add to cart' a click yap
        ReusableMethods.addToCartRA();
        String randomRA=cartPage.randomUrunRA.getText();

        //Cart' a click yap
        cartPage.cartClickRA.click();

        //Checkout' a click yap
        cartPage.checkOutRA.click();

        //Secilen urun- un/ -lerin your order da goruldugunu dogrula
        Assert.assertTrue(cartPage.yourOrderdakiIlkUrunRA.getText().contains(randomRA));
        ReusableMethods.bekle(3);
    }

}
