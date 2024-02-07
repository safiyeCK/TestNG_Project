package team02.tests.US_17;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import team02.pages.CartPage;
import team02.pages.HomePage;
import team02.pages.RegisterPage;
import team02.utilities.ConfigReader;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

import javax.swing.*;

public class TestCase_01 {
    //Ürün ve ürünler seçilip sepete eklenebilmeli

    @Test
    public void test01() {
        //Vendor olarak siteye git
        //Vendor olarak siteye sign in yap
        ReusableMethods.singInVendorRA();

        //Herhangi bir urune click yap
        ReusableMethods.urunSec();

        //Add to cart' a click yap
        CartPage cartPage=new CartPage();
        cartPage.addToCartRA.click();

    }
}
