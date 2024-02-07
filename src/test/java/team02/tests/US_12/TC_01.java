package team02.tests.US_12;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import team02.pages.RegisterPage;
import team02.pages.VendorMyAccountPage;
import team02.utilities.ConfigReader;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

public class TC_01 { //PASSED
    /*
    Vendor kullanici , My Accounts-Adresses sayfasindaki Billing Address altindaki ADD butonuna tikladiginda
    e-Mail address'i otomatik olarak gelmeli
     */

    @Test
    public void testTc01() {

        //Web sitesine git
        //Sisteme Vendor olarak giris yap
        ReusableMethods.signInVendor1Ep();

        Actions actions =new Actions(Driver.getDriver());
        VendorMyAccountPage myAccountPage=new VendorMyAccountPage();

        //Footer da My Account linkine tikla
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);
        myAccountPage.myAccountButonuEp.click();
        ReusableMethods.bekle(2);

        //My Account sayfasinda Addresses linkine tikla
        ReusableMethods.scroll(myAccountPage.adressesButonuEp);
        ReusableMethods.bekle(2);
        myAccountPage.adressesButonuEp.click();
        ReusableMethods.bekle(3);

        //Billing Address altindaki ADD butonuna tikla
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        myAccountPage.billingAddressAddButonuEp.click();
        ReusableMethods.bekle(3);

        //Acilan sayfada email kutusunun dolu olarak geldigini dogrula
        ReusableMethods.scroll(myAccountPage.billingAddressEmail1Ep);
        ReusableMethods.bekle(3);
        Assert.assertEquals(myAccountPage.billingAddressEmail1Ep.getAttribute("value"),ConfigReader.getProperty("eMail2Ep"));

    }
}
