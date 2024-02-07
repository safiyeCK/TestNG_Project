package team02.tests.US_07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import team02.pages.ComparePage;
import team02.pages.HomePage;
import team02.utilities.ConfigReader;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

import java.util.List;

public class TestCase_03 {

    //Kullanıcı karşılaştırmak istedigi bir ürünü silip yeni ürün ekleyebilmeli
    @Test
    public void test01() {
        //Siteye git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        //Herhangi bir urune tikla
        ReusableMethods.urunSec();

        //Açılan ürün sekmesinde "terazi" simgesine tıkla
        ReusableMethods.compare();

        //"Compare Products" penceresinin acildigini dogrula
        ComparePage comparePage= new ComparePage();
        Assert.assertTrue(comparePage.startCompare.isDisplayed());

        //"Compare Products" penceresinde silmek istedigin urunun uzerindeki carpi isaretine tıkla
        comparePage.removeFromCompare.click();

        //"Compare Products" listesinden istenilen urununün silindigini dogrula
        ReusableMethods.bekle(2);
        List<WebElement> compareProducts= Driver.getDriver().findElements(By.xpath("//a//figure"));
        ReusableMethods.bekle(2);
        Assert.assertEquals(compareProducts.size(), 0);

        //Anasayfaya geri dön
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        //Yeni ürün eklemek için herhangi bir urune tikla
        ReusableMethods.urunSec();

        //Acılan ürün sekmesinde "terazi" simgesine tıkla
        ReusableMethods.compare();

        //"Compare Products" listesine yeni urunun eklendigini dogrula
        List<WebElement> compareProducts2= Driver.getDriver().findElements(By.xpath("//a//figure"));
        Assert.assertEquals(compareProducts2.size(), 1);


    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
