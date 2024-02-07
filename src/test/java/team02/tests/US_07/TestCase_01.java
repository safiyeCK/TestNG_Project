package team02.tests.US_07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import team02.pages.HomePage;
import team02.utilities.ConfigReader;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

public class TestCase_01 {

    //Kullanıcı istedigi ürünleri karşılaştırmak için seçebilmeli

    @Test
    public void test01() {
        //Siteye git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        //Herhangi bir urune tikla
        ReusableMethods.urunSec();

        //Açılan ürün sekmesinde "terazi" simgesine tıkla
        ReusableMethods.compare();

        //Ürünün karsılastırmak icin seçildigini dogrula
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("(//h3)[11]")).isDisplayed());

    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }


}
