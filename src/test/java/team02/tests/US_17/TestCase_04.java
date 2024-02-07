package team02.tests.US_17;

import org.testng.Assert;
import org.testng.annotations.Test;
import team02.pages.CartPage;
import team02.utilities.ReusableMethods;

public class TestCase_04 {

    //Toplam ödenecek rakam görüntülebilmeli
    @Test
    public void test01() {
        //1	Vendor olarak siteye git
        //2	Vendor olarak siteye sign in yap
        ReusableMethods.singInVendorRA();

        //3	Herhangi bir urune click yap
        ReusableMethods.urunSec();

        //4	Add to cart' a click yap
        ReusableMethods.addToCartRA();

        //5 Cart' a click yap
        //6	Check Out' a click yap
        CartPage cartPage=new CartPage();
        cartPage.cartClickRA.click();
        cartPage.checkOutRA.click();
        ReusableMethods.bekle(2);


        //7	Secilen urunun your order da goruldugunu dogrula
        Assert.assertTrue(cartPage.yourOrderdakiIlkUrunRA.getText().contains(cartPage.shoppingCartRA.getText()));

        //8	Toplam ödenecek rakamin görüntülendigi dogrula.
        Assert.assertTrue(cartPage.totalRA.isDisplayed());
        ReusableMethods.sepetiBosaltRA();


    }
}
