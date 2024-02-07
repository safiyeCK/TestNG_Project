package team02.tests.US_12;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import team02.pages.VendorMyAccountPage;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

public class TC_05 { //PASSED
    /*
    Vendor kullanici, My Accounts-Adresses sayfasindaki Country / Region secilmeden
Shipping Address (Fatura Adresi) ekleyememeli.
     */

    @Test
    public void testTc05() {

        //Web sitesine git
        //Sisteme Vendor olarak giris yap
    ReusableMethods.vendorRegisterMethodu();

    Actions actions = new Actions(Driver.getDriver());
    Faker faker = new Faker();
    VendorMyAccountPage myAccountPage = new VendorMyAccountPage();

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

        //Country/Region (dropdown menuden) bos birak
        //Country/Region harici tum zorunlu alanlari doldur
        myAccountPage.billingAddressFirstNameEp.sendKeys(faker.name().firstName(),
                Keys.TAB,faker.name().lastName());
        ReusableMethods.bekle(1);

        myAccountPage.billingAddressCompanyNameEp.sendKeys(faker.company().name(),
                Keys.TAB,Keys.TAB);
        ReusableMethods.bekle(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

        myAccountPage.billingAddressStreetAddressKutusuEp.sendKeys(faker.address().streetAddress(),
                Keys.TAB, faker.address().streetAddress());

        myAccountPage.billingAddressTownCityEp.sendKeys(faker.address().city(),
                Keys.TAB, "Alabama", Keys.TAB);

        myAccountPage.billingAddressZipCodeEp.sendKeys(faker.address().zipCode());

        myAccountPage.billingAddressPhoneEp.sendKeys(faker.phoneNumber().cellPhone());

    //SAVE ADDRESS butonuna tikla
        ReusableMethods.scroll(myAccountPage.billingSaveAddressEp);
        ReusableMethods.bekle(3);
        myAccountPage.billingSaveAddressEp.click();

    //"Address changed successfully'' mesajinin alindigini dogrula
        ReusableMethods.scroll(myAccountPage.billingCountryDdmNegatifMesaji);
        Assert.assertEquals(myAccountPage.billingCountryDdmNegatifMesaji.getText(),"Country / Region is a required field.");

    }
}
