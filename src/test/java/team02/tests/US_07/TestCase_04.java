package team02.tests.US_07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import team02.pages.ComparePage;
import team02.utilities.ConfigReader;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

import java.util.List;

public class TestCase_04 {

    //Kullanıcı karşılaştırmak istedigi ürünleri silip yeni ürün ekleyebilmeli
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

        //Anasayfaya geri dön
        Driver.getDriver().navigate().back();

        //Herhangi bir urune tikla
        ReusableMethods.urunSec();

        //Açılan ürün sekmesinde "terazi" simgesine tıkla
        ReusableMethods.compare();

        //"Compare Products" penceresinde urunlerden birini silmek icin urunun uzerindeki carpi isaretine tıkla
        comparePage.removeFromCompare.click();

        //"Compare Products" listesinden secilen urunun silindigini dogrula
        ReusableMethods.bekle(2);
        List<WebElement> compareProducts= Driver.getDriver().findElements(By.xpath("//a//figure"));
        Assert.assertEquals(compareProducts.size(), 1);

        //"Compare Products" penceresinde listede kalan son urunu silmek icin urunun uzerindeki carpi isaretine tıkla
        comparePage.removeFromCompare.click();

        //"Compare Products" listesinden secilen urununün silindigini dogrula
        ReusableMethods.bekle(2);
        List<WebElement> compareProducts2= Driver.getDriver().findElements(By.xpath("//a//figure"));
        Assert.assertEquals(compareProducts2.size(), 0);

        //Anasayfaya geri dön
        Driver.getDriver().navigate().back();

        //Yeni ürün eklemek için herhangi bir urune tikla
        ReusableMethods.urunSec();

        //Açılan ürün sekmesinde "terazi" simgesine tıkla
        ReusableMethods.compare();

        //"Compare Products" listesine yeni urunun eklendigini dogrula
        List<WebElement> compareProducts3= Driver.getDriver().findElements(By.xpath("//a//figure"));
        Assert.assertEquals(compareProducts3.size(), 1);


    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
