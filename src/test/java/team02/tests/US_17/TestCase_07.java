package team02.tests.US_17;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import team02.pages.CartPage;
import team02.utilities.ReusableMethods;

public class TestCase_07 {

    //Place Order'a tıklanarak alışverişin tamamlandığı görülebilmeli
    @Test
    public void test01() {
        //1	Vendor olarak siteye git
        //2	Vendor olarak siteye sign in yap
        ReusableMethods.singInVendorRA();

        //3	Herhangi bir urune click yap
        ReusableMethods.urunSec();

        //4	Add to cart' a click yap
        ReusableMethods.addToCartRA();

        //5	Cart' a click yap
        CartPage cartPage=new CartPage();
        cartPage.cartClickRA.click();

        //6	Check Out' a click yap
        cartPage.checkOutRA.click();

        //7	Secilen urunun your order da goruldugunu dogrula
        Assert.assertTrue(cartPage.yourOrderdakiIlkUrunRA.getText().contains(cartPage.shoppingCartRA.getText()));

        //8	Zorunlu alanlari doldur. (First name, Last name, Country,  Street Adress, Town, State, ZIP code, Phone, E mail adress
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


        //9	Payment method sec
        //10 Place order' a click yap (Place order' a click yapildiginda Thank you yazisi gorulmeli)
        cartPage.placeOrderRA.click();

        //11 Place order' a click yapildigini dogrula
        Assert.assertTrue(cartPage.thankYouRA.getText().contains("Thank you"));

    }
}
