package team02.tests.US_14;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import team02.pages.RegisterPage;
import team02.pages.VendorMyAccountPage;
import team02.utilities.ConfigReader;
import team02.utilities.Driver;

import team02.utilities.Extent_Reports;
import team02.utilities.ReusableMethods;

import java.util.List;

public class TestCase01  {     //PASSED
    VendorMyAccountPage vendorMyAccountPage =new VendorMyAccountPage();
    Actions actions =new Actions(Driver.getDriver());
    Faker faker=new Faker();



        @Test
        public void ilkOnAdim_14() {
            /* *//*Vendor olarak siteye giris yaptiginda Simple Product,
        Variable Product, Grouped Product, External -
        Affiliate Product product cesitlerini gorebilmeli
         */
            Extent_Reports.rapor(ConfigReader.getProperty("browser"),"Smoke Test","Safiye");
            Extent_Reports.extentTest= Extent_Reports.extentReport.createTest("Extent Report", "Test Raporu");

            //   Web sitesine git
            Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
            Extent_Reports.extentTest.info("Kullanici Allover Commerce sayfasina gider");

            //Sign in butonuna tıkla
            RegisterPage registerPage =new RegisterPage();
            ReusableMethods.click(registerPage.signInKutusu);
            ReusableMethods.bekle(3);
            Extent_Reports.extentTest.info("Kullanici sign in butonuna tiklar");

            //Username veya email adress kutusuna kayitli bir email gir
            //Password gir
            //Sign in butonuna tıkla
            registerPage.userName.sendKeys(ConfigReader.getProperty("email_SK"),
                    Keys.TAB, ConfigReader.getProperty("password_SK"),
                    Keys.ENTER);
            ReusableMethods.bekle(3);
            Extent_Reports.extentTest.info("Kullanici kayitli bir email ve password girer ve sign in butonuna tiklar");

            //Başarılı giriş yapıldığını doğrula.
            Assert.assertTrue(vendorMyAccountPage.signOutYazisi_SK.isDisplayed());
            ReusableMethods.bekle(3);
            Extent_Reports.extentTest.info("Basarili bir giris yapildigini dogrular");

            //Sayfa sonundaki My Account butonuna tikla
            ReusableMethods.scrollEnd();
            ReusableMethods.bekle(2);
            vendorMyAccountPage.myAccountButonu_SK.click();
            ReusableMethods.bekle(2);
            Extent_Reports.extentTest.info("Kullanici My Account butonuna tiklar");

            //Store Manager butonuna tıkla.
            vendorMyAccountPage.storeManagerButonu_SK.click();
            ReusableMethods.bekle(3);
            Extent_Reports.extentTest.info("Kullanici Store Manager butonuna tiklar");

            //My Store webelementi altindaki Products butonuna tıkla.
            ReusableMethods.bekle(3);
            ReusableMethods.click(vendorMyAccountPage.productsButonu_SK);
            ReusableMethods.bekle(3);
            Extent_Reports.extentTest.info("Kullanici My Store webelementi altindaki Products butonuna tiklar");

            //Add new butonuna tıkla.
            ReusableMethods.click(vendorMyAccountPage.addNewButonu_SK);
            ReusableMethods.bekle(3);
            Extent_Reports.extentTest.info("Kullanici Add new butonuna tiklar");
            Extent_Reports.extentReport.flush();
        }
        @Test(dependsOnMethods = "ilkOnAdim_14")
        public void testTC01() {
            Extent_Reports.rapor(ConfigReader.getProperty("browser"),"Smoke Test","Safiye");
            Extent_Reports.extentTest= Extent_Reports.extentReport.createTest("Extent Report", "Test Raporu");

            //Product çeşitleri ddm tıkla.
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            ReusableMethods.click(vendorMyAccountPage.productTypeDDM_SK);
            Extent_Reports.extentTest.info("Kullanici Product çeşitleri ddm tıklar");

            //Product çeşitleri görüntülendiğini doğrula
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            Select select = new Select(vendorMyAccountPage.productTypeDDM_SK);
            List<WebElement> weblist = select.getOptions();
            weblist.forEach(t -> System.out.println(t.getText()));
            for (WebElement product : weblist) {
                Assert.assertTrue(product.getText().equals("Simple Product")
                        || product.getText().equals("Variable Product")
                        || product.getText().equals("Grouped Product")
                        || product.getText().equals("External/Affiliate Product"));
            }
            Assert.assertTrue(vendorMyAccountPage.productTypeDDM_SK.isEnabled());
            Extent_Reports.extentTest.info("Kullanici Product çeşitlerinin görüntülendiğini doğrular");
            Extent_Reports.extentReport.flush();
        }
        @Test(dependsOnMethods = "ilkOnAdim_14")
        public void testTC02() {
            Extent_Reports.rapor(ConfigReader.getProperty("browser"),"Smoke Test","Safiye");
            Extent_Reports.extentTest= Extent_Reports.extentReport.createTest("Extent Report", "Test Raporu");

            /*Vendor olarak siteye giris yaptiginda yeni urün fotoğrafı eklenebilmeli*/
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            ReusableMethods.bekle(3);

            //Fotoğraf eklemek icin images ikonuna tıkla.
           ReusableMethods.click(vendorMyAccountPage.fotografEkleWE_SK);
            ReusableMethods.bekle(4);
            Extent_Reports.extentTest.info("Kullanici Fotoğraf eklemek icin images ikonuna tıklar");

            //  Select files butonuna tıkla
            //Fotoğraf seç.
            ReusableMethods.click(vendorMyAccountPage.selectFilesButonu_SK);
            String dosyaYolu= "C:\\Users\\Eigenaar\\Pictures\\Ekran görüntüsü 2023-07-27 164828.png";  //Not:Burasi kendi bilgisayarimdaki dosya yolu
            ReusableMethods.uploadFile(dosyaYolu);
            ReusableMethods.bekle(4);
            Extent_Reports.extentTest.info("Kullanici Select files butonuna tıklar");

            //  Select butonuna tıkla.
            ReusableMethods.click(vendorMyAccountPage.selectButonu_SK);
            ReusableMethods.bekle(4);
            Extent_Reports.extentTest.info("Kullanici Select butonuna tıklar");

            //  Fotoğraf eklendiğini doğrula.
            Assert.assertTrue(vendorMyAccountPage.xButtonu_SK.isEnabled());
            Extent_Reports.extentTest.info("Kullanici fotoğraf eklendiğini doğrular");
            Extent_Reports.extentReport.flush();
        }
        @Test(dependsOnMethods = "ilkOnAdim_14")
        public void testTC03() {
            Extent_Reports.rapor(ConfigReader.getProperty("browser"),"Smoke Test","Safiye");
            Extent_Reports.extentTest= Extent_Reports.extentReport.createTest("Extent Report", "Test Raporu");

            /*Product Title, Short Description ve Description yazılabilmeli*/
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            ReusableMethods.bekle(3);
            //   Product Tile alanina bir veri gir.
            vendorMyAccountPage.productTitleMetinAlani_SK.sendKeys(ConfigReader.getProperty("productTitle"));
            ReusableMethods.bekle(3);
            Extent_Reports.extentTest.info("Kullanici Product Tile alanina bir veri girer");

            //Short description alanina bir veri gir.
            //Short description alanina veri girildigini doğrula.
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            Driver.getDriver().switchTo().frame(0);
            ReusableMethods.bekle(3);
            vendorMyAccountPage.shortDescriptionMetinAlani_SK.sendKeys(ConfigReader.getProperty("shortDescription"));
            ReusableMethods.bekle(3);
            Assert.assertEquals(vendorMyAccountPage.shortDescriptionMetinAlaninaGirilenVeri_SK.getText(),
                    ConfigReader.getProperty("shortDescription"));
            Driver.getDriver().switchTo().defaultContent();
            ReusableMethods.bekle(5);
            Extent_Reports.extentTest.info("Kullanici Short description alanina bir veri girer");
            Extent_Reports.extentTest.info("Kullanici Short description alanina veri girildigini doğrular");

            //Description  alanina bir veri gir.
            //Description alanina veri girildigini doğrula.
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            Driver.getDriver().switchTo().frame(1);
            ReusableMethods.bekle(3);
            vendorMyAccountPage.descriptionMetinAlani_SK.sendKeys(ConfigReader.getProperty("description"));
            ReusableMethods.bekle(3);
            Assert.assertEquals(vendorMyAccountPage.descriptionMetinAlaninaGirilenVeri_SK.getText(),
                    ConfigReader.getProperty("description"));
            Driver.getDriver().switchTo().defaultContent();

            ReusableMethods.bekle(3);
            Extent_Reports.extentTest.info("Kullanici Description  alanina bir veri girer");
            Extent_Reports.extentTest.info("Kullanici Description alanina veri girildigini doğrular");
            Extent_Reports.extentReport.flush();
        }
        @Test(dependsOnMethods = "ilkOnAdim_14")
        public void testTC04() {
            /*Catagories webelementinden istedigini secebilmeli*/

            Extent_Reports.rapor(ConfigReader.getProperty("browser"),"Smoke Test","Safiye");
            Extent_Reports.extentTest= Extent_Reports.extentReport.createTest("Extent Report", "Test Raporu");

            actions.sendKeys(Keys.PAGE_DOWN).perform();
            ReusableMethods.bekle(3);
            //  Catagories yazisinin goruntulendigini dogrula
            Assert.assertTrue(vendorMyAccountPage.catagoriesYazisi_SK.isDisplayed());
            ReusableMethods.bekle(3);
            Extent_Reports.extentTest.info("Kullanici Catagories yazisinin goruntulendigini dogrular");

            //  Categories webelementinden istedigin bir urunu sec
            ReusableMethods.click(vendorMyAccountPage.catagoriesClikButonu_SK);
            ReusableMethods.bekle(3);
            Extent_Reports.extentTest.info("Kullanici Categories webelementinden istedigin bir urunu secer");

            //Categories click butonun secilebilir oldugunu dogrula
            Assert.assertTrue(vendorMyAccountPage.catagoriesClikButonu_SK.isSelected());
            ReusableMethods.bekle(3);
            List<WebElement> clickButonlari = vendorMyAccountPage.catagoriesToplamClikButonlari_SK;
            for (int i = 0; i < clickButonlari.size(); i++) {
                if (clickButonlari.get(i).isDisplayed()) {
                    ReusableMethods.click(clickButonlari.get(i));
                }
            }
            Extent_Reports.extentTest.info("Kullanici Categories click butonun secilebilir oldugunu dogrular");
            Extent_Reports.extentReport.flush();


        }
        @Test(dependsOnMethods = "ilkOnAdim_14")
        public void testTC05() {
            /* Catagories webelementine yeni catagories eklenebilmeli*/
            Extent_Reports.rapor(ConfigReader.getProperty("browser"),"Smoke Test","Safiye");
            Extent_Reports.extentTest= Extent_Reports.extentReport.createTest("Extent Report", "Test Raporu");

            actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
            ReusableMethods.bekle(3);
            //Add new category yazisina tikla
            ReusableMethods.click(vendorMyAccountPage.addNewCategoryYazisi_SK);
            ReusableMethods.bekle(3);
            Extent_Reports.extentTest.info("Kullanici Add new category yazisina tiklar");

            //Category name butonuna bir isim gir
            ReusableMethods.bekle(3);
            Faker faker=new Faker();
            vendorMyAccountPage.categoryNameKutusu_SK.sendKeys(faker.food().fruit());
            Extent_Reports.extentTest.info("Kullanici Category name butonuna bir isim girer");

            //Parent categoryden bir category sec
            ReusableMethods.ddmIndex(vendorMyAccountPage.parentCategoryDDM_SK,0);
            ReusableMethods.bekle(3);
            Extent_Reports.extentTest.info("Kullanici Parent categoryden bir category secer");

            //Add butonuna tikla
            ReusableMethods.click(vendorMyAccountPage.addButonu_SK);
            ReusableMethods.bekle(3);
            Extent_Reports.extentTest.info("Kullanici Add butonuna tiklar");

            //Categories webelementine yeni bir catagori eklendigini dogrular
            actions.sendKeys(Keys.PAGE_UP).perform();
            Assert.assertTrue(vendorMyAccountPage.categoryYeniEklenenUrun_SK.isSelected());
            Extent_Reports.extentTest.info("Kullanici Categories webelementine yeni bir catagori eklendigini dogrular");
            Extent_Reports.extentReport.flush();
        }
        @Test(dependsOnMethods = "ilkOnAdim_14",priority = 6)
        public void testTC06() {
            /*Product brands seçilebilmeli*/
            Extent_Reports.rapor(ConfigReader.getProperty("browser"),"Smoke Test","Safiye");
            Extent_Reports.extentTest= Extent_Reports.extentReport.createTest("Extent Report", "Test Raporu");

            actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();
            ReusableMethods.bekle(3);
            //Products brands' dan secim yap
            ReusableMethods.click(vendorMyAccountPage.productBrandsClikButonu_SK);
            ReusableMethods.bekle(3);
            Extent_Reports.extentTest.info("Kullanici Products brands' dan secim yapar");

            //Products brands  secildigini dogrula
            Assert.assertTrue(vendorMyAccountPage.productBrandsClikButonu_SK.isSelected());
            ReusableMethods.bekle(3);
            List<WebElement> clikButonProductBrands= vendorMyAccountPage.productBrandsListesi_SK;
            for (int i = 0; i < clikButonProductBrands.size(); i++) {
                if (clikButonProductBrands.get(i).isDisplayed()) {
                    ReusableMethods.click(clikButonProductBrands.get(i));
                }
            }
            Extent_Reports.extentTest.info("Kullanici Products brands  secildigini dogrular");
            Extent_Reports.extentReport.flush();
        }
        @Test(dependsOnMethods = "ilkOnAdim_14")
        public void testTC07() {
            /*Product brands eklenebilmeli*/
            Extent_Reports.rapor(ConfigReader.getProperty("browser"),"Smoke Test","Safiye");
            Extent_Reports.extentTest= Extent_Reports.extentReport.createTest("Extent Report", "Test Raporu");

            actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();
            ReusableMethods.bekle(3);
            // Add new products brands 'a tikla
            ReusableMethods.click(vendorMyAccountPage.addNewproductBrandsYazisi_SK);
            ReusableMethods.bekle(2);
            Extent_Reports.extentTest.info("Kullanici Add new products brands 'a tiklar");

            // Product brands name '  e isim gir
            vendorMyAccountPage.productBrandsNameKutusu_SK.sendKeys(faker.company().name());
            ReusableMethods.bekle(2);
            Extent_Reports.extentTest.info("Kullanici Product brands name '  e isim girer");

            // Parent taxonomiy'den birini sec
            ReusableMethods.ddmIndex(vendorMyAccountPage.parentTaxonomyDDM_SK,9);
            ReusableMethods.bekle(2);
            Extent_Reports.extentTest.info("Kullanici Parent taxonomiy'den birini secer");

            //Add butonuna tikla
            vendorMyAccountPage.productBrandAddButonu_SK.click();
            ReusableMethods.bekle(4);
            Extent_Reports.extentTest.info("Kullanici Add butonuna tiklar");

            // Products brands alanına yeni product brand eklendigini  dogrula
            Assert.assertTrue(vendorMyAccountPage.productBrandsEklenenUrun_SK.isSelected());
            ReusableMethods.bekle(2);
            Extent_Reports.extentTest.info("Kullanici Products brands alanına yeni product brand eklendigini  dogrular");
            Extent_Reports.extentReport.flush();
        }

    @AfterClass
    public void afterClass() {
            Driver.closeDriver();


    }
}


