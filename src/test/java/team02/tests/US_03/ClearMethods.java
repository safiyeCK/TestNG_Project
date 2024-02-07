package team02.tests.US_03;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import team02.pages.UserMyAccountPage;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

public class ClearMethods {
    public static void userBillingClearMethod() {
        UserMyAccountPage myAccountPage = new UserMyAccountPage();
        if (myAccountPage.billingFirstNameKutusu.isDisplayed()) {
            Actions actions = new Actions(Driver.getDriver());
            ReusableMethods.bekle(2);
            actions.scrollByAmount(0, 500).perform();
           // myAccountPage.billingEDITYOURBILLINGADDRESSButonu.click();
            ReusableMethods.bekle(1);
            myAccountPage.billingFirstNameKutusu.clear();
            ReusableMethods.bekle(1);
            myAccountPage.billingLastNameKutusu.clear();
            ReusableMethods.bekle(1);
            myAccountPage.billingCompanyKutusu.clear();
            ReusableMethods.bekle(1);
            actions.scrollByAmount(0, 500).perform();

            ReusableMethods.bekle(1);
            myAccountPage.billingStreetAddressKutusu1.clear();
            ReusableMethods.bekle(1);
            myAccountPage.billingStreetAddressKutusu2.clear();
            ReusableMethods.bekle(1);
            myAccountPage.billingZipCodeKutusu.clear();
            ReusableMethods.bekle(1);
            myAccountPage.billingTownCityKutusu.clear();
            ReusableMethods.bekle(1);
            myAccountPage.billingPhoneKutusu.clear();
        } else {
            myAccountPage.billingAddButonu.click();
        }


    }
}
