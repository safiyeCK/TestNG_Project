package team02.tests.US_17;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import team02.pages.CartPage;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

import javax.swing.*;

public class TestCase_03 {
    //Fatura ayrıntıları (BILLING DETAILS) doldurulabilmeli
    @Test
    public void test01() {
        //Vendor olarak siteye git
        //Vendor olarak siteye sign in yap
        ReusableMethods.singInVendorRA();

        //Herhangi bir urune click yap
        ReusableMethods.urunSec();

        //Add to cart' a click yap
        ReusableMethods.addToCartRA();

        //Cart' a click yap
        CartPage cartPage=new CartPage();
        cartPage.cartClickRA.click();

        //Checkout' a click yap
        cartPage.checkOutRA.click();

        //Zorunlu alanlari doldur. (First name, Last name, Country,  Street Adress, Town, State, ZIP code, Phone, E mail adress
        Faker faker=new Faker();
        cartPage.zorunlularRA.sendKeys(faker.name().firstName(),
                Keys.TAB,faker.name().lastName());

        cartPage.streetAdress.sendKeys(faker.address().streetAddress(),
                Keys.TAB,Keys.TAB, faker.address().cityName(),
                Keys.TAB,Keys.TAB,faker.address().zipCode(),
                Keys.TAB,faker.phoneNumber().phoneNumber());

        ReusableMethods.bekle(2);
       ReusableMethods.scroll(cartPage.placeOrderRA);
       ReusableMethods.bekle(2);

        //Zorunlu alanlari dolduruldugunu dogrula
        cartPage.placeOrderRA.click();
        Assert.assertEquals(cartPage.orderCompletedRA.getText(), "Thank you. Your order has been received.");



    }
}
