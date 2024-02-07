package team02.tests.US_12;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import team02.pages.VendorMyAccountPage;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

public class TC_02 { //PASSED

    @Test
    public void testTc02() {

        //Web sitesine git
        //Sisteme Vendor olarak kaydolup giris yap
        ReusableMethods.vendorRegisterMethodu();

        Actions actions =new Actions(Driver.getDriver());
        Faker faker = new Faker();
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

        //First name kutusuna isim gir
        //Last name kutusuna bir soyisim gir
        myAccountPage.billingAddressFirstNameEp.sendKeys(faker.name().firstName(),
                Keys.TAB,faker.name().lastName());
        //Country/Region dropdown menusunden ulke sec
        Select select = new Select(myAccountPage.billingAddressCountryRegionDdmEp);
        select.selectByVisibleText("United States (US)");
        //Street address kutusuna adresi gir
        myAccountPage.billingAddressStreetAddressKutusuEp.sendKeys(faker.address().streetAddress());
        //Town/City kutusuna sehir ismi gir
        myAccountPage.billingAddressTownCityEp.sendKeys(faker.address().city());
        //Secilen ulkeye gore State(Canton-Town) kutusu ya da bolmesi doldurulur
        Select select1 = new Select(myAccountPage.billingAddressStateDdmEp);
        select1.selectByIndex(1);
        //ZIP Code kutusuna ulkenin ZIP kodunu gir
        myAccountPage.billingAddressZipCodeEp.sendKeys(faker.address().zipCode());
        //Phone kutusuna tel nosu gir
        myAccountPage.billingAddressPhoneEp.sendKeys(faker.phoneNumber().cellPhone());

        //SAVE ADDRESS butonuna tikla
        ReusableMethods.scroll(myAccountPage.billingSaveAddressEp);
        ReusableMethods.bekle(3);
        myAccountPage.billingSaveAddressEp.click();

        //"Address changed successfully'' mesajinin alindigini dogrula
        ReusableMethods.scroll(myAccountPage.billingAddressChangedSuccessfullyMesajiEp);
        Assert.assertEquals(myAccountPage.billingAddressChangedSuccessfullyMesajiEp.getText(),"Address changed successfully.");


    }
}
