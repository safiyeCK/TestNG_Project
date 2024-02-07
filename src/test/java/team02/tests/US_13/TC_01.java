package team02.tests.US_13;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import team02.pages.VendorMyAccountPage;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

public class TC_01 { //PASSED

    /*
    Vendor kullanici, My Accounts-Adresses sayfasindaki zorunlu alanlari doldurarak
    Shipping Address (Fatura Adresi) ekleyebilmeli.
     */
    @Test
    public void deneme() {

        //Web sitesine git
        //Sisteme Vendor olarak kaydolup giris yap
        ReusableMethods.vendorRegisterMethodu();

        VendorMyAccountPage myAccountPage=new VendorMyAccountPage();
        Actions actions =new Actions(Driver.getDriver());
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

        //First name kutusuna isim gir
        //Last name kutusuna bir soyisim gir
        myAccountPage.shippingAddressFirstNameKutusuEp.sendKeys(faker.name().firstName(),
                Keys.TAB,faker.name().lastName());
        ReusableMethods.bekle(1);

        //Company name kutusuna bir isim gir
        //Country/Region dropdown menusunden ulke sec
        myAccountPage.shippingAdressCompanyNameKutusuEp.sendKeys(faker.company().name(),
                Keys.TAB,"United States (US)",Keys.TAB);
        ReusableMethods.bekle(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

        //Street address kutusuna adresi gir
        myAccountPage.shippingAddressStreetAddressKutusu1Ep.sendKeys(faker.address().streetAddress(),
                Keys.TAB,faker.address().streetAddress());
        ReusableMethods.bekle(1);

        //Town/City kutusuna sehir ismi gir
        //Secilen ulkeye gore State(Canton-Town) kutusu ya da bolmesi doldurulur
        myAccountPage.shippingAddressTownCityKutusuEp.sendKeys(faker.address().city(),
                Keys.TAB,"Alabama",Keys.TAB);

        //ZIP Code kutusuna ulkenin ZIP kodunu gir
        myAccountPage.shippingAddressZipCodeKutusuEp.sendKeys(faker.address().zipCode());

        //SAVE ADDRESS butonuna tikla
        ReusableMethods.scroll(myAccountPage.shippingAddressSaveAddressButonuEp);
        ReusableMethods.bekle(3);
        myAccountPage.shippingAddressSaveAddressButonuEp.click();

        //"Address changed successfully'' mesajinin alindigini dogrula
        ReusableMethods.scroll(myAccountPage.shippingAddressChangedSuccessfullyMesajiEp);
        Assert.assertEquals(myAccountPage.shippingAddressChangedSuccessfullyMesajiEp.getText(),"Address changed successfully.");


    }
}
