package team02.tests.US_07;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import team02.pages.ComparePage;
import team02.utilities.ConfigReader;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

public class TestCase_06 {

    //Kullanıcı seçtiği ürünleri karşılaştırabilmeli
    @Test
    public void test01() {
        //Siteye git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        //Herhangi bir urune tikla
        //Açılan ürün sekmesinde "terazi" simgesine tıkla
        //"Compare Products" penceresinin acildigini dogrula
        //Anasayfaya geri dön
        //Herhangi bir urune tikla
        //Açılan ürün sekmesinde "terazi" simgesine tıkla
        ReusableMethods.compare(26,2);
        ReusableMethods.bekle(2);

        //Açılan  "Compare Products" penceresinde "Start Compare" yazisina  tıkla
        ComparePage comparePage= new ComparePage();
        Assert.assertTrue(comparePage.startCompare.isDisplayed());
        comparePage.startCompare.click();

        //"Compare" baslikli karsilstirma sayfasinin acildigini dogrula
        Assert.assertEquals(comparePage.comparePageBaslik.getText(), "Compare");
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
