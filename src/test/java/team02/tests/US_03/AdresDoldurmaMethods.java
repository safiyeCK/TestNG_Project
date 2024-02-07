package team02.tests.US_03;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import team02.pages.UserMyAccountPage;
import team02.utilities.ReusableMethods;

public class AdresDoldurmaMethods {

    public static void billingAddressDoldurmaMethodu() {
        UserMyAccountPage myAccountPage = new UserMyAccountPage();
        myAccountPage.billingFirstNameKutusu.sendKeys("Melike", Keys.TAB,
                "Mercan", Keys.TAB, "Team02 Company");
        Select select = new Select(myAccountPage.billingCountryRegiondDmKutusu);
        select.selectByVisibleText("Turkey");
        myAccountPage.billingStreetAddressKutusu1.sendKeys("Gülyaka");
        myAccountPage.billingStreetAddressKutusu2.sendKeys("Bahar , 22");
        myAccountPage.billingZipCodeKutusu.sendKeys("1100");
        myAccountPage.billingTownCityKutusu.sendKeys("Izmir");
        Select select1 = new Select(myAccountPage.billingProvinceKutusu); //?
        select1.selectByIndex(34); //?
        ReusableMethods.bekle(3);
        myAccountPage.billingPhoneKutusu.sendKeys("05378765432");
        ReusableMethods.scroll(myAccountPage.billingsaveAddressKutusu);
        ReusableMethods.bekle(3);
        myAccountPage.billingsaveAddressKutusu.click();



    }
}