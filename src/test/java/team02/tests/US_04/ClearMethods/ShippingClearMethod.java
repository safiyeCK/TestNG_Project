package team02.tests.US_04.ClearMethods;

import org.openqa.selenium.interactions.Actions;
import team02.pages.UserMyAccountPage;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

public class ShippingClearMethod {
    public static void shippingClearMethods() {
        UserMyAccountPage myAccountPage = new UserMyAccountPage();
        if (myAccountPage.shippingFirstNameKutusu.isDisplayed()) {
            Actions actions = new Actions(Driver.getDriver());
            ReusableMethods.bekle(2);
            actions.scrollByAmount(0, 500).perform();
            // myAccountPage.billingEDITYOURBILLINGADDRESSButonu.click();
            ReusableMethods.bekle(1);
            myAccountPage.shippingFirstNameKutusu.clear();
            ReusableMethods.bekle(1);
            myAccountPage.shippingLastNameKutusu.clear();
            ReusableMethods.bekle(1);
            myAccountPage.shippingCompanyKutusu.clear();
            ReusableMethods.bekle(1);
            actions.scrollByAmount(0, 500).perform();

            ReusableMethods.bekle(1);
            myAccountPage.shippingStreetAddressKutusu1.clear();
            ReusableMethods.bekle(1);
            myAccountPage.shippingStreetAddressKutusu2.clear();
            ReusableMethods.bekle(1);
            myAccountPage.shippingZipCodeKutusu.clear();
            ReusableMethods.bekle(1);
            myAccountPage.shippingTownCityKutusu.clear();
            ReusableMethods.bekle(1);

        } else {
            myAccountPage.shippingAddButonu.click();
        }
    }
}
