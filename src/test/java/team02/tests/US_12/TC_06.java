package team02.tests.US_12;

import org.testng.Assert;
import org.testng.annotations.Test;
import team02.pages.VendorMyAccountPage;
import team02.utilities.ReusableMethods;

public class TC_06 { //PASSED

    /*
        Vendor kullanici, My Accounts-Adresses sayfasindaki Street / Address kutusunu bos biraktiginda
Billing Address (Fatura Adresi) ekleyememeli.
         */

    @Test
    public void testTc06() {

        //Web sitesine git
        //Sistemde kayitli olan verilerle Vendor olarak giris yap
        ReusableMethods.signInVendorEp();
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


        //Billing Address altindaki Edit Your Billing Address butonuna tikla
        ReusableMethods.scroll(myAccountPage.billingEditYourBillingAddressButonuEp);
        ReusableMethods.bekle(2);
        myAccountPage.billingEditYourBillingAddressButonuEp.click();
        ReusableMethods.bekle(3);

        //Street / Address kutusunu bos birak
        myAccountPage.billingAddressStreetAddressKutusuEp.clear();

        //SAVE ADDRESS butonuna tikla
        ReusableMethods.scroll(myAccountPage.billingSaveAddressEp);
        ReusableMethods.bekle(2);
        myAccountPage.billingSaveAddressEp.click();
        ReusableMethods.bekle(2);

        //"Street / Address is a required field." yazisinin ciktigini ve hesap degisikligi yapilamadigini dogrula
        ReusableMethods.scroll(myAccountPage.billingStreetAddressNegatifMesajiEp);
        Assert.assertEquals(myAccountPage.billingStreetAddressNegatifMesajiEp.getText(),"Street address is a required field.");


    }
}



