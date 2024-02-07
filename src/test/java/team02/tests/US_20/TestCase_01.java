package team02.tests.US_20;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import team02.pages.CartPage;
import team02.utilities.ConfigReader;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

public class TestCase_01 {
    //US20 Oluşturulan Coupon ile Vendor olarak alışveriş yapılabilmeli

    @AfterMethod
    public void tearDown() {
       // Driver.getDriver().quit();
    }

    @Test
    public void test01() {
        //Oluşturulan coupon ENTER YOUR CODE tıklanarak girilmeli

        //1	Vendor olarak siteye git
        //2	Vendor olarak siteye sign in yap
        ReusableMethods.singInVendorRA();

        //3	Olusturdugum urunumu search yap
        CartPage cartPage=new CartPage();
        cartPage.searchButtonRA.sendKeys("iPad Pro 12.9-inch",Keys.ENTER);

        //4	Add to cart' a click yap
        ReusableMethods.addToCartRA();

        //5	Cart' a click yap
        cartPage.cartClickRA.click();

        //6	view cart' a click yap
        cartPage.viewCartRA.click();

        //7	ENTER YOUR CODE tıkla
        cartPage.enterCouponCodeRA.click();

        //8	Coupon code gir //
        cartPage.enterCouponCodeRA.sendKeys(ConfigReader.getProperty("coupon01RA"));
        ReusableMethods.bekle(2);

        //9	Apply coupon butonuna tikla
        ReusableMethods.scroll(cartPage.applyCouponCodeRA);
        ReusableMethods.bekle(2);
        cartPage.applyCouponCodeRA.click();

        //10 Gecerli coupon kodu girilidigini dogrula
        Assert.assertTrue(cartPage.successCouponRA.getText().contains("Coupon code applied successfully."));
        ReusableMethods.bekle(3);

        //11 Proceed to checkout' a click yap
        ReusableMethods.scroll(Driver.getDriver().findElement(By.xpath("//span//input")));
        ReusableMethods.bekle(1);
        cartPage.proceedToCheckoutRA.click();
        ReusableMethods.bekle(2);

        //12 Zorunlu alanlari doldur. (First name, Last name, Country, Street Adress, Town, State, ZIP code, Phone, E mail adress
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

        //13 Place order' a click yap
        cartPage.placeOrderRA.click();

        //14 Place order' a click yapildigini dogrula  (Place order' a click yapildiginda Thank you yazisi gorulmeli)
        Assert.assertTrue(cartPage.thankYouRA.getText().contains("Thank you"));
        ReusableMethods.bekle(3);



    }
}
