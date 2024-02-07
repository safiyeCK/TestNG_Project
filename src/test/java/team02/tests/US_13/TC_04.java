package team02.tests.US_13;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import team02.pages.VendorMyAccountPage;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

public class TC_04 { // PASSED
        /*
        Vendor kullanici, My Accounts-Adresses sayfasindaki Country / Region secilmeden
Shipping Address (Fatura Adresi) ekleyememeli.
         */
    @Test
    public void tc04() {
        //Web sitesine git
        //Sisteme Vendor olarak giris yap
        ReusableMethods.vendorRegisterMethodu();

        VendorMyAccountPage myAccountPage = new VendorMyAccountPage();
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();

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

        //Shipping Address altindaki ADD butonuna tikla
        ReusableMethods.scroll(myAccountPage.shippingAddressAddButonuEp);
        ReusableMethods.bekle(3);
        myAccountPage.shippingAddressAddButonuEp.click();
        ReusableMethods.bekle(3);

        //Country/Region (dropdown menuden) bos birak
        //Country/Region harici tum zorunlu alanlari doldur
        myAccountPage.shippingAddressFirstNameKutusuEp.sendKeys(faker.name().firstName(),
                Keys.TAB,faker.name().lastName());
        ReusableMethods.bekle(1);
        myAccountPage.shippingAdressCompanyNameKutusuEp.sendKeys(faker.company().name(),
                Keys.TAB, Keys.TAB);
        ReusableMethods.bekle(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

        myAccountPage.shippingAddressStreetAddressKutusu1Ep.sendKeys(faker.address().streetAddress(),
                Keys.TAB, faker.address().streetAddress());
        ReusableMethods.bekle(1);

        myAccountPage.shippingAddressTownCityKutusuEp.sendKeys(faker.address().city(),
                Keys.TAB, "Alabama", Keys.TAB);

        myAccountPage.shippingAddressZipCodeKutusuEp.sendKeys(faker.address().zipCode());

        //SAVE ADDRESS butonuna tikla
        ReusableMethods.scroll(myAccountPage.shippingAddressSaveAddressButonuEp);
        ReusableMethods.bekle(3);
        myAccountPage.shippingAddressSaveAddressButonuEp.click();

        //"Country / Region is a required field." yazisinin ciktigini ve hesap degisikligi yapilamadigini dogrula
        ReusableMethods.scroll(myAccountPage.shippingAddressCountryRegionWarningMessageEp);
        Assert.assertEquals(myAccountPage.shippingAddressCountryRegionWarningMessageEp.getText(), "Country / Region is a required field.");

    }
}
